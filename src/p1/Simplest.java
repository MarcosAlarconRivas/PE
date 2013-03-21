package p1;

import ga.Individual;
import ga.Mutation;
import ga.Population;

/**
 * This is a trivial Mutation algorithm:
 * For each allele in each chromosome in each Individual 
 * decides (using alleleMutationProb) switch the bit or not.
 * 
 * Doesn't work with inbreedingControl or annealingFactor.
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
		
		for(int i=0; i<creatures.people.length; i++){
			DoubleValue ind = (DoubleValue)creatures.people[i];
			boolean mutated = false;
			for(int gen=0; gen<ind.genotype.length; gen++){
				long genotypeBits = ((DoubleFunction)creatures.getFitnessFunction()).genotypeBits[gen];
				for (int bit=0; bit<genotypeBits; bit++){
					if(Math.random()<baseRate){
						ind.genotype[gen].xor(bit);
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
