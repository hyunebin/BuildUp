package com.buildup.bu.Exception.Code;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MailErrorCode {

    MAIL_SEND_FAIL(HttpStatus.BAD_REQUEST,"메일 전송에 실패하였습니다.");
    private final HttpStatus httpStatus;
    private final String errorMessage;

}
