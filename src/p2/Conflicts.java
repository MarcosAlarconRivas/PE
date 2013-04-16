package p2;

import ga.Fitness;
import ga.Individual;

public class Conflicts implements Fitness {
	
	//Singleton instance
	private static Conflicts instance= new Conflicts();
	
	private Conflicts(){
		super();
	}
	
	@Override
	public boolean maximization(){return false;}

	public static Fitness getInstance() {
		return instance;
	}

	@Override
	public Class<? extends Individual> specie() {
		return Sudoku.class;
	}

	@Override
	public double evaluate(Individual sudoku) {
		return confCols((Sudoku)sudoku)+confBlok((Sudoku)sudoku);
	}
	
	public int confCols(Sudoku s){
		int sum=0;
		for(int i=0; i<9; i++)
			sum+=confCol(i,s);
		return sum;
	}
	
	public int confBlok(Sudoku s){
		int sum=0;
		for(int i=0; i<9; i++)
			sum+=confBlok(i,s);
		return sum;
	}
	
	public int confCol(int col, Sudoku s){
		boolean checkList[] = {false,false,false, false,false,false, false,false,false};
		int num;
		int conf = 0;
		for(int i=0; i<9; i++){
			num = Math.abs(s.rows[i][col]);
			if(checkList[num-1])conf++;
			else checkList[num-1]=true;
		}
		return conf;
	}
	
	public int confBlok(int blk, Sudoku s){
		boolean checkList[] = {false,false,false, false,false,false, false,false,false};
		int num;
		int conf = 0;
		for(int r=0; r<3; r++)
			for(int c=0; c<3; c++){
				num = Math.abs(s.rows[blk/3+r][blk%3+c]);
				if(checkList[num-1])conf++;
				else checkList[num-1]=true;
			}
		return conf;
	}

}
