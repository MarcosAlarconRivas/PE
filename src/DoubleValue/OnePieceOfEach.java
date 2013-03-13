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
	public LinkedList<Individual> crossover(int[] parent, Population pop) {
		
		LinkedList<Individual> childsList = new LinkedList<Individual>();
		
		@SuppressWarnings("static-access")
		int genotypeBits[] = ((DoubleFunction)(pop.getFitnessFunction())).genotypeBits;
		
		for( int i=0; i<parent.length-1; i+=2){
			//generar nueva lista de parents
			LinkedList<DoubleValue> parents = new LinkedList<DoubleValue>();
			for (int j=0; j<numOfParents; j++)
				parents.add((DoubleValue) pop.people[parent[j]]);
			cross(childsList, genotypeBits, parents);
		}
		return childsList;
	}
	
	private void cross(LinkedList<Individual> childs, int[] genotypeBits, 
			List<DoubleValue> parents) 
	{
		//TODO see same method in SinglePiontCut
	}
}
