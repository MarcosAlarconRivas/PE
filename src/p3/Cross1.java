package p3;

import java.util.LinkedList;
import java.util.Random;
import ga.Crossover;
import ga.Individual;
import ga.Population;

public class Cross1 implements Crossover {

	@Override
	public LinkedList<Individual> crossover(int[] parents, Population pop) {
		LinkedList<Individual> children = new LinkedList<Individual> ();
		
		Random r = new Random();

		//choose 2 parents
		int r1 = r.nextInt(parents.length);
		int r2 = r.nextInt(parents.length);
		
		//create the children
		Expression ch1 = (Expression) pop.people[parents[r1]].clone();
		Expression ch2 = (Expression) pop.people[parents[r2]].clone();
		
		//choose cut point, depending on number of args
		int cut1 = r.nextInt(ch1.getArity());
		int cut2 = r.nextInt(ch2.getArity());
		
		//FIXME no puedes saber si son Operator o Leaf
		Expression e1 = ((Operator) ch1).expressions[cut1];
		Expression e2 = ((Operator) ch2).expressions[cut2];
		
		((Operator) ch1).expressions[cut1] = e2 ;
		((Operator) ch2).expressions[cut2] = e1;	
		
		children.add(ch1);
		children.add(ch2);
		
		return children;
	}
	
}
