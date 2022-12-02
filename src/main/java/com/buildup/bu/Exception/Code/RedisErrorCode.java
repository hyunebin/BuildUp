package com.buildup.bu.Exception.Code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum RedisErrorCode {
    NONEXISTENT_CERTIFY_CODE(HttpStatus.BAD_REQUEST, "존재하지 않는 인증 코드입니다.");

    private final HttpStatus httpStatus;
    private final String errorMesssage;
}
