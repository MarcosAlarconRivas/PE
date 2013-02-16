package GA;

import GA.Crossover.Crossover;
import GA.Replacement.Replacement;
import GA.Selection.Selection;

public class Reproduccion {
	Selection selFun;
	Crossover xFun;
	Replacement repFun;
	
	public Reproduccion(Selection selectionMethod, Crossover crossMethod,
			Replacement repalceMthod)
	{
		selFun = selectionMethod;
		xFun = crossMethod;
		repFun = repalceMthod;
	}

	/**
	 * Reproduccion algorithm, decides the procreation for all the population.
	 */
	public void reproduce(Population creatures) {
		// TODO Auto-generated method stub
		
	}

}
