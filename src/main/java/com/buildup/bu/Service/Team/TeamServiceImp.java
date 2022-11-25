package com.buildup.bu.Service.Team;

import com.buildup.bu.Model.Team.ClubRegistration;
import com.buildup.bu.Persist.Entity.Team;
import com.buildup.bu.Repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamServiceImp implements TeamService {
    private final TeamRepository teamRepository;

    @Override
    public boolean teamNameCheck(String teamName){
        Optional<Team> team = teamRepository.findByTeamName(teamName);

        return team.isPresent() ? false : true;
    }
    @Override
    public Team register(ClubRegistration clubRegistration) {
        Team team = ClubRegistration.of(clubRegistration);
        return teamRepository.save(team);
    }

}
