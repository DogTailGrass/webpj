package com.fdu.pjserver.controller;

import com.fdu.pjserver.common.AjaxResult;
import com.fdu.pjserver.dao.Notice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {
    @GetMapping("/get")
    public AjaxResult getNotice() {

        List<Notice> notices = new ArrayList<>();
        Notice notice = new Notice();
        notice.setId(1);
        notice.setValidDate(new Date());
        notice.setValidTimestamp(System.currentTimeMillis());
        notice.setTitle("标题");
        notice.setContent("这是内容");
        notice.setStatus(1);
        notice.setCreateBy("System");
        notice.setCreateTime(new Date());
        notices.add(notice);
        return AjaxResult.success(notices);
    }
}
