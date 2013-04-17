package p2;

import java.util.LinkedList;
import java.util.Random;

import ga.Individual;
/**
 * Individual representing a Sudoku
 * Negative values represents input data (positions that can't change).
 */
public class Sudoku extends Individual {

	protected int rows[][] = new int[9][9];
	
	public static int[][] inputData = new int[9][9]; 
	
	public static void setUserInput(int data[][]){
		inputData = data;
	}
	
	/** new sudoku**/
	public Sudoku(boolean empty){
		super(Conflicts.getInstance());
		if(!empty)
			for(int i=0; i<9; i++)
				rows[i]= generateRow(inputData[i]);
			
	}
	
	/**
	 * Creates a new random sudoku with the fixed positions in rows.
	 */
	public Sudoku(int rowsMatrix[][]){
		super(Conflicts.getInstance());
		for(int i=0; i<9; i++)
			rows[i]= generateRow(rowsMatrix[i]);
		
	}
	
	/**
	 * Generate a valid row using the given positions
	 */
	private int[] generateRow(int[] input) {
		LinkedList<Integer> checkList  = new LinkedList<Integer>();
		Random r =  new  Random();
		int row[] = new int[9];
		for(int i=1; i<10; i++)
			checkList.add(i);
		
		for(int i=0; i<9; i++){
			int num = Math.abs(input[i]);
			if(num>9||num==0)
				row[i]=0;
			else{ 
				row[i]= -num;
				checkList.removeFirstOccurrence(num);
			}
		}
		
		for(int i=0; i<9; i++){
			if(row[i]!=0)continue;
			if(checkList.isEmpty()) break;
			row[i]= checkList.remove(r.nextInt(checkList.size()));
		}

		return row;
	}

	/**
	 * 0->[___][___][___]
	 * 1->[...
	 * 2->
	 * ...
	 * 8->[___][___][___]
	 */
	public int[] getRow(int r){
		return rows[r].clone();
	}
	
	/**
	 * 0 1 2 | 3 4 5 | 6 7 8
	 * | | |   | | |   | | |
	 * v v v   v v v   v v v 
	 * [][][]| [][][]| [][][]
	 * [][][]| ......| ......
	 * .....
	 */
	public int[] getCol(int c){
		int[] column = new int[9];
		
		for(int r=0;r<9;r++)
			column[r] = rows[r][c];
			
		return column;
	}
	
	/**
	 *  ________
	 * |0 |1 |2 |
	 * |3 |4 |5 |
	 * |6 |7 |8 |
	 */
	public int[] getblk(int b){
		int[] block = new int[9];
		
		for(int r=0; r<3; r++)
			for(int c=0; c<3; c++)
				block[r+c]= rows[b/3+r][b%3+c];
		
		return block;
	}
	
	@Override
	public Individual clone() {
		Sudoku copy = new Sudoku(true);
		copy.rows = rows.clone();
		return copy;
	}
	
}
