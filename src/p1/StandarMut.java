package p1;

import ga.Individual;
import ga.Mutation;

public class StandarMut extends Mutation {

	public StandarMut(double mutationRate, double inbreedingControl, 
			double annealingControl) {
		super(mutationRate, inbreedingControl, annealingControl);
	}

	@Override
	protected void mutate(Individual i) {
		DoubleValue ind = (DoubleValue)i;
		int chrLen[] = ((DoubleFunction) ind.fitness).genotypeBits;
		
		for(int ch=0; ch<chrLen.length; ch++){//for each chromosome
			
			//generate n (number of mutations)
			int n= (int) Math.min(
					Math.floor(Math.random()*chrLen[ch]),
					Math.floor(Math.random()*chrLen[ch]));
			
			//mutate n alleles
			while(n-->0)
				ind.genotype[ch].xor((long)Math.floor(Math.random()*chrLen[ch]));
			
			
		}

	}

}
