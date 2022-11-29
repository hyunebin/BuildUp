package com.buildup.bu.Service.Mail;

import com.buildup.bu.Model.User.SignUp;

public interface MailService {
    String send(SignUp signUp);
}
