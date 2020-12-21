package com.fdu.pjserver.controller;

import com.fdu.pjserver.common.AjaxResult;
import com.fdu.pjserver.dao.Student;
import com.fdu.pjserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentInfoController {
    

    @PostMapping
    public int modify() {
//        Student student = new Student();
//        studentService.add(student);
        return 1;
    }

    @RequestMapping(value = "/report", method = RequestMethod.POST)
    public AjaxResult report(@RequestParam String userId,
                             @RequestParam String currentLocation,
                             @RequestParam Integer hasFever,
                             @RequestParam Integer hasLeave,
                             @RequestParam Integer todayBodyTemperature,
                             @RequestParam Integer hasContact,
                             @RequestParam Integer isolationPeriod,
                             @RequestParam String remarks) {
        return AjaxResult.success("上报成功！");
    }

}
