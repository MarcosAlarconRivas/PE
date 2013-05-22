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
		Random r = new Random();
		if (e.isLeaf()) {
			((Leaf) e).rebuild(r.nextInt(Leaf.names.length));
			return;
		}// else
		int d = r.nextInt(e.depth());
		int current = 0;
		int choosen = 0;
		Expression[] exps = ((Operator) e).expressions;;
		while (current < d && !e.isLeaf()) {
			exps = ((Operator) e).expressions;
			choosen = r.nextInt(exps.length);
			e = exps[choosen];
		}
		exps[choosen] = Expression.generateRandomTree(Expression.maxDepth-e.depth());
		e.recalcule();
	}
	
	

}

