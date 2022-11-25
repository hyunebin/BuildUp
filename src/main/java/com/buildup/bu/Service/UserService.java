package com.buildup.bu.Service;

import com.buildup.bu.Model.User.SignIn;
import com.buildup.bu.Model.User.SignUp;
import com.buildup.bu.Persist.Entity.Users;

public interface UserService {
    //회원 가입
    public Users register(SignUp signUp);

}
