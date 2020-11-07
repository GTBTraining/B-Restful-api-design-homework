package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TeamRepository {
    public static final List<Team> allTeams = new ArrayList<>();

    public static void formTeam() {
        List<Student> allStudents = StudentRepository.getAllStudents();
        List<Student> tempList = new ArrayList<>();
        tempList.addAll(allStudents);
        Collections.shuffle(tempList);

        for (int i = 0; i < 6; i++) {
            List<Student> TeamMembers = new ArrayList<>();
            allTeams.add(new Team(i+1,null,null, TeamMembers));
        }

        for (int i = 0; i < tempList.size(); i++) {
            if (i < 6) {
                List<Student> students = allTeams.get(i).getStudentList();
                students.add(tempList.get(i));
                allTeams.get(i).setStudentList(students);
            } else {
                List<Student> TeamMembers = allTeams.get(i % 6).getStudentList();
                TeamMembers.add(tempList.get(i));
                allTeams.get(i % 6).setStudentList(TeamMembers);
            }
        }
    }


    public static Team getTeamById(Integer teamId) {
   return allTeams.stream().filter(team -> team.getId().equals(teamId)).collect(Collectors.toList()).get(0);
    }

    public static List<Team> getAllTeams() {
        return allTeams;
    }
}
