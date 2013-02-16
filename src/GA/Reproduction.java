package GA;

import java.util.List;

import GA.Crossover.Crossover;
import GA.Replacement.Replacement;
import GA.Selection.Selection;
import GA.Individual.Individual;

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
	public void reproduce(Population creatures) {
		List<Individual> parents = selFun.select(creatures);
		List<Individual> children = xFun.crossover(parents);
		repFun.replace(creatures, parents, children);
	}

}
