package ga;

import java.util.Set;

public class Population {
	//copied elite creatures (they are also in people).
	Individual elite[] = null;
		//int elitePos[] = null;
	
	Fitness fitnessFunction;

	//current full population
	public Individual[] people;

	//position in people of the best individual
	private int best;

	protected double fitAverage;
	
	public Population(Fitness fitness, int numOfIndividuals, boolean elite){
		fitnessFunction= fitness;
		
		people = new Individual[numOfIndividuals];
		
		if(elite) this.elite = new Individual[numOfIndividuals/50];
			//elite is 2% of total size of population
		for (int i=0; i<numOfIndividuals; i++) 
			try {
				people[i]= fitness.specie().newInstance();
			}catch (Exception e) {
				System.out.println(e);
			}
		
		recalculate();
	}
	
	public Fitness getFitnessFunction(){
		return fitnessFunction;
	}

	public double average(){
		return fitAverage;
	}

	public Individual getBest() {
		return people[best];
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
			if(people[i].compareTo(people[best])>0)
				best= i;

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
