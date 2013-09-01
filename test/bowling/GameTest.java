package bowling;

import junit.framework.TestCase;

public class GameTest extends TestCase {
/*
	public void testCurrentFrameAndCurrentRollIndex() throws Exception {
		Game game = new Game();
		assertEquals(false, game.isOver());
		assertEquals(1, game.getCurrentFrame());
		assertEquals(1, game.getCurrentRollIndex());
		game.roll(9);
		assertEquals(1, game.getCurrentFrame());
		assertEquals(2, game.getCurrentRollIndex());
		game.roll(1);
		assertEquals(2, game.getCurrentFrame());
		assertEquals(1, game.getCurrentRollIndex());
		game.roll(8);
		assertEquals(2, game.getCurrentFrame());
		assertEquals(2, game.getCurrentRollIndex());
		game.roll(0);
		assertEquals(3, game.getCurrentFrame());
		assertEquals(1, game.getCurrentRollIndex());
		game.roll(10);
		assertEquals(4, game.getCurrentFrame());
		assertEquals(1, game.getCurrentRollIndex());
		game.roll(10);
		assertEquals(5, game.getCurrentFrame());
		assertEquals(1, game.getCurrentRollIndex());
		game.roll(8);
		assertEquals(5, game.getCurrentFrame());
		assertEquals(2, game.getCurrentRollIndex());
		game.roll(0);
		assertEquals(6, game.getCurrentFrame());
		assertEquals(1, game.getCurrentRollIndex());
		game.roll(10);
		assertEquals(7, game.getCurrentFrame());
		assertEquals(1, game.getCurrentRollIndex());
		game.roll(8);
		assertEquals(7, game.getCurrentFrame());
		assertEquals(2, game.getCurrentRollIndex());
		game.roll(1);
		assertEquals(8, game.getCurrentFrame());
		assertEquals(1, game.getCurrentRollIndex());
		game.roll(9);
		assertEquals(8, game.getCurrentFrame());
		assertEquals(2, game.getCurrentRollIndex());
		game.roll(1);
		assertEquals(9, game.getCurrentFrame());
		assertEquals(1, game.getCurrentRollIndex());
		game.roll(8);
		assertEquals(9, game.getCurrentFrame());
		assertEquals(2, game.getCurrentRollIndex());
		game.roll(1);
		assertEquals(10, game.getCurrentFrame());
		assertEquals(1, game.getCurrentRollIndex());
		game.roll(10);
		assertEquals(11, game.getCurrentFrame());
		assertEquals(1, game.getCurrentRollIndex());
		game.roll(9);		
		assertEquals(11, game.getCurrentFrame());
		assertEquals(2, game.getCurrentRollIndex());
		game.roll(1);		
		assertEquals(0, game.getCurrentFrame());
		assertEquals(0, game.getCurrentRollIndex());
	}

	public void testIsOver() throws Exception {
		
		Game game = new Game();
		assertEquals(false, game.isOver());
		assertEquals(1, game.getCurrentFrame());
		game.roll(9);
		game.roll(1);
		game.roll(8);
		game.roll(0);	
		game.roll(10);
		game.roll(10);
		game.roll(8);
		game.roll(0);
		game.roll(10);
		game.roll(8);
		game.roll(1);
		game.roll(9);
		game.roll(1);
		game.roll(8);
		game.roll(1);
		game.roll(10);
		assertEquals(11, game.getCurrentFrame());
		assertEquals(false, game.isOver());
		game.roll(9);		
		assertEquals(false, game.isOver());
		assertEquals(11, game.getCurrentFrame());
		game.roll(1);
		assertEquals(true, game.isOver());
		assertEquals(0, game.getCurrentFrame());
		
		Game game1 = new Game();
		assertEquals(false, game1.isOver());
		assertEquals(1, game1.getCurrentFrame());
		game1.roll(9);
		game1.roll(1);
		game1.roll(8);
		game1.roll(0);	
		game1.roll(10);
		game1.roll(10);
		game1.roll(8);
		game1.roll(0);
		game1.roll(10);
		game1.roll(8);
		game1.roll(1);
		game1.roll(9);
		game1.roll(1);
		game1.roll(8);
		game1.roll(1);
		game1.roll(8);
		assertEquals(10, game1.getCurrentFrame());
		assertEquals(false, game1.isOver());
		game1.roll(2);		
		assertEquals(false, game1.isOver());
		assertEquals(11, game1.getCurrentFrame());
		game1.roll(1);
		assertEquals(true, game1.isOver());
		assertEquals(0, game1.getCurrentFrame());		
		
		Game game2 = new Game();
		assertEquals(false, game2.isOver());
		assertEquals(1, game2.getCurrentFrame());
		game2.roll(9);
		game2.roll(1);
		game2.roll(8);
		game2.roll(0);	
		game2.roll(10);
		game2.roll(10);
		game2.roll(8);
		game2.roll(0);
		game2.roll(10);
		game2.roll(8);
		game2.roll(1);
		game2.roll(9);
		game2.roll(1);
		game2.roll(8);
		game2.roll(1);
		game2.roll(8);
		assertEquals(10, game2.getCurrentFrame());
		assertEquals(false, game2.isOver());
		game2.roll(1);		
		assertEquals(true, game2.isOver());
		assertEquals(0, game2.getCurrentFrame());
		game2.roll(1);
		assertEquals(true, game2.isOver());
		assertEquals(0, game2.getCurrentFrame());	
	}

	public void testRollAndPrint() throws Exception {
		Game game = new Game();
		assertEquals("                     ", game.generateGameScore());
		game.roll(9);
		game.roll(1);
		assertEquals("9/                   ", game.generateGameScore());
		game.roll(8);
		game.roll(0);
		game.roll(10);
		game.roll(10);
		game.roll(8);
		game.roll(0);
		assertEquals("9/8-X X 8-           ", game.generateGameScore());
		game.roll(10);
		game.roll(8);
		game.roll(1);
		game.roll(9);
		game.roll(1);
		game.roll(8);
		game.roll(1);
		game.roll(10);
		game.roll(9);
		game.roll(1);
		assertEquals("9/8-X X 8-X 819/81X9/", game.generateGameScore());
	}
	
	public void testCalculatedScores() throws Exception {
		Game game = new Game();
		game.roll(9);
		game.roll(1);
		game.roll(8);
		game.roll(0);
		game.roll(10);
		game.roll(10);
		game.roll(8);
		game.roll(0);
		game.roll(10);
		game.roll(8);
		game.roll(1);
		game.roll(9);
		game.roll(1);
		game.roll(8);
		game.roll(1);
		game.roll(10);
		game.roll(9);
		game.roll(1);
		assertEquals(18, game.getCalculatedScores()[0]);	
		assertEquals(26, game.getCalculatedScores()[1]);		
		assertEquals(54, game.getCalculatedScores()[2]);		
		assertEquals(72, game.getCalculatedScores()[3]);		
		assertEquals(80, game.getCalculatedScores()[4]);		
		assertEquals(99, game.getCalculatedScores()[5]);		
		assertEquals(108, game.getCalculatedScores()[6]);		
		assertEquals(126, game.getCalculatedScores()[7]);		
		assertEquals(135, game.getCalculatedScores()[8]);		
		assertEquals(155, game.getCalculatedScores()[9]);	

		Game game1 = new Game();
		game1.roll(9);
		game1.roll(1);
		game1.roll(8);
		game1.roll(0);
		game1.roll(10);
		game1.roll(10);
		game1.roll(8);
		game1.roll(0);
		game1.roll(10);
		game1.roll(8);
		game1.roll(1);
		game1.roll(9);
		game1.roll(1);
		game1.roll(8);
		game1.roll(1);
		game1.roll(9);
		game1.roll(1);
		game1.roll(10);
		assertEquals(18, game1.getCalculatedScores()[0]);	
		assertEquals(26, game1.getCalculatedScores()[1]);		
		assertEquals(54, game1.getCalculatedScores()[2]);		
		assertEquals(72, game1.getCalculatedScores()[3]);		
		assertEquals(80, game1.getCalculatedScores()[4]);		
		assertEquals(99, game1.getCalculatedScores()[5]);		
		assertEquals(108, game1.getCalculatedScores()[6]);		
		assertEquals(126, game1.getCalculatedScores()[7]);		
		assertEquals(135, game1.getCalculatedScores()[8]);		
		assertEquals(155, game1.getCalculatedScores()[9]);
		
		Game game2 = new Game();
		game2.roll(9);
		game2.roll(1);
		game2.roll(8);
		game2.roll(0);
		game2.roll(10);
		game2.roll(10);
		game2.roll(8);
		game2.roll(0);
		assertEquals(18, game2.getCalculatedScores()[0]);	
		assertEquals(26, game2.getCalculatedScores()[1]);		
		assertEquals(54, game2.getCalculatedScores()[2]);		
		assertEquals(72, game2.getCalculatedScores()[3]);		
		assertEquals(80, game2.getCalculatedScores()[4]);		
		assertEquals(0, game2.getCalculatedScores()[5]);		
		assertEquals(0, game2.getCalculatedScores()[6]);		
		assertEquals(0, game2.getCalculatedScores()[7]);		
		assertEquals(0, game2.getCalculatedScores()[8]);		
		assertEquals(0, game2.getCalculatedScores()[9]);
		game2.roll(10);
		game2.roll(8);
		game2.roll(1);
		game2.roll(9);
		game2.roll(1);
		game2.roll(8);
		game2.roll(1);
		game2.roll(9);
		game2.roll(0);
		game2.roll(10);
		assertEquals(18, game2.getCalculatedScores()[0]);	
		assertEquals(26, game2.getCalculatedScores()[1]);		
		assertEquals(54, game2.getCalculatedScores()[2]);		
		assertEquals(72, game2.getCalculatedScores()[3]);		
		assertEquals(80, game2.getCalculatedScores()[4]);		
		assertEquals(99, game2.getCalculatedScores()[5]);		
		assertEquals(108, game2.getCalculatedScores()[6]);		
		assertEquals(126, game2.getCalculatedScores()[7]);		
		assertEquals(135, game2.getCalculatedScores()[8]);		
		assertEquals(144, game2.getCalculatedScores()[9]);
	}

	public void testScoreBoard() throws Exception {
		Game game = new Game();
		game.roll(9);
		game.roll(1);
		game.roll(8);
		game.roll(0);
		game.roll(10);
		game.roll(10);
		game.roll(8);
		game.roll(0);
		game.roll(10);
		game.roll(8);
		game.roll(1);
		game.roll(9);
		game.roll(1);
		game.roll(8);
		game.roll(1);
		System.out.println(game.generateGameScore());
		System.out.println(game.generateCalculatedScores());
		game.roll(9);
		System.out.println(game.generateGameScore());
		System.out.println(game.generateCalculatedScores());
		game.roll(1);
		System.out.println(game.generateGameScore());
		System.out.println(game.generateCalculatedScores());
		game.roll(10);

	System.out.println(game.generateGameScore());
	System.out.println(game.generateCalculatedScores());	
		assertEquals(18, game.getCalculatedScores()[0]);	
		assertEquals(26, game.getCalculatedScores()[1]);		
		assertEquals(54, game.getCalculatedScores()[2]);		
		assertEquals(72, game.getCalculatedScores()[3]);		
		assertEquals(80, game.getCalculatedScores()[4]);		
		assertEquals(99, game.getCalculatedScores()[5]);		
		assertEquals(108, game.getCalculatedScores()[6]);		
		assertEquals(126, game.getCalculatedScores()[7]);		
		assertEquals(135, game.getCalculatedScores()[8]);		
		assertEquals(155, game.getCalculatedScores()[9]);
	}
	*/
	public void testPerfectGame() throws Exception {
		Game game = new Game();
		game.roll(10);
		System.out.println(game.generateLane(new ConsoleGenerator()));
		game.roll(10);
		System.out.println(game.generateLane(new ConsoleGenerator()));
		game.roll(10);
		System.out.println(game.generateLane(new ConsoleGenerator()));
		game.roll(10);
		System.out.println(game.generateLane(new ConsoleGenerator()));
		game.roll(10);
		System.out.println(game.generateLane(new ConsoleGenerator()));
		game.roll(10);
		System.out.println(game.generateLane(new ConsoleGenerator()));
		game.roll(10);
		System.out.println(game.generateLane(new ConsoleGenerator()));
		game.roll(10);
		System.out.println(game.generateLane(new ConsoleGenerator()));
		game.roll(10);
		System.out.println(game.generateLane(new ConsoleGenerator()));
		game.roll(10);
		System.out.println(game.generateLane(new ConsoleGenerator()));
		game.roll(10);
		System.out.println(game.generateLane(new ConsoleGenerator()));
		game.roll(10);		
		System.out.println(game.generateLane(new ConsoleGenerator()));
	
	}
}
