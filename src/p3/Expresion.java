package p3;

import ga.Individual;

public class Expresion extends Individual {
	
	//public static Fitness fitness;
	
	protected boolean evaluate(boolean args[]){
		return false;
	}
	
	public boolean isLeaf(){
		 return (this instaceof Leaf);
	}

	@Override
	public Individual clone() {
		// TODO Auto-generated method stub
		return null;
	}

}
