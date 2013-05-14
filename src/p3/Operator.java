package p3;

import java.util.Random;

public abstract class Operator extends Expression {
	private static Extender extenders[]= new Extender[]{
		new Extender(Not.class, Not.arity),
		new Extender(Or.class, Or.arity),
		new Extender(And.class, And.arity),
		new Extender(If.class, If.arity),
	};

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
		Random r= new Random();
		Extender wich = extenders[r.nextInt(extenders.length-(enabledIf?0:1))];

		Expression branch[] = new Expression[wich.arity];
		for(int i=0; i<wich.arity; i++){
			branch[i]= Expression.generateRandomTree(maxDepth-1);
		}
		
		Operator op= null;
		try {
			op = (Operator) wich.c.getConstructors()[0].newInstance(branch);
			//FIXME this doesn't make me calmed down
		} catch (Exception e) {
			System.out.println("Revisar Operator::generateRandomOp");
			e.printStackTrace();
		}
		return op;
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
	
	private static class Extender{
		Class<? extends Operator> c= null;
		int arity= -1;
		
		Extender(Class<? extends Operator> cl, int arity){
			if(Operator.class.isAssignableFrom(cl)){
				c= cl;
				this.arity= arity;
			}
		}
	}//end of Extender
	
	public static void main(String args[]){
		
		Extender e= new Extender(Not.class, 1);
		System.out.println(e);
		
		Expression ex = generateRandomTree(3);
		System.out.println(ex);
		/*
		System.out.println(Not.class.isAssignableFrom(Operator.class));
		System.out.println(Operator.class.isAssignableFrom(Not.class));
		System.out.println(Operator.class.isAssignableFrom(If.class));
		System.out.println(Expression.class.isAssignableFrom(And.class));
	*/
	}
	
}
