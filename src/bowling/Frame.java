package bowling;

public class Frame {
	public static final int NUMBER_OF_PINS_PER_FRAME = 10;

	private Roll firstRoll, secondRoll;

	Frame() {
		this.firstRoll = new Roll();
		this.secondRoll = new Roll();
	}
	
	/**
	 * 입력받은 점수대로 공을 굴린다.
	 * 처음일 경우는 firstRoll에 점수를 넣고 두번째일 경우에는 secondRoll에 
	 * 모든 기회를 쓰고나서 공을 굴리면 아무작업도 하지않는다. 
	 * @param score
	 */
	public void roll(int score) {
		if(!firstRoll.isRolled()){
			firstRoll.setScore(score);
			return;
		} else if (!secondRoll.isRolled()) {
			secondRoll.setScore(score);	
			return;
		} else if (firstRoll.isRolled()&&secondRoll.isRolled()) {
			return;
		}
	}

	/**
	 * 한번이라도 공을 굴렸다면 true를 반환한다.
	 * @return
	 */
	public boolean isStarted() {
		if(firstRoll.isRolled())
			return true;
		return false;
	}
	/**
	 * 마지막 기회까지 모두 공을 굴렸다면 true를 반환한다.
	 * @return
	 */
	public boolean isFinished() {
		if(secondRoll.isRolled())
			return true;
		return false;
	}
	/**
	 * 마지막 기회까지 공을 굴렸는데도 모든 핀을 처리하지 못했을 경우 true를 반환한다.
	 * @return
	 */
	public boolean isOpen() {
		if(!isFinished())
			return false;
		int scoreSum = firstRoll.getScore() + secondRoll.getScore();
		if(scoreSum < NUMBER_OF_PINS_PER_FRAME)
			return true;
		return false;		
	}

}
