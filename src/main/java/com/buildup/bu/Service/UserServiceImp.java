package com.buildup.bu.Service;

import com.buildup.bu.Component.MailComponent;
import com.buildup.bu.Exception.Code.UserErrorCode;
import com.buildup.bu.Exception.UserException;
import com.buildup.bu.Model.User.SignUp;
import com.buildup.bu.Persist.Entity.Users;
import com.buildup.bu.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{
    private static final String SUBJECT = "안녕하세요 인증확인 메일 입니다.";
    private final MailComponent mailComponent;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Users register(SignUp signUp) {
        Optional<Users> users = userRepository.findByEmail(signUp.getEmail());

        if(users.isPresent()){
            throw new UserException(UserErrorCode.ALREADY_EXISTS_USER);
        }
        //10자리 랜덤 String 생성
        String code  = RandomStringUtils.random(10,true,true);
        signUp.setPassword(passwordEncoder.encode(signUp.getPassword()));
        signUp.setVerifyCode(code);
        mailComponent.sendMail(signUp.getEmail(),SUBJECT,getVerificationEmailBody(signUp.getEmail(),signUp.getName(),code));
        Users user = userRepository.save(SignUp.of(signUp));

        return user;
    }

    private String getVerificationEmailBody(String email, String name, String code){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(name)
                .append("님 인증을 완료해 주세요" + "\n")
                .append("http://localhost:8080/customer/signup/verify?email=")
                .append(email)
                .append("&code=")
                .append(code)
                .toString();
    }


}
