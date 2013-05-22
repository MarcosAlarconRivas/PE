package p3;

import ga.Individual;
import ga.Mutation;
import java.util.Random;


/**
 * Chooses a root node in the tree & changes it for a random branch
 * * (with max depth equals to the original node)
 */

public class RandomBrachingMut extends Mutation {

	public RandomBrachingMut(double baseProb, double inbreedingControl,
			double annealingControl) {
		super(baseProb, inbreedingControl, annealingControl);
	}

	@Override
	protected void mutate(Individual i) {
		Expression e = (Expression) i;
		Random r =  new Random();
		if(e.isLeaf()){
			((Leaf)e).x= r.nextInt(Leaf.names.length);
			return;
		}//else
		Operator op  = (Operator) e;
		op.expressions[r.nextInt(op.expressions.length)]= Expression.generateRandomTree();
	}

}

