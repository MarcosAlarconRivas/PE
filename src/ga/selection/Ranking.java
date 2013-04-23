package ga.selection;

import ga.Population;

/**
 * WARNING:
 * This code is copied from theory because is required in specifications of p2, 
 * is not good implementation for my architecture, i do not recommend this method.
 */
public class Ranking implements Selection {

	protected double prop;

	public Ranking(double prob){
		prop= prob;
	}

	@Override
	public int[] select(Population pop) {
		return select(pop, (int)Math.round(pop.people.length*prop));
	}
	
	/**
	 * Selects some individuals form given population using Ranking method
	 * @param pop: population to select
	 * @param toSelect: number of creatures to select
	 * @return positions of selected individuals
	 */
	@Override
	public int[] select(Population pop, int toSelect) {
		int[] futureParents = new int[toSelect];
		futureParents[0] = 0;
		futureParents[1] = 1;
		int numOfParents = 2;
		double[] fitnessSegments = rankPopulation(pop);
		double entireSegment = fitnessSegments[fitnessSegments.length - 1];
		while (numOfParents < futureParents.length) {
			double x = (double) (Math.random() * entireSegment);
			if (x <= fitnessSegments[0]) {
				/*** First Idividual was Selected **/
				futureParents[numOfParents] = 0;
				numOfParents++;
			} else
				for (int i = 1; i < futureParents.length; i++)
					if (x > fitnessSegments[i - 1] && x <= fitnessSegments[i]) {
						/*** i'th Idividual was Selected **/
						futureParents[numOfParents] = i;
						numOfParents++;
					}
		}
		return futureParents;
	}
	
	private double[] rankPopulation(Population pop) {
		int populationSize = pop.people.length;
		double Beta = 1 + prop;
		double[] fitnessSegments = new double[populationSize];
		for (int i = 0; i < fitnessSegments.length; i++) {
			double probOfIth = (double) i / populationSize;
			probOfIth = probOfIth * 2 * (Beta - 1);
			probOfIth = Beta - probOfIth;
			probOfIth = (double) probOfIth * ((double) 1 / populationSize);
			fitnessSegments[i] = probOfIth +((i== 0)?0:fitnessSegments[i - 1]);
		}
		return fitnessSegments;
	}

}
