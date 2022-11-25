package com.buildup.bu.Model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignUp {
    String phone;
    String age;
    String email;
    String name;
    String verifyCode;

}
