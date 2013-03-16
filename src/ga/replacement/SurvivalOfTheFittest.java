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
		Individual c[]=(Individual[])children.toArray();
		Arrays.sort(c);
		for(int i=c.length, j=c.length; j>=0; j--)
			if(pop.people[j].compareTo(c[i])<0)
				pop.people[j]=c[i--];
		
	}

}
