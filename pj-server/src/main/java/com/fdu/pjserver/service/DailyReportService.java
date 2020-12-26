package com.fdu.pjserver.service;

import com.fdu.pjserver.dao.DailyReport;
import com.fdu.pjserver.dao.UserDailyReport;

import java.util.Date;
import java.util.List;

public interface DailyReportService {
    DailyReport add(DailyReport dailyReport);

    void delete(String userId, Date reportDate);

    DailyReport update(DailyReport dailyReport);

    List<DailyReport> retrieveByUserId(String userId);

    DailyReport retrieveByUserIdAndDate(String userId, Date reportDate);

    List<DailyReport> retrieveAll();

    List<UserDailyReport> retrieveAllByDate(Date reportDate);

}
