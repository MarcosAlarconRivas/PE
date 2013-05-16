package p3;

import ga.Fitness;
import ga.Individual;

public abstract class Expression extends Individual {
	public static final Fitness fitness= new MUX4();
	protected static boolean enabledIf= true;
	protected static int maxDepth = 5;
	
	/**
	 * Returns a new Random Expression of the default maxDepth.
	 * You can change this depth using the static method 'setMaxDepth(int)'.
	 */
	public static Expression generateRandomTree(){
		return generateRandomTree(maxDepth);
	}
	
	/**
	 * This creates a new Expression with a 'maxDepth' size.
	 * Some of its branches can be shorter:
	 * 	0.25 of the nodes are Leaf before then reach the depth.
	 */
	public static Expression generateRandomTree(int maxDepth){
		if(maxDepth<=Leaf.depth||Math.random()<.25*(maxDepth/Expression.maxDepth))
			return new Leaf();
		return Operator.generateRandomOp(maxDepth);
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

}
