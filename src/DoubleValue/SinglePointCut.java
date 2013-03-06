package DoubleValue;

import java.util.LinkedList;
import java.util.List;

import GA.Crossover;
import GA.Individual;
import GA.Population;
/**
 * Reproduce parents 2 by 2 with a single random cut point
 */
public class SinglePointCut implements Crossover {

	@Override
	public LinkedList<Individual> crossover(int[] parent, Population pop) {
		LinkedList<Individual> childs = new LinkedList<Individual>();
		@SuppressWarnings("static-access")
		int genotypeBits[] = ((DoubleFunction)(pop.people[0].fitness)).genotypeBits;
		
		for( int i=0; i<parent.length-1; i+=2)
			cross(childs, genotypeBits,
					(DoubleValue)pop.people[parent[i]],
					(DoubleValue)pop.people[parent[i+1]]);
		
		return childs;
	}

	/**
	 * Reproduce 2 parents and add their child into a list
	 * 
	 * @param childs: list to add to
	 * @param genotypeBits: sizes of all chromosomes
	 * @param p1: parent1
	 * @param p2: parent2
	 */
	private void cross(LinkedList<Individual> childs, int[] genotypeBits, 
			DoubleValue p1, DoubleValue p2) 
	{
		DoubleChromosome[] child1_dna = new DoubleChromosome[genotypeBits.length];
		DoubleChromosome[] child2_dna = new DoubleChromosome[genotypeBits.length];
		
		for(int chr=0; chr<genotypeBits.length; chr++){
			//FIXME: homogeneous random cut point?
			long[] cutPoint ={(long) Math.floor(Math.random()*genotypeBits[chr])};
			boolean parents_dna[][][] = new boolean[2][][];
			parents_dna[0] = p1.genotype[chr].meiosis(cutPoint);
			parents_dna[1] = p2.genotype[chr].meiosis(cutPoint);
			List<DoubleChromosome> mix = DoubleChromosome.rebuid(parents_dna);
			child1_dna[chr] = mix.get(0);
			child2_dna[chr] = mix.get(1);
		}

		childs.add(new DoubleValue(child1_dna));
		childs.add(new DoubleValue(child2_dna));
	}
}
