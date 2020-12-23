package com.fdu.pjserver.controller;

import com.fdu.pjserver.common.AjaxResult;
import com.fdu.pjserver.dao.Notice;
import com.fdu.pjserver.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * @api {GET} /notice/get getAll
     * @apiVersion 1.0.0
     * @apiGroup 公告
     * @apiName getAll
     * @apiDescription 获取所有公告
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/get_all", method = RequestMethod.GET)
    public AjaxResult getAll() {
        return AjaxResult.success(noticeService.retrieveAll());
    }

    /**
     * @api {POST} /notice/add add
     * @apiVersion 1.0.0
     * @apiGroup 公告
     * @apiName add
     * @apiDescription 新增公告
     * @apiParam (请求参数) {String} title
     * @apiParam (请求参数) {String} content
     * @apiParam (请求参数) {Number} status
     * @apiParam (请求参数) {Number} validDate
     * @apiParam (请求参数) {Number} validTime
     * @apiParamExample 请求参数示例
     * title=公告2&content=lll&status=1&validDate=2020/12/23 23:24:46&validTime=1608737086
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AjaxResult add(@RequestParam String title,
                          @RequestParam String content,
                          @RequestParam Integer status,
                          @RequestParam Date validDate,
                          @RequestParam Long validTime) {
        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setContent(content);
        notice.setStatus(status);
        notice.setValidDate(validDate);
        notice.setValidTime(validTime);
        return AjaxResult.success(noticeService.add(notice));
    }


    /**
     * @api {POST} /notice/update update
     * @apiVersion 1.0.0
     * @apiGroup 公告
     * @apiName update
     * @apiDescription 更新公告
     * @apiParam (请求参数) {Number} id
     * @apiParam (请求参数) {String} title
     * @apiParam (请求参数) {String} content
     * @apiParam (请求参数) {Number} status
     * @apiParam (请求参数) {Number} validDate
     * @apiParam (请求参数) {Number} validTime
     * @apiParamExample 请求参数示例
     * validDate=2020/12/23 23:24:46&validTime=1608737086&id=7159&title=标题&content=巴拉巴拉&status=1
     * @apiSuccess (响应结果) {Object} response
     * @apiSuccessExample 响应结果示例
     * {}
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public AjaxResult update(@RequestParam Integer id,
                             @RequestParam String title,
                             @RequestParam String content,
                             @RequestParam Integer status,
                             @RequestParam Date validDate,
                             @RequestParam Long validTime) {
        Notice notice = new Notice();
        notice.setId(id);
        notice.setTitle(title);
        notice.setContent(content);
        notice.setStatus(status);
        notice.setValidDate(validDate);
        notice.setValidTime(validTime);
        return AjaxResult.success(noticeService.update(notice));
    }


}
