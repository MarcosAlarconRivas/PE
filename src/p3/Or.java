package p3;

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

	public void mutate() {
		new And(this.expressions);	
	}

	@Override
	public int getArity() {
		return arity;
	}
	
}
