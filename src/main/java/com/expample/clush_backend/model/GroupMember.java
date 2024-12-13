package com.expample.clush_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Entity
@Table(name = "group_member")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupMember {
    @Id
    @Column(name = "group_id")
    private Integer groupId;

    @Column(name = "group_role", length = 80)
    private String groupRole;

    @Column(name = "join_date")
    private Timestamp joinDate;

    @ManyToOne
    @JoinColumn(name = "group_id", insertable = false, updatable = false)
    private Group group;
}