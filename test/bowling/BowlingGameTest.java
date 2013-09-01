package bowling;

import junit.framework.TestCase;

public class BowlingGameTest extends TestCase {
/*
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
		assertEquals("플레이어1의 10번째 프레임, 1번째 투구",bowlingGame.getThrowInformation());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.generateLane());
		assertEquals("플레이어1의 10번째 프레임, 2번째 투구",bowlingGame.getThrowInformation());
		bowlingGame.roll(9);
		System.out.println(bowlingGame.generateLane());
		assertEquals("플레이어1의 10번째 프레임, 3번째 투구",bowlingGame.getThrowInformation());

		bowlingGame.roll(1);
		System.out.println(bowlingGame.generateLane());
		assertEquals("Player 1\n|9 /|8 -|X  |X  |8 -|X  |8 1|9 /|8 1|X9/|\n|18 |26 |54 |72 |80 |99 |108|126|135|155|\n",bowlingGame.generateLane());		
	}
*/	
	public void testTwoPlayer() throws Exception {
		BowlingGame bowlingGame = new BowlingGame(2);
		
		bowlingGame.roll(9);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(1);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(9);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(1);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(8);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(0);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(8);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(0);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(8);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(0);
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
		bowlingGame.roll(1);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(8);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(1);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(9);
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
		bowlingGame.roll(8);
		System.out.println(bowlingGame.generateLane());
		bowlingGame.roll(1);
		System.out.println(bowlingGame.generateLane());

		assertEquals("플레이어1의 10번째 프레임, 1번째 투구",bowlingGame.getThrowInformation());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.generateLane());

		assertEquals("플레이어1의 10번째 프레임, 2번째 투구",bowlingGame.getThrowInformation());

		bowlingGame.roll(9);
		System.out.println(bowlingGame.generateLane());

		assertEquals("플레이어1의 10번째 프레임, 3번째 투구",bowlingGame.getThrowInformation());

		bowlingGame.roll(1);
		System.out.println(bowlingGame.generateLane());

		assertEquals("플레이어2의 10번째 프레임, 1번째 투구",bowlingGame.getThrowInformation());
		bowlingGame.roll(10);
		System.out.println(bowlingGame.generateLane());

		assertEquals("플레이어2의 10번째 프레임, 2번째 투구",bowlingGame.getThrowInformation());

		bowlingGame.roll(9);
		System.out.println(bowlingGame.generateLane());

		assertEquals("플레이어2의 10번째 프레임, 3번째 투구",bowlingGame.getThrowInformation());

		bowlingGame.roll(1);
		System.out.println(bowlingGame.generateLane());
	}
}
