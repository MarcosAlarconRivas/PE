package p2;

import java.util.LinkedList;

import ga.Crossover;
import ga.Individual;
import ga.Population;
import ga.VarParentsCross;
/**
 * It generates new sudokus mixing the rows of parents.
 */
public class UnbrokenRows extends VarParentsCross implements Crossover {
	
	@Override
	public void setNumOfParents(int num){
		if(num<2)
			 numOfParents=2;
		else if(num>9)
			numOfParents=9;
		else
			numOfParents = num;
	}

	@Override
	public LinkedList<Individual> crossover(int[] parents, Population pop) {
		LinkedList<Individual> children = new LinkedList<Individual> ();
		
		return null;
	}

}
