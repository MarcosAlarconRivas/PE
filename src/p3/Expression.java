package p3;

import ga.Fitness;
import ga.Individual;

public abstract class Expression extends Individual {
	public static final Fitness fitness= new MUX4();
	protected static boolean enabledIf= true;
	protected static int maxDepth = 2;
	
	/**
	 * Returns a new Random Expression of the default maxDepth.
	 * You can change this depth using the static method 'setMaxDepth(int)'.
	 */
	public static Expression generateRandomTree(){
		Expression r= generateRandomTree(maxDepth, false);
		r.recalcule();
		return r;
	}
	
	/**
	 * This creates a new Expression with a 'maxDepth' size.
	 * Some of its branches can be shorter.
	 */
	static Expression generateRandomTree(int maxDepths){
		return generateRandomTree(maxDepths, true);
	}
	
	/**
	 * This creates a new Expression with a 'maxDepth' size.
	 * If 'leafs' some intern nodes are randomly generated as leafs.
	 */
	static Expression generateRandomTree(int maxDepth, boolean leafs){
		if(maxDepth<=Leaf.depth)return new Leaf();
		if(maxDepth<=Leaf.depth||(leafs&&Math.random()<.75*(maxDepth/Expression.maxDepth)))
			return new Leaf();
		return Operator.generateRandomOp(maxDepth, leafs);
	}
	
	protected abstract boolean evaluate(boolean args[]);
	
	public abstract int depth();
	
	protected abstract int measureDepth();
	
	public boolean isLeaf(){
		 return this instanceof Leaf;
	}
	
	public static void setIfEnabled(boolean use_if){
		enabledIf = use_if;
	}
	
	public static void setMaxDepth(int depth){
		maxDepth = depth;
	}
	
	@Override
	public double recalcule(){
		measureDepth();
		return super.recalcule();
	}
	
	public abstract int getArity();

}
