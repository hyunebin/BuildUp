package com.buildup.bu.Controller;

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
}
