package com.fdu.pjserver.service.impl;

import com.fdu.pjserver.dao.DailyReport;
import com.fdu.pjserver.repository.DailyReportDAO;
import com.fdu.pjserver.service.DailyReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DailyReportServiceImpl implements DailyReportService {
    @Autowired
    private DailyReportDAO dailyReportDAO;

    @Override
    public DailyReport add(DailyReport dailyReport) {
        return dailyReportDAO.save(dailyReport);
    }

    @Override
    public void delete(String userId, Date reportDate) {
    }

    @Override
    public DailyReport update(DailyReport dailyReport) {
        return dailyReportDAO.saveAndFlush(dailyReport);
    }

    @Override
    public List<DailyReport> retrieveByUserId(String userId) {
        return dailyReportDAO.findDailyReportByUserId(userId);
    }

    @Override
    public DailyReport retrieveByUserIdAndDate(String userId, Date reportDate) {
        return dailyReportDAO.findDailyReportByUserIdAndDate(userId, reportDate);
    }

    @Override
    public List<DailyReport> retrieveAll() {
        return dailyReportDAO.findAll();
    }
}
