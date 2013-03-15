package p1;

import ga.Individual;

public class DoubleValue extends Individual {
	DoubleChromosome genotype[];
	
	DoubleValue(DoubleChromosome gen[]){
		genotype = gen;
	}
	
	public DoubleValue(int numOfVars){
		genotype = new DoubleChromosome[numOfVars];
		for(int i=0; i<numOfVars; i++)
			genotype[i]=new DoubleChromosome(DoubleFunction.genotypeBits[i]);
	}
	
	public boolean equals(Individual other){
		if(!(other instanceof DoubleValue))return false;
		if(!super.equals(other))return false;
		return genotype==((DoubleValue)other).genotype;
	}
	
	public Individual clone(){
		return new DoubleValue(genotype.clone());
	}
}
