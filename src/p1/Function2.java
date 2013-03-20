package p1;

public class Function2 extends DoubleFunction{
	
	public Function2(){
		lowLimit= new double[]{-3.0, 4.1};
		highLimit=new double[]{12.1, 5.8};
		numOfChromosomes = 2;
		genotypeBits = new int[2];
		genotypeBits[1]=genotypeBits[0];
	}
	
	public String toString(){
		return "f(x,y) = 21.5 + x*sen(4PI*x)+y*sen(20PI*y)";
	}

	@Override
	protected double evaluate(double[] fenotypes) {
		double x = fenotypes[0];
		double y = fenotypes[1];
		return 21.5 +x*Math.sin(5*Math.PI*x)+ y*Math.sin(20*Math.PI*y);
	}
}
