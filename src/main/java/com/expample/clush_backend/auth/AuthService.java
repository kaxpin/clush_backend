package com.expample.clush_backend.auth;

import com.expample.clush_backend.exception.AuthException;
import com.expample.clush_backend.model.User;
import com.expample.clush_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    private UserRepository userRepository;

    public AuthService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //회원가입 등록
    @Transactional
    public User inseltAccount(User user){

        if(!checkDupId(user.getUserId())) {
            System.out.println("중복되는 아이디가 있음");
            throw new AuthException("중복되는 아이디가 있습니다.");
        }

        try{
//            user.setUserPw(AuthSecurityConfiguration.passwordEncoder().encode(user.getUserPw()));
            return userRepository.save(user);

        } catch (Exception e) {
            throw new RuntimeException("Error during user registration", e);
        }
    }

    //아이디 중복 체크 : T 가입가능
    public boolean checkDupId(String userId){
            return userRepository.findById(userId).isEmpty();
    }

    //로그인
    @Transactional
    public boolean checkAccount(User user){
        return userRepository.findByUserIdAndUserPw(user.getUserId(), user.getUserPw()).isPresent();
    }


}
