package com.fdu.pjserver.controller;

import com.fdu.pjserver.common.AjaxResult;
import com.fdu.pjserver.dao.DailyReport;
import com.fdu.pjserver.service.DailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/report")
public class DailyReportController {
    @Autowired
    private DailyReportService dailyReportService;

    /**
     * @api {POST} /report/add add
     * @apiVersion 1.0.0
     * @apiGroup 疫情上报数据
     * @apiName add
     * @apiDescription 新增疫情上报数据
     * @apiParam (请求参数) {String} userId 学生用户id
     * @apiParam (请求参数) {Number} reportDate 上报日期
     * @apiParam (请求参数) {Number} hasFever 是否有发烧症状
     * @apiParam (请求参数) {Number} atSchool 是否在校
     * @apiParam (请求参数) {Number} temperatureRange 体温范围0:正常,1:37.3-38,2:38以上
     * @apiParam (请求参数) {Number} hasCough 是否咳嗽
     * @apiParam (请求参数) {Number} atIsolation 是否处于隔离期
     * @apiParam (请求参数) {Number} hasRiskContact 是否与国内中高风险地区人员有较为密切的接触
     * @apiParam (请求参数) {Number} hasInfectedContact 是否接触确诊/疑似人群
     * @apiParamExample 请求参数示例
     * temperatureRange=0&reportDate=2020/12/23&hasFever=1&hasCough=1&atSchool=1&userId=20262010002&atIsolation=1&hasRiskContact=1&hasInfectedContact=1
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AjaxResult add(@RequestParam String userId,
                          @RequestParam Date reportDate,
                          @RequestParam Integer hasFever,
                          @RequestParam Integer atSchool,
                          @RequestParam Integer temperatureRange,
                          @RequestParam Integer hasCough,
                          @RequestParam Integer atIsolation,
                          @RequestParam Integer hasRiskContact,
                          @RequestParam Integer hasInfectedContact) {
        DailyReport dailyReport = new DailyReport();
        dailyReport.setUserId(userId);
        dailyReport.setReportDate(reportDate);
        dailyReport.setHasFever(hasFever);
        dailyReport.setAtSchool(atSchool);
        dailyReport.setTemperatureRange(temperatureRange);
        dailyReport.setHasCough(hasCough);
        dailyReport.setAtIsolation(atIsolation);
        dailyReport.setHasRiskContact(hasRiskContact);
        dailyReport.setHasInfectedContact(hasInfectedContact);
        return AjaxResult.success(dailyReportService.add(dailyReport));
    }

    /**
     * @api {POST} /report/update update
     * @apiVersion 1.0.0
     * @apiGroup 疫情上报数据
     * @apiName update
     * @apiDescription 更新疫情上报数据
     * @apiParam (请求参数) {String} userId
     * @apiParam (请求参数) {Number} reportDate
     * @apiParam (请求参数) {Number} hasFever
     * @apiParam (请求参数) {Number} atSchool
     * @apiParam (请求参数) {Number} temperatureRange
     * @apiParam (请求参数) {Number} hasCough
     * @apiParam (请求参数) {Number} atIsolation
     * @apiParam (请求参数) {Number} hasRiskContact
     * @apiParam (请求参数) {Number} hasInfectedContact
     * @apiParamExample 请求参数示例
     * temperatureRange=0&reportDate=2020/12/23&hasFever=1&hasCough=1&atSchool=1&userId=20262010002&atIsolation=1&hasRiskContact=1&hasInfectedContact=1
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public AjaxResult update(@RequestParam String userId,
                             @RequestParam Date reportDate,
                             @RequestParam Integer hasFever,
                             @RequestParam Integer atSchool,
                             @RequestParam Integer temperatureRange,
                             @RequestParam Integer hasCough,
                             @RequestParam Integer atIsolation,
                             @RequestParam Integer hasRiskContact,
                             @RequestParam Integer hasInfectedContact) {
        DailyReport dailyReport = new DailyReport();
        dailyReport.setUserId(userId);
        dailyReport.setReportDate(reportDate);
        dailyReport.setHasFever(hasFever);
        dailyReport.setAtSchool(atSchool);
        dailyReport.setTemperatureRange(temperatureRange);
        dailyReport.setHasCough(hasCough);
        dailyReport.setAtIsolation(atIsolation);
        dailyReport.setHasRiskContact(hasRiskContact);
        dailyReport.setHasInfectedContact(hasInfectedContact);
        return AjaxResult.success(dailyReportService.update(dailyReport));
    }

    /**
     * @api {POST} /report/get_user_reports getUserReport
     * @apiVersion 1.0.0
     * @apiGroup 疫情上报数据
     * @apiName getUserReport
     * @apiDescription 获取某个学生所有疫情上报数据
     * @apiParam (请求参数) {String} userId
     * @apiParamExample 请求参数示例
     * userId=20262010001
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/get_user_reports", method = RequestMethod.POST)
    public AjaxResult getUserReport(@RequestParam String userId) {
        return AjaxResult.success(dailyReportService.retrieveByUserId(userId));
    }

    /**
     * @api {POST} /report/get_user_single_report getUserSingleReport
     * @apiVersion 1.0.0
     * @apiGroup 疫情上报数据
     * @apiName getUserReport
     * @apiDescription 获取某个学生某天疫情上报数据
     * @apiParam (请求参数) {String} userId
     * @apiParam (请求参数) {Number} reportDate
     * @apiParamExample 请求参数示例
     * reportDate=2020/12/23&userId=20262010002
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/get_user_single_report", method = RequestMethod.POST)
    public AjaxResult getUserSingleReport(@RequestParam String userId,
                                    @RequestParam Date reportDate) {
        return AjaxResult.success(dailyReportService.retrieveByUserIdAndDate(userId, reportDate));
    }

    /**
     * @api {GET} /report/get_reports getReports
     * @apiVersion 1.0.0
     * @apiGroup 疫情上报数据
     * @apiName getReports
     * @apiDescription 获取所有疫情上报数据
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/get_reports", method = RequestMethod.GET)
    public AjaxResult getReports(){
        return AjaxResult.success(dailyReportService.retrieveAll());
    }


}
