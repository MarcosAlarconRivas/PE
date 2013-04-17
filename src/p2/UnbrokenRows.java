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
	
	protected static int numOfParents = 3;
	
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
		
		for(int i=0; i<parents.length; i+=numOfParents){
			addChildrenNewChildren(children, pop, parents, i);
		}
		
		return children;
	}

	private void addChildrenNewChildren(LinkedList<Individual> children, Population pop, 
			int[] parents, int firstPar) {
		
		for(int child=0; child<numOfParents; child++){
			//generate new child
			Sudoku newChild = new Sudoku();
			int row;
			for(int par=child; ; par= (par+1)%numOfParents){
				
			}
			
			
			//add in children
		}
	}

}
