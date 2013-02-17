package Fitness;

import GA.Fitness;
import GA.Individual.Individual;
import GA.Individual.DoubleValue;

public class Function1 implements Fitness {
	
	@Override
	public Class<? extends Individual> specie() {
		// TODO Auto-generated method stub
		return DoubleValue.class;
	}
	
	@Override
	public double evaluate(Individual creature) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean maximization() {
		// TODO Auto-generated method stub
		return false;
	}


}
