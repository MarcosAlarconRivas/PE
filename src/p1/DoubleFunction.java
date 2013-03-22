package p1;

import utilities.BitVector;
import ga.Fitness;
import ga.Individual;
/**
 * This fitness is a math function form double vars to double value
 * f(double x, ...) -> double 
 */
public abstract class DoubleFunction implements Fitness {

	protected boolean maximization = true;
	//it decides if we'r trying to maximize or minimize the result
	
	protected double lowLimit[], highLimit[];
	//rages of entry vars
	
	int genotypeBits[] = {16};
	//size of chormosome representation of each var
	
	public int numOfChromosomes = 1;
	//how many vars is specting for entry
	
	//density of the search (this is the difference between 2 contiguous) possible values
	
	@Override
	public Class<? extends Individual> specie() {
		return DoubleValue.class;
	}

	@Override
	public double evaluate(Individual creature) {
		double fenotypes[] = new double[numOfChromosomes];
		for(int i=0; i<numOfChromosomes; i++){
			fenotypes[i]=((DoubleValue) creature).genotype[i].toFenotype(lowLimit[i], highLimit[i]);
		}
		return evaluate(fenotypes);
	}

	@Override
	public boolean maximization() {
		return maximization;
	}
	
	public void setFailover(double failover){
		for(int i=0; i<numOfChromosomes; i++){
			genotypeBits[i] = BitVector.minimalLength((int)Math.ceil((highLimit[i]-lowLimit[i])/failover)+1);
		}
		
	}
	
	protected abstract double evaluate(double[] fenotypes);
	

}
