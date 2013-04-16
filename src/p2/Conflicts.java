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
	public double evaluate(Individual creature) {
		// TODO Auto-generated method stub
		return 0;
	}

}
