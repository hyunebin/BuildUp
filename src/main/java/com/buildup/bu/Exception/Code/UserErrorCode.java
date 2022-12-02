package com.buildup.bu.Exception.Code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum UserErrorCode {
    ALREADY_EXISTS_USER( HttpStatus.BAD_REQUEST,"이미 존재하는 유저 입니다."),
    NOT_EXISTS_USER( HttpStatus.BAD_REQUEST,"존재하지 않는 유저입니다.");


    private final HttpStatus httpStatus;
    private final String errorMessage;
}
