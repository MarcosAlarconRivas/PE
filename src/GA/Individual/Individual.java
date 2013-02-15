package GA.Individual;

import GA.Fitness;

public abstract class Individual implements Comparable<Individual>{
	public static Fitness fitness;
	
	public double fitness(){
		return fitness.evaluate(this);
	}
	
	/**
	 * Decides if 'this' is better, equal or worse of than 'other'
	 */
	public int compareTo(Individual other){
		double mine= this.fitness();
		double its= other.fitness();
		if(mine==its)return 0;
		return (fitness.maximization()?1:-1)*(mine>its?1:-1);
	}
	
	/**
	 * This is not a good implementation for every single Individual kind.
	 * Please re-write this method depending on your individual's type.
	 */
	public boolean equals(Individual other){
		if(other==null)return false;
		return fitness()==other.fitness();
	}
}
