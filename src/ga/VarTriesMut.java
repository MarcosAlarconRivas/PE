package ga;

public abstract class VarTriesMut extends Mutation {
	
	protected static int numOfTries= 1;

	public VarTriesMut(double mutationRate){
		super(mutationRate);
	}
	
	public VarTriesMut(double baseProb, double inbreedingControl,
			double annealingControl) {
		super(baseProb, inbreedingControl, annealingControl);
	}
	
	public static void setNumOfTries(int num){
		if(num>0)numOfTries=num;
	}
	
	public static int getNumOfTies(){
		return numOfTries;
	}
	
	



}
