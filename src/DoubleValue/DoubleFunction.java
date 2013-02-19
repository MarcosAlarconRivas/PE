package DoubleValue;

import GA.Fitness;
import GA.Individual;

public abstract class DoubleFunction implements Fitness {

	protected boolean maximization = true;
	
	@Override
	public Class<? extends Individual> specie() {
		return DoubleValue.class;
	}

	@Override
	public double evaluate(Individual creature) {
		return fitnessFun(((DoubleValue) creature).genotype);
	}

	@Override
	public boolean maximization() {
		return maximization;
	}
	
	protected abstract double fitnessFun(double fenotype);
	

}
