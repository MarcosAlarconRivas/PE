package p1;

public class Function3 extends DoubleFunction{
	
	public Function3(){
		lowLimit = new double[]{-250};
		highLimit = new double[]{250};
		maximization= false;
	}
	
	public String toString(){
		return "f(x) = -|x*sen(sqrt(|x|))|";
	}

	@Override
	protected double evaluate(double[] fenotypes) {
		double f = fenotypes[0];
		double r1 = f*Math.sin(Math.sqrt(Math.abs(f)));
		return -(Math.abs(r1));
	}
}
