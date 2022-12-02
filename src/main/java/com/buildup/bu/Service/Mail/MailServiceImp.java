package com.buildup.bu.Service.Mail;

import com.buildup.bu.Component.MailComponent;
import com.buildup.bu.Exception.Code.RedisErrorCode;
import com.buildup.bu.Exception.Code.UserErrorCode;
import com.buildup.bu.Exception.MailException;
import com.buildup.bu.Exception.RedisCustomizingException;
import com.buildup.bu.Exception.UserException;
import com.buildup.bu.Model.User.SignUp;
import com.buildup.bu.Persist.Entity.Users;
import com.buildup.bu.Repository.UserRepository;
import io.lettuce.core.RedisException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Duration;
import java.util.Optional;
@Slf4j
@Service
@RequiredArgsConstructor
public class MailServiceImp implements MailService{
    private static final String SUBJECT = "안녕하세요 Build UP! 이메일 인증입니다. ";
    private final UserRepository userRepository;
    private final MailComponent mailComponent;
    private final RedisTemplate redisTemplate;


    public String send(SignUp signUp){

        Optional<Users> users = userRepository.findByEmail(signUp.getEmail());

        if(users.isPresent()){
            throw new UserException(UserErrorCode.ALREADY_EXISTS_USER);
        }
        //10자리 랜덤 String 생성
        String code  = RandomStringUtils.random(10,true,true);
        mailComponent.sendMail(signUp.getEmail(),SUBJECT,getVerificationEmailBody(signUp.getEmail(),signUp.getName(),code));
        //redis에 랜덤 string 코드 저장 만료시간 3분
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        vop.set("emailCertifyCode", code, Duration.ofSeconds(180));
        return code;
    }
    private String getVerificationEmailBody(String email, String name, String code){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(name)
                .append("님 인증을 완료해 주세요" + "\n")
                .append("\n 인증 번호")
                .append(code)
                .toString();
    }
    public boolean certifyEmail(String code){
        log.info(code);
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        String certifyCode = Optional.ofNullable(vop.get("emailCertifyCode")).orElseThrow(()-> new RedisCustomizingException(RedisErrorCode.NONEXISTENT_CERTIFY_CODE));
        log.info(certifyCode);

        return code.equals(certifyCode);
    }
}
