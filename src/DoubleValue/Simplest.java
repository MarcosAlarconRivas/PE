package DoubleValue;

import GA.Individual;
import GA.Population;
import GA.Mutation.Mutation;

public class Simplest extends Mutation {

	public Simplest(double alleleMutationProb) {
		super(alleleMutationProb, 0, 1);
	}
	
	/**
	 * Mutation algorithm, decides the mutation for all the population.
	 */
	@Override
	public void mutate(Population creatures){
		long genotypeBits = ((DoubleFunction)creatures.getBest().fitness).genotypeBits;
		for(Individual ind : creatures.mutable()){
			boolean mutated = false;
			for (int bit=0; bit<genotypeBits; bit++){
				if(Math.random()<baseRate){
					((DoubleValue)ind).genotype.xor(bit);
					mutated = true;
				}
			}
			if(mutated)ind.recalce();
		}
	}
	
	@Override
	protected void mutate(Individual i) {}//Not used

}
