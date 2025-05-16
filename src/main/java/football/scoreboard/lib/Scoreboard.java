package football.scoreboard.lib;

import java.util.*;
import java.util.stream.Collectors;

public class Scoreboard {
    private static final Scoreboard instance = new Scoreboard();
    private final List<Match> matches = new ArrayList<>();
    private int orderCounter = 0;


    public Scoreboard() {
    }

    public static Scoreboard getInstance() {
        return instance;
    }

    public void startGame(String homeTeam, String awayTeam) {
        if (homeTeam == null || awayTeam == null || homeTeam.equals(awayTeam))
            throw new IllegalArgumentException("Invalid team names");

        matches.add(new Match(homeTeam, awayTeam, orderCounter++));
    }


    public void finishGame(String homeTeam, String awayTeam) {
        matches.removeIf(m ->
                m.getHomeTeam().equals(homeTeam) && m.getAwayTeam().equals(awayTeam)
        );
    }

    public void updateScore(String homeTeam, String awayTeam, int homeScore, int awayScore) {
        for (Match match : matches) {
            if (match.getHomeTeam().equals(homeTeam) && match.getAwayTeam().equals(awayTeam)) {
                match.setHomeScore(homeScore);
                match.setAwayScore(awayScore);
                return;
            }
        }
        throw new NoSuchElementException("Match not found");
    }

    public List<Match> getSummary() {
        return matches.stream()
                .sorted(Comparator.<Match>comparingInt(m -> m.getHomeScore() + m.getAwayScore())
                        .reversed()
                        .thenComparing(Comparator.comparingInt(Match::getInsertionOrder).reversed()))

                .collect(Collectors.toList());
    }


    public void reset() {
        matches.clear();
    }
}


