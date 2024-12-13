package com.expample.clush_backend.repository;

import com.expample.clush_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUserIdAndUserPw(String userId, String userPw);
}
