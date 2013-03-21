package p1;

import java.util.LinkedList;
import utilities.BitVector;

public class DoubleChromosome extends BitVector {
	
	/**
	 * Creates a random binary vector of given length.
	 * @param length
	 */
	DoubleChromosome(long length){
		super(RANDOM, length);
	}
	
	/**
	 * Creates a binary vector of given length and set's it to 1(true) or 0 (false) 
	 * @param length
	 * @param setValue
	 */
	DoubleChromosome(long length, boolean setValue){
		super(setValue?ALL_1:ALL_0, length);
	}
	
	/**
	 * Breaks the bit vector in subvectors
	 * @param cutPoints ascending ordered points where cut the vector
	 * @return the bit vector parts as boolean[]
	 */
	boolean [][] meiosis(long cutPoints[]){
		int cuts = cutPoints.length;
		boolean result[][] =  new boolean [cuts+1][];
		long head = 0;
		for (int p = 0; p<=cuts; p++){
			long tail= (p<cuts)?cutPoints[p]:length;
			result[p]= new boolean[(int)(tail-head)];
			for(int i=0; i<tail-head; i++)
				result[p][i]= get(head+i);
			head=tail;
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
		int numOfCuts= dna [0].length;
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
	 * Give the rage of the var, returns the value of the chromosome.
	 */
	double toFenotype(double min, double max) {
		long dec = toUnsigned();
		long rage = rage();
		double f = min + dec * (max - min) / rage;
		if (f < min || f > max) {
			System.err.println("Out of rage " + f + " fenotype.");
		}
		return f;
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
