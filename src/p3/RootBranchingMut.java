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
		if(e.isLeaf()){
			((Leaf)e).x= r.nextInt(Leaf.names.length);
			return;
		}//else
		int d= r.nextInt(e.depth());
		int current= 0;
		int choosen= 0;
		Expression[] exps = null;
		while(current<d&&!e.isLeaf()){
			exps= ((Operator) e).expressions;
			choosen= r.nextInt(exps.length);
			e= exps[choosen];
		}
		exps[choosen]= Expression.generateRandomTree(Expression.maxDepth-e.depth());
	}

}
