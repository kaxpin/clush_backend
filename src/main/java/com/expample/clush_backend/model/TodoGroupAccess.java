package com.expample.clush_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "todo_group_access")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoGroupAccess {
    @Id
    @Column(name = "task_id")
    private Integer taskId;

    @Column(name = "user_id", length = 50)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "task_id", insertable = false, updatable = false)
    private Todo todo;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private User user;
}

