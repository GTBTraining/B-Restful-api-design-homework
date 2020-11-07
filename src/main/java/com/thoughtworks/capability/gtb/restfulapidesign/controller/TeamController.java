package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamController {
    final TeamService teamService;
    public TeamController(TeamService teamService){
        this.teamService=teamService;
    }

    @GetMapping("/teams")
    public ResponseEntity<List<Team>> formTeams() {
        return ResponseEntity.ok(teamService.formTeam());
    }
}
