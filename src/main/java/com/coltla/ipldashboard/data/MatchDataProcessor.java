package com.coltla.ipldashboard.data;

import com.coltla.ipldashboard.model.Match;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

  private static final Logger log = LoggerFactory.getLogger(MatchDataProcessor.class);

  @Nullable
  @Override
  public Match process(@NonNull final MatchInput matchInput) throws Exception {
    Match match = new Match();

    match.setId(Long.parseLong(matchInput.getId()));
    match.setCity(matchInput.getCity());

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    match.setDate(LocalDate.parse(matchInput.getDate(), formatter));

    match.setPlayerOfMatch(matchInput.getPlayer_of_match());
    match.setVenue(matchInput.getVenue());

    // Set team 1 and team 2 depending on the innings order
    String firstInningsTeam, secondInningsTeam;
    if ("bat".equals(matchInput.getToss_decision())) {
      firstInningsTeam = matchInput.getToss_winner();
      secondInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())
          ? matchInput.getTeam2()
          : matchInput.getTeam1();
    } else {
      secondInningsTeam = matchInput.getToss_winner();
      firstInningsTeam = matchInput.getToss_winner().equals(matchInput.getTeam1())
          ? matchInput.getTeam2()
          : matchInput.getTeam1();
    }

    match.setTeam1(firstInningsTeam);
    match.setTeam2(secondInningsTeam);

    match.setMatchWinner(matchInput.getWinner());
    match.setTossWinner(matchInput.getToss_winner());
    match.setTossDecision(matchInput.getToss_decision());
    match.setResult(matchInput.getResult());
    match.setResultMargin(matchInput.getResult_margin());

    match.setUmpire1(matchInput.getUmpire1());
    match.setUmpire2(matchInput.getUmpire2());

    return match;
  }

}
