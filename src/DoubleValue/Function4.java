package DoubleValue;

public class Function4 extends DoubleFunction{
	
	protected static double lowLimit[]= {0};
	protected static double highLimit[]={100};
	protected static int n = 1;
	
	public String toString(){
		return "f(xi, i=1..n) = sum(-x*sen(sqrt(|xi|)))";
	}

	@Override
	protected double fitnessFun(double[] fenotypes) {
		double f = fenotypes[0];
		res = 0;
		for (int i=1; i<=n; i++){
			double r1 = f*Math.sin(Math.sqrt(Math.abs(f)));
			double r = -(Math.abs(r1));
			res += r;
		}
		return res;
	}
		
	public static void setN(int _n){
		n = _n;
	}
}
