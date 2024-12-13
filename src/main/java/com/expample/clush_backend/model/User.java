package com.expample.clush_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
        @Id
        @Column(name = "user_id", length = 50)
        private String userId;

        @Column(name = "user_name", nullable = false, length = 50)
        private String userName;

        @Column(name = "user_pw", nullable = false, length = 30)
        private String userPw;

}

