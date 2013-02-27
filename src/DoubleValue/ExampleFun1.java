package DoubleValue;

public class ExampleFun1 extends DoubleFunction{
	
	public String toString(){
		return "2·e^x -3·pi·x² +12/x";
	}

	@Override
	protected double fitnessFun(double[] fenotypes) {
		double f = fenotypes[0];
		return 2*Math.E*f-3*Math.PI*f*f+12/f;
	}


}
