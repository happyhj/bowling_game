package bowling;

import junit.framework.TestCase;

public class FrameTest extends TestCase {
	public void testStartedFinishedOpen() throws Exception {
		Frame frame = new Frame();
		assertEquals(false, frame.isStarted());
		assertEquals(false, frame.isFinished());
		assertEquals(false, frame.isOpen());
		frame.roll(6);
		assertEquals(true, frame.isStarted());
		assertEquals(false, frame.isFinished());
		assertEquals(false, frame.isOpen());
		frame.roll(3);
		assertEquals(true, frame.isStarted());
		assertEquals(true, frame.isFinished());
		assertEquals(true, frame.isOpen());

		Frame frame2 = new Frame();
		assertEquals(false, frame2.isStarted());
		assertEquals(false, frame2.isFinished());
		assertEquals(false, frame2.isOpen());
		frame2.roll(6);
		assertEquals(true, frame2.isStarted());
		assertEquals(false, frame2.isFinished());
		assertEquals(false, frame2.isOpen());
		frame2.roll(4);
		assertEquals(true, frame2.isStarted());
		assertEquals(true, frame2.isFinished());
		assertEquals(false, frame2.isOpen());
	}
	public void testRollAndGetSymbol() throws Exception {
		Frame frame = new Frame();
		assertEquals("  ", frame.generateScore());
		frame.roll(9);
		assertEquals("9 ", frame.generateScore());
		frame.roll(1);
		assertEquals("9/", frame.generateScore());
		Frame frame2 = new Frame();
		frame2.roll(8);
		assertEquals("8 ", frame2.generateScore());
		frame2.roll(0);
		assertEquals("8-", frame2.generateScore());

		Frame frame3 = new Frame();
		frame3.roll(10);
		assertEquals("X ", frame3.generateScore());
	}
	
	public void testSpareStrike() throws Exception {
		Frame frame3 = new Frame();
		assertEquals(false, frame3.isStrike());		
		frame3.roll(10);
		assertEquals(true, frame3.isStrike());		
		Frame frame = new Frame();
		frame.roll(9);
		assertEquals(false, frame.isSpare());
		frame.roll(1);
		assertEquals(true, frame.isSpare());
		assertEquals(false, frame.isStrike());		
		Frame frame2 = new Frame();
		frame2.roll(8);
		frame2.roll(0);
		assertEquals(false, frame2.isSpare());
		assertEquals(false, frame2.isStrike());		
	}
}
