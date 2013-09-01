package bowling;

import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
	public void testSingleGame() throws Exception {
		BowlingGame bowlingGame = new BowlingGame(1);
		bowlingGame.roll(9);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(1);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(8);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(0);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(8);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(0);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(8);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(1);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(9);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(1);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(8);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(1);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(9);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(1);
		System.out.println(bowlingGame.generateLane());

	}
}
