package p2;

import ga.Individual;
/**
 * Individual representing a Sudoku
 * Negative values represents input data (positions that can't change).
 */
public class Sudoku extends Individual {

	protected int rows[][] = new int[9][9];
	
	/** new empty sudoku**/
	Sudoku(){
		super(Conflicts.getInstance());
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
		// TODO Auto-generated method stub
		return null;
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
		Sudoku copy = new Sudoku();
		copy.rows = rows.clone();
		return copy;
	}
	
}
