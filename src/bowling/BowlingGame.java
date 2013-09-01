package bowling;

import java.util.ArrayList;
import java.util.List;
import static util.Constants.NEW_LINE;

public class BowlingGame {
	List<Game> games;
	private int currentFrameIndex;
	
	// 기본 플레이어는 1 명.
	BowlingGame() {
		games = new ArrayList<Game>();
		games.add(new Game());
		currentFrameIndex=1;
	}
	
	BowlingGame(int numberOfPlayer) {
		games = new ArrayList<Game>();
		for (int i = 0; i < numberOfPlayer; i++) {
			games.add(new Game());
		}
		currentFrameIndex=1;
	}

	public String generateLane() {
		StringBuilder sb = new StringBuilder();
//		for(Game game: games) {
		for(int i=0;i<games.size();i++) {		
			Game game = games.get(i);
			sb.append("Player "+(i+1));
			sb.append(NEW_LINE);
			sb.append(game.generatePlayerScore(new ConsoleGenerator()));
			sb.append(NEW_LINE);
		}
		return sb.toString();
	}	
		
	public void roll(int hitPoint) {
		for(int i=0;i<games.size();i++) {		
			Game game = games.get(i);
			if(game.getCurrentFrame()==currentFrameIndex) {
				System.out.println(game.getThrowInformation());
				game.roll(hitPoint);
				if(game.equals(games.get(games.size()-1))&&(game.getCurrentFrame()!=currentFrameIndex))
					currentFrameIndex++;
				break;
			}
		}

	}
}
