package p3;

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
		if(e.isLeaf())
			((Leaf)e).rebuild();
		else{
			Operator op  = (Operator) e;
			op.rebuildBest(4);
		}
	}
}
