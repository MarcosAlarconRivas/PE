package ga;

import java.util.List;
import ga.replacement.Replacement;
import ga.selection.Selection;

public class Reproduction {
	
	Selection selFun;
	Crossover xFun;
	Replacement repFun;
	
	public Reproduction(Selection selectionMethod, Crossover crossMethod,
			Replacement repalceMthod)
	{
		selFun = selectionMethod;
		xFun = crossMethod;
		repFun = repalceMthod;
	}

	/**
	 * Reproduction algorithm, decides the procreation for all the population.
	 */
	public void reproduce(Population population) {
		List<Individual> children;
		int[] parents = selFun.select(population);
		children= xFun.crossover(parents, population);
		repFun.replace(children, parents, population);
	}

}
