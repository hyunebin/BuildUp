package com.buildup.bu.Service.Team;

import com.buildup.bu.Model.Team.ClubRegistration;
import com.buildup.bu.Persist.Entity.Team;

public interface TeamService {
    //구단 등록
    Team register(ClubRegistration clubRegistration);
    boolean teamNameCheck(String teamName);
}
