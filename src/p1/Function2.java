package p1;

public class Function2 extends DoubleFunction{
	
	public Function2(){
		lowLimit= new double[]{-3.0, 4.1};
		highLimit=new double[]{12.1, 5.8};
		numOfChromosomes = 2;
	}
	
	public String toString(){
		return "f(x,y) = 21.5 + x*sen(4PI*x)+y*sen(20PI*y)";
	}

	@Override
	protected double evaluate(double[] fenotypes) {
		double f1 = fenotypes[0];
		double f2 = fenotypes[1];
		return 21.5+f1*Math.sin(5*Math.PI*f1)+f2*Math.sin(20*Math.PI*f2);
	}
}