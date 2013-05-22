package p3;

import java.util.LinkedList;

import ga.Fitness;
import ga.Individual;

public class MUX4 implements Fitness {
	public static final boolean test[][] = testingVector();

	@Override
	public double evaluate(Individual creature) {
		Expression e = (Expression)creature;
		int h = hits(e);
		//return (h^2)/(e.measureDepth()+1);
		return h;
		//FIXME can i use depth()?
	}
	
	public static int hits(Individual cre){
		Expression e = (Expression)cre;
		int hits=0;
		for(int i=0; i<test.length; i++)
			if(e.evaluate(test[i])==mux(test[i]))
				hits++;
		return hits;
		
	}

	private static boolean mux(boolean inputs[]){
		return inputs[(inputs[5]?2:0)+(inputs[4]?1:0)];
	}

	@Override
	public Class<? extends Individual> specie() {
		return Expression.class;
	}
	
	@Override
	public boolean maximization() {
		return true;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	private static LinkedList<LinkedList<Boolean>>testingList(int ln) {
		if(ln<0)return null;
		if(ln==0)
			return new LinkedList<LinkedList<Boolean>>();
		LinkedList<LinkedList<Boolean>> result= new LinkedList<LinkedList<Boolean>>();
		if(ln==1){
			LinkedList<Boolean> t, f;
			t= new LinkedList<Boolean>();
			t.add(true);
			result.add(t);
			f= new LinkedList<Boolean>();
			t.add(false);
			result.add(f);
			return result;
		}
		
		LinkedList<LinkedList<Boolean>> t, f;
		f = testingList(ln-1);
		t = (LinkedList<LinkedList<Boolean>>)f.clone();

		for(LinkedList<Boolean> l: f){
			l.addLast(false);
			result.addLast(l);
		}
		
		for(LinkedList<Boolean> l: t){
			l.addLast(true);
			result.addLast(l);
		}
		
		return result;
	}
	
	private static boolean[][] testingVector() {
		return new boolean[][]{
		{false,false,false,false,false,false},
		{false,false,false,false,false,true},
		{false,false,false,false,true,false},
		{false,false,false,false,true,true},
		{false,false,false,true,false,false},
		{false,false,false,true,false,true},
		{false,false,false,true,true,false},
		{false,false,false,true,true,true},
		{false,false,true,false,false,false},
		{false,false,true,false,false,true},
		{false,false,true,false,true,false},
		{false,false,true,false,true,true},
		{false,false,true,true,false,false},
		{false,false,true,true,false,true},
		{false,false,true,true,true,false},
		{false,false,true,true,true,true},
		{false,true,false,false,false,false},
		{false,true,false,false,false,true},
		{false,true,false,false,true,false},
		{false,true,false,false,true,true},
		{false,true,false,true,false,false},
		{false,true,false,true,false,true},
		{false,true,false,true,true,false},
		{false,true,false,true,true,true},
		{false,true,true,false,false,false},
		{false,true,true,false,false,true},
		{false,true,true,false,true,false},
		{false,true,true,false,true,true},
		{false,true,true,true,false,false},
		{false,true,true,true,false,true},
		{false,true,true,true,true,false},
		{false,true,true,true,true,true},
		{true,false,false,false,false,false},
		{true,false,false,false,false,true},
		{true,false,false,false,true,false},
		{true,false,false,false,true,true},
		{true,false,false,true,false,false},
		{true,false,false,true,false,true},
		{true,false,false,true,true,false},
		{true,false,false,true,true,true},
		{true,false,true,false,false,false},
		{true,false,true,false,false,true},
		{true,false,true,false,true,false},
		{true,false,true,false,true,true},
		{true,false,true,true,false,false},
		{true,false,true,true,false,true},
		{true,false,true,true,true,false},
		{true,false,true,true,true,true},
		{true,true,false,false,false,false},
		{true,true,false,false,false,true},
		{true,true,false,false,true,false},
		{true,true,false,false,true,true},
		{true,true,false,true,false,false},
		{true,true,false,true,false,true},
		{true,true,false,true,true,false},
		{true,true,false,true,true,true},
		{true,true,true,false,false,false},
		{true,true,true,false,false,true},
		{true,true,true,false,true,false},
		{true,true,true,false,true,true},
		{true,true,true,true,false,false},
		{true,true,true,true,false,true},
		{true,true,true,true,true,false},
		{true,true,true,true,true,true}
		};
	}
	
	public static void main(String args[]){
		for(int i=0; i<test.length; i++){
			for(int j=0; j<test[i].length; j++)
				System.out.print(test[i][j]?1:0);
			System.out.println();
		}
			
	}


}
