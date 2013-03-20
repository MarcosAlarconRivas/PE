package ga.replacement;

import java.util.Arrays;
import java.util.List;

import ga.Individual;
import ga.Population;
/**
 * Supposing the population is ordered, 
 * replaces worst individual with children (if they are better).
 */
public class SurvivalOfTheFittest implements Replacement {

	@Override
	public void replace(List<? extends Individual> children, int[] parents, Population pop) {
		//for(Individual in:children)in.recalce();
		
		Object c[]=children.toArray();
		Arrays.sort(c);
		for(int i=c.length-1, j=c.length-1; j>=0; j--)
			if(pop.people[j].compareTo((Individual)c[i])<0)
				pop.people[j]=(Individual)c[i--];
		
	}

}
