package com.coltla.ipldashboard.repository;

import com.coltla.ipldashboard.model.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {

  Team findByTeamName(String teamName);

}