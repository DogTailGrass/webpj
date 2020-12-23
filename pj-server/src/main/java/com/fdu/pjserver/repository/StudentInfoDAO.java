package com.fdu.pjserver.repository;

import com.fdu.pjserver.dao.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface StudentInfoDAO extends JpaRepository<StudentInfo, String>, JpaSpecificationExecutor<StudentInfo> {
}
