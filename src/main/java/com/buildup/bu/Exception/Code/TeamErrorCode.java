package com.buildup.bu.Exception.Code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum TeamErrorCode {
    AlREADY_EXIST_TEAM(HttpStatus.BAD_REQUEST,"이미 사용중인 구단명입니다");
    private final HttpStatus httpStatus;
    private final String errorMessage;
}
