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

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public User create(@RequestParam String userId, @RequestParam String userName, @RequestParam String pwd) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPwd(pwd);
        user.setStatus(1);
        return userService.addUser(user);
    }

    @RequestMapping(value = "/modifyPwd", method = RequestMethod.POST)
    public AjaxResult modifyPassword(@RequestParam String userId, @RequestParam String newPw) {
        User user = new User();
        user.setUserId(userId);
        user.setPwd(newPw);
        user.setStatus(1);
        return AjaxResult.success("密码修改成功", user);
    }

    @RequestMapping(value = "/modifyInfo", method = RequestMethod.POST)
    public AjaxResult modifyInfo(@RequestParam String userId, @RequestParam String userName) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setStatus(1);
        return AjaxResult.success("个人信息修改成功", user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AjaxResult login(@RequestParam String userId, @RequestParam String pwd) {
        User user = userService.retrieve(userId);
        if (user != null && StringUtils.isNotNull(pwd)) {
            if (pwd.equals(user.getPwd())) {
                return AjaxResult.success("登陆成功！", user);
            }
        }
        return AjaxResult.error("登陆失败");


    }
}
