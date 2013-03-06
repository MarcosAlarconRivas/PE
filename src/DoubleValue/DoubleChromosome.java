package DoubleValue;

import Utilities.BitVector;

public class DoubleChromosome extends BitVector {
	DoubleChromosome(int length){
		super(RANDOM, length);
	}
	
	boolean [][] meiosis(long cutPoints[]){
		//FIXME 
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

}
