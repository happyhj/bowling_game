package bowling;

public class BonusFrame extends Frame {

	/**
	 * 두번의 투구기회를 모두 허용한다.
	 * @return
	 */
	public boolean isFinished() {
		Roll lastRoll = rolls.get(rolls.size() - 1);
		if (lastRoll.isRolled())
			return true;
		return false;
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
				sb.append(" ");
				continue;
			}
			// STRIKE
			if((roll.getScore()==10)) {
				sb.append("X");
				continue;
			}
			// SPARE
			if(roll.equals(rolls.get(NUMBER_OF_ROLLS_PER_FRAME-1))&&(scoreSum==NUMBER_OF_PINS_PER_FRAME)) {
				sb.append("/");
				continue;
			}
			// GUTTER
			if(roll.getScore()==0) {
				sb.append("-");
				continue;
			}
			// OTHER
			sb.append(roll.getScore());
			
		}
		return sb.toString();
	}
		
}
