package p2;


public class SudokuChromosome {
	protected int rows[][] = new int[9][9];
	

	public int[] getRow(int r){
		return rows[r].clone();
	}
	
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

}
