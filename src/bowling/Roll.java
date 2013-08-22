package bowling;

public class Roll {

	private int score = -1;
	
	/**
	 * 롤의 점수를 받아 설정한다.
	 * 굴렸다는 표시를 하기위해 isRolled 값을 참으로 설정한다.
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}
	public int getScore() {
		return score;
	}
	public boolean isRolled() {
		if(score == -1)
			return false;
		return true;
	}
}
