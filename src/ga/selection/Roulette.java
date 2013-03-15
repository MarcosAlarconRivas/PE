package ga.selection;

import java.util.ArrayList;
import java.util.Random;

import ga.Individual;
import ga.Population;

public class Roulette implements Selection {

	public int[] select(Population pop) {
		/*Individual[] list = new Individual[pop.people.length]; 
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
		return list;*/return null;
	}
}
