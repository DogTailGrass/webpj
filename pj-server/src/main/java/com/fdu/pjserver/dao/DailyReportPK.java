package com.fdu.pjserver.dao;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Data
public class DailyReportPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;

    private Date reportDate;

    @Override
    public int hashCode() {
        return Objects.hash(userId, reportDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DailyReportPK pk = (DailyReportPK) obj;
        return Objects.equals(userId, pk.userId) &&
                Objects.equals(reportDate, pk.reportDate);
    }

}
