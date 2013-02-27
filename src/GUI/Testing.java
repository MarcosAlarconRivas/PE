package GUI;

import DoubleValue.BitVector;

public class Testnig {

	public static void main(String[] args) {
		System.out.println("Project runing");
		System.out.println("");
		/* RUNS
		  for(int i=0; i<256; i++){
			byte b = BitVector.unsignedToByte(i);
			int j = BitVector.byteToUnsigned(b);
			System.out.println(i+"="+j+"="+BitVector.byteToHex(b));
		}*/
		
		/* ????
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
		for (int i=0; i<1025; i++){
			System.out.print(i+"=");
			BitVector bv =new BitVector(i);
			System.out.print(bv.toUnsigned()+"="+bv);
			System.out.println(": length= "+bv.length());
		}
		*/
		/* RUNS
		for(int i=1024; i<4096; i++){
			  BitVector bv = new BitVector(i);
			  System.out.println(bv.toString()+"="+Integer.toHexString(i));
		}*/
		
		/*RUNS
		BitVector bv = new BitVector(BitVector.ALL_1, 32);
		System.out.println(bv.toBinaryString()+"="+bv+"="+bv.toUnsigned());
		for (int i=0; i<bv.length();i++){
			bv.set(i,false);
			System.out.println(bv.toBinaryString()+"="+bv+"="+bv.toUnsigned());
			bv.set(i,true);
		}
		*/
		
		/*RUNS
		BitVector bv = new BitVector(BitVector.ALL_1, 32);
		BitVector bv1 = new BitVector(BitVector.RANDOM, 32);
		for(int i=0; i<bv1.length();i++)
			bv1.set(i, true);
		System.out.print("\n"+bv1.toBinaryString());
		System.out.print("  "+bv1.toUnsigned());
		System.out.println(bv1);
		System.out.print("\n"+bv.toBinaryString());
		System.out.print("  "+bv.toUnsigned());
		System.out.println(bv);
		*/
		
		/*RUNS
		  for (int i=0; i<1025; i++){
			  BitVector bv = new BitVector(i);
			  boolean bit_changed = bv.get(bv.length()-1);
			  bv.set(bv.length()-1, true);
	
				bv.set(bv.length()-1, bit_changed);
				System.out.print(i+"="+bv);
				System.out.print("="  +bv.toBinaryString());
				
				bv.set(bv.length()-1, true);
				System.out.print("<=>"+bv.toBinaryString());
				System.out.print("="+bv);
				System.out.print("="+bv.toUnsigned()+'\n');
		}*/
		
		
	}
}
