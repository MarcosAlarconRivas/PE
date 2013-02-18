package GA;

import java.util.Arrays;
import java.util.Set;

public class Population {
	public Individual[] people;
	private int best;
	protected double fitAverage;

	public double average(){
		return fitAverage;
	}
	
	public Individual getBest() {
		return people[best];
	}

	public double inbreading() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void recalculate() {
		Arrays.sort(people);
		best = 0;
		
		fitAverage= 0;
		int length= people.length;
		for(int i=0; i<length; i++){
			fitAverage += people[i].fitness()/length;
			if(people[i].compareTo(people[best])>0)
				best= i;
		}
	}
	
	/**
	 * @returns non elite individuals.
	 */
	public Set<Individual> mortals(){
		// TODO Auto-generated method stub
		return null;
	}

}
