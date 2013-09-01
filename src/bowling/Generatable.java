package bowling;

import java.util.List;

public interface Generatable {
	String generatePlayerScore(List<Frame> frames, int[] calculatedScores);

}

