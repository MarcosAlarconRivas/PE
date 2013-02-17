package GA.Replacement;

import java.util.List;

import GA.Population;
import GA.Individual.Individual;

public interface Replacement {

	public void replace(List<Individual> children, int[] parents, Population pop);
	
}
