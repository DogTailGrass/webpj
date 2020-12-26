package com.fdu.pjserver.service.impl;

import com.fdu.pjserver.dao.StudentInfo;
import com.fdu.pjserver.repository.StudentInfoDAO;
import com.fdu.pjserver.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentInfoServiceImpl implements StudentInfoService {
    @Autowired
    private StudentInfoDAO studentInfoDAO;

    public StudentInfo add(StudentInfo studentInfo) {
        return studentInfoDAO.save(studentInfo);
    }

    public void delete(String userId) {
    }

    public Optional<StudentInfo> retrieve(String userId) {
        return studentInfoDAO.findById(userId);
    }

    public StudentInfo update(StudentInfo studentInfo) {
        return studentInfoDAO.saveAndFlush(studentInfo);
    }

    public List<StudentInfo> retrieveAll() {
        return studentInfoDAO.findAll();
    }

    public List<StudentInfo> retrieveAllValid() {
        return studentInfoDAO.findAllValid();
    }
}
