package p1;

public class Function3 extends DoubleFunction{
	
	protected static double lowLimit[]= {-250};
	protected static double highLimit[]={250};
	
	public String toString(){
		return "f(x) = -|x*sen(sqrt(|x|))|";
	}

	@Override
	protected double fitnessFun(double[] fenotypes) {
		double f = fenotypes[0];
		double r1 = f*Math.sin(Math.sqrt(Math.abs(f)));
		return -(Math.abs(r1));
	}
}
