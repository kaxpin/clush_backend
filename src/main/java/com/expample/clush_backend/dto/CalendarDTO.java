package com.expample.clush_backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalendarDTO {

    private Integer scheduleId;
    private String title;
    private String content;
    private Timestamp writeDate;
    private Timestamp startDate;
    private Timestamp endDate;
    private String indexColor;
    private String place;


    private Integer groupId;

    private String type;

    private String writerId;

}
