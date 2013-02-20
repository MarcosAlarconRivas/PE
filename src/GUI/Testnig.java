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
		int j=0;
		byte i = Byte.MIN_VALUE;
		for(; ; i++, j++){
			  System.out.println(j+"="+BitVector.byteToUnsigned(i));
			 if( i==Byte.MAX_VALUE) break;
		  }*/
		
		/* RUNS
		long lon=-1;
		for (long i=1; i<Long.MAX_VALUE; i*=2){
			BitVector bv = new BitVector(i);
			if(lon != bv.length()){
				lon = bv.length();
				System.out.print(i+"->");
				System.out.print(bv.length()+" bits->");
				System.out.println(bv.g.length+" bytes");
			}
				
		}*/
		
		/* RUNS
		for (int i=0; i<1024; i++){
			System.out.print(i+"=");
			System.out.println(new BitVector(i).toUnsigned());
		} */
		
		/* RUNS
		 for (int i=0; i<1024; i++){
			System.out.print(i+": ");
			System.out.println(new BitVector((long)i));
		}*/
		
		/* RUNS
		for(int i=1024; i<4096; i++){
			  BitVector bv = new BitVector(i);
			  System.out.println(bv.toString()+"="+Integer.toHexString(i));
		}*/

		  for (int i=0; i<256; i++){
				BitVector bv = new BitVector(i);
				System.out.print("= "+i);
				System.out.print("= "+bv.toBinaryString());
				System.out.print("= "+bv+'\n');
		}
		
	}
}
