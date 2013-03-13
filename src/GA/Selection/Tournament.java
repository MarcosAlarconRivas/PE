package GA.Selection;
import GA.Population;


public class Tournament implements Selection {
	
	public static int k = 3;
	public static double prob;
	//the size of the tournament
	
	public Tournament(double p){
		p=prob;
	}

	@Override
	public int[] select(Population pop) {
		int t = pop.people.length;
		int toChoose = (int) Math.round(t*prob);
		int choosen[] = new int[toChoose];
		for(int i=0; i<toChoose; i++){
			int ch=-1;
			for(int p=0; p<k;p++){
				int ch2 = Math.min((int)Math.floor(Math.random()*t), t);
				if(ch<0 || pop.people[ch2].compareTo(pop.people[ch])>0)
					ch=ch2;
			}
			choosen[i]=ch;
		}
		return choosen;
	}

}
