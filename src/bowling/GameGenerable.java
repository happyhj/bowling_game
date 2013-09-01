package bowling;

import java.util.List;

public interface GameGenerable {
	String generateGameDashBoard(List<Game> games, int currentFrameIndex);
}
