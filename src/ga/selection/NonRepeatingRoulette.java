package ga.selection;

import java.util.LinkedList;

import ga.Population;
/**
 * WARNING this version suppose that population is ordered.
 */
public class NonRepeatingRoulette extends Roulette implements Selection{
	
	public NonRepeatingRoulette(double prob) {
		super(prob);
	}

	@Override
	public int[] select(Population pop, int toSelect){
		double minimal = pop.people[0].fitness();
			//if population is not ordered, search the worst one.
		
		if(minimal* pop.getBest().fitness()>=0) minimal=0;
		//only necessary if fitness of pop has both symbols (+/-)
		
		toSelect=Math.min(toSelect, pop.people.length);
		//i can't choose more than total population size.
		
		LinkedList<Integer> choosable = new LinkedList<Integer>();
		for(int i=pop.people.length-1; i>=0; i--)
			choosable.add(new Integer(i));
			//inits choosable with all pop positions
		
		double total = Math.abs(pop.average()-minimal)*pop.people.length;
		int selected[] = new int[toSelect];
		
		for(int creature = 0; creature < toSelect; creature++){
			
			double acc = Math.random()*total;
			//Target accumulate fitness
			
			for(Integer i: choosable)//FIXME test this for, i'm not sure about it.
				if(0>( acc-= Math.abs(pop.people[i].fitness()-minimal))){
					//if is the one i was looking for:
					
					total-= Math.abs(pop.people[i].fitness()-minimal);
					//calculate total fitness of population
					
					selected[creature]= i;
					//save it in selected
					
					choosable.remove(choosable.indexOf(i));
					//delete it from choosable
					break;
			}
		
		}
		return selected;
	}
}
