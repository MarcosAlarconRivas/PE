package DoubleValue;

import java.util.LinkedList;
import Utilities.BitVector;

public class DoubleChromosome extends BitVector {
	
	DoubleChromosome(long length){
		super(RANDOM, length);
	}
	
	DoubleChromosome(long length, boolean setValue){
		super(setValue?ALL_1:ALL_0, length);
	}
	
	/**
	 * Breaks the bit vector in subvectors
	 * @param cutPoints ascending ordered points where cut the vector
	 * @return the bit vector parts as boolean[]
	 */
	boolean [][] meiosis(long cutPoints[]){
		//FIXME debug
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
	public static LinkedList<DoubleChromosome> rebuild(boolean [][][] dna){
		//FIXME debug
		LinkedList<DoubleChromosome> result = new LinkedList<DoubleChromosome>();
		
		long total_length = 0;
		int numOfCuts= dna [0][0].length;
		int numOfParents = dna.length;
		
		for(int i=0;i<dna[0].length;i++)
			total_length += dna[0][i].length;

		for(int child=0; child<numOfParents; child++){
			DoubleChromosome newC = new DoubleChromosome(total_length, false);
			long bit = 0;
			for(int cut=0; cut<numOfCuts; cut++){
				bit=newC.paste(dna[(child+cut)%numOfParents][(child+cut)%numOfCuts], bit);
			}
			result.add(newC);
		}	
		return result;
	}
	
	/**
	 * Copies a boolean vector in given position and nexts
	 * @param bits_to_copy
	 * @param begin_bit
	 * @return begin_bit + bits_to_copy.length (how long has been modified the vector)
	 */
	private long paste(boolean[] bits_to_copy, long begin_bit) {
		
		for (int bit =0; bit<bits_to_copy.length; bit++)
			set(bit+begin_bit, bits_to_copy[bit]);
		
		return begin_bit + bits_to_copy.length;
	}
}
