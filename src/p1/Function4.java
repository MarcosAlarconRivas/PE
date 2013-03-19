package p1;

public class Function4 extends DoubleFunction{
	
	protected static int n = 1;
	
	public Function4(){
		lowLimit= new double[]{0};
		highLimit=new double[]{100};
		numOfChromosomes = n;
	}
	 
	
	public String toString(){
		return "f(xi, i=1..n) = sum(i=1..n)[(-x*sen(sqrt(|xi|)))]";
	}

	@Override
	protected double evaluate(double[] fenotypes) {
		double res = 0;
		for (int i=1; i<=n; i++){
			double f = fenotypes[i];
			double r = -(f*Math.sin(Math.sqrt(Math.abs(f))));
			res += r;
		}
		return res;
	}
		
	public void setN(int n){
		if(n>numOfChromosomes){
			double hl = highLimit[0];
			double ll = lowLimit[0];
			highLimit= new double[n];
			lowLimit= new double[n];
			for(int i=0; i<n; i++){
				highLimit[i]= hl;
				lowLimit[i]= ll;
			}
		}
		numOfChromosomes = n;
		
	}
}
