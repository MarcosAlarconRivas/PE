package p3;

//import java.util.Random;


public abstract class Operator extends Expression {
	protected Expression expressions[];
	public static int arity= -1;
	
	public Operator(Expression args[]){
		if(args.length!=arity)
			System.out.println("Numero de argumentos incorrecto");
		else
			expressions=args;
	}

	/*
	public Operator(){
		op = (new Random()).nextInt(names.length-(enabledIf?0:1));
	}*/
	




}
