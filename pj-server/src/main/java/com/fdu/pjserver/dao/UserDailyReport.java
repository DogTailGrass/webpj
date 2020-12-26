package com.fdu.pjserver.dao;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class UserDailyReport extends DailyReport {

    private String userId;

    private String userName;

    /**
     * 上报日期
     */
    @Id
    private Date reportDate;

    /**
     * 是否有发烧症状
     */
    private Integer hasFever;

    /**
     * 是否在校
     */
    private Integer atSchool;

    /**
     * 体温范围
     * 0:正常
     * 1:37.3-38
     * 2:38以上
     */
    private Integer temperatureRange;

    /**
     * 是否咳嗽
     */
    private Integer hasCough;

    /**
     * 是否处于隔离期
     */
    private Integer atIsolation;

    /**
     * 是否与国内中高风险地区人员有较为密切的接触
     */
    private Integer hasRiskContact;

    /**
     * 是否接触确诊/疑似人群
     */
    private Integer hasInfectedContact;

    public UserDailyReport(String userId, String userName, Date reportDate, Integer hasFever, Integer atSchool, Integer temperatureRange, Integer hasCough, Integer atIsolation, Integer hasRiskContact, Integer hasInfectedContact) {
        this.userId = userId;
        this.userName = userName;
        this.reportDate = reportDate;
        this.hasFever = hasFever;
        this.atSchool = atSchool;
        this.temperatureRange = temperatureRange;
        this.hasCough = hasCough;
        this.atIsolation = atIsolation;
        this.hasRiskContact = hasRiskContact;
        this.hasInfectedContact = hasInfectedContact;
    }
}
