package DoubleValue;

import GA.Individual;

public class DoubleValue extends Individual {
	BitVector genotype;
	
	public DoubleValue(){
		genotype=new BitVector(BitVector.RANDOM, DoubleFunction.genotypeBits);
	}
	
	public boolean equals(Individual other){
		if(!(other instanceof DoubleValue))return false;
		return genotype==((DoubleValue)other).genotype;
	}
}
