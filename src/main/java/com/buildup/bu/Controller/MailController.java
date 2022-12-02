package com.buildup.bu.Controller;

import com.buildup.bu.Model.CertifyCode.MailCertifyCode;
import com.buildup.bu.Model.User.SignUp;
import com.buildup.bu.Service.Mail.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mail")
public class MailController {
    private final MailService mailService;
    @PostMapping("/send")
    public String mailSend(@RequestBody SignUp signUp){
        String code = mailService.send(signUp);
        return code;
    }
    @PostMapping("/certify")
    public boolean emailCertify(@RequestBody MailCertifyCode code){
        return mailService.certifyEmail(code.getCode());
    }
}
