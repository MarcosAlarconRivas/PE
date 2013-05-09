package p3;

import ga.Individual;

public abstract class Expression extends Individual {
	
	protected static boolean enabledIf= true;
	//protected int depth;
	
	protected abstract boolean evaluate(boolean args[]);
	
	public boolean isLeaf(){
		 return this instanceof Leaf;
	}
	
	public void setIfEnabled(boolean use_if){
		enabledIf = use_if;
	}
	
	public abstract void mutate();

}
