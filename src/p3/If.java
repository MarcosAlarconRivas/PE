package p3;

import ga.Individual;

public class If extends Operator {

	public static int arity = 3;
	
	public If(Expression[] args) {
		super(args);
	}
	
	@Override
	protected boolean evaluate(boolean[] input) {
		if(expressions[0].evaluate(input))
			return expressions[1].evaluate(input);
		else
			return expressions[2].evaluate(input);
	}

	@Override
	public Individual clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
