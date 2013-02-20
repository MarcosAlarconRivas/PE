package GUI;

import DoubleValue.BitVector;

public class Testnig {

	public static void main(String[] args) {
		System.out.println("Project runing");
		/* RUNS
		  for(int i=0; i<256; i++){
			byte b = BitVector.unsignedToByte(i);
			int j = BitVector.byteToUnsigned(b);
			System.out.println(i+"="+j+"="+BitVector.byteToHex(b));
		}*/
		/* RUNS
		 for (int i=0; i<256; i++){
			for (int j=0; j<256; j++){
				byte b[] = {BitVector.unsignedToByte(j), BitVector.unsignedToByte(i)};
			System.out.print(i+","+j+": ");
			System.out.println(new BitVector(b));
			}
		}*/
		  for (int i=0; i<256; i++){

				byte b[]= {BitVector.unsignedToByte(i)};
				BitVector bv = new BitVector(b);
				System.out.print("= "+i);
				System.out.print("= "+bv.toBinary());
				System.out.print("= "+bv+'\n');
		}
		
	}
}
