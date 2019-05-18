package Tree;

import java.util.*;

public class Nodo {
	private HashMap<String, String> stringhe = new HashMap<String, String>();
	private HashMap<String, Double> interi = new HashMap<String, Double>();
	private static int numeroDouble = 0;
	private static int numeroStringe = 0;

	public Nodo(int attributiDouble, int attributiStringhe) {
		this.numeroDouble = attributiDouble;
		this.numeroStringe = attributiStringhe;
	}
	
	public Nodo() {
		
	}
}
