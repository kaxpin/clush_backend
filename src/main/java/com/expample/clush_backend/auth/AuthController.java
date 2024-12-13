package com.expample.clush_backend.auth;

import com.expample.clush_backend.dto.ClushResponse;
import com.expample.clush_backend.model.User;
import com.expample.clush_backend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/auth/signup")
    public ResponseEntity<?> createAccount(@RequestBody User user) {

        try {
            authService.inseltAccount(user);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ClushResponse(200,user.getUserId(),"회원 가입 성공"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ClushResponse(500,user.getUserId(),e.getMessage()));
        }
    }

    @GetMapping("/auth/signup/check/{userId}")
    public ResponseEntity<?> checkDupId(@PathVariable String userId) {
        try {
            boolean result = authService.checkDupId(userId);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ClushResponse(200, result, result ? "아이디 중복 없음" : "아이디 중복"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ClushResponse(500,userId,e.getMessage()));
        }
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        try {
            boolean result = authService.checkAccount(user);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ClushResponse(200, result, result ? "로그인" : "사용자 없음"));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ClushResponse(500, user, e.getMessage()));
        }
    }


}
