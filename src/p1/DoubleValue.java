package p1;

import ga.Individual;
/**
 * Individual representing a (or some) double values
 * for the entry of a function (see DoubleFunction)
 */
public class DoubleValue extends Individual {
	DoubleChromosome genotype[];
	
	public DoubleValue(){
		this(((DoubleFunction)fitness).numOfChromosomes);
	}
	
	DoubleValue(DoubleChromosome gen[]){
		genotype = gen;
		recalce();
	}
	
	private DoubleValue(DoubleChromosome gen[], double eval){
		genotype = gen;
		lastEvaluation = eval;
	}
	
	public DoubleValue(int numOfVars){
		genotype = new DoubleChromosome[numOfVars];
		for(int i=0; i<numOfVars; i++)
			genotype[i]=new DoubleChromosome(((DoubleFunction)fitness).genotypeBits[i]);
		recalce();
	}
	
	public boolean equals(Individual other){
		if(!(other instanceof DoubleValue))return false;
		if(!super.equals(other))return false;
		return genotype==((DoubleValue)other).genotype;
	}
	
	public Individual clone(){
		return new DoubleValue(genotype.clone(), lastEvaluation);
	}
	
	public double[] fenotypes(){
		int nCh= genotype.length;
		DoubleFunction f = ((DoubleFunction)fitness);
		double fenotypes[] = new double[nCh];
		for(int i=0; i<nCh; i++){
			fenotypes[i]=genotype[i].toFenotype(f.lowLimit[i], f.highLimit[i]);
		}
		return fenotypes;
	}
}
