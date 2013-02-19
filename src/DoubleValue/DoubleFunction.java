package DoubleValue;

import GA.Fitness;
import GA.Individual;

public abstract class DoubleFunction implements Fitness {

	protected boolean maximization = true;
	protected static double lowLimit, highLimit;
	protected static int precision;
	
	@Override
	public Class<? extends Individual> specie() {
		return DoubleValue.class;
	}

	@Override
	public double evaluate(Individual creature) {
		return fitnessFun(((DoubleValue) creature).fenotype);
	}

	@Override
	public boolean maximization() {
		return maximization;
	}
	
	public static void setSearchRage(double min, double max){
		lowLimit= min;
		highLimit= max;
	}
	
	public static void setPrecision(int numOfBits){
		precision = numOfBits;
	}
	
	protected abstract double fitnessFun(double fenotype);
	

}
