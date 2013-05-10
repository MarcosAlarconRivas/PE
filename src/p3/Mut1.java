package p3;

import ga.Individual;
import ga.Mutation;

public class Mut1 extends Mutation {

	public Mut1(double baseProb, double inbreedingControl, 
			double annealingControl) { //prob, endogamia, enfriamiento
		super(baseProb, inbreedingControl, annealingControl);
	}

	@Override
	protected void mutate(Individual indiv) {
		if (!((Expression) indiv).isLeaf()){
			Operator expr = ((Operator) indiv);
			expr.mutate();
		}
	}
	
	public static void main(String args[]){
		Expression args1[] = {new Leaf(),new Leaf(),new Leaf()};
		If a = new If(args1);
		a.mutate();
	}

}
