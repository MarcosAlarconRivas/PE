package p3;

import ga.Individual;

public class Or extends Operator {

	public static int arity = 2;
	public static String opName = "Or";
	
	public Or(Expression[] args) {
		super(args);
	}
	
	@Override
	protected boolean evaluate(boolean[] input) {
		return (expressions[0].evaluate(input)) || (expressions[1].evaluate(input));
	}

}
