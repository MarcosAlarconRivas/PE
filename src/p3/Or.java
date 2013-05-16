package p3;

public class Or extends Operator {

	public static int arity = 2;
	
	public Or(Expression[] args) {
		super(args);
	}
	
	Or(){};
	
	@Override
	protected boolean evaluate(boolean[] input) {
		return (expressions[0].evaluate(input)) || (expressions[1].evaluate(input));
	}
	
	@Override
	public int getArity() {
		return arity;
	}
	
}
