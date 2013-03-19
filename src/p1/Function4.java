package p1;

public class Function4 extends DoubleFunction{
	
	protected static int n = 1;
	
	public Function4(){
		lowLimit= new double[]{0};
		highLimit=new double[]{100};
		numOfChromosomes = 1;
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
		
	public static void setN(int _n){
		n = _n;
	}
}
