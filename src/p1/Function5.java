package p1;

public class Function5 extends DoubleFunction{

	public Function5(){
		lowLimit= new double[]{-10, -10};
		highLimit=new double[]{ 10, 10};
		numOfChromosomes = 2;
		genotypeBits= new int[]{4, 4};
		maximization= false;
	}
	
	public String toString(){
		return "f(xi, i=1..2) = sum(i=1..5)[(i*cos((i+1)*x1+i))]*sum(i=1..5)[(i*cos((i+1)*x2+i))]";
	}

	@Override
	protected double evaluate(double[] fenotypes) {
		double sum1 = 0;
		double sum2 = 0;
		
		double x = fenotypes[0];
		double y = fenotypes[1];
		
		for (int i=1; i<=5; i++){
			sum1 += i*Math.cos((i+1)*x+i);
			sum2 += i*Math.cos((i+1)*y+i);
		}
		
		return sum1*sum2;
	}
	
}
