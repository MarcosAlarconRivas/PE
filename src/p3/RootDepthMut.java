package p3;

import java.util.Random;

import ga.Individual;
import ga.Mutation;

public class RootDepthMut extends Mutation {

	public RootDepthMut(double baseProb, double inbreedingControl, 
			double annealingControl) { //prob, endogamia, enfriamiento
		super(baseProb, inbreedingControl, annealingControl);
	}

	@Override
	protected void mutate(Individual indiv) {
		Expression ex = ((Expression) indiv);
		if (ex.isLeaf())
			((Leaf) ex).x = (new Random()).nextInt(Leaf.names.length);
		else{
			Operator op = (Operator) ex;
			if (ex instanceof If){
				Expression aux = op.expressions[1];
				op.expressions[1]=op.expressions[2];
				op.expressions[2]=aux;
			} else if (op instanceof Or)
				op = new And(op.expressions);
			 else if (op instanceof And)
				op = new Or(op.expressions);
		} 	
		ex.recalce();
	}

}
