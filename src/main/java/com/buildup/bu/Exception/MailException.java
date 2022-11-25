package com.buildup.bu.Exception;

import com.buildup.bu.Exception.Code.MailErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MailException extends RuntimeException{
    private MailErrorCode errorCode;
    private String errorMessage;

    public MailException(MailErrorCode errorCode){
        this.errorCode  = errorCode;
        this.errorMessage = errorCode.getErrorMessage();
    }
}
