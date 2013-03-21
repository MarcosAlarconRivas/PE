package ga;

/**
 * Homogeneus (same for all the population) mutation function.
 * Can be extended for improves.
 */
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
			rate= Math.min(rate, 1);
		}
		
		for(int i=0; i<creatures.people.length; i++)
			if(Math.random()<rate){ 
				mutate(creatures.people[i]);
				creatures.people[i].recalce();
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
