package ga;


public interface Fitness {
	/**
	 * The class of the Individuals to work with in this fitness.
	 */
	public Class<? extends Individual> specie();
	
	/**
	 * Core method of the Fitness function, evaluates an individual
	 * with a double.
	 */
	public double evaluate(Individual creature);
	
	/**
	 * True if you are trying to maximize the fitness evaluation
	 * False if it mast be minimized.
	 */
	public boolean maximization();
}
