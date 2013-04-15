package ga;


public abstract class Individual implements Comparable<Individual>, Cloneable{
	public static Fitness fitness;
	public double lastEvaluation;
	
	public Individual(){}
	
	public Individual(Fitness fitFun){
		if(fitness == null && this.getClass() == fitFun.specie())//instanceof falis
			setStaticFitness(fitFun);
	}
	
	/**
	 * @returns the last fitness calculated for this Individual.
	 */
	public double fitness(){
		return lastEvaluation;
	}
	
	/**
	 * recalces and @returns the fitness of this Individual.
	 */
	public double recalce(){
		return lastEvaluation=fitness.evaluate(this);
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
	/**
	 * Changes the evaluation function for this individual;
	 */
	static final void setStaticFitness(Fitness fitFun){
			fitness= fitFun;
	}

	/**
	 * This is used to measure inbreading of the population.
	 * It should be overwrite in each kind of individual.
	 */
	public double kinship(Individual individual) {
		if(this==individual) return 1;
		return 0;
	}
	
	public abstract Individual clone();
}
