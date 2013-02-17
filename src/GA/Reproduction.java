package GA;

import GA.Crossover.Crossover;
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
	public void reproduce(Population creatures) {
		selFun.select(creatures);
		xFun.crossover(creatures);
		repFun.replace(creatures);
	}

}
