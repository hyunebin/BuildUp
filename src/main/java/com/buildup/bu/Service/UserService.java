package com.buildup.bu.Service;

import com.buildup.bu.Model.User.SignUp;
import com.buildup.bu.Persist.Entity.Users;

import java.util.Optional;

public interface UserService {
    //회원 가입
    Users register(SignUp signUp);

}
