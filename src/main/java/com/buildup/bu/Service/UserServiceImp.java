package com.buildup.bu.Service;

import com.buildup.bu.Component.MailComponent;
import com.buildup.bu.Model.User.SignIn;
import com.buildup.bu.Model.User.SignUp;
import com.buildup.bu.Persist.Entity.User;
import com.buildup.bu.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
    private final MailComponent component;
    private final UserRepository userRepository;


    @Override
    public boolean register(SignUp signUp) {
        User user = userRepository.findByEmail(signUp.getEmail()).orElseThrow();


        //10자리 랜덤 String 생성
        String code  = RandomStringUtils.random(10);




        return false;
    }


}
