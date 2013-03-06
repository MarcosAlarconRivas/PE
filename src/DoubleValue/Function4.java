package DoubleValue;

public class Function4 extends DoubleFunction{
	
	protected static double lowLimit[]= {0};
	protected static double highLimit[]={100};
	protected static int n = 1;
	protected static int numOfChromosomes = n;
	
	public String toString(){
		return "f(xi, i=1..n) = sum(i=1..n)[(-x*sen(sqrt(|xi|)))]";
	}

	@Override
	protected double fitnessFun(double[] fenotypes) {
		double res = 0;
		for (int i=1; i<=n; i++){
			double f = fenotypes[i];
			double r = -(f*Math.sin(Math.sqrt(Math.abs(f))));
			res += r;
		}
		return res;
	}
		
	public static void setN(int _n){
		n = _n;
	}
}
