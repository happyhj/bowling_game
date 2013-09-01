package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BowlingGame {
	List<Game> games;
	private int currentFrameIndex;

	// 기본 플레이어는 1 명.
	public BowlingGame() {
		games = new ArrayList<Game>();
		games.add(new Game());
		currentFrameIndex = 1;
	}

	BowlingGame(int numberOfPlayer) {
		games = new ArrayList<Game>();
		for (int i = 0; i < numberOfPlayer; i++) {
			games.add(new Game());
		}
		currentFrameIndex = 1;
	}
	
	public String generateLane(GameGenerable gameGenerator) {
		return gameGenerator.generateGameDashBoard(games,currentFrameIndex);

	}

	public String getThrowInformation() {
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

	public String roll(int hitPoint) throws GameOverException {
		for (int i = 0; i < games.size(); i++) {
			Game game = games.get(i);
			// 현재프레임을 현재프레임으로가진 첫 플레이어 탐색 (마지막프레임이 아닐 때)
			if ((game.getCurrentFrame() == currentFrameIndex)
					&& (currentFrameIndex < Game.NUMBER_OF_FRAMES_PER_GAME)) {
				game.roll(hitPoint);
				// 방금 던진 투구가 마지막 플레이어의 것이고, 해당 플레이어의 프레임이 종료되어 다음프레임으로 업데이트되었다면
				// 전체게임의 기준 프레임 번호도 업데이트
				if (game.equals(games.get(games.size() - 1))
						&& (game.getCurrentFrame() != currentFrameIndex))
					currentFrameIndex++;
				break;
			}
			// 이제 할 프레임이 마지막 프레임이라면 (예:10)
			// 게임 오버되지않은 첫 플레이어를 찾아 끝날때 까지 Roll 넣어줌
			if ((game.getCurrentFrame() >= currentFrameIndex)
					&& (currentFrameIndex == Game.NUMBER_OF_FRAMES_PER_GAME)
					&& (!game.isOver())) {
				game.roll(hitPoint);
				break;
			}
		}
		
		System.out.println(generateLane(new ConsoleGameGenerator()));
		
		// 모든 게임이 끝났을 경우 게임오버 입섹션을 던진다.
		for(Game game:games) {
			if(!game.isOver())
				return generateLane(new ConsoleGameGenerator());
		}
		
		throw new GameOverException("이 레인의 게임이 종료되었습니다.");
	}

	public static void main(String[] args) {
		System.out.println("볼링을 같이 할 플레이어의 수를 입력해 주세요.");
		Scanner sc = new Scanner(System.in);
		int numberOfPlayer = sc.nextInt();
		BowlingGame bowlingGame = new BowlingGame(numberOfPlayer);
		while(true) {
			System.out.println(bowlingGame.getThrowInformation());
			System.out.println("쓰러트린 핀의 수를 입력하세요.");
			Scanner pin = new Scanner(System.in);
			int hitPoint = pin.nextInt();
			bowlingGame.roll(hitPoint);
		}
	}
	
}
