package p3;

public class Not extends Operator {

	public static int arity = 1;
	public static String opName = "Not";
	
	public Not(Expression[] args) {
		super(args);
	}
	
	@Override
	protected boolean evaluate(boolean[] input) {
		return !(expressions[0].evaluate(input));
	}

	@Override
	public void mutate() {
		//TODO
	}

}
