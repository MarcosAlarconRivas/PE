package p3;

public class Not extends Operator {

	public static int arity = 1;
	
	public Not(Expression[] args) {
		super(args);
	}
	
	Not(){};
	
	@Override
	protected boolean evaluate(boolean[] input) {
		return !(expressions[0].evaluate(input));
	}
	
	@Override
	public int getArity() {
		return arity;
	}

}
