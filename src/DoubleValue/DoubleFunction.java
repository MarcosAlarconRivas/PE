package DoubleValue;

import GA.Fitness;
import GA.Individual;

public abstract class DoubleFunction implements Fitness {

	protected boolean maximization = true;
	protected static double lowLimit, highLimit;
	protected static int genotypeBits = 16;
	protected static double failover = 1;
	
	@Override
	public Class<? extends Individual> specie() {
		return DoubleValue.class;
	}

	@Override
	public double evaluate(Individual creature) {
		double val = ((DoubleValue) creature).genotype.toUnsigned()*failover;
		return fitnessFun(lowLimit+val);
	}

	@Override
	public boolean maximization() {
		return maximization;
	}
	
	public static void setSearchRage(double min, double max){
		lowLimit= min;
		highLimit= max;
	}
	
	public static void setFailover(double failover){
		DoubleFunction.failover = failover;
		DoubleFunction.genotypeBits = (int)((highLimit-lowLimit)/failover+1);
	}
	
	protected abstract double fitnessFun(double fenotype);
	

}
