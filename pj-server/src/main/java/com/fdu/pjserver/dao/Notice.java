package com.fdu.pjserver.dao;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Data
public class Notice {
    private Integer id;

    private Date validDate;

    private Long validTimestamp;

    private String title;

    private String content;

    private Integer status;

    @CreatedDate
    private Date createTime;

    @CreatedBy
    private String createBy;

    @LastModifiedDate
    private Date updateTime;

    @LastModifiedBy
    private String updateBy;
}
