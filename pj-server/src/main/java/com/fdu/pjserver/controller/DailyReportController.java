package com.fdu.pjserver.controller;

import com.fdu.pjserver.common.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class DailyReportController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public AjaxResult add(@RequestParam String userId,
                             @RequestParam String currentLocation,
                             @RequestParam Integer hasFever,
                             @RequestParam Integer hasLeave,
                             @RequestParam Integer todayBodyTemperature,
                             @RequestParam Integer hasContact,
                             @RequestParam Integer isolationPeriod) {
        return AjaxResult.success("上报成功！");
    }
}
