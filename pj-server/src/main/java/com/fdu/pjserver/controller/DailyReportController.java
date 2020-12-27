package com.fdu.pjserver.controller;

import com.fdu.pjserver.common.AjaxResult;
import com.fdu.pjserver.common.utils.DateUtils;
import com.fdu.pjserver.common.utils.StringUtils;
import com.fdu.pjserver.dao.DailyReport;
import com.fdu.pjserver.dao.StudentInfo;
import com.fdu.pjserver.dao.UserDailyReport;
import com.fdu.pjserver.service.DailyReportService;
import com.fdu.pjserver.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/report")
public class DailyReportController {
    @Autowired
    private DailyReportService dailyReportService;

    @Autowired
    private StudentInfoService studentInfoService;

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
     * @api {POST} /report/get_reports_by_date getReportsByDate
     * @apiVersion 1.0.0
     * @apiGroup 疫情上报数据
     * @apiName getReportsByDate
     * @apiDescription 获取某天学生疫情上报数据，并返回未上报用户信息
     * @apiParam (请求参数) {Number} reportDate
     * @apiParamExample 请求参数示例
     * reportDate=2020/12/01
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {
     * "msg": "操作成功",
     * "code": 200,
     * "data": {
     * "not_report_users": [
     * {
     * "userId": "20262010001",
     * "userName": "张三",
     * "pwd": "123",
     * "status": 1,
     * "createTime": "2020-12-22T01:30:51.000+08:00",
     * "createBy": "System",
     * "updateTime": "2020-12-22T01:30:51.000+08:00",
     * "updateBy": "System",
     * "mobile": "13800000000",
     * "department": "软件学院",
     * "degree": "研究生",
     * "fullTime": 0,
     * "counselorName": "李老师",
     * "graduation": 1,
     * "address": "上海市XX区XX路"
     * }
     * ],
     * "report": [
     * {
     * "userId": "20262010002",
     * "reportDate": "2020-12-01T00:00:00.000+08:00",
     * "hasFever": 1,
     * "atSchool": 1,
     * "temperatureRange": 0,
     * "hasCough": 1,
     * "atIsolation": 1,
     * "hasRiskContact": 1,
     * "hasInfectedContact": 1,
     * "userName": "李四"
     * }
     * ]
     * }
     * }
     */
    @RequestMapping(value = "/get_reports_by_date", method = RequestMethod.POST)
    public AjaxResult getReportsByDate(@RequestParam Date reportDate) {
        List<UserDailyReport> dailyReports = dailyReportService.retrieveAllByDate(reportDate);
        Set<String> reportUserIds = dailyReports.stream().map(DailyReport::getUserId).collect(Collectors.toSet());
        List<StudentInfo> notReportStudents = new ArrayList<>();
        for (StudentInfo studentInfo : studentInfoService.retrieveAllValid()) {
            if (studentInfo != null && !reportUserIds.contains(studentInfo.getUserId())) {
                notReportStudents.add(studentInfo);
            }
        }
        HashMap<String, Object> response = new HashMap<>();
        response.put("report", dailyReports);
        response.put("not_report_users", notReportStudents);
        return AjaxResult.success(response);
    }

