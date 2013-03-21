package p1;

public class Function1 extends DoubleFunction{
	
	public Function1(){
		lowLimit= new double[]{0};
		highLimit= new double[]{32};;
	}

	public String toString(){
		return "f(x) = 20 + e -20e^(-0,2|x|) -e ^(cos(2*PI*x))";
	}

	@Override
	protected double evaluate(double[] fenotypes) {
		double x = fenotypes[0];
		double r1 = -0.2*Math.abs(x);
		double r2 = Math.cos(2*Math.PI*x);
		return 20+ Math.E-20* Math.exp(r1)  -Math.exp(r2);
	}
}
