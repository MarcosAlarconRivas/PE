package p3;

public class If extends Operator {

	public static int arity = 3;
	
	public If(Expression[] args) {
		super(args);
	}
	
	If(){};
	
	@Override
	protected boolean evaluate(boolean[] input) {
		if(expressions[0].evaluate(input))
			return expressions[1].evaluate(input);
		else
			return expressions[2].evaluate(input);
	}

	@Override
	public int getArity() {
		return arity;
	}

}
