package utilities;

import java.util.Random;

/**
 * It works as a bit[], but is implemented with a byte[] (for efficiency).
 * It was created as implementation of DoubleValues genotype.
 */
public class BitVector {
	//Type used to initialize the vector with 0s, 1s or randomly 
	public enum InitType {ALL0, ALL1, RANDOM}
	public static final InitType ALL_0= InitType.ALL0;
	public static final InitType ALL_1= InitType.ALL1;
	public static final InitType RANDOM= InitType.RANDOM;

	//Real vector containing the info.
	protected byte[] g;

	//number of bits contained.
	protected long length;

	/**
	 * Creates a natural binary representation of the number.
	 */
	public BitVector(long unsigned){
		this(unsigned, minimalLength(unsigned));
	}

	public static int minimalLength(long unsigned){
		if(unsigned==0)return 1;
		int shift;
		for(shift=0; unsigned>= 0x1<<shift; shift++);
		return shift;
	}
	
	public long rage(){
		return rage(length);
	}
	
	public static long rage(long bits){
		return (0x1<<bits)-1;
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

	/**
	 * Obvious constructor.
	 */
	public BitVector(byte vect[]){
		g = vect;
		length = 8*vect.length;
	}

	/**
	 * Initialize as '@param t' a vector of '@param length' bits.
	 */
	public BitVector(InitType t, long length) {
		this.length = length;
		int residue = (int) (length%8);
		int bytes = (int)(length/8 +(residue>0?1:0));
		g = new byte[bytes];
		Random r = new Random();
		for (int i= 0; i< bytes; i++) {
			switch (t) {
			case ALL0:
				g[i] = unsignedToByte(0);
				break;
			case ALL1:
				g[i] = unsignedToByte(255);
				break;
			case RANDOM:
				g[i] = unsignedToByte(r.nextInt(256));//FIXME
				break;
			}
		}
		
		if(residue>0)
			g[bytes-1] &= ~(0xff<<residue);
			//delete possible bits in positions > length
	}

	/**
	 * @return number of bits contained.
	 */
	public long length(){
		return length;
	}

	/**
	 * Gets the bit[position]
	 * @return the specified bit value as a boolean.
	 */
	public boolean get(long position) {
		if(position<0||position>=length)return false;
		return (g[(int) (position/8)] & (0x1<<position%8)) !=0;
	}

	/**
	 * Sets the bit[position]= (boolean)value
	 */
	public void set(long position, boolean value) {
		if(position<0 || position>=length) return;

		byte oldValue = g[(int)position/8];
		g[(int)position/8] = setBit(oldValue, (int)position%8, value);
	}

	private byte setBit(byte oldValue, int position, boolean value) {
		if(position>7||position<0) return oldValue;

		if(value) return (byte) (oldValue | 0x1<<position);

		return (byte) (oldValue & ~(0x1<<position));
	}
	
	/**
	 * Switches the specified bit:
	 *  bit[position]= !bit[position];
	 */
	public void xor(long position) {
		if(position<0 || position>=length) return;
		g[(int)position/8] ^= 0x1<<position%8;
	}

	/**
	 * Given a byte coded in natural binary returns its value.
	 */
	public static int byteToUnsigned(byte b){
		return (b+128)^0x1<<7;
	}

	/**
	 * Given 0<=natural<=255 returns its codification in natural binary.
	 */
	public static byte unsignedToByte(int n){
		return (byte)((n-128)^0x1<<7);
	}

	/**
	 * @returns the value of the vector (as natural).
	 */
	public long toUnsigned(){
		long sum = 0;
		int b = g.length-1;
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
		if(length==0) return "";
		String result = Integer.toHexString(byteToUnsigned(g[g.length-1]));
		for(int i= g.length-2; i>=0; i--){
			result += byteToHex(g[i]);
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