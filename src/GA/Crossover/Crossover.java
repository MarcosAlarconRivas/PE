package GA.Crossover;

import GA.Population;
import GA.Individual.Individual;
import java.util.LinkedList;

public interface Crossover {

	public LinkedList<Individual> crossover(int[] parents, Population pop);
	
}
