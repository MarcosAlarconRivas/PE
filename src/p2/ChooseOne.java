package p2;

import java.util.Random;

import ga.Individual;
import ga.Mutation;
/**
 * This mutation tries 'numOfTries' times to change two positions of the same row.
 * returns the best one of them.
 */
public class ChooseOne extends Mutation {
	
	public static int numOfTries= 3;

	public ChooseOne(double baseProb, double inbreedingControl, double annealingControl) {
		super(baseProb, inbreedingControl, annealingControl);
	}

	@Override
	protected void mutate(Individual sudoku) {
		Random r = new Random();
		
		for(int i=0; i<numOfTries; i++){
			//choose a row
			int row = r.nextInt(9);
			
			//choose 2 cols
			int c1= r.nextInt(9);
			int c2 = r.nextInt(9);
			
			if(c1==c2 || c1<0 || c2<0) continue;
			
			Sudoku newOne  = (Sudoku)sudoku.clone();
			int p = newOne.rows[row][c1];
			newOne.rows[row][c1]= newOne.rows[row][c2];
			newOne.rows[row][c2]= p;
			
			newOne.recalce();
			
			if(newOne.compareTo(sudoku)>0)//choose the best one
				sudoku= newOne;//FIXME ref arg?
		
		}

	}

}
