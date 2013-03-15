package ga;

import java.util.LinkedList;

public interface Crossover {

	public LinkedList<Individual> crossover(int[] parents, Population pop);
	
}
