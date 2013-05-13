package p3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import ga.Crossover;
import ga.GeneticAlgorithm;
import ga.Individual;
import ga.Mutation;
import ga.Population;
import ga.Reproduction;
import ga.replacement.SurvivalOfTheFittest;
import ga.selection.Roulette;

public class Cross1 implements Crossover {

	@Override
	public LinkedList<Individual> crossover(int[] parents, Population pop) {
		LinkedList<Individual> children = new LinkedList<Individual> ();
		
		Random r = new Random();

		//choose 2 parents
		int r1 = r.nextInt(parents.length);
		int r2 = r.nextInt(parents.length);
		Individual p1 = pop.people[parents[r1]];
		Individual p2 = pop.people[parents[r2]];
		
		Expression ep1 = ((Expression) p1);
		Expression ep2 = ((Expression) p2);
		
		//create the children
		Expression ch1 = ep1;
		Expression ch2 = ep2;
		
		//choose cut point, depending on number of args
		int cut1 = r.nextInt(ep1.getArity());
		int cut2 = r.nextInt(ep2.getArity());		

		Expression e1 = ((Operator) ch1).expressions[cut1];
		Expression e2 = ((Operator) ch2).expressions[cut2];
		
		((Operator) ch1).expressions[cut1] = e2 ;
		((Operator) ch2).expressions[cut2] = e1;	
		
		children.add(ch1);
		children.add(ch2);
		
		return children;
	}

	public static void main(String args[]){
		Expression args1[] = {new Leaf(1),new Leaf(2),new Leaf(3)};
		Population p = new Population();
		Reproduction r = new Reproduction(new Roulette(0.5) , 
				new Cross1(), new SurvivalOfTheFittest());
		GeneticAlgorithm g = new GeneticAlgorithm(100, p, r, new Mut1(0.5,0.5,0.5));
	}
	
}
