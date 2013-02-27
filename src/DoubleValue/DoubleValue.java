package DoubleValue;

import GA.Individual;

public class DoubleValue extends Individual {
	BitVector genotype[];
	
	public DoubleValue(int numOfVars){
		genotype = new BitVector[numOfVars];
		for(int i=0; i<numOfVars; i++)
			genotype[i]=new BitVector(BitVector.RANDOM, DoubleFunction.genotypeBits[i]);
	}
	
	public boolean equals(Individual other){
		if(!(other instanceof DoubleValue))return false;
		if(!super.equals(other))return false;
		return genotype==((DoubleValue)other).genotype;
	}
}
