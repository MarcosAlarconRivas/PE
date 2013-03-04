package GA.Selection;

import java.util.ArrayList;
import java.util.Random;

import GA.Individual;
import GA.Population;

public class Roulette implements Selection {

	public Individual[] select(Population pop) {
		Individual[] list = new Individual[pop.people.length]; 
		int pos = 0;
		double probability;
		int positionSurvivor;
		Random r = new Random();
		for (int i=0;i<pop.people.length;i++){
			probability=r.nextDouble();
			positionSurvivor=0;
			while ((probability>pop.getI(positionSurvivor).fitness()) && positionSurvivor<pop.people.length){
				positionSurvivor++;
			}
			list[pos] = pop.getI(positionSurvivor);
			i++;
		}
		return list;
	}
}
