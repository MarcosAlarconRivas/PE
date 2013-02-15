package GA.Mutation;

import GA.Population;
import GA.Individual.Individual;

public abstract class Mutation {
	protected double baseRate;
	protected double inbreedingMult;
	protected double annealingFactor;

	public void mutate(Population creatures) {
		// TODO Auto-generated method stub
		
	}
	
	protected abstract void mutate(Individual i);

}
