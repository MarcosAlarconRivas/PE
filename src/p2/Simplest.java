package p2;

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
	//TODO
	}
	
	@Override
	protected void mutate(Individual i) {}//Not used

}
