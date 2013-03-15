package ga.replacement;

import java.util.List;

import ga.Individual;
import ga.Population;

public interface Replacement {

	public void replace(List<? extends Individual> children, int[] parents, Population pop);
	
}
