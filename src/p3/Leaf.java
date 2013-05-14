package p3;

import java.util.Random;

public class Leaf extends Expression{
	protected int x;
	protected static String names[] = {"a1","a0","d3","d2","d1","d0"};
	static final int depth= 0;
	
	public Leaf(){
		x = (new Random()).nextInt(names.length);
	}
	
	public Leaf(int wich_var){
		x = wich_var;
	}
	
	public Leaf clone(){
		return new Leaf(x);
	}
	
	protected boolean evaluate(boolean args[]){
		return args[x];
	}
	
	public String toString(){
		return names[x];
	}

	public int measureDepth() {
		//does nothing
		return depth;
	}
	
	public int depth(){
		return depth;
	}
	
	public void mutate(){
		this.x = (new Random()).nextInt(names.length);		
	}

	@Override
	public int getArity() {
		return 0;
	}
	
}
