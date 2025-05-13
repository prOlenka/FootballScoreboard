package football.scoreboard.lib;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTest {

    private Scoreboard scoreboard;

    @BeforeEach
    void setUp() {
        scoreboard = Scoreboard.getInstance();
        scoreboard.reset();
    }

    @Test
    void testStartGameAddsMatch() {
        scoreboard.startGame("Team A", "Team B");
        assertEquals(1, scoreboard.getSummary().size());
    }

    @Test
    void testFinishGameRemovesMatch() {
        scoreboard.startGame("Team A", "Team B");
        scoreboard.finishGame("Team A", "Team B");
        assertTrue(scoreboard.getSummary().isEmpty());
    }

    @Test
    void testUpdateScore() {
        scoreboard.startGame("A", "B");
        scoreboard.updateScore("A", "B", 3, 2);
        Match match = scoreboard.getSummary().get(0);
        assertEquals(3, match.getHomeScore());
        assertEquals(2, match.getAwayScore());
    }

    @Test
    void testSummaryOrderingByTotalScore() {
        scoreboard.startGame("A", "B");
        scoreboard.updateScore("A", "B", 3, 2); // total 5

        scoreboard.startGame("C", "D");
        scoreboard.updateScore("C", "D", 2, 2); // total 4

        List<Match> summary = scoreboard.getSummary();
        assertEquals("A", summary.get(0).getHomeTeam());
    }

    @Test
    void testInvalidTeamNames() {
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame(null, "B"));
        assertThrows(IllegalArgumentException.class, () -> scoreboard.startGame("A", "A"));
    }
}
