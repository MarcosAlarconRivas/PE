package DoubleValue;

import java.util.LinkedList;

import GA.Crossover;
import GA.Individual;
import GA.Population;

public class SinglePointCut implements Crossover {

	@Override
	public LinkedList<Individual> crossover(int[] parent, Population pop) {
		LinkedList<Individual> children = new LinkedList<Individual>();
		for(int i=0; i<parent.length-1; i+=2){
			//This 2 are the genotype of parents
			/*double g1= ((DoubleValue)pop.people[parent[i]]).genotype;
			double g2= ((DoubleValue)pop.people[parent[i+1]]).genotype;
			*/
			//choose a random cut point
			
			
		}
		return children;
	}



}
