package DoubleValue;

import GA.Fitness;
import GA.Individual;

public class Function1 implements Fitness {
	
	@Override
	public Class<? extends Individual> specie() {
		return DoubleValue.class;
	}
	
	@Override
	public double evaluate(Individual creature) {
		double gen= ((DoubleValue) creature).genotype;
		return 2*Math.E*gen-3*Math.PI*gen*gen+12/gen;
	}

	@Override
	public boolean maximization() {
		return true;
	}
	
	public String toString(){
		return "2·e^x -3·pi·x² +12/x";
	}


}
