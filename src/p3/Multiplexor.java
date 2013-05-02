package p3;

import ga.Individual;
/**
 * Individual representing a Sudoku
 * Negative values represents input data (positions that can't change).
 */
public class Multiplexor extends Individual {
	
	//data for initalition of the new individuals
	protected static int A0,A1,D0,D1,D2,D3;
	
	static Tree arbol; // estrategia de rastreo
	static double adaptacion;// función de evaluación
	static double puntuacion;//puntuacion relativa:adaptación/sumadaptacion
	static double punt_acu; // puntuacion acumulada
	static boolean elite; // elitismo 

	public Multiplexor(Tree arbol, double adaptacion, double puntuacion,
			double punt_acu, boolean elite) {
		this();
	}
	
	public Multiplexor() {
		arbol=new Tree();
		adaptacion=0; puntuacion=0; punt_acu=0; elite=false;
	}

	@Override
	public Individual clone() {
		Multiplexor copy = new Multiplexor(arbol,adaptacion,puntuacion,punt_acu,elite);
		return copy;
	}
	
}
