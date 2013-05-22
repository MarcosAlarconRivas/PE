package p3;

import java.util.LinkedList;
import java.util.Random;
import ga.Crossover;
import ga.Individual;
import ga.Population;

public class RandomDepthCorss implements Crossover {

	@Override
	public LinkedList<Individual> crossover(int[] parents, Population pop) {
		Random r = new Random();
		
		LinkedList<Individual> children= new LinkedList<Individual>();
		
		//for each 2 parents
		for (int i = 0; i < parents.length-1; i += 2) {
			
			// copy 2 parents
			Expression ch1 = (Expression) pop.people[parents[i]].clone();
			Expression ch2 = (Expression) pop.people[parents[i+1]].clone();
			
			
			//choose random nodes in the trees
			
			Expression e1= ch1; //chosen node
			Expression pe1= null;//parent node of e1
			int b1=-1;//branch of pe1 that matches with e1
			for (int depth=r.nextInt(e1.depth()>0?e1.depth():1); !e1.isLeaf()&&depth>0; depth--){
				pe1= e1;
				b1 = r.nextInt(e1.getArity());
				e1 = ((Operator)e1).expressions[b1];
			}
			
			Expression e2= ch2; //chosen node
			Expression pe2= null;//parent node of e2
			int b2=-1;//branch of pe2 that matches with e2
			for (int depth=r.nextInt(e2.depth()>0?e2.depth():1); !e2.isLeaf()&&depth>0; depth--){
				pe2= e2;
				b2 = r.nextInt(e2.getArity());
				e2 = ((Operator)e2).expressions[b2];
			}
			
			// graft branches in new trees
			if (pe1 != null)((Operator) pe1).expressions[b1] = e2;
			if (pe2 != null)((Operator) pe2).expressions[b2] = e1;
			if (pe1 == null)//for children 1 was chosen the root 
				ch1 = (Expression) e2.clone();
			else if (pe2 == null)//for children 2 was chosen the root
				ch2 = (Expression) e1.clone();
			//if for both them are chosen their roots, nothing is done
		

			//add grafted trees into the list
			children.add(ch1);
			children.add(ch2);
		}
		//return the list
		return children;
	}
	
}
