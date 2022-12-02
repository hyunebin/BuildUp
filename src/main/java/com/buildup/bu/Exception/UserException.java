package com.buildup.bu.Exception;

import com.buildup.bu.Exception.Code.MailErrorCode;
import com.buildup.bu.Exception.Code.UserErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserException extends RuntimeException{
    private UserErrorCode errorCode;
    private String errorMessage;


    public UserException(UserErrorCode errorCode){
        this.errorCode  = errorCode;
        this.errorMessage = errorCode.getErrorMessage();
    }
}
