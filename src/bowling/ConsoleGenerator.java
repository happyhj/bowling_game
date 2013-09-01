package bowling;

import java.util.List;
import static util.Constants.NEW_LINE;

public class ConsoleGenerator implements Generatable {

	public String generatePlayerScore(List<Frame> frames,int[] calculatedScores) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();

		sb.append(generateGameScore(frames));
		sb.append(NEW_LINE);
		sb.append(generateCalculatedScores(frames,calculatedScores));
		return sb.toString();
	}
	
	/**
	 * 투구시 넘어간 핀 수를 규칙에 맞게 문자열로 반환한다.
	 * @return
	 */
	public String generateGameScore(List<Frame> frames) {
		StringBuilder sb = new StringBuilder();
		int NUMBER_OF_FRAMES_PER_GAME = frames.size()-1;
		sb.append("|");

		for(Frame frame:frames){
			if(frame.equals(frames.get(NUMBER_OF_FRAMES_PER_GAME-1)))
				break;
			sb.append(frame.generateScore());
			sb.append("|");
		
		}
		//// 여기부터 10번째 프레임 문자열 작업을 수행
		Frame lastFrame = frames.get(NUMBER_OF_FRAMES_PER_GAME-1);
		Frame bonusFrame = frames.get(NUMBER_OF_FRAMES_PER_GAME);
		
		// 아직 10번째 프레임을 플레이하지 않았을 때, 일반적 프레임수 +1의 공백을 넣어준다.
		if(!lastFrame.isStarted()) {
			sb.append(lastFrame.generateScore());
//			sb.append(" ");
		}			
		/// 10프레임이 스트라이크인 경우 - 10번째 프레임 문자열 첫문자만 사용, 11번째 프레임 문자 모두 사용
		if(lastFrame.isStrike()) {
			sb.append(lastFrame.generateScore().substring(0, 1));
			sb.append(bonusFrame.generateScore());
		}
		/// 10프레임이 스페어인 경우 - 10번째 프레임 문자열 모두 사용, 11번째 프레임 첫 문자만 사용
		if(lastFrame.isSpare()) {
			sb.append(lastFrame.generateScore().replaceAll("\\s",""));
			sb.append(bonusFrame.generateScore().substring(0, 1));
		}
		/// 10프레임이 오픈인 경우 - 10번째 프레임 문자열 모두 사용 + 공백문자
		if(lastFrame.isOpen()) {
			sb.append(lastFrame.generateScore().replaceAll("\\s",""));
			sb.append(" ");
		}
		
		/// 10프레임이 첫투구만 한 경우- 10번째 프레임 문자열 모두 사용 + 공백문자
		if(lastFrame.isStarted()&&!lastFrame.isFinished()) {
			sb.append(lastFrame.generateScore());
		}	
		sb.append("|");

		String score = sb.toString();
		return score;
	}

	public String generateCalculatedScores(List<Frame> frames,int[] calculatedScores) {
		StringBuilder sb = new StringBuilder();
		sb.append("|");
		for(int i=0;i<calculatedScores.length;i++) {
			//// 표시 해줘야 하는 0점의 케이스
			// 1. 프레임이 끝났고, 모든 roll의 점수가 0일 때
			if((calculatedScores[i]==0)&&(frames.get(i).isFinished())&&(frames.get(i).getRolls().get(0).getScore()==0)&&((frames.get(i).getRolls().get(1).getScore()==0))) 
				sb.append("0");	
			else if((calculatedScores[i]==0))
				sb.append(" ");	
			else
				sb.append(calculatedScores[i]);	
			
			if(calculatedScores[i]/10==0)
				sb.append("  ");
			else if(calculatedScores[i]/100<=0)
				sb.append(" ");
			

			sb.append("|");
		
		}

		return sb.toString();
	}	

}
