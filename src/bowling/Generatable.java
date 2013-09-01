package bowling;

import java.util.List;

public interface Generatable {
	String generateLane(List<Frame> frames, int[] calculatedScores);
}
