package com.buildup.bu.Exception.Code;

import lombok.*;

@Getter
@AllArgsConstructor
public enum MailErrorCode {

    MAIL_SEND_FAIL("메일 전송에 실패하였습니다.");
    private final String errorMessage;

}
