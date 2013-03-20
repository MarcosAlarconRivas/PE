package ga;

import java.util.LinkedList;
/**
 * User can choose how many parents will be used in each reproduction.
 */
public abstract class VarParentsCross implements Crossover {
	protected static int numOfParents = 2;
	
	public void setNumOfParents(int num){
		numOfParents = num;
	}
	
	public abstract LinkedList<Individual> crossover(int[] parents, Population pop);

}
