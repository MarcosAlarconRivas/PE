package p3;

import java.util.LinkedList;
import java.util.Random;
import ga.Crossover;
import ga.Individual;
import ga.Population;
public class Cross2 implements Crossover {

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

		int depth = r.nextInt(ch1.depth());
		while(!ch1.isLeaf()&&depth>0){
			ch1 = ((Operator)ch1).expressions[r.nextInt(ch1.getArity())];
			depth--;
		}
		depth = r.nextInt(ch2.depth());
		while(!ch2.isLeaf()&&depth>0){
			ch2 = ((Operator)ch2).expressions[r.nextInt(ch2.getArity())];
			depth--;
		}
		
		Expression aux = ch1;
		if (!ch1.isLeaf()) ((Operator) ch1).expressions[r.nextInt(ch1.getArity())] = ch2;
		else
		if (!ch2.isLeaf()) ((Operator) ch2).expressions[r.nextInt(ch2.getArity())] = aux;
		else
		
		children.add(ch1);
		children.add(ch2);
		
		return children;
	}
	
}
