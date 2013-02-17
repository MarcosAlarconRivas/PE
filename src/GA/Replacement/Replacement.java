package GA.Replacement;

import java.util.List;

import GA.Individual;
import GA.Population;

public interface Replacement {

	public void replace(List<Individual> children, int[] parents, Population pop);
	
}
