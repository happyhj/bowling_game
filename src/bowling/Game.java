package bowling;

import java.util.ArrayList;
import java.util.List;

import bowling.Generatable;

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
	public Game() {
		frames = new ArrayList<Frame>();
		for (int i = 0; i < NUMBER_OF_FRAMES_PER_GAME; i++) {
			this.frames.add(new Frame());
		}
		this.frames.add(new BonusFrame());
		calculatedScores=new int[NUMBER_OF_FRAMES_PER_GAME];
	}
	
	/**
	 * 규칙에 맞게 계산된 각 프레임에 해당하는 누적점수를 배열형태로 반환한다. 
	 * @return
	 */
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
	
	/**
	 * 투구한다.
	 * @param score
	 */
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
	
	/**
	 * 현재 게임이 종료되었는지 확인한다.
	 * @return
	 */
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
	
	
	/**
	 * 매번 투구를 하고나서 모든 프레임을 돌아가며 점수를 계산하여 calculatedScores멤버변수를 업데이트한다.
	 */
	public void updateCalculatedScores() {
		Frame frame;
		// finish된 frame이		
		for(int i=0;i<frames.size();i++) {
			frame = frames.get(i);

			//// open이거나 마지막프레임이 아닐 때 (예 10,11프레임이 아닐 때) - 굴린 투구의 핀 수를 더하여 점수로 저장한다.
			if(frame.isOpen()&&(i<frames.size()-2)) {
				this.calculatedScores[i] = frame.getRolls().get(0).getScore() + frame.getRolls().get(1).getScore();
				if(i-1>=0)
					this.calculatedScores[i] = this.calculatedScores[i] + this.calculatedScores[i-1];
				continue;
			}
		
			//// strike이고 마지막 프레임 아닐 경우
			if(frame.isStrike()&&(i<frames.size()-2)) {
				Frame nextFrame = frames.get(i+1);
				// 다음 프레임이 strike라면 현재투구 다음 하나밖에 확보하지 못했으므로 다다음 프레임이 Start 되어있는지 확인 후 시작되었다면 점수를 계산한다. 
				if(nextFrame.isStrike()) {
					Frame nextNextFrame= frames.get(i+2);
					if(nextNextFrame.isStarted()) {
						this.calculatedScores[i] = frames.get(i+2).getRolls().get(0).getScore() + (2 * Frame.NUMBER_OF_PINS_PER_FRAME);
						if(i-1>=0)
							this.calculatedScores[i] = this.calculatedScores[i] + this.calculatedScores[i-1];
						continue;
					}
				}
				// 다음 프레임이 strike가 아니고 다 투구하였다면 그냥 다음프레임의 점수로 점수 계산 가능하다 
				if(nextFrame.isSpare()||nextFrame.isOpen()) {
					this.calculatedScores[i] = nextFrame.getRolls().get(0).getScore() +nextFrame.getRolls().get(1).getScore() + Frame.NUMBER_OF_PINS_PER_FRAME;
					if(i-1>=0)
						this.calculatedScores[i] = this.calculatedScores[i] + this.calculatedScores[i-1];
					continue;
				}
			}	
			
			//// spare이고 마지막프레임(10,11)이 아닐경우 - 
			// 다음프레임의 첫번째 투구가 던져졌다면, 다음 프레임의 첫 투구핀수 + Frame.NUMBER_OF_PINS_PER_FRAME 를 점수로 저장한다.
			if(frame.isSpare()&&(i<frames.size()-2)&&(frames.get(i+1).getRolls().get(0).isRolled())) {
				List<Roll> nextFrameRolls = frames.get(i+1).getRolls();
				this.calculatedScores[i] = nextFrameRolls.get(0).getScore() + Frame.NUMBER_OF_PINS_PER_FRAME;
				if(i-1>=0)
					this.calculatedScores[i] = this.calculatedScores[i] + this.calculatedScores[i-1];
				continue;
			}
			
			//// 마지막 프레임(10)에서 오픈일 때 - 굴린 투구의 핀 수를 더하여 점수로 저장한다. 그리고 게임 끝
			if(frame.isOpen()&&(i==frames.size()-2)) {
				System.out.println("마지막 공굴리고 점수 계산 중 ");
				this.calculatedScores[i] = frame.getRolls().get(0).getScore() + frame.getRolls().get(1).getScore();
				if(i-1>=0)
					this.calculatedScores[i] = this.calculatedScores[i] + this.calculatedScores[i-1];
				continue;
			}			

			//// 보너스 프레임(11)굴리고나서 게임 끝났을때 - 마지막 프레임, 보너스프레임의 투구핀 수를 다 더하여 점수로저장한다. 게임 끝
			if(this.isOver()&&(i==frames.size()-1)&&(frame.isStarted())) {
				System.out.println("마지막 공굴리고 점수 계산 중 보너스");
				Frame prevFrame = frames.get(i-1);					
				
				this.calculatedScores[i-1] = prevFrame.getRolls().get(0).getScore();
				if(prevFrame.getRolls().get(1).isRolled())
					this.calculatedScores[i-1] = this.calculatedScores[i-1] + prevFrame.getRolls().get(1).getScore();
				if(frame.getRolls().get(0).isRolled())
					this.calculatedScores[i-1] = this.calculatedScores[i-1] + frame.getRolls().get(0).getScore();
				if(frame.getRolls().get(1).isRolled())
					this.calculatedScores[i-1] = this.calculatedScores[i-1] + frame.getRolls().get(1).getScore();

				if(i-1>=0)
					this.calculatedScores[i-1] = this.calculatedScores[i-1] + this.calculatedScores[i-2];
				
				continue;
			}
		}

	}
	
	public String generateLane(Generatable generator) {
		return generator.generateLane(frames, calculatedScores);
	}	
	
	public class GameOverException extends RuntimeException { 
		public GameOverException(String message) {
			super(message); 
		}
	}
}


