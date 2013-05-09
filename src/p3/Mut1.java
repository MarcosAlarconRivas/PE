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

}
