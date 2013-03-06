package GA;

import java.util.List;
import GA.Replacement.Replacement;
import GA.Selection.Selection;

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
