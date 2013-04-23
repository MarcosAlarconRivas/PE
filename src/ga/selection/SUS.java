package ga.selection;

import java.util.LinkedList;
import java.util.Random;

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
	 	SUS(Population, N)
    	F := total fitness of population
    	N := number of offspring to keep
    	P := distance between the pointers (F/N)
    	Start := random number between 0 and P
    	Pointers := [Start + i*P | i in [0..N-1]]
    	Keep = []
    	i := 0
    	for P in Points
        	while fitness of Population[i] < P
            	i++
        	add Population[i] to Keep
    	return Keep
    */
	@Override
	public int[] select(Population pop, int numToSelect) {
		Random r = new Random();
		double totalFit = pop.average() * pop.people.length;
		int p = (int) Math.round(totalFit / numToSelect);
		int start = r.nextInt(p);

		LinkedList<Integer> choosable = new LinkedList<Integer>();
		for (int i = 0; i < numToSelect; i++)
			choosable.addLast(start + i * p);

		double minimal = pop.people[0].fitness();
		// if population is not ordered, search the worst one.

		if (minimal * pop.getBest().fitness() >= 0)
			minimal = 0;
		// only necessary if fitness of pop has both symbols (+/-)

		numToSelect = Math.min(numToSelect, pop.people.length);
		// i can't choose more than total population size.

		double total = Math.abs(pop.average() - minimal) * pop.people.length;
		int selected[] = new int[numToSelect];

		for (int creature = 0; creature < numToSelect; creature++) {

			double acc = Math.random() * total;
			// Target accumulate fitness

			for (Integer i : choosable)
				if (0 > (acc -= Math.abs(pop.people[i].fitness() - minimal))) {
					// if is the one i was looking for:

					total -= Math.abs(pop.people[i].fitness() - minimal);
					// calculate total fitness of population

					selected[creature] = i;
					// save it in selected
					break;
				}
		}
		return selected;
	}


}
