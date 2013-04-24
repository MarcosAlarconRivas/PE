package p2;

import java.util.LinkedList;
import java.util.Random;

import ga.Crossover;
import ga.Individual;
import ga.Population;

public class MiddleInterchangeCross implements Crossover {

	@Override
	public LinkedList<Individual> crossover(int[] parents, Population pop) {
		LinkedList<Individual> children = new LinkedList<Individual> ();
		
		Random r = new Random();

		//choose 2 parents
		int r1 = r.nextInt(parents.length);
		int r2 = r.nextInt(parents.length);
		Individual p1 = pop.people[parents[r1]];
		Individual p2 = pop.people[parents[r2]];
		
		int dna1[][] = new int[9][9];
		int dna2[][] = new int[9][9];
		Sudoku parent1=((Sudoku) p1);
		Sudoku parent2=((Sudoku) p2);
		
		for (int row=0; row<9; row++){
			
			//choose a begin point of cut
			int cut1 = r.nextInt(9);
			//choose a end point of cut
			int cut2 = r.nextInt(9);
			
			if (cut2<cut1){
				int temp = cut1;
				cut1=cut2;
				cut2=temp;
			}
			
			for (int col=0; col<9; col++){
				if (col<=cut1 || col>=cut2){
					dna1[row][col]= parent1.rows[row][col];
					dna2[row][col]= parent2.rows[row][col];
				}
				else{
					int a = parent1.rows[row][col];
					if (!contains(a,dna1[row])) dna1[row][col]=a;
					int b = parent2.rows[row][col];
					if (!contains(b,dna2[row])) dna2[row][col]=b;
				}
			}
		}
		
		children.add(new Sudoku(dna1));
		children.add(new Sudoku(dna2));
		return children;
	}
	
	private boolean contains(Integer integer, int[] row) {
		for (int i=0; i<9; i++)
			if (row[i]==integer) return true;
		return false;
	}
}