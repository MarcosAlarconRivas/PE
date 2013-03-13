package DoubleValue;

import java.util.LinkedList;
import java.util.List;

import GA.Crossover;
import GA.Individual;
import GA.Population;
import GA.VarParentsCross;
/**
 * Take parents n by n cut them in n parts and paste one parts of each 
 * to build n new children
 */
public class OnePieceOfEach extends VarParentsCross implements Crossover {

	@Override
	public LinkedList<Individual> crossover(int[] parents, Population pop) {
		
		LinkedList<Individual> childsList = new LinkedList<Individual>();
		// TODO Auto-generated method stub
		
		//Take parents[], divide it in groups of 'numOfParents' size
		
		//cross them adding to childsList
	
		return childsList;
	}
	
	private void cross(LinkedList<Individual> childs, int[] genotypeBits, 
			List<DoubleValue> parents) 
	{
		//TODO see same method in SinglePiontCut
	}
}
