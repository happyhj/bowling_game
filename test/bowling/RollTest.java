package bowling;

import junit.framework.TestCase;

public class RollTest extends TestCase {
	public void testSetAndGetScore() throws Exception {
		Roll roll1 = new Roll();
		Roll roll2 = new Roll();

		roll1.setScore(0);
		assertEquals(0,	roll1.getScore(0));
		roll2.setScore(3);
		assertEquals(3,	roll2.getScore(3));
	}
}
