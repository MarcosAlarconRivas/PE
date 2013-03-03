package GA.Selection;

import GA.Individual;
import GA.Population;

public interface Selection {
	
	public Individual[] select(Population pop);
	
}
