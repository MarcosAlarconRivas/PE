package ga.selection;

import ga.Population;

public interface Selection {
	
	public int[] select(Population pop);
	
	public int[] select(Population pop, int numToSelect);
	
}
