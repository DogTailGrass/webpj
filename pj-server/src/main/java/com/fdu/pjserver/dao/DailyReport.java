package com.fdu.pjserver.dao;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
@Data
@IdClass(DailyReportPK.class)
public class DailyReport{

    /**
     * 学生用户id
     */
    @Id
    private String userId;

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

}
