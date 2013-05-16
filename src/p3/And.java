package p3;

public class And extends Operator {

	public static int arity = 2;
	
	public And(Expression[] args) {
		super(args);
	}
	
	And(){}
	
	@Override
	protected boolean evaluate(boolean[] input) {
		return (expressions[0].evaluate(input)) && (expressions[1].evaluate(input));
	}

	@Override
	public int getArity() {
		return arity;
	}

}
