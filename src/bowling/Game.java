package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
	public static final int NUMBER_OF_FRAMES_PER_GAME = 10;

	private List<Frame> frames;
	private int[] calculatedScores;
	private int currentFrame = 1;
	private int currentRollIndex;
	
	/**
	 * 10프레임짜리 게임의 경우 마지막 프레임의 보너스 throw를 포함하는 1 roll짜리 효력만 지닌 Frame을 추가하여
	 * 11프레임을 만든다.
	 */
	Game() {
		frames = new ArrayList<Frame>();
		for (int i = 0; i < NUMBER_OF_FRAMES_PER_GAME + 1; i++) {
			this.frames.add(new Frame());
		}
		calculatedScores=new int[NUMBER_OF_FRAMES_PER_GAME];
	}
	public int[] getCalculatedScores() {
		return this.calculatedScores;
	}
	
	/**
	 * 현재 던질 투구의 프레임이 몇번째인지 반환한다.
	 * 게임이 끝났다면 0을 반환
	 * @return
	 */
	public int getCurrentFrame() {
		return currentFrame;
	}
	/**
	 * 현재 프레임 내에서 현재 던져야하는 투구가 몇번째 투구인지 반환한다.
	 * 프레임 내 첫번쨰 투구라면 1을 반환.
	 * 게임이 끝났다면 0을 반환
	 * @return
	 */
	public int getCurrentRollIndex() {
		if(isOver())
			return this.currentRollIndex;
		return this.currentRollIndex+1;
	}
	
	public void roll(int score) {
		for (Frame frame:frames){
			if(!frame.isFinished()) {
				if(!isOver()) {
					// 현재 투구정보 출력 부분 - 시작
					int currentRollIndex=0;
					while(true) {
						if(frames.get(currentFrame-1).getRolls().get(currentRollIndex).isRolled())
							currentRollIndex++;
						else 
							break;
					}
					currentRollIndex++;
					this.currentRollIndex = currentRollIndex;
					String rollPrint = currentFrame+"번째 프레임, "+currentRollIndex+"번째 투구 던짐, 핀 "+score+"개 쓰러트림";

					// 현재 투구정보 출력 부분 -끝 
					frame.roll(score);
					
					if(frame.isStrike())
						rollPrint = rollPrint + " STRIKE!!";
					if(frame.isSpare())
						rollPrint = rollPrint + " SPARE!";
					System.out.println(rollPrint);
					
					if(frame.isFinished()) {
						currentFrame++;
						this.currentRollIndex = 0;
					}
					if(isOver()) {
						currentFrame=0;
						this.currentRollIndex = 0;	
					}
					break;
				}
				// 끝나지 않은 (보너스)프레임 발견, 근데 게임은 끝나있는 경우 - 10프레임에서 오픈이 된 케이스
				if(isOver()) {
					System.out.println("게임이 끝났으므로 더이상 공을 던질 수 없습니다.");
					currentFrame=0;
					this.currentRollIndex = 0;	
					return;
				}
			} 		
		}
		updateCalculatedScores();
	}
	
	public boolean isOver() {
		Frame lastFrame = frames.get(NUMBER_OF_FRAMES_PER_GAME-1);
		Frame bonusFrame = frames.get(NUMBER_OF_FRAMES_PER_GAME);
		// 마지막 프레임이 끝났고 오픈이면 게임 끝
		if(lastFrame.isFinished()&&lastFrame.isOpen()) {
			System.out.println("마지막프레임이 오픈으로 보너스프레임없이게임끝");
			return true;		
		}
		// 마지막 프레임이 스트라이크면, 보너스프레임이 끝나야 게임이 끝남 
		if(lastFrame.isFinished()&&lastFrame.isStrike()&&bonusFrame.isFinished()) {
			System.out.println("마지막프레임이 스트라이크, 보너스프레임 두번굴리고 게임끝");
			return true;
		}
		
		// 마지막 프레임이 스페어면, 보너스 프레임의 시작되었으면 게임 끝남
		if(lastFrame.isFinished()&&lastFrame.isSpare()&&bonusFrame.isStarted()) {
			System.out.println("마지막프레임이 스페어, 보너스프레임 한번굴리고 게임끝");
			return true;
		}
		
		return false;
	}
	
	public void updateCalculatedScores() {
		System.out.println("점수 계산중...");
		Frame frame;
		// finish된 frame이
		 
		
		for(int i=0;i<frames.size()-1;i++) {
			frame = frames.get(i);
			
			//// open일 경우 - 굴린 투구의 핀 수를 더하여 점수로 저장한다.
			if(frame.isOpen()) {
				this.calculatedScores[i] = frame.getRolls().get(0).getScore() + frame.getRolls().get(1).getScore();
				if(i-1>=0)
					this.calculatedScores[i] = this.calculatedScores[i] + this.calculatedScores[i-1];
				continue;
			}
			//// strike일 경우
			if(frame.isStrike()) {
				Frame nextFrame = frames.get(i+1);
				if(nextFrame.isStrike()) {
					this.calculatedScores[i] = frames.get(i+2).getRolls().get(0).getScore() + (2 * Frame.NUMBER_OF_PINS_PER_FRAME);
					if(i-1>=0)
						this.calculatedScores[i] = this.calculatedScores[i] + this.calculatedScores[i-1];
					continue;
				}
				if(nextFrame.isSpare()||nextFrame.isOpen()) {
					this.calculatedScores[i] = nextFrame.getRolls().get(0).getScore() +nextFrame.getRolls().get(1).getScore() + Frame.NUMBER_OF_PINS_PER_FRAME;
					if(i-1>=0)
						this.calculatedScores[i] = this.calculatedScores[i] + this.calculatedScores[i-1];
					continue;
				}
			}	
			//// spare일 경우 - 다음프레임의 첫번째 투구가 던져졌다면, 다음 프레임의 첫 투구핀수 + Frame.NUMBER_OF_PINS_PER_FRAME 를 점수로 저장한다.
			if(frame.isSpare()&&(frames.get(i+1).getRolls().get(0).isRolled())) {
				List<Roll> nextFrameRolls = frames.get(i+1).getRolls();
				this.calculatedScores[i] = nextFrameRolls.get(0).getScore() + Frame.NUMBER_OF_PINS_PER_FRAME;
				if(i-1>=0)
					this.calculatedScores[i] = this.calculatedScores[i] + this.calculatedScores[i-1];
				continue;
			}	
		}

	}
	
	public String generateGameScore() {
		StringBuilder sb = new StringBuilder();
		for(Frame frame:frames){
			if(frame.equals(frames.get(NUMBER_OF_FRAMES_PER_GAME-1)))
				break;
			sb.append(frame.generateScore());
		}
		//// 여기부터 10번째 프레임 문자열 작업을 수행
		Frame lastFrame = frames.get(NUMBER_OF_FRAMES_PER_GAME-1);
		Frame bonusFrame = frames.get(NUMBER_OF_FRAMES_PER_GAME);
		
		// 아직 10번째 프레임을 플레이하지 않았을 때, 일반적 프레임수 +1의 공백을 넣어준다.
		if(!lastFrame.isStarted()) {
			sb.append(lastFrame.generateScore());
			sb.append(" ");
		}			
		/// 10프레임이 스트라이크인 경우 - 10번째 프레임 문자열 첫문자만 사용, 11번째 프레임 문자 모두 사용
		if(lastFrame.isStrike()) {
			sb.append(lastFrame.generateScore().substring(0, 1));
			sb.append(bonusFrame.generateScore());
		}
		/// 10프레임이 스페어인 경우 - 10번째 프레임 문자열 모두 사용, 11번째 프레임 첫 문자만 사용
		if(lastFrame.isSpare()) {
			sb.append(lastFrame.generateScore());
			sb.append(bonusFrame.generateScore().substring(0, 1));
		}
		/// 10프레임이 오픈인 경우 - 10번째 프레임 문자열 모두 사용 + 공백문자
		if(lastFrame.isOpen()) {
			sb.append(lastFrame.generateScore());
			sb.append(" ");
		}		
		
		String score = sb.toString();
		return score;
	}


	
}
