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
	public void testIsRolled() throws Exception {
		Roll roll1 = new Roll();
		Roll roll2 = new Roll();
		assertEquals(false,	roll2.isRolled());
		assertEquals(false,	roll1.isRolled());
		roll1.setScore(0);
		assertEquals(false,	roll2.isRolled());
		assertEquals(true,	roll1.isRolled());
		roll2.setScore(3);
		assertEquals(true,	roll2.isRolled());
		assertEquals(true,	roll1.isRolled());	
	}
}
