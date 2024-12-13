package com.expample.clush_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "calendar_group_access")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalendarGroupAccess {
    @Id
    @Column(name = "schedule_id")
    private Integer scheduleId;

    @Column(name = "user_id", length = 50)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "schedule_id", insertable = false, updatable = false)
    private Calendar calendar;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;
}