package com.buildup.bu.Model.Team;

import com.buildup.bu.Persist.Entity.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClubRegistration {
    private String teamName;
    private String region;
    private Integer teamSize;
    private String gameType;
    private String teamImg;
    private String level;
    private String intro;

    public static Team of(ClubRegistration clubRegistration){
        return Team.builder()
                .teamName(clubRegistration.getTeamName())
                .region(clubRegistration.getRegion())
                .teamSize(clubRegistration.getTeamSize())
                .gameType(clubRegistration.getGameType())
                .teamImg(clubRegistration.getTeamImg())
                .level(clubRegistration.getLevel())
                .intro(clubRegistration.getIntro())
                .build();
    }
}
