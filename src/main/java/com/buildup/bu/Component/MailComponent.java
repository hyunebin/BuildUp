package com.buildup.bu.Component;


import com.buildup.bu.Exception.Code.MailErrorCode;
import com.buildup.bu.Exception.MailException;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

@RequiredArgsConstructor
@Component
public class MailComponent {
    private final JavaMailSender javaMailSender;

    public boolean sendMail(String mail, String subject, String text){

        boolean result = false;

        MimeMessagePreparator message = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
                mimeMessageHelper.setTo(mail);
                mimeMessageHelper.setSubject(subject);
                mimeMessageHelper.setText(text, true);

            }
        };

        try {
            javaMailSender.send(message);
            result = true;
        }catch (Exception e){
            throw new MailException(MailErrorCode.MAIL_SEND_FAIL);
        }

        return result;
    }
}
