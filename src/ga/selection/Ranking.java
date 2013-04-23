package ga.selection;

import ga.Individual;
import ga.Population;

/**
 * WARNING this version suppose that population is ordered.
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
	 * Selects some individuals form given population using roulette method
	 * @param pop: population to select
	 * @param toSelect: number of creatures to select
	 * @return positions of selected individuals
	 */

	public Individual[] performRankSelection(Individual[] initPop) {
		Individual[] sortedPop = SortIndividual.selectionSort(initPop);
		Individual[] futureParents = new Individual[sortedPop.length];
		futureParents[0]=sortedPop[0];futureParents[1]=sortedPop[1];
		int numOfParents =2;
		double[] fitnessSegments = rankPopulation();
		double entireSegment = fitnessSegments[fitnessSegments.length-1]; 
		while(numOfParents<futureParents.length){
			double x = (double)(Math.random()*entireSegment);
			if(x<=fitnessSegments[0]) {
				/*** First Idividual was Selected **/
				futureParents[numOfParents]=sortedPop[0];
				numOfParents++;}
			else
				for(int i=1; i<futureParents.length; i++)
					if(x>fitnessSegments[i-1] && x<=fitnessSegments[i]){
						/*** i'th Idividual was Selected **/
						futureParents[numOfParents]=sortedPop[i];
						numOfParents++;}
		} return futureParents;
	}

	private double[] rankPopulation(){
		double[] fitnessSegments = new double[populationSize_];
		for(int i=0 ; i<fitnessSegments.length ; i++){
			double probOfIth = (double)i/populationSize_; 
			probOfIth = probOfIth*2*(Beta_-1);
			probOfIth = Beta_ - probOfIth;
			probOfIth = (double)probOfIth*((double)1/populationSize_);
			if(i!=0)
				fitnessSegments[i] = fitnessSegments[i-1] + probOfIth;
			else
				fitnessSegments[i] = probOfIth;
		}
		return fitnessSegments;
	}


	public int[] select(Population pop, int toSelect){

	}

}
