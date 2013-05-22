package p3;

import java.util.Random;

public abstract class Operator extends Expression {
	@SuppressWarnings("unchecked")
	private final static Class<? extends Operator> extenders[]= 
			new Class[]{Not.class, Or.class, And.class, If.class};

	public Expression expressions[];
	public static final int arity= -1;
	protected int depth;
	
	public Operator(Expression args[]){
		rebuild(args);
	}
	
	protected Operator() {}//all subclasses must implement empty constructor
	
	private void rebuild(Expression args[]){
		if(args.length!=getArity())
			System.out.println("Numero de argumentos incorrecto");
		else{
			expressions=args;
			measureDepth();
		}
	}

	public String toString(){
		String s = this.getClass().getName();
		String cuts[] = s.split("[.]");
		if (cuts.length > 0)
			s = cuts[cuts.length - 1];
		for(int i=0; i<expressions.length; i++)
			s+=" "+expressions[i].toString();
		return s;
	}

	public static Operator generateRandomOp(int maxDepth, boolean leafs){
		Random r= new Random();
		Class<? extends Operator> wich = extenders[r.nextInt(extenders.length-(enabledIf?0:1))];
		int ar = extenderArity(wich);

		Expression branch[] = new Expression[ar];
		for(int i=0; i<ar; i++){
			branch[i]= Expression.generateRandomTree(maxDepth-1, leafs);
		}
		
		Operator op= null;
		try {
			op = (Operator) wich.newInstance();
			op.rebuild(branch);
		} catch (Exception e) {
			System.out.println(e+" >> revisar Operator::generateRandomOp");
		}
		return op;
	}
	
	@Override
	public int depth(){
		return depth;
	}
	
	public abstract int getArity();
	
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
		Operator copy= null;
		try {
			Class<? extends Operator> myClass = this.getClass(); 
			copy = (Operator) myClass.newInstance();
			copy.rebuild(this.expressions.clone());
			copy.lastEvaluation= lastEvaluation;
		} catch (Exception e) {
			System.out.println(e+" >> revisar Operator::clone");
		}
		return copy;
	}
	
	private static int extenderArity(Class<? extends Operator> c){
		int res = -1;
		try {
			res = c.getDeclaredField("arity").getInt(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public static void main(String args[]){
		System.out.println(generateRandomTree());

	}
	
}
