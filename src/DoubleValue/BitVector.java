package DoubleValue;

/**
 * Genotype for DoubleValues.
 * It works as a bit[], but is implemented with a byte[] (for efficiency).
 */
public class BitVector {
	public enum InitType {ALL0, ALL1, RANDOM}

	//Real vector containing the info.
	private byte[] g;
	
	//number of bits contained.
	private long length;

	public BitVector(DoubleFunction fitness) {
		new BitVector(InitType.RANDOM, fitness.precision);
	}

	public BitVector(byte vect[]){
		g = vect;
		length = 8*vect.length;
	}
	
	public BitVector(InitType t, long length) {
		this.length = length;
		int residue = (int) (length%8);
		int bytes = (int)(length/8 +(residue>0?1:0));
		g = new byte[bytes];
		for (int i= 0; i< bytes-1; i++) {
			switch (t) {
			case ALL0:
				g[i] = Byte.MIN_VALUE;
				break;
			case ALL1:
				g[i] =  Byte.MAX_VALUE;
				break;
			case RANDOM:
				g[i] =(byte)(Math.ceil(Math.random()*(Byte.MAX_VALUE-Byte.MIN_VALUE)));
				break;
			}
		}
		if(residue>0){
			g[bytes-1]=Byte.MIN_VALUE; 
			for(int i=0; i<residue; i++){
				g[bytes-1]=(byte) (2*g[bytes-1]+(Math.random()>0.5?1:0));
			}
		}
	}
	
	/**
	 * @return number of bits contained.
	 */
	public long length(){
		return length;
	}

	/**public BitVector(BitVector[] meiosis1, BitVector[] meiosis2) {
		// Genera un hijo a partir de los genes troceados de 2 padres
		g = new boolean[meiosis1[0].g.length + meiosis1[1].g.length
				* (meiosis1.length - 1)];
		BitVector[][] padres = new BitVector[2][];
		padres[0] = meiosis1;
		padres[1] = meiosis2;
		for (int i = 0, k = 0; i < meiosis1.length; i++)
			for (int j = 0; j < padres[i % 2][i].g.length; j++, k++)
				g[k] = padres[i % 2][i].g[j];
		//numMax = (long) (Math.pow(2, g.length) - 1);
	}*/
	
	/**
	 * gets the bit[position]
	 * @return the specified bit value as a boolean.
	 */
	public boolean get(long position) {
		if(position<0||position>length)return false;
		return getBit(g[(int) (position/8)], position%8);
	}

	public static boolean getBit(byte b, long numOfBit) {
		return (b%(0x1<<numOfBit) !=0 );
	}

	/**
	 * sets the bit[position]= (boolean)value
	 */
	public void set(int position, boolean value) {
		if(position<0 || position>=length) return;
		
		byte oldValue = g[(int)position/8];
		g[(int)position/8]= setBit(oldValue, position%8, value);
	}

	private byte setBit(byte oldValue, int position, boolean value) {
		if(position>7||position<0) return oldValue;
		
		if(value) return (byte) (oldValue | 0x1<<position);
		
		return (byte) (oldValue & 0x1<<position);
	}
	
	public static int byteToUnsigned(byte b){
		if(b>=0) return (int)b;
		return (int)b+256;
	}
	
	public static byte unsignedToByte(int i){
		if(i<0||i>255) return 0;
		if(i>127) return (byte)(i-256);
		return (byte)i;
	}
	
	private static char halfByteToHex(int num){
		if(num<10)return (char) ('0'+num);//FIXME
		switch(num){
			case 10: return 'A';
			case 11: return 'B';
			case 12: return 'C';
			case 13: return 'D';
			case 14: return 'E';
			case 15: return 'F';
			default: return '?';
		}
	}
	
	public static String byteToHex(byte b){
		int natVal = byteToUnsigned(b);
		char ff[] = {halfByteToHex(natVal/256), halfByteToHex(natVal%256)};
		return String.valueOf(ff);
	}
	
	/**
	 * @returns Hexadecimal representation of the bit vector.
	 */
	public String toString(){
		String result = "";
		for(int i=g.length-1; i>=0; i--){
			result+=byteToHex(g[i]);
		}
		return result;
	}


}