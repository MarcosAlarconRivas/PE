package p3;

import sun.security.jca.GetInstance.Instance;
import ga.Fitness;
import ga.Individual;

public abstract class Expression extends Individual {
	public static final Fitness fitness= new MUX4();
	protected static boolean enabledIf= true;
	
	protected abstract boolean evaluate(boolean args[]);
	
	public abstract int depth();
	
	public abstract int measureDepth();
	
	public boolean isLeaf(){
		 return this instanceof Leaf;
	}
	
	public void setIfEnabled(boolean use_if){
		enabledIf = use_if;
	}
	
	public abstract int getArity();
	
	public abstract void mutate();

}
