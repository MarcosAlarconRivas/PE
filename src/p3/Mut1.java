package p3;

import java.util.Random;

import ga.Individual;
import ga.Mutation;

public class Mut1 extends Mutation {

	public Mut1(double baseProb, double inbreedingControl, 
			double annealingControl) { //prob, endogamia, enfriamiento
		super(baseProb, inbreedingControl, annealingControl);
	}

	@Override
	protected void mutate(Individual indiv) {
		Expression ex = ((Expression) indiv);
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
