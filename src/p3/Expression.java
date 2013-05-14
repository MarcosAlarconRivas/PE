package p3;

import ga.Fitness;
import ga.Individual;

public abstract class Expression extends Individual {
	public static final Fitness fitness= new MUX4();
	protected static boolean enabledIf= true;
	protected static int maxDepth = 5;
	
	public static Expression generateRandomTree(){
		return generateRandomTree(maxDepth);
	}
	
	
	public static Expression generateRandomTree(int maxDepth){
		//TODO
		return null;
	}
	
	protected abstract boolean evaluate(boolean args[]);
	
	public abstract int depth();
	
	public abstract int measureDepth();
	
	public boolean isLeaf(){
		 return this instanceof Leaf;
	}
	
	public void setIfEnabled(boolean use_if){
		enabledIf = use_if;
	}
	
	public static void setMaxDepth(int depth){
		maxDepth = depth;
	}
	
	public abstract int getArity();
	
	public abstract void mutate();

}
