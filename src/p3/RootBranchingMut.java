package p3;

import java.util.Random;

import ga.Individual;
import ga.Mutation;

/**
 * Chooses a root node in the tree & changes it for a random branch
 */
public class RootBranchingMut extends Mutation {

	public RootBranchingMut(double baseProb, double inbreedingControl,
			double annealingControl) {
		super(baseProb, inbreedingControl, annealingControl);
	}
	@Override
	protected void mutate(Individual i) {
		Expression e = (Expression) i;
		Random r =  new Random();
		if(e.isLeaf())
			((Leaf)e).x= r.nextInt(Leaf.names.length);
		else{
			Operator op  = (Operator) e;
			op.expressions[r.nextInt(op.expressions.length)]= Expression.generateRandomTree();
			op.recalce();
		}
	}
}
