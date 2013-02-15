package GA.Mutation;

import GA.Population;
import GA.Individual.Individual;

public abstract class Mutation {
	protected double baseRate;
	protected double inbreedingMult = 0;
	protected double annealingFactor = 1;

	public void mutate(Population creatures) {
		double rate = baseRate;
		
		if(inbreedingMult>0){
			rate+= inbreedingMult*creatures.inbreading();
		}
		
		for(Individual ind : creatures.mutable()){
			if(Math.random()<rate){
				mutate(ind);
			}
			
		}
		
		baseRate *= annealingFactor;
		
	}
	
	protected abstract void mutate(Individual i);

}
