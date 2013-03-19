package p1;

import ga.Fitness;
import ga.Individual;

public abstract class DoubleFunction implements Fitness {

	protected boolean maximization = true;
	protected double lowLimit[], highLimit[];
	int genotypeBits[] = {16};
	int numOfChromosomes = 1;
	private double failover = 1;
	
	@Override
	public Class<? extends Individual> specie() {
		return DoubleValue.class;
	}

	@Override
	public double evaluate(Individual creature) {
		double fenotypes[] = new double[numOfChromosomes];
		for(int i=0; i<numOfChromosomes; i++)
			fenotypes[i]=lowLimit[i]+((DoubleValue) creature).genotype[i].toUnsigned()*failover;	
		return evaluate(fenotypes);
	}

	@Override
	public boolean maximization() {
		return maximization;
	}
	
	public void setFailover(double failover){
		this.failover = failover;
		for(int i=0; i<numOfChromosomes; i++)
			genotypeBits[i] = (int)((highLimit[i]-lowLimit[i])/failover+1);
	}
	
	protected abstract double evaluate(double[] fenotypes);
	

}
