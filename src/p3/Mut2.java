package p3;

import java.util.Random;
import ga.Individual;
import ga.VarTriesMut;
/**
 * This does same as Mut1 except it makes the mutation at random depth
 * and it tries to mutate more than once and chooses the best.
 */
public class Mut2 extends VarTriesMut {

	public Mut2(double baseProb, double inbreedingControl,
			double annealingControl) {
		super(baseProb, inbreedingControl, annealingControl);
	}

	@Override
	protected void mutate(Individual i) {
		Expression tree = (Expression)i;
		Random r = new Random();
		int depth =r.nextInt(tree.depth());
		while(!tree.isLeaf()&&depth>0){
			tree= ((Operator)tree).expressions[r.nextInt(tree.getArity())];
			depth--;
		}
		tree.mutate();
	}

}
