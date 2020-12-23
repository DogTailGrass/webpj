package com.fdu.pjserver.controller;

import com.fdu.pjserver.common.AjaxResult;
import com.fdu.pjserver.dao.StudentInfo;
import com.fdu.pjserver.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student_info")
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;

    /**
     * @api {POST} /student_info/add add
     * @apiVersion 1.0.0
     * @apiGroup 学生基本信息
     * @apiName add
     * @apiDescription 新增学生基本信息
     * @apiParam (请求参数) {String} userId
     * @apiParam (请求参数) {String} mobile
     * @apiParam (请求参数) {String} department
     * @apiParam (请求参数) {String} degree
     * @apiParam (请求参数) {Number} fullTime
     * @apiParam (请求参数) {String} counselorName
     * @apiParam (请求参数) {Number} graduation
     * @apiParam (请求参数) {String} address
     * @apiParamExample 请求参数示例
     * counselorName=李老师&address=上海市XX区XX路&graduation=0&mobile=13800000000&degree=研究生&fullTime=0&department=软件学院&userId=20262010001
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AjaxResult add(@RequestParam String userId,
                          @RequestParam String mobile,
                          @RequestParam String department,
                          @RequestParam String degree,
                          @RequestParam Integer fullTime,
                          @RequestParam String counselorName,
                          @RequestParam Integer graduation,
                          @RequestParam String address) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setUserId(userId);
        studentInfo.setMobile(mobile);
        studentInfo.setDepartment(department);
        studentInfo.setDegree(degree);
        studentInfo.setFullTime(fullTime);
        studentInfo.setCounselorName(counselorName);
        studentInfo.setGraduation(graduation);
        studentInfo.setAddress(address);
        return AjaxResult.success(studentInfoService.add(studentInfo));
    }

    /**
     * @api {POST} /student_info/update update
     * @apiVersion 1.0.0
     * @apiGroup 学生基本信息
     * @apiName update
     * @apiDescription 修改学生基本信息
     * @apiParam (请求参数) {String} userId
     * @apiParam (请求参数) {String} mobile
     * @apiParam (请求参数) {String} department
     * @apiParam (请求参数) {String} degree
     * @apiParam (请求参数) {Number} fullTime
     * @apiParam (请求参数) {String} counselorName
     * @apiParam (请求参数) {Number} graduation
     * @apiParam (请求参数) {String} address
     * @apiParamExample 请求参数示例
     * counselorName=李老师&address=上海市XX区XX路&graduation=0&mobile=13800000000&degree=研究生&fullTime=0&department=软件学院&userId=20262010001
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public AjaxResult update(@RequestParam String userId,
                             @RequestParam String mobile,
                             @RequestParam String department,
                             @RequestParam String degree,
                             @RequestParam Integer fullTime,
                             @RequestParam String counselorName,
                             @RequestParam Integer graduation,
                             @RequestParam String address) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setUserId(userId);
        studentInfo.setMobile(mobile);
        studentInfo.setDepartment(department);
        studentInfo.setDegree(degree);
        studentInfo.setFullTime(fullTime);
        studentInfo.setCounselorName(counselorName);
        studentInfo.setGraduation(graduation);
        studentInfo.setAddress(address);
        return AjaxResult.success(studentInfoService.update(studentInfo));
    }

    /**
     * @api {POST} /student_info/get get
     * @apiVersion 1.0.0
     * @apiGroup 学生基本信息
     * @apiName get
     * @apiDescription 获取学生基本信息
     * @apiParam (请求参数) {String} userId
     * @apiParamExample 请求参数示例
     * userId=20262010001
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public AjaxResult get(@RequestParam String userId) {
        return AjaxResult.success(studentInfoService.retrieve(userId));
    }


}
