package GA.Replacement;

import java.util.List;

import GA.Individual;
import GA.Population;

public interface Replacement {

	public void replace(List<? extends Individual> children, int[] parents, Population pop);
	
}
