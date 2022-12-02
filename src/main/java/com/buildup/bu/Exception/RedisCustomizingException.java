package com.buildup.bu.Exception;

import com.buildup.bu.Exception.Code.RedisErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RedisCustomizingException extends RuntimeException{
    private RedisErrorCode redisErrorCode;
    private String errorMessage;

    public RedisCustomizingException(RedisErrorCode errorCode){
        this.redisErrorCode = errorCode;
        this.errorMessage = errorCode.getErrorMesssage();
    }
}
