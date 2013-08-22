package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
	public static final int NUMBER_OF_FRAMES_PER_GAME = 10;

	private List<Frame> frames;

	/**
	 * 10프레임짜리 게임의 경우 마지막 프레임의 보너스 throw를 포함하는 1 roll짜리 효력만 지닌 Frame을 추가하여
	 * 11프레임을 만든다.
	 */
	Game() {
		frames = new ArrayList<Frame>();
		for (int i = 0; i < NUMBER_OF_FRAMES_PER_GAME + 1; i++) {
			this.frames.add(new Frame());
		}
	}
	
	public List<Frame> getFrames() {
		return frames;
	}
	
}
