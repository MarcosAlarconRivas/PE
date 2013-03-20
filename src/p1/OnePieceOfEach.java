package p1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import ga.Crossover;
import ga.Individual;
import ga.Population;
import ga.VarParentsCross;
/**
 * Take parents n by n cut them in n parts and paste one parts of each 
 * to build n new children
 */
public class OnePieceOfEach extends VarParentsCross implements Crossover {

	@Override
	public LinkedList<Individual> crossover(int[] parent, Population pop) {
		
		LinkedList<Individual> childsList = new LinkedList<Individual>();
		
		int genotypeBits[] = ((DoubleFunction)(pop.getFitnessFunction())).genotypeBits;
		
		for( int i=0; i<parent.length-numOfParents; ){
			LinkedList<DoubleValue> parents = new LinkedList<DoubleValue>();
			for (int j=0; j<numOfParents; j++)
				parents.add((DoubleValue) pop.people[parent[i++]]);
			cross(childsList, genotypeBits, parents);
		}
		return childsList;
	}
	
	private void cross(LinkedList<Individual> childs, int[] genotypeBits, 
			List<DoubleValue> parents) 
	{
		DoubleChromosome[][] childs_dna = new DoubleChromosome[numOfParents][genotypeBits.length];
			//numOfParents = numOfChids = numOfCuts+1
		
		for(int chr=0; chr<genotypeBits.length; chr++){//for each chromosome
			
			//generate cut points
			long[] cutPoints = new long[numOfParents-1];
			Random r =  new Random();
			for(int cut= 0; cut<numOfParents-1; cut++)
				cutPoints[cut]= (long)r.nextInt(genotypeBits[chr]);
			Arrays.sort(cutPoints);//order chosen cut points
			
			//cut parents chromosomes
			boolean parents_dna[][][] = new boolean[numOfParents][][];
			int p= 0;
			for(DoubleValue parent: parents)
				parents_dna[p++] = parent.genotype[chr].meiosis(cutPoints);
			if(p!=numOfParents)
				System.out.println("Error at OnePieceOfEach: private void cross\n numOfParents should be also the size of @param List<DoubleValue> parents");
			
			//set childs new chromosomes
			List<DoubleChromosome> mix = DoubleChromosome.rebuild(parents_dna);
			p= 0;
			for (DoubleChromosome chrom: mix)
				childs_dna[p++][chr] = chrom;
			if(p!=numOfParents)
				System.out.println("Error at OnePieceOfEach: private void cross\n child num check failed");
		}
		//create new individuals using the generated chromosomes
		for(int child= 0; child<numOfParents; child++)
			childs.add(new DoubleValue(childs_dna[child]));
	}
}
