package com.expample.clush_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity
@Table(name = "todo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "content", length = 3000)
    private String content;

    @Column(name = "write_date", nullable = false)
    private Timestamp  writeDate;

    @Column(name = "start_date", nullable = false)
    private Timestamp startDate;

    @Column(name = "end_date", nullable = false)
    private Timestamp endDate;

    @Column(name = "done_YN", length = 10, columnDefinition = "VARCHAR(10) DEFAULT 'N'")
    private String doneYN = "N";

    @Column(name = "done_date", nullable = false)
    private Timestamp doneDate;

    @Column(name = "group_id")
    private Integer groupId;

    @ManyToOne
    @JoinColumn(name = "writer_id", referencedColumnName = "user_id")
    private User writerId;

    @ManyToOne
    @JoinColumn(name = "group_id", insertable = false, updatable = false)
    private Group group;
}
