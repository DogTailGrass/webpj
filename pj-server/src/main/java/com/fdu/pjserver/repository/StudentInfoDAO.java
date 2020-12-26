package com.fdu.pjserver.repository;

import com.fdu.pjserver.dao.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentInfoDAO extends JpaRepository<StudentInfo, String>, JpaSpecificationExecutor<StudentInfo> {
//    @Query(value = "from StudentInfo s left join User u on s.userId=u.userId where u.status=1")
    @Query("from StudentInfo where status=1")
    public List<StudentInfo> findAllValid();
}
