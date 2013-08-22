package bowling;

import junit.framework.TestCase;

public class GameTest extends TestCase {
	public void testCreate() throws Exception {
		Game game = new Game();
		assertEquals(11, game.getFrames().size());
	}
	public void testRollAndPrint() throws Exception {
		
	}
}
