package p3;

import java.util.Random;

public class Leaf extends Expression{
	protected int x;
	protected static String names[] = {"a1","a0","d3","d2","d1","d0"};
	
	public Leaf(){
		x = (new Random()).nextInt(names.length);
	}
	
	public Leaf(int in){
		x = in;
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
		return 1;
	}
	
	public int depth(){
		return 1;
	}
	
	public void mutate(){
		this.x = (new Random()).nextInt(names.length);		
	}

	@Override
	public int getArity() {
		return 0;
	}
	
}
