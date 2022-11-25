package com.buildup.bu.Model.User;

import com.buildup.bu.Persist.Entity.Users;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUp {
    String phone;
    String age;
    String password;
    String email;
    String name;
    String verifyCode;

    public static Users of(SignUp signUp){
        return Users.builder()
                .phone(signUp.getPhone())
                .age(signUp.getAge())
                .password(signUp.getPassword())
                .email(signUp.getEmail())
                .name(signUp.getName())
                .verifyCode(signUp.getVerifyCode())
                .build();
    }

}
