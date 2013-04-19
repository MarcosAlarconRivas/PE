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
		this(empty?null:inputData);
	}
	
	/**
	 * Creates a new random sudoku with the fixed positions in rows.
	 */
	public Sudoku(int rowsMatrix[][]){
		super(Conflicts.getInstance());
		if(rowsMatrix==null)return;
		for(int i=0; i<9; i++)
			rows[i]= generateRow(rowsMatrix[i]);
		
		this.recalce();
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
	 * Returns current configuration of the table.
	 */
	public int[][] fenotype(){
		return rows.clone();
	}
	
	@Override
	public Individual clone() {
		Sudoku copy = new Sudoku(true);
		copy.rows = rows.clone();
		copy.lastEvaluation = lastEvaluation;
		return copy;
	}
	
	@Override
	@SuppressWarnings("static-access")
	public double kinship(Individual indi) {
		if(this==indi) return 1;
		if(fitness!=indi.fitness)return 0;
		int hit  = 0;
		int miss = 0;
		int n;
		Sudoku oth = (Sudoku) indi;
		for (int r=0; r<9; r++)
			for(int c=0; c<9; c++)
				if((n=rows[r][c])>0)
					if(n==oth.rows[r][c])hit++;
					else miss++;
		
		if(hit+miss==0)return 1;
		return hit/hit+miss;
	}
	
}
