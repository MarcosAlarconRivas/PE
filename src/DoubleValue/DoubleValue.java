package DoubleValue;

import GA.Individual;

public class DoubleValue extends Individual {
	double genotype;
	
	public DoubleValue(double genotype){
		this.genotype= genotype;
	}
	
	public boolean equals(Individual other){
		if(!(other instanceof DoubleValue))return false;
		return genotype==((DoubleValue)other).genotype;
	}
}
