package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TeamService {

    public void formTeam() {
        TeamRepository.formTeam();
    }

    public void changeTeamName(Integer teamId, String teamName) {
        TeamRepository.getTeamById(teamId).setName(teamName);
    }

    public List<Team> getTeam() {
        return TeamRepository.getAllTeams();
    }
}
