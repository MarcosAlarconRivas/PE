package DoubleValue;

/**
 * Genotype for DoubleValues.
 * It works as a bit[], but is implemented with a byte[] (for efficiency).
 */
public class BitVector {
	public enum InitType {ALL0, ALL1, RANDOM}

	private byte[] g;
	private long length;
	private DoubleValue owner;
	

	public BitVector(DoubleFunction fitness) {
		new BitVector(InitType.RANDOM, fitness.precision);
	}

	public BitVector(InitType t, long length) {
		this.length = length;
		int bytes = (int)(length/8 +length%8);
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
				g[i] =  (byte)(Byte.MIN_VALUE + Math.random()*Byte.MAX_VALUE);
				//FIXME prove this random generation
				break;
			}
			//TODO generate last byte
		}
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

	public boolean get(long position) {
		if(position<0||position>length)return false;
		return getBit(g[(int) (position/8)], position%8);
	}

	private boolean getBit(byte b, long numOfBit) {
		// TODO Auto-generated method stub
		return false;
	}

	public void set(int position, boolean value) {
		if(position>=0&&position<length){
			byte oldValue = g[(int)position/8];
			g[(int)position/8]= setBit(oldValue, position%8, value);
		}
	}

	private byte setBit(byte oldValue, int i, boolean value) {
		// TODO Auto-generated method stub
		return 0;
	}
/**
	public double getFenotipo(double tolerancia, double xMin, double xMax) {
		long dec = binToDec();
		Double fenotipo = xMin + dec * (xMax - xMin) ;// / numMax;
		if (fenotipo < xMin || fenotipo > xMax) {
			System.err.println("Fenotipo " + fenotipo + " fuera de rango");
		}
		return fenotipo;
	}

	private long binToDec() {
		long pot = 1;
		long result = 0;
		for (int i = 0; i < g.length; i++) {
			if (g[i])
				result += pot;
			pot *= 2;
		}
		return result;
	}

	public int getFen() {
		int fen = 0;
		for (int i = 0, m = 1; i < g.length; i++, m *= 2)
			if (g[i])
				fen += m;
		return fen;
	}

	public static BitVector[] cut(int[] cutPoint, BitVector gen) {
		BitVector[] slice = new BitVector[cutPoint.length + 1];
		slice[0] = new BitVector(cutPoint[0], 0, gen);
		for (int i = 1; i < cutPoint.length - 1; i++)
			slice[i] = new BitVector(cutPoint[i + 1] - cutPoint[i],
					cutPoint[i], gen);
		slice[cutPoint.length] = new BitVector(gen.length()
				- cutPoint[cutPoint.length - 1],
				cutPoint[cutPoint.length - 1], gen);
		return slice;
	}

	public void muta(double prob) {
		for (int i = 0; i < g.length; i++)
			if (Math.random() <= prob) {
				g[i] = !g[i];
			}
	}
**/

}