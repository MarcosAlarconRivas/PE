package ga.selection;

import ga.Population;
/**
 * WARNING:
 * this code is copied from wikipedia because is required in specifications of p2, 
 * is not well tested in my architecture, i do not recommend this method.
 * 
 * SOURCE:
 * http://en.wikipedia.org/wiki/Stochastic_universal_sampling
 */
public class SUS extends Roulette implements Selection {
	
	public SUS(double prob){
		super(prob);
	}
	
	/**
	 * This is like roulette except the points
	 * are taken uniformly instead of randomly.
	 */
	@Override
	public int[] select(Population pop, int toSelect) {
		double minimal = pop.people[0].fitness();
		// if population is not ordered, search the worst one.

		if (minimal * pop.getBest().fitness() >= 0) minimal = 0;
		// only necessary if fitness of pop has both symbols (+/-)

		double tot_acc = Math.abs(pop.average()-minimal)*pop.people.length;
		double org_acc = Math.random()*tot_acc;
		
		int selected[] = new int[toSelect];
		for (int creature = 0; creature < toSelect; creature++) {

			double acc=(org_acc+ creature*tot_acc/toSelect)%tot_acc;
			// Target accumulate fitness

			int s = pop.people.length;
			// last creature added to acc

			while (acc >= 0 && s > 0)
				acc -= Math.abs(pop.people[--s].fitness() - minimal);

			selected[creature] = s;
		}
		return selected;
	}

}
