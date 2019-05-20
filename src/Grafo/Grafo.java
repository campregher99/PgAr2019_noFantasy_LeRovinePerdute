package Grafo;

import java.util.*;

public class Grafo {
	private ArrayList<String> keyStringhe = new ArrayList<String>();
	private ArrayList<String> keyDoppio = new ArrayList<String>();
	private ArrayList<String> keyBooleani = new ArrayList<String>();
	private ArrayList<Nodo> nodi = new ArrayList<Nodo>();
	private ArrayList<Double> archi = new ArrayList<Double>();

	public Grafo() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Integer> getArchi() {
		return archi;
	}

	public Integer getArco(int i) {
		return archi.get(i);
	}

	public ArrayList<Nodo> getNodi() {
		return nodi;
	}

	public Nodo getNodo(int i) {
		return nodi.get(i);
	}

	public Nodo getNodo(String attributo, String valore) {
		return " ";
	}

	public Nodo getNodo(String attributo, Double valore) {
		return " ";
	}

	public Nodo getNodo(String attributo, Boolean valore) {
		return " ";
	}

	public void aggiungiArco(Nodo nodo1, Nodo nodo2, Double valore) {

	}

	public boolean aggiungiNodo(ArrayList<String> stringhe, ArrayList<Double> doppio, ArrayList<Boolean> booleani) {
		return false;
	}

	public void removeArco(int i) {

	}

	public void removeNodo(int i) {

	}

	public void removeNodo(String attributo, String valore) {

	}
}
