package ga.selection;

import ga.Population;

/**
 * WARNING this version suppose that population is ordered.
 */
public class Roulette implements Selection {
	
	protected double prop;
	
	public Roulette(double prob){
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
	public int[] select(Population pop, int toSelect){
		double minimal = pop.people[0].fitness();
			//if population is not ordered, search the worst one.
		
		if(minimal* pop.getBest().fitness()>=0) minimal=0;
		//only necessary if fitness of pop has both symbols (+/-)
		
		int selected[] = new int[toSelect];
		for(int creature = 0; creature < toSelect; creature++){
			
			double acc = Math.abs(Math.random()*pop.average()-minimal)*pop.people.length;
			//Target accumulate fitness
			
			int s =pop.people.length;
			//last creature added to acc
			
			while(acc>=0 && s>0)
				acc-= Math.abs(pop.people[--s].fitness()-minimal);

			selected[creature]= s;
		}
		return selected;
	}

}
