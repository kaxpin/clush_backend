package com.expample.clush_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity
@Table(name = "calendar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Integer scheduleId;

//    @Column(name = "writer_id", nullable = false, length = 50, insertable = false, updatable = false)
//    private String writerId;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "content", length = 3000)
    private String content;

    @Column(name = "write_date", nullable = false)
    private Timestamp writeDate;

    @Column(name = "start_date", nullable = false)
    private Timestamp  startDate;

    @Column(name = "end_date", nullable = false)
    private Timestamp  endDate;

    @Column(name = "index_color", length = 50)
    private String indexColor;

    @Column(name = "place", length = 255)
    private String place;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "writer_id", referencedColumnName = "user_id")
    private User writer;

    @ManyToOne
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    private Group group;

}