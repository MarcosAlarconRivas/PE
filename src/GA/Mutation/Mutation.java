package GA.Mutation;

import GA.Individual;
import GA.Population;

public abstract class Mutation {
	private double startingBaseRate;
	protected double baseRate;
	protected double inbreedingMult = 0;
	protected double annealingFactor = 1;
	
	public Mutation(double mutationRate){
		startingBaseRate = baseRate = mutationRate;
	}
	
	public Mutation(double baseProb, double inbreedingControl, 
			double annealingControl)
	{
		startingBaseRate = baseRate = baseProb;
		inbreedingMult = inbreedingControl;
		annealingFactor = annealingControl;
	}

	/**
	 * Mutation algorithm, decides the mutation for all the population.
	 */
	public void mutate(Population creatures){
		double rate = baseRate;
		
		if(inbreedingMult>0){
			rate+= inbreedingMult*creatures.inbreading();
		}
		
		for(Individual ind : creatures.mortals()){
			if(Math.random()<rate) mutate(ind);
		}
		
		baseRate *= annealingFactor;
	}
	
	/**
	 * Restarts the mutation rate (does nothing if there is not annealing).
	 */
	public void reset(){
		baseRate= startingBaseRate;
	}
	
	/**
	 * Core method of the mutation function, mutate an individual.
	 */
	protected abstract void mutate(Individual i);

}
