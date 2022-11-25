package com.buildup.bu.Exception.Code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserErrorCode {
    ALREADY_EXISTS_USER("이미 존재하는 유저 입니다.");


    private final String errorMessage;
}
