package com.fdu.pjserver.service;

import com.fdu.pjserver.dao.StudentInfo;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface StudentInfoService {
    StudentInfo add(StudentInfo studentInfo);

    void delete(String userId);

    StudentInfo update(StudentInfo studentInfo);

    Optional<StudentInfo> retrieve(String userId);
}
