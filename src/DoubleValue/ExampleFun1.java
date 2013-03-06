package DoubleValue;

public class ExampleFun1 extends DoubleFunction{
	
	protected static double lowLimit[]= {-1};
	protected static double highLimit[]={ 5};
	
	public String toString(){
		return "2·e^x -3·pi·x² +12/x";
	}

	@Override
	protected double fitnessFun(double[] fenotypes) {
		double f = fenotypes[0];
		return 2*Math.E*f-3*Math.PI*f*f+12/f;
	}


}
