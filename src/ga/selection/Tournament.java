package ga.selection;
import java.util.Random;

import ga.Population;


public class Tournament implements Selection {
	
	public static int k = 3;
	//the size of the tournament
	
	public static double prop;
	//proportion of the population that will be selected
	
	
	public Tournament(double prob){
		prob=prop;
	}

	@Override
	public int[] select(Population pop, int toChoose) {
		int t = pop.people.length;
		int choosen[] = new int[toChoose];
		Random r =  new Random();
		for(int i=0; i<toChoose; i++){
			int ch=-1;
			for(int p=0; p<k;p++){
				int ch2 = r.nextInt(t);
				if(ch<0 || pop.people[ch2].compareTo(pop.people[ch])>0)
					ch=ch2;
			}
			choosen[i]=ch;
		}
		return choosen;
	}

	@Override
	public int[] select(Population pop) {
		return select(pop,(int) Math.round(pop.people.length*prop));
	}

}
