package DoubleValue;

import GA.Fitness;
import GA.Individual;

public abstract class DoubleFunction implements Fitness {

	protected static boolean maximization = true;
	protected static int numOfChromosomes = 1;
	protected static double lowLimit[], highLimit[];
	static int genotypeBits[] = {16};
	private static double failover = 1;
	
	
	@Override
	public Class<? extends Individual> specie() {
		return DoubleValue.class;
	}

	@Override
	public double evaluate(Individual creature) {
		double fenotypes[] = new double[numOfChromosomes];
		for(int i=0; i<numOfChromosomes; i++)
			fenotypes[i]=lowLimit[i]+((DoubleValue) creature).genotype[i].toUnsigned()*failover;
		return fitnessFun(fenotypes);
	}

	@Override
	public boolean maximization() {
		return maximization;
	}
	
	public static void setFailover(double failover){
		DoubleFunction.failover = failover;
		for(int i=0; i<numOfChromosomes; i++)
			DoubleFunction.genotypeBits[i] = (int)((highLimit[i]-lowLimit[i])/failover+1);
	}
	
	protected abstract double fitnessFun(double[] fenotypes);
	

}
