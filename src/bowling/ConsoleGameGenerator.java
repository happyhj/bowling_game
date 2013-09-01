package bowling;

import java.util.List;
import static util.Constants.NEW_LINE;

public class ConsoleGameGenerator implements GameGenerable {

	public String generateGameDashBoard(List<Game> games, int currentFrameIndex) {
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < games.size(); i++) {
			Game game = games.get(i);
			sb.append("Player " + (i + 1));
			sb.append(NEW_LINE);
			sb.append(game.generatePlayerScore(new ConsoleGenerator()));
			sb.append(NEW_LINE);
		}
		return sb.toString();
	}

	public String getThrowInformation(List<Game> games, int currentFrameIndex) {
		String throwInfo = "";
		for (int i = 0; i < games.size(); i++) {
			Game game = games.get(i);
			// (마지막프레임이 아닐 때)
			if ((game.getCurrentFrame() == currentFrameIndex)
					&& (currentFrameIndex < Game.NUMBER_OF_FRAMES_PER_GAME)) {
				throwInfo = "플레이어" + (i + 1) + "가(이) "
						+ game.getThrowInformation();
				break;
			}
			// (마지막프레임이상일 때)
			if ((game.getCurrentFrame() >= currentFrameIndex)
					&& (currentFrameIndex >= Game.NUMBER_OF_FRAMES_PER_GAME)) {
				throwInfo = "플레이어" + (i + 1) + "가(이) "
						+ game.getThrowInformation();
				break;
			}
		}
		throwInfo = throwInfo +"를 할 차례입니다.";
		
		if(throwInfo.length()<12)
			throwInfo = "게임 끝. 수고하셨습니다.";
		return throwInfo;
	}
}
