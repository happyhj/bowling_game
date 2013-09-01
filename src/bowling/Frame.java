package bowling;

import java.util.ArrayList;
import java.util.List;

public class Frame {
	public static final int NUMBER_OF_PINS_PER_FRAME = 10;
	public static final int NUMBER_OF_ROLLS_PER_FRAME = 2;

	protected List<Roll> rolls;

	Frame() {
		rolls = new ArrayList<Roll>();
		for (int i = 0; i < NUMBER_OF_ROLLS_PER_FRAME; i++) {
			this.rolls.add(new Roll());
		}
	}

	public List<Roll> getRolls() {
		return rolls;
	}
	/**
	 * 입력받은 점수대로 공을 굴린다. 처음일 경우는 firstRoll에 점수를 넣고 두번째일 경우에는 secondRoll에, ... 모든
	 * 기회를 쓰고나서 공을 굴리면 아무작업도 하지않는다.
	 * @param score
	 */
	public void roll(int score) {
		for (Roll roll : rolls) {
			if (!roll.isRolled()) {
				roll.setScore(score);
				break;
			}
		}
	}

	/**
	 * 한번이라도 공을 굴렸다면 true를 반환한다.
	 * @return
	 */
	public boolean isStarted() {
		Roll firstRoll = rolls.get(0);
		if (firstRoll.isRolled())
			return true;
		return false;
	}

	/**
	 * 마지막 기회까지 모두 공을 굴렸다면 true를 반환한다.
	 * @return
	 */
	public boolean isFinished() {
		Roll lastRoll = rolls.get(rolls.size() - 1);
		if (lastRoll.isRolled())
			return true;
		if (isStrike())
			return true;
		return false;
	}

	/**
	 * 마지막 기회까지 공을 굴렸는데도 모든 핀을 처리하지 못했을 경우 true를 반환한다.
	 * @return
	 */
	public boolean isOpen() {
		if (!isFinished())
			return false;
		int scoreSum = 0;
		for (Roll roll : rolls) {
			if(roll.isRolled())
				scoreSum = scoreSum + roll.getScore();
		}
		if (scoreSum < NUMBER_OF_PINS_PER_FRAME)
			return true;
		return false;
	}

	public boolean isStrike() {
		if(rolls.get(0).getScore()==NUMBER_OF_PINS_PER_FRAME) {
			return true;
		}
		return false;
	}
	
	public boolean isSpare() {
		if(!isStrike()) {
			int scoreSum = 0;
			for(Roll roll:rolls) {
				if(roll.isRolled())
					scoreSum = scoreSum + roll.getScore();
			}
			if(scoreSum == NUMBER_OF_PINS_PER_FRAME)
				return true;
			return false;
		} return false;
	}	
	/**
	 * 현재프레임의 점수현황을 문자열로 출력한다.
	 * @return
	 */
	public String generateScore() {
		StringBuilder sb = new StringBuilder();
		int scoreSum = 0;
		for(Roll roll:rolls) {
			scoreSum = scoreSum + roll.getScore();
			
			// BEFORE ROLLED
			if(!roll.isRolled()) {
				sb.append("  ");
				continue;
			}
			// STRIKE
			if((roll.equals(rolls.get(0)))&&(scoreSum==NUMBER_OF_PINS_PER_FRAME)) {
				sb.append("X ");
				continue;
			}
			// SPARE
			if(roll.equals(rolls.get(NUMBER_OF_ROLLS_PER_FRAME-1))&&(scoreSum==NUMBER_OF_PINS_PER_FRAME)) {
				sb.append("/ ");
				continue;
			}
			// GUTTER
			if(roll.getScore()==0) {
				sb.append("- ");
				continue;
			}
			// OTHER
			sb.append(roll.getScore());
			
		}
		return sb.toString().substring(0,sb.toString().length()-1);
	}
	
	public int getScore(int index) {
		return rolls.get(index).getScore();
	}
}
