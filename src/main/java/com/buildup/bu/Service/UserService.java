package com.buildup.bu.Service;

import com.buildup.bu.Model.User.SignIn;
import com.buildup.bu.Model.User.SignUp;

public interface UserService {
    //회원 가입
    public boolean register(SignUp signUp);

}
