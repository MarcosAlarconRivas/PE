package p1;

public class Function4 extends DoubleFunction{
	
	public Function4(){
		lowLimit= new double[]{0};
		highLimit=new double[]{100};
		numOfChromosomes = 1;
		maximization= false;
	}
	
	public String toString(){
		return "f(xi, i=1..n) = sum(i=1..n)[(-x*sen(sqrt(|xi|)))]";
	}
	
	/**
	 * Sets the num of vars for the function.
	 */
	public void setN(int n){
		if(n>numOfChromosomes){
			double hl = highLimit[0];
			double ll = lowLimit[0];
			int bits = genotypeBits[0];
			highLimit= new double[n];
			lowLimit= new double[n];
			genotypeBits = new int[n];
			for(int i=0; i<n; i++){
				genotypeBits[i]= bits;
				highLimit[i]= hl;
				lowLimit[i]= ll;
			}
		}
		numOfChromosomes = n;
	}

	@Override
	protected double evaluate(double[] fenotypes) {
		double res = 0;
		for (int i=0; i<numOfChromosomes; i++){
			double f = fenotypes[i];
			double r = -(f*Math.sin(Math.sqrt(Math.abs(f))));
			res += r;
		}
		return res;
	}
}
