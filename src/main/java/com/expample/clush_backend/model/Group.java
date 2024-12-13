package com.expample.clush_backend.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Entity
@Table(name = "group")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "group_name", nullable = false, length = 50)
    private String groupName;

    @Column(name = "group_master_id", nullable = false, length = 50)
    private String groupMasterId;

    @Column(name = "created_date")
    private Timestamp createdDate;

    @ManyToOne
    @JoinColumn(name = "group_master_id", referencedColumnName = "user_id", insertable = false, updatable = false, nullable = true)
    private User groupMaster;
}