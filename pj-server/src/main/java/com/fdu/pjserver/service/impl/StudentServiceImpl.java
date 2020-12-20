package com.fdu.pjserver.service.impl;

import com.fdu.pjserver.dao.Student;
import com.fdu.pjserver.repository.StudentRepository;
import com.fdu.pjserver.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student add(Student student) {
        return studentRepository.save(student);
    }
}
