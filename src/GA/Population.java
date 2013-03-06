package GA;

import java.util.Set;

public class Population {
	//copied elite creatures (they are also in people).
	Individual elite[] = null;
	
	//current full population
	public Individual[] people;
	
	//position in people of the best individual
	private int best, second, third, fourth, fifth;
	
	protected double fitAverage;

	public double average(){
		return fitAverage;
	}
	
	public Individual getBest() {
		return people[best];
	}
	

	public Individual getSecond() {
		return people[second];
	}

	public Individual getThird() {
		return people[third];
	}

	public Individual getFourth() {
		return people[fourth];
	}

	public Individual getFifth() {
		return people[fifth];
	}
	
	public Individual getI(int i){
		return people[i];
	}

	public double inbreading() {
		// TODO Implement inbreading calculus
		return 0;
	}

	public void recalculate() {
		//Arrays.sort(people);
		best = 0;
		fitAverage= 0;
		int length= people.length;
		for(int i=0; i<length; i++){
			//calculating fitAverage
			fitAverage += people[i].fitness()/length;
			
			//calculating best
			if(people[i].compareTo(people[best])>0){
				fourth = third;
				third = second;
				second = best;
				best = i;
			} else if(people[i].compareTo(people[second])>0){
				fourth = third;
				third = second;
				second = i;
			} else if(people[i].compareTo(people[third])>0){
				fourth = third;
				third = i;
			} else if(people[i].compareTo(people[fourth])>0){
				fourth = i;
			}
			
			//calculating elite
			if(elite!=null){
				// TODO Implement elite calculus
			}
		}
	}
	
	/**
	 * @returns individuals to crossover.
	 */
	public Set<Individual> fertile(){
		return ((Set<Individual>)java.util.Arrays.asList(people));
	}
	/**
	 * @returns individuals to mutate.
	 */
	public Set<Individual> mutable(){
		return ((Set<Individual>)java.util.Arrays.asList(people));
	}
}
