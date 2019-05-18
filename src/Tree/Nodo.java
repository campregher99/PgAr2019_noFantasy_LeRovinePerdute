package Tree;

import java.util.*;

public class Nodo {
	private HashMap<String, String> stringhe = new HashMap<String, String>();
	private HashMap<String, Double> doppio = new HashMap<String, Double>();
	private static int numeroDoppio = 0;
	private static int numeroStringe = 0;
	private ArrayList<Nodo> figli = new ArrayList<Nodo>();

	public Nodo(int attributiDouble, int attributiStringhe) {
		this.numeroDoppio = attributiDouble;
		this.numeroStringe = attributiStringhe;
	}

	public Nodo() {

	}
}
