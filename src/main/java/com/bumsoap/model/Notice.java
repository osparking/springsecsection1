package com.bumsoap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "notice_details")
@Getter @Setter
public class Notice {
    @Id
    private long noticeId;
    private String noticeSummary;
    private String noticeDetails;
    private Date noticeBegDt;
    private Date noticeEndDt;
    @JsonIgnore
    private Date createDt;
    @JsonIgnore
    private Date updateDt;
}
