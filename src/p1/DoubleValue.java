package p1;

import ga.Individual;
/**
 * Individual representing a (or some) double values
 * for the entry of a function (see DoubleFunction)
 */
public class DoubleValue extends Individual {
	DoubleChromosome genotype[];
	
	public DoubleValue(){
		this(((DoubleFunction)fitness).numOfChromosomes);
	}
	
	DoubleValue(DoubleChromosome gen[]){
		genotype = gen;
		recalce();
	}
	
	private DoubleValue(DoubleChromosome gen[], double eval){
		genotype = gen;
		lastEvaluation = eval;
	}
	
	public DoubleValue(int numOfVars){
		genotype = new DoubleChromosome[numOfVars];
		for(int i=0; i<numOfVars; i++)
			genotype[i]=new DoubleChromosome(((DoubleFunction)fitness).genotypeBits[i]);
		recalce();
	}
	
	public boolean equals(Individual other){
		if(!(other instanceof DoubleValue))return false;
		if(!super.equals(other))return false;
		return genotype==((DoubleValue)other).genotype;
	}
	
	public Individual clone(){
		return new DoubleValue(genotype.clone(), lastEvaluation);
	}
	
	public double[] fenotypes(){
		int nCh= genotype.length;
		DoubleFunction f = ((DoubleFunction)fitness);
		double fenotypes[] = new double[nCh];
		for(int i=0; i<nCh; i++){
			fenotypes[i]=genotype[i].toFenotype(f.lowLimit[i], f.highLimit[i]);
		}
		return fenotypes;
	}
	
	
	@SuppressWarnings("static-access")
	public double kinship(Individual other) {
		if(!(other instanceof DoubleValue)) return 0;
		
		DoubleFunction f = ((DoubleFunction)fitness);
		
		if(other.fitness != f) return 0;
		if(other==this)return 1;
		
		double[] cousinFen = ((DoubleValue) other).fenotypes();
		double[] myFen = fenotypes();
		int numGen= genotype.length;
		double kinship = 0;
		
		for(int g =0 ; g<numGen; g++)
			kinship += Math.abs(cousinFen[g]-myFen[g]/(f.highLimit[g]-f.lowLimit[g]));
		
		return kinship/numGen;
	}
	
}
