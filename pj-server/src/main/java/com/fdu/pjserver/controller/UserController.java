package com.fdu.pjserver.controller;

import com.fdu.pjserver.common.AjaxResult;
import com.fdu.pjserver.common.utils.StringUtils;
import com.fdu.pjserver.dao.User;
import com.fdu.pjserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * @api {POST} /user/add add
     * @apiVersion 1.0.0
     * @apiGroup 用户
     * @apiName add
     * @apiDescription 创建用户
     * @apiParam (请求参数) {String} userId 用户ID（学号或管理员账号）
     * @apiParam (请求参数) {String} userName 姓名
     * @apiParam (请求参数) {String} pwd 密码
     * @apiParamExample 请求参数示例
     * userName=张三&pwd=123&userId=20262010001
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AjaxResult add(@RequestParam String userId,
                          @RequestParam String userName,
                          @RequestParam String pwd) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPwd(pwd);
        user.setStatus(1);
        return AjaxResult.success(userService.add(user));
    }

    /**
     * @api {POST} /user/modifyPwd modifyPassword
     * @apiVersion 1.0.0
     * @apiGroup 用户
     * @apiName modifyPassword
     * @apiDescription 修改密码
     * @apiParam (请求参数) {String} userId
     * @apiParam (请求参数) {String} newPw
     * @apiParamExample 请求参数示例
     * newPw=123456&userId=20262010001
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/modifyPwd", method = RequestMethod.POST)
    public AjaxResult modifyPassword(@RequestParam String userId, @RequestParam String newPw) {
        User user = new User();
        user.setUserId(userId);
        user.setPwd(newPw);
        user.setStatus(1);
        return AjaxResult.success(userService.update(user));
    }

    /**
     * @api {POST} /user/modifyInfo modifyInfo
     * @apiVersion 1.0.0
     * @apiGroup 用户
     * @apiName modifyInfo
     * @apiDescription 修改用户姓名
     * @apiParam (请求参数) {String} userId
     * @apiParam (请求参数) {String} userName
     * @apiParamExample 请求参数示例
     * userName=李四&userId=20262010001
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/modifyInfo", method = RequestMethod.POST)
    public AjaxResult modifyInfo(@RequestParam String userId, @RequestParam String userName) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setStatus(1);
        return AjaxResult.success(userService.update(user));
    }

    /**
     * @api {POST} /user/login login
     * @apiVersion 1.0.0
     * @apiGroup 用户
     * @apiName login
     * @apiDescription 用户登陆
     * @apiParam (请求参数) {String} userId
     * @apiParam (请求参数) {String} pwd
     * @apiParamExample 请求参数示例
     * pwd=123&userId=20262010001
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AjaxResult login(@RequestParam String userId, @RequestParam String pwd) {
        Optional<User> user = userService.retrieve(userId);
        if (user.isPresent() && StringUtils.isNotNull(pwd)) {
            if (pwd.equals(user.get().getPwd())) {
                return AjaxResult.success("登陆成功！", user);
            }
        }
        return AjaxResult.error("登陆失败");
    }

    /**
     * @api {POST} /user/get get
     * @apiVersion 1.0.0
     * @apiGroup 用户
     * @apiName get
     * @apiDescription 获取用户信息
     * @apiParam (请求参数) {String} userId
     * @apiParamExample 请求参数示例
     * userId=Y7kmt
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public AjaxResult get(@RequestParam String userId) {
        return AjaxResult.success(userService.retrieve(userId));
    }

    /**
     * @api {GET} /user/get_all getALL
     * @apiVersion 1.0.0
     * @apiGroup 用户
     * @apiName getALL
     * @apiDescription 获取所有用户信息
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public AjaxResult getALL() {
        return AjaxResult.success(userService.retrieveAll());
    }
}
