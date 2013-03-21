package p1;

import java.util.Random;

import ga.Individual;
import ga.Mutation;
/**
 * Normal Mutation algorithm, 
 * it produces a random number of alele's mutations in given individual.
 */
public class StandarMut extends Mutation {

	public StandarMut(double mutationRate, double inbreedingControl, 
			double annealingControl) {
		super(mutationRate, inbreedingControl, annealingControl);
	}

	@Override
	protected void mutate(Individual i) {
		DoubleValue ind = (DoubleValue)i;
		@SuppressWarnings("static-access")
		int chrLen[] = ((DoubleFunction) ind.fitness).genotypeBits;
		//== int chrLen[] = ((DoubleFunction) DoubleValue.fitness).genotypeBits;
		Random r =  new Random();
		
		for(int ch=0; ch<chrLen.length; ch++){//for each chromosome
			
			//generate n (number of mutations)
			int n= (int) Math.min(
					r.nextInt(chrLen[ch]),
					r.nextInt(chrLen[ch]));
			
			//mutate n alleles
			while(n-->0)
				ind.genotype[ch].xor(r.nextInt(chrLen[ch]));
			
			
		}

	}

}
