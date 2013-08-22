package bowling;

public class Roll {

	private int score;
	private boolean isRolled = false;
	
	public void setScore(int i) {
		// TODO Auto-generated method stub
		score = i;
		isRolled = true;
	}
	public int getScore(int i) {
		// TODO Auto-generated method stub
		return score;
	}
	public boolean isRolled() {
		// TODO Auto-generated method stub
		return isRolled;
	}
}
