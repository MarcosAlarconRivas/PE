package p3;

import java.util.Random;

public abstract class Operator extends Expression {
	private static Class extenders[]= new Class[]{Not.class, Or.class, And.class, If.class};
	public Expression expressions[];
	public static final int arity= -1;
	protected int depth;
	public static String opName;
	
	public Operator(Expression args[]){
		if(args.length!=arity)
			System.out.println("Numero de argumentos incorrecto");
		else{
			expressions=args;
			measureDepth();
		}
		
	}

	public String toString(){
		String s = opName;
		for(int i=0; i<expressions.length; i++)
			s+=" "+expressions[i].toString();
		return s;
	}
	
	public static Operator generateRandomOp(int maxDepth){
		Random r;
		Operator op;
		try{
			r = new Random();
			//TODO
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		return null;
	}
	
	@Override
	public int depth(){
		return depth;
	}
	
	public int measureDepth(){
		depth = 0;
		for(int i=0; i<arity; i++){
			int argDepth = expressions[i].measureDepth();
			if(depth<argDepth)
				depth=argDepth;
		}//depth = Max(arg[0].depth, arg[1].depth..)
		
		return ++depth;
	}
	
	@Override
	public Operator clone() {
		return (Operator) (Object)this.clone();
	}
	
	@Override
	public abstract void mutate();
	
	@Override
	public abstract int getArity();
	
}
