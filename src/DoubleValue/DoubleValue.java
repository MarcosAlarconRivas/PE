package DoubleValue;

import GA.Individual;

public class DoubleValue extends Individual {
	BitVector genotype;
	
	public DoubleValue(){
		this.genotype= new BitVector((DoubleFunction)fitness);
	}
	
	public boolean equals(Individual other){
		if(!(other instanceof DoubleValue))return false;
		return genotype==((DoubleValue)other).genotype;
	}
}
