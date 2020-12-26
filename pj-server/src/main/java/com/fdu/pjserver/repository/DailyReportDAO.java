package com.fdu.pjserver.repository;


import com.fdu.pjserver.dao.DailyReport;
import com.fdu.pjserver.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;


public interface DailyReportDAO extends JpaRepository<DailyReport, String>, JpaSpecificationExecutor<DailyReport> {
    @Query(value = "from DailyReport where userId=?1 and reportDate=?2")
    public DailyReport findDailyReportByUserIdAndDate(String userId, Date reportDate);

    @Query(value = "from DailyReport where userId=?1")
    public List<DailyReport> findDailyReportByUserId(String userId);
}