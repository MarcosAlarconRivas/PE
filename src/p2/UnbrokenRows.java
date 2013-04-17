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
		
		int nPar = Math.min(parents.length-firstPar, numOfParents);
		
		for(int child=0; child<nPar; child++){
			int dna[][] = new int[9][];
			 for(int row=0; row<9; row++){
				int p = ((child+row)%nPar)+firstPar;
				Sudoku parent=(Sudoku)pop.people[parents[p]];
				dna[row]= parent.rows[row].clone();
			 }
			children.add(new Sudoku(dna));
		}
	}

}
