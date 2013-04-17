package p2;

import java.util.LinkedList;
import java.util.Random;

import ga.Individual;
/**
 * Individual representing a Sudoku
 * Negative values represents input data (positions that can't change).
 */
public class Sudoku extends Individual {
	
	//data for initalition of the new individuals
	protected static int[][] inputData = new int[9][9]; 

	//chromosome
	protected int rows[][] = new int[9][9];
	
	/**
	 * This method is used by the gui to assign initial positions of the sudoku. 
	 */
	public static void setUserInput(int data[][]){
		inputData = data;
	}
	
	/**
	 * Creates a new random sudoku with 'inputData' positions fixed.
	 */
	public Sudoku(){
		this(false);
	}
	
	/** Creates a new sudoku if not 'empty' uses 'inputData'**/
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
	
	@Override
	public Individual clone() {
		Sudoku copy = new Sudoku(true);
		copy.rows = rows.clone();
		return copy;
	}
	
}
