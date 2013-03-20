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
		double r1 = Math.exp(-0.2*Math.abs(x));
		double r2 = Math.exp( Math.cos(2*Math.PI*x));
		System.out.println(x+"->"+r1+" "+r2);//XXX
		return 20+ -20*Math.E*r1  -r2;
	}
}
