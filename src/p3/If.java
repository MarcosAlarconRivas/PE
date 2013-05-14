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
	
	public void mutate(){
		Expression aux = expressions[1];
		expressions[1]=expressions[2];
		expressions[2]=aux;
	}

	@Override
	public int getArity() {
		return arity;
	}

}