    /**
     * @api {POST} /report/day_analysis analysisDay
     * @apiVersion 1.0.0
     * @apiGroup 疫情上报数据
     * @apiName analysisDay
     * @apiDescription 当日数据分析接口
     * @apiParam (请求参数) {Number} reportDate
     * @apiParam (请求参数) {String} type 取值区间on_time,at_school,temp,cough,isolation,risk_cont,infected_cont
     * @apiParamExample 请求参数示例
     * reportDate=2020/12/23&type=isolation
     * @apiSuccess (响应结果) {Object} response data字段中一般为not_report_users,true,false三个字段，分别表示当日未上报、当前请求分析字段为1/0的数据。
     * 如果type取值为temp，返回normal,mid,high三个字段表示体温的三个区间
     * @apiSuccessExample 响应结果示例
     * {
     * "msg": "操作成功",
     * "code": 200,
     * "data": {
     * "not_report_users": [],
     * "true": [
     * {
     * "userId": "20262010002",
     * "reportDate": "2020-12-23T00:00:00.000+08:00",
     * "hasFever": 1,
     * "atSchool": 1,
     * "temperatureRange": 0,
     * "hasCough": 1,
     * "atIsolation": 1,
     * "hasRiskContact": 1,
     * "hasInfectedContact": 1,
     * "userName": "李四"
     * }
     * ],
     * "false": [
     * {
     * "userId": "20262010001",
     * "reportDate": "2020-12-23T00:00:00.000+08:00",
     * "hasFever": 0,
     * "atSchool": 0,
     * "temperatureRange": 1,
     * "hasCough": 0,
     * "atIsolation": 0,
     * "hasRiskContact": 0,
     * "hasInfectedContact": 0,
     * "userName": "张三"
     * }
     * ]
     * }
     * }
     */
    @RequestMapping(value = "/day_analysis", method = RequestMethod.POST)
    public AjaxResult analysisDay(@RequestParam Date reportDate,
                                     @RequestParam String type) {
        // type: on_time,at_school,temp,cough,isolation,risk_cont,infected_cont
        List<UserDailyReport> dailyReports = dailyReportService.retrieveAllByDate(reportDate);
        Set<String> reportUserIds = dailyReports.stream().map(DailyReport::getUserId).collect(Collectors.toSet());
        List<StudentInfo> notReportStudents = new ArrayList<>();
        for (StudentInfo studentInfo : studentInfoService.retrieveAllValid()) {
            if (studentInfo != null && !reportUserIds.contains(studentInfo.getUserId())) {
                notReportStudents.add(studentInfo);
            }
        }
        // 根据请求进行各维度数据解析
        HashMap<String, Object> response = new HashMap<>();
        response.put("not_report_users", notReportStudents);
        List<UserDailyReport> trueList = new ArrayList<>();
        List<UserDailyReport> falseList = new ArrayList<>();
        switch (type) {
            case "on_time":
                response.put("report", dailyReports);
                break;
            case "at_school":
                for (UserDailyReport report : dailyReports) {
                    if (report.getAtSchool() == 0) {
                        falseList.add(report);
                    } else {
                        trueList.add(report);
                    }
                }
                response.put("true", trueList);
                response.put("false", falseList);
                break;
            case "cough":
                for (UserDailyReport report : dailyReports) {
                    if (report.getHasCough() == 0) {
                        falseList.add(report);
                    } else {
                        trueList.add(report);
                    }
                }
                response.put("true", trueList);
                response.put("false", falseList);
                break;
            case "isolation":
                for (UserDailyReport report : dailyReports) {
                    if (report.getAtIsolation() == 0) {
                        falseList.add(report);
                    } else {
                        trueList.add(report);
                    }
                }
                response.put("true", trueList);
                response.put("false", falseList);
                break;
            case "risk_cont":
                for (UserDailyReport report : dailyReports) {
                    if (report.getHasRiskContact() == 0) {
                        falseList.add(report);
                    } else {
                        trueList.add(report);
                    }
                }
                response.put("true", trueList);
                response.put("false", falseList);
                break;
            case "infected_cont":
                for (UserDailyReport report : dailyReports) {
                    if (report.getHasInfectedContact() == 0) {
                        falseList.add(report);
                    } else {
                        trueList.add(report);
                    }
                }
                response.put("true", trueList);
                response.put("false", falseList);
                break;
            case "temp":
                //体温范围0:正常,1:37.3-38,2:38以上
                List<UserDailyReport> normalList = new ArrayList<>();
                List<UserDailyReport> midList = new ArrayList<>();
                List<UserDailyReport> highList = new ArrayList<>();
                for (UserDailyReport report : dailyReports) {
                    if (report.getTemperatureRange() == 0) {
                        normalList.add(report);
                    } else if (report.getTemperatureRange() == 1) {
                        midList.add(report);
                    } else if (report.getTemperatureRange() == 2) {
                        highList.add(report);
                    }
                }
                response.put("normal", normalList);
                response.put("mid", midList);
                response.put("high", highList);
                break;
            default:
                return AjaxResult.error("type参数错误");
        }


        return AjaxResult.success(response);
    }

    /**
     * @api {POST} /report/range_abnormal_analysis analysisDateRank
     * @apiVersion 1.0.0
     * @apiGroup 疫情上报数据
     * @apiName analysisDateRank
     * @apiDescription 日期区间内异常数据
     * @apiParam (请求参数) {Number} oldDate 起始日
     * @apiParam (请求参数) {Number} newDate 结束日
     * @apiParam (请求参数) {String} type
     * @apiParamExample 请求参数示例
     * oldDate=2020/12/01&type=cough&newDate=2020/12/23
     * @apiSuccess (响应结果) {Object} response 取值区间on_time,at_school,temp,cough,isolation,risk_cont,infected_cont
     * @apiSuccessExample 响应结果示例
     * {
     *     "msg": "操作成功",
     *     "code": 200,
     *     "data": [
     *         {
     *             "2020-12-01": 1
     *         },
     *         {
     *             "2020-12-23": 1
     *         }
     *     ]
     * }
     */
    @RequestMapping(value = "/range_abnormal_analysis", method = RequestMethod.POST)
    public AjaxResult analysisDateRank(@RequestParam Date oldDate,
                                      @RequestParam Date newDate,
                                      @RequestParam String type) {
        // type: on_time,at_school,temp,cough,isolation,risk_cont,infected_cont
        List<UserDailyReport> dailyReports = dailyReportService.retrieveAllBetweenDate(oldDate, newDate);
        HashMap<String, Integer> responseMap = new HashMap<>();
        for (UserDailyReport report : dailyReports) {
            Date date = report.getReportDate();
            String day = DateUtils.dateToDay(date);
            if (!responseMap.containsKey(day)) {
                responseMap.put(day, 0);
            }
            switch (type) {
                case "on_time":
                    if (date.getHours() > 17) {
                        responseMap.put(day, responseMap.get(day) + 1);
                    }
                    break;
                case "at_school":
                    if (report.getAtSchool() == 0) {
                        responseMap.put(day, responseMap.get(day) + 1);
                    }
                    break;
                case "cough":
                    if (report.getHasCough() == 1) {
                        responseMap.put(day, responseMap.get(day) + 1);
                    }
                    break;
                case "isolation":
                    if (report.getAtIsolation() == 1) {
                        responseMap.put(day, responseMap.get(day) + 1);
                    }
                    break;
                case "risk_cont":
                    if (report.getHasRiskContact() == 1) {
                        responseMap.put(day, responseMap.get(day) + 1);
                    }
                    break;
                case "infected_cont":
                    if (report.getHasInfectedContact() == 1) {
                        responseMap.put(day, responseMap.get(day) + 1);
                    }
                    break;
                case "temp":
                    //体温范围0:正常,1:37.3-38,2:38以上
                    if (report.getTemperatureRange() > 0) {
                        responseMap.put(day, responseMap.get(day) + 1);
                    }
                    break;
                default:
                    return AjaxResult.error("type参数错误");
            }
        }
        List<Map.Entry<String, Integer>> result =
                responseMap.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByKey())
                        .collect(Collectors.toList());
        return AjaxResult.success(result);
    }


}
