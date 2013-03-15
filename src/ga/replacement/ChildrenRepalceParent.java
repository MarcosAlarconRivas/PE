package ga.replacement;

import java.util.List;

import ga.Individual;
import ga.Population;
/**
 * This is a trivial Replace algorithm:
 * It writes children in parents position.
 * Warning: if there any repeated parent, some children will be override.
 */
public class ChildrenRepalceParent implements Replacement {

	@Override
	public void replace(List<? extends Individual> children, int[] parents,
			Population pop) {
		int i = 0;
		for(Individual ind : children){
			if(i>=parents.length)break;
			pop.people[parents[i++]] = ind;
		}

	}

}
