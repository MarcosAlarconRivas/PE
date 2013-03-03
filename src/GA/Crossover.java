package GA;

import java.util.LinkedList;

public interface Crossover {

	public LinkedList<Individual> crossover(Individual[] parents, Population pop);
	
}
