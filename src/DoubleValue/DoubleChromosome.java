package DoubleValue;

import java.util.LinkedList;
import java.util.List;
import Utilities.BitVector;

public class DoubleChromosome extends BitVector {
	DoubleChromosome(int length){
		super(RANDOM, length);
	}
	
	/**
	 * Breaks the bit vector in subvectors
	 * @param cutPoints ascending ordered points where cut the vector
	 * @return the bit vector parts as boolean[]
	 */
	boolean [][] meiosis(long cutPoints[]){
		//FIXME read it carefully &/or test it
		boolean result[][] =  new boolean [cutPoints.length+1][];
		long head = 0;
		for (int p = 0; p<= cutPoints.length; head=cutPoints[p++]){
			long tail= (p<cutPoints.length)?cutPoints[p]:length;
			result[p]= new boolean[(int)(tail-head)];
			for(int i=0; i<tail-head; i++)
				result[p][i]= get(head+i);
		}
		return result;
	}

	/**
	 * Rebuilds chromosomes from meiosis results.
	 */
	public static LinkedList<DoubleChromosome> rebuid(List<boolean [][]> dna){
		LinkedList<DoubleChromosome> reslut = new LinkedList<DoubleChromosome>();
		int numOfChilds = dna.size();//same as numOfParents
		
		return reslut;
		
	}
}
