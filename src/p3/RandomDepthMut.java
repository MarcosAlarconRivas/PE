package p3;

import java.util.Random;
import ga.Individual;
import ga.Mutation;
/**
 * This does same as Mut1 except it makes the mutation at random depth.
 */
public class RandomDepthMut extends Mutation {

	public RandomDepthMut(double baseProb, double inbreedingControl,
			double annealingControl) {
		super(baseProb, inbreedingControl, annealingControl);
	}

	@Override
	protected void mutate(Individual i) {
		Expression ex = (Expression)i;
		Random r = new Random();
		int depth =r.nextInt(ex.depth()>0?ex.depth():1);
		while(!ex.isLeaf()&&depth>0){
			ex= ((Operator)ex).expressions[r.nextInt(ex.getArity())];
			depth--;
		}
		if (!ex.isLeaf()){
			Operator op = (Operator) ex;
			if (op instanceof If){
				Expression aux = op.expressions[1];
				op.expressions[1]=op.expressions[2];
				op.expressions[2]=aux;
			} else if (op instanceof Or){
				op = new And(op.expressions);
			} else if (op instanceof And){
				op = new Or(op.expressions);
			}
		} else {
			((Leaf) ex).x = (new Random()).nextInt(Leaf.names.length);
		}
		ex.recalcule();
	}

}
