package com.coltla.ipldashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.coltla.ipldashboard.model.Team;
import com.coltla.ipldashboard.repository.MatchRepository;
import com.coltla.ipldashboard.repository.TeamRepository;

@RestController
public class TeamController {

  @Autowired
  private TeamRepository teamRepository;

  @Autowired
  private MatchRepository matchRepository;

  @GetMapping("/team/{teamName}")
  public Team getTeam(@PathVariable String teamName) {
    Team team = this.teamRepository.findByTeamName(teamName);
    int lastMatches = 3;

    team.setMatches(this.matchRepository.findLatestMatchesByTeam(teamName, lastMatches));

    return team;
  }
}
