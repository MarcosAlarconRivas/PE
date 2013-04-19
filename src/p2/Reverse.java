package p2;

import java.util.Random;

import ga.Individual;
import ga.VarTriesMut;
/**
 * This mutation tries 'numOfTries' times reverse some positions in a row.
 */
public class Reverse extends VarTriesMut {
	
	public static int numOfTries= 3;

	public Reverse(double baseProb, double inbreedingControl, double annealingControl) {
		super(baseProb, inbreedingControl, annealingControl);
	}

	@Override
	protected void mutate(Individual indiv) {
		Sudoku sudoku = (Sudoku)indiv;
		Random r = new Random();
		
		for(int i=0; i<numOfTries; i++){
			//choose a row
			int row = r.nextInt(9);
			
			//choose a begin point of cut
			int cut1 = r.nextInt(9);
			//choose a end point of cut
			int cut2 = r.nextInt(9);
			
			if (cut2<cut1){
				int temp = cut1;
				cut1=cut2;
				cut2=temp;
			}
			
			Sudoku newOne  = (Sudoku)sudoku.clone();
			
			while (cut1 < cut2){
				while (sudoku.rows[row][cut1]<0){
					cut1++;
				}
				while (sudoku.rows[row][cut2]<0){
					cut2--;
				}
				if (cut1 < cut2){
					int p = newOne.rows[row][cut1];
					newOne.rows[row][cut1]= newOne.rows[row][cut2];
					newOne.rows[row][cut2]= p;
					cut1++; cut2--;
				}
			}
			
			newOne.recalce();
			
			if(newOne.compareTo(sudoku)>0){//choose the best one
				sudoku.rows = newOne.rows;
				sudoku.lastEvaluation = newOne.lastEvaluation;
			}
		}

	}

}
