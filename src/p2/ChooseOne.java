package p2;

import ga.Individual;
import ga.Mutation;
/**
 * This mutation tries 3 times to change two positions of the same row.
 * returns the best one of the 3
 */
public class ChooseOne extends Mutation {

	public ChooseOne(double baseProb, double inbreedingControl, double annealingControl) {
		super(baseProb, inbreedingControl, annealingControl);
	}

	@Override
	protected void mutate(Individual i) {
		// TODO Auto-generated method stub

	}

}
