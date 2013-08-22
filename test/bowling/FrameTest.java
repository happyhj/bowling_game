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
}
