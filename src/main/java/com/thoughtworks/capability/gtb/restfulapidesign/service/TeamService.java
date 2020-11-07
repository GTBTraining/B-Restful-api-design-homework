package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TeamService {

    public List<Team> formTeam() {
        List<Student> allStudents = StudentRepository.getAllStudents();
        List<Student> tempList = new ArrayList<>();
        tempList.addAll(allStudents);
        Collections.shuffle(tempList);

        List<Team> AllTeams = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            List<Student> TeamMembers = new ArrayList<>();
            AllTeams.add(new Team(i+1,null,null, TeamMembers));
        }

        for (int i = 0; i < tempList.size(); i++) {
            if (i < 6) {
                List<Student> students = AllTeams.get(i).getStudentList();
                students.add(tempList.get(i));
                AllTeams.get(i).setStudentList(students);
            } else {
                List<Student> TeamMembers = AllTeams.get(i % 6).getStudentList();
                TeamMembers.add(tempList.get(i));
                AllTeams.get(i % 6).setStudentList(TeamMembers);
            }
        }
        return AllTeams;
    }
}
