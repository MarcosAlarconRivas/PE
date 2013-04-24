package p2;

import java.util.Random;

import ga.Individual;
import ga.VarTriesMut;
/**
 * This mutation tries 'numOfTries' times to change two positions of the same row.
 * returns the best one of them.
 */
public class ChooseOne extends VarTriesMut {
	
	protected static int numOfTries= 12;

	public ChooseOne(double baseProb, double inbreedingControl, double annealingControl) {
		super(baseProb, inbreedingControl, annealingControl);
	}

	@Override
	protected void mutate(Individual indiv) {
		Sudoku sudoku = (Sudoku)indiv;
		Sudoku best = null;
		Random r = new Random();
		
		for(int i=0; i<numOfTries; i++){
			//choose a row
			int row = r.nextInt(9);
			
			//choose 2 cols
			int c1= r.nextInt(9);
			int c2 = r.nextInt(9);
			
			if(c1==c2 || sudoku.rows[row][c1]<0 || sudoku.rows[row][c2]<0)
				continue;
			
			Sudoku newOne  = (Sudoku)sudoku.clone();
			
			//switch c1 & c2
			int p = newOne.rows[row][c1];
			newOne.rows[row][c1]= newOne.rows[row][c2];
			newOne.rows[row][c2]= p;
			
			newOne.recalce();
			
			if(best==null||newOne.compareTo(best)>0)//choose the best one
				best= newOne;
		}
		if(best==null)return;
		
		sudoku.rows = best.rows;
		sudoku.lastEvaluation = best.lastEvaluation;
	}

}
