package DoubleValue;

import GA.Individual;
import GA.Population;
import GA.Mutation.Mutation;

/**
 * This is a trivial Mutation algorithm:
 * For each allele in each chromosome in each Individual decides (using alleleMutationProb)
 * switch the bit or not.
 */
public class Simplest extends Mutation {

	public Simplest(double alleleMutationProb) {
		super(alleleMutationProb, 0, 1);
	}
	
	/**
	 * Mutation algorithm, decides the mutation for all the population.
	 */
	@Override
	public void mutate(Population creatures){
		
		for(Individual ind : creatures.mutable()){
			boolean mutated = false;
			for(int gen=0; gen<((DoubleValue)ind).genotype.length; gen++){
				long genotypeBits = ((DoubleFunction)creatures.getBest().fitness).genotypeBits[gen];
				for (int bit=0; bit<genotypeBits; bit++){
					if(Math.random()<baseRate){
						((DoubleValue)ind).genotype[gen].xor(bit);
						mutated = true;
					}
				}
			}
			if(mutated)ind.recalce();
		}
	}
	
	@Override
	protected void mutate(Individual i) {}//Not used

}
