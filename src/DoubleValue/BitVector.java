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

	BitVector(DoubleFunction fitness) {
		this(InitType.RANDOM, fitness.precision);
	}
	
	/**
	 * Creates a natural binary representation of the number.
	 */
	public BitVector(long unsigned){
		this(unsigned, minimalLength(unsigned));
	}
	
	private static int minimalLength(long unsigned){
		if(unsigned==0)return 1;
		int shift;
		for(shift=0; unsigned>= 0x1<<shift; shift++);
		return shift;
	}
	
	/**
	 * Creates a natural binary representation of the number,
	 * and saves it in a vector with given length.
	 */
	public BitVector(long unsigned, long length){
		this.length = length;
		if(unsigned<0){
			g = null;
		}else{
			g = new byte[(int) (length/8)+(length%8>0?1:0)];
			for(int i=0; i<g.length; i++){
				g[i]= unsignedToByte((int) (unsigned%256));
				unsigned /= 256;
			}
		}
		
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

	/*public BitVector(BitVector[] meiosis1, BitVector[] meiosis2) {
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
	public boolean get(long position) {//FIXME something is wrong
		if(position<0||position>=length)return false;
		return getBit(g[(int) (position/8)], position%8);
	}

	private static boolean getBit(byte b, long numOfBit) {
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
		return b+128;
	}
	
	public static byte unsignedToByte(int i){
		if(i<0||i>255) return 0;
		return (byte)(i-128);
	}
	
	public long toUnsigned(){
		long sum = 0;
		int b = g.length-1;;
		for(; b>-1; ){
			sum *= 256;
			sum += BitVector.byteToUnsigned(g[b--]);
		}
		return sum;
	}
	
	private static String byteToHex(byte b){
		int i = byteToUnsigned(b);
		String result = "";
		if(i<16) result += '0';
		result += Integer.toHexString(i);
		return result;
	}
	/**
	 * @returns Hexadecimal representation of the bit vector.
	 */
	public String toHexString(){
		String result = "";
		for(int i= g.length-1; i>=0; i--){
			result +=byteToHex(g[i]);
		}
		return result;
	}
	
	/**
	 * @returns Binary representation of the bit vector.
	 */
	public String toBinaryString(){
		String result = "";
		for(long i= length-1; i>=0; i--){
			result +=(get(i)?1:0);
		}
		return result;
	}
	
	public String toString(){
		return "["+toHexString()+"]";
	}


}