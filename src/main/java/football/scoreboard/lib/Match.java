package football.scoreboard.lib;

import java.time.LocalDateTime;

public class Match {
    private final String homeTeam;
    private final String awayTeam;
    private int homeScore;
    private int awayScore;
    private final int insertionOrder;

    public Match(String homeTeam, String awayTeam, int insertionOrder) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.insertionOrder = insertionOrder;
        this.homeScore = 0;
        this.awayScore = 0;
    }
    public int getInsertionOrder() {
        return insertionOrder;
    }

    public String getHomeTeam() { return homeTeam; }
    public String getAwayTeam() { return awayTeam; }
    public int getHomeScore() { return homeScore; }
    public int getAwayScore() { return awayScore; }
    public void setHomeScore(int score) { this.homeScore = score; }
    public void setAwayScore(int score) { this.awayScore = score; }

    @Override
    public String toString() {
        return homeTeam + " " + homeScore + " – " + awayTeam + " " + awayScore;
    }
}

