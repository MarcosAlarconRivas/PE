package GA.Crossover;

import GA.Individual;
import GA.Population;
import java.util.LinkedList;

public interface Crossover {

	public LinkedList<Individual> crossover(int[] parents, Population pop);
	
}
