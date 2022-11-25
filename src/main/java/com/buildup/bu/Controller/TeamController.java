package com.buildup.bu.Controller;

import com.buildup.bu.Model.Team.ClubRegistration;
import com.buildup.bu.Persist.Entity.Team;
import com.buildup.bu.Service.Team.TeamServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/team")
public class TeamController {
    private final TeamServiceImp teamServiceImp;

    @GetMapping("nameCheck")
    public ResponseEntity<?> teamNameCheck(@RequestParam String teamName){ //DB에 구단명 중복검사
        boolean check = teamServiceImp.teamNameCheck(teamName);
        return ResponseEntity.ok().body(check);
    }

    @PostMapping("register") // 구단 정보 등록
    public ResponseEntity<?> register(@RequestBody ClubRegistration clubRegistration){
        Team team = teamServiceImp.register(clubRegistration);
        return ResponseEntity.ok().body(team);
    }
}
