package p3;

import ga.Fitness;
import ga.Individual;

public class MUX4 implements Fitness {
	public static final boolean test[][] = testingVector();

	@Override
	public double evaluate(Individual creature) {
		Expression e = (Expression)creature;
		int hits=0;
		for(int i=0; i<test.length; i++)
			if(e.evaluate(test[i])==mux(test[i]))
				hits++;
		
		return 3*hits/e.measureDepth();
		//FIXME can i use depth()?
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
	
	private static boolean[][] testingVector() {
		//TODO generate it with a loop
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


}
