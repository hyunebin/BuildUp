package com.buildup.bu.Exception;

import com.buildup.bu.Exception.Code.TeamErrorCode;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamException extends RuntimeException{
    private TeamErrorCode errorCode;
    private String errorMessage;

    public TeamException(TeamErrorCode teamErrorCode){
        this.errorCode = teamErrorCode;
        this.errorMessage = teamErrorCode.getErrorMessage();
    }
}
