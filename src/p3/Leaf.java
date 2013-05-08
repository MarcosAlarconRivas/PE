package p3;

import java.util.Random;

public class Leaf extends Expresion{
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
	
	protected boolean evalate(boolean args[]){
		return args[x];
	}
	
	public String toString(){
		return names[x];
	}
	
}
