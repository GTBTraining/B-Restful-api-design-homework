package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teams")
public class TeamController {
    final TeamService teamService;
    public TeamController(TeamService teamService){
        this.teamService=teamService;
    }

    @GetMapping
    public ResponseEntity<List<Team>> formTeams() {
        return ResponseEntity.ok(teamService.formTeam());
    }

    @PutMapping
    public void namingTeam(@PathVariable Integer teamId ,@RequestBody String teamName){
      teamService.changeTeamName(teamId,teamName);
    }
}
