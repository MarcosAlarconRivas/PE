package p3;

import ga.Individual;

public abstract class Operator extends Expression {
	protected Expression expressions[];
	public static int arity= -1;
	public static String opName; 
	
	public Operator(Expression args[]){
		if(args.length!=arity)
			System.out.println("Numero de argumentos incorrecto");
		else
			expressions=args;
	}

	public String toString(){
		String s = opName;
		for(int i=0; i<expressions.length; i++)
			s+=" "+expressions[i].toString();
		return s;
	}
	
	@Override
	public Individual clone() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
