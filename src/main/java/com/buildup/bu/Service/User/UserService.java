package com.buildup.bu.Service.User;

import com.buildup.bu.Model.User.SignIn;
import com.buildup.bu.Model.User.SignUp;
import com.buildup.bu.Persist.Entity.Users;

public interface UserService {
    //회원 가입
    Users register(SignUp signUp);

}
