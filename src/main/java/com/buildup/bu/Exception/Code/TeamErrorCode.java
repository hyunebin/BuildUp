package com.buildup.bu.Exception.Code;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TeamErrorCode {
    AlREADY_EXIST_TEAM("이미 사용중인 구단명입니다");
    private final String errorMessage;
}
