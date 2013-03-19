package ga;

import java.util.Arrays;
import java.util.Set;


//import p1.DoubleValue;

public class Population {
	//copied elite creatures (they are also in people).
	Individual elite[] = null;
		//int elitePos[] = null;
	
	Fitness fitnessFunction;

	//current full population
	public Individual[] people;

	//position in people of the best individual
	private int best;

	protected double fitAverage;
	
	public Population(Fitness fitness, int numOfIndividuals, boolean elite){
		fitnessFunction= fitness;
		
		people = new Individual[numOfIndividuals];
		
		if(elite) this.elite = new Individual[numOfIndividuals/50];
			//elite is 2% of total size of population
		
		Individual.setStaticFitness(fitness);
		
		for (int i=0; i<numOfIndividuals; i++) 
			try {
				people[i]= fitness.specie().newInstance();
			}catch (Exception e) {
				System.out.println(e);
			}
		recalculate();
	}
	
	public Fitness getFitnessFunction(){
		return fitnessFunction;
	}

	public double average(){
		return fitAverage;
	}

	public Individual getBest() {
		return people[best];
	}

	public double inbreading() {
		/*if(fitnessFunction.specie() instanceof DoubleValue){
			for(int i=0; i<people.length; i++){
				for(int c=0; c<fitnessFunction.specie().genotypeBits.length;c++){
					
				}
			}
		}*/
		
		return 0;
	}

	public void recalculate() {
		Arrays.sort(people);
		best = people.length-1;;
		fitAverage= 0;
		int length= people.length;
		for(int i=0; i<length; i++){
			//calculating fitAverage
			fitAverage += people[i].recalce()/length;//FIXME optimize recalce

			//calculating best (not necessary when population is ordered).
			//if(people[i].compareTo(people[best])>0) best= i;
	
			}
		//calculating elite
		if(elite!=null)
			//WRNING just for ordered populations
			for(int i=0; i<elite.length; i++)
				elite[i]= people[best-i].clone();
		
	}
	
	/**
	 * Overwrite worst individuals with elite (if people is ordered).
	 */
	public void restoreElite(){
		if(elite==null)return;
		for(int i=0; i<elite.length; i++)
			people[i]= elite[elite.length-i-1];
	}

}
