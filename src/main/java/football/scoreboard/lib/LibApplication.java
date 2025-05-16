package football.scoreboard.lib;

import java.util.List;

public class LibApplication {

	public static void main(String[] args) {
		Scoreboard scoreboard = Scoreboard.getInstance();
		scoreboard.reset();

		scoreboard.startGame("Mexico", "Canada");
		scoreboard.updateScore("Mexico", "Canada", 0, 5);

		scoreboard.startGame("Spain", "Brazil");
		scoreboard.updateScore("Spain", "Brazil", 10, 2);

		scoreboard.startGame("Germany", "France");
		scoreboard.updateScore("Germany", "France", 2, 2);

		scoreboard.startGame("Uruguay", "Italy");
		scoreboard.updateScore("Uruguay", "Italy", 6, 6);

		scoreboard.startGame("Argentina", "Australia");
		scoreboard.updateScore("Argentina", "Australia", 3, 1);

		List<Match> summary = scoreboard.getSummary();
		int i = 1;
		for (Match m : summary) {
			System.out.println(i++ + ". " + m);
		}

//		for (Match match : scoreboard.getSummary()) {
//			System.out.println(match + " | InsertionOrder: " + match.getInsertionOrder());
//		}

	}
}
