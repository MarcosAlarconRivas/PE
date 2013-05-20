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
		int depth =r.nextInt(ex.depth());
		while(!ex.isLeaf()&&depth>0){
			ex= ((Operator)ex).expressions[r.nextInt(ex.getArity())];
			depth--;
		}
		if (!ex.isLeaf()){
			if (ex instanceof If){
				Expression aux = ((If) ex).expressions[1];
				((If) ex).expressions[1]=((If) ex).expressions[2];
				((If) ex).expressions[2]=aux;
			} else if (ex instanceof Or){
				ex = new And(((Or) ex).expressions);
			} else if (ex instanceof And){
				ex = new Or(((And) ex).expressions);
			}
		} else {
			((Leaf) ex).x = (new Random()).nextInt(Leaf.names.length);
		}
	}

}
