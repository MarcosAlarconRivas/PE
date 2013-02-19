package GUI;

import DoubleValue.BitVector;

public class Testnig {

	public static void main(String[] args) {
		System.out.println("Project runing");
		for (int i=0; i<=255; i++){
			for(int j=0; j<=8; j++){
				byte b=BitVector.unsignedToByte(i);
				if((i%j!=0)!= BitVector.getBit(b, j))
					System.out.print(i+','+j+" fails"+'\n');
			}
		}

	}

}
