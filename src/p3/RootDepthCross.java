package p3;

import java.util.LinkedList;
import java.util.Random;
import ga.Crossover;
import ga.Individual;
import ga.Population;

public class RootDepthCross implements Crossover {

	@Override
	public LinkedList<Individual> crossover(int[] parents, Population pop) {
		LinkedList<Individual> children= new LinkedList<Individual>();
		
		//for each 2 parents
		for (int i = 0; i < parents.length-1; i += 2) {
			
			// copy 2 parents to build children
			Expression ch1 = (Expression) pop.people[parents[i]].clone();
			Expression ch2 = (Expression) pop.people[parents[i+1]].clone();

			// cross them (grafting branches)
			graftage(ch1, ch2);

			// add new trees in the list
			children.add(ch1);
			children.add(ch2);
		}
		//return the list
		return children;
	}

	/**
	 *	Copies a branch of ch1 in ch2 & a branch of ch2 in ch1
	 **/
	protected static void graftage(Expression ch1, Expression ch2) {
		Random r = new Random();
		
		//choose cut point, depending on number of args
		int cut1 = r.nextInt(ch1.getArity());
		int cut2 = r.nextInt(ch2.getArity());

		//copy branches to change
		Expression e1 =(Expression)((ch1.isLeaf())?ch1:((Operator)ch1).expressions[cut1]).clone();
		Expression e2 =(Expression)((ch2.isLeaf())?ch2:((Operator)ch2).expressions[cut2]).clone();

		//change them
		if (!ch1.isLeaf())((Operator) ch1).expressions[cut1] = e2;
		else ch1 = e2;
		if (!ch2.isLeaf())((Operator) ch2).expressions[cut2] = e1;
		else ch2 = e1;
		
	}
	
}
