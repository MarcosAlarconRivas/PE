package p3;

import java.util.LinkedList;
import java.util.Random;

public class Leaf extends Expression{
	private int x;
	protected static String names[] = {"a1","a0","d3","d2","d1","d0"};
	static final int depth= 0;
	private static LinkedList<Integer> list= new LinkedList<Integer>();
		//used for more homogeneous distribution of random leafs
	
	public Leaf(){
		this((new Random()).nextInt(names.length));
	}
	
	public Leaf(int wich_var){
		x = wich_var;
		recalcule();
	}
	
	public Leaf clone(){
		return new Leaf(x);
	}
	
	protected void rebuild(int x){
		this.x=x;
		recalcule();
	}
	
	public void rebuild(){
		rebuild(new Random().nextInt(names.length));
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

	@Override
	public int getArity() {
		return 0;
	}
	
	public boolean equals(Leaf l){
		return x==l.x;
	}

	static Leaf data(boolean rel) {
		if(rel)list.clear();
		return new Leaf(2+getData());
	}

	private static int getData() {
		if(list.isEmpty())
			for(int i=0;i<4;i++)list.add(i);
		return list.remove(new Random().nextInt(list.size()));
	}
	
}
