package p2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import ga.Crossover;
import ga.Individual;
import ga.Population;

public class OXCross implements Crossover {

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
			
			ArrayList<Integer> al = new ArrayList<Integer>();
			
			for (int col=0; col<9; col++){
				if ((col<=cut1 || col>=cut2) && parent1.rows[row][col]>0){
					al.add(parent1.rows[row][col]);
					al.add(parent2.rows[row][col]);
				}
				else{
					dna1[row][col]= parent2.rows[row][col];
					dna2[row][col]= parent1.rows[row][col];
				}
			}
			
			int i=al.size()-1; int col1=0, col2=0;
			while (i>=0){
				int elem = al.get(i);
				if (i==cut2) i=cut1;			
				if (!contains(elem,dna1[row],cut1,cut2)){
					dna1[row][col1]=elem; col1++;
				}
				else{ 
					dna2[row][col2]=elem; col2++;
				}
				i--;
			}
		}
		children.add(new Sudoku(dna1));
		children.add(new Sudoku(dna2));
		
		return children;
	}

	private boolean contains(Integer integer, int[] row, int cut1, int cut2) {
		for (int i=cut1; i<=cut2; i++)
			if (row[i]==integer) return true;
		return false;
	}
}