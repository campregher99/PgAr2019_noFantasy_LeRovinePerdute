package Grafo;

import java.util.ArrayList;

public class Dijkstra {
	ArrayList<Integer> nodi = new ArrayList<Integer>();
	ArrayList<Double> distanza0 = new ArrayList<Double>();
	ArrayList<Integer> precedente = new ArrayList<Integer>();
	ArrayList<Integer> idNodi = new ArrayList<Integer>();

	public void addNodo(Nodo nodo) {
		nodi.add(nodo.getId());
		idNodi.add(nodo.getId());
	}

	public void addNodo(int idNodo) {
		nodi.add(idNodo);
		idNodi.add(idNodo);
	}

	public void addDistanzaO(Double distanza) {
		distanza0.add(distanza);
	}

	public void addPrecedente(Nodo nodo) {
		precedente.add(nodo.getId());
	}

	public void addPrecedente(Integer idNodo) {
		precedente.add(idNodo);
	}

	public void setDistanzaO(Nodo nodo, Double newDistanza) {
		distanza0.set(idNodi.indexOf(nodo.getId()), 0.0);
	}

	public void setDistanzaO(Integer idNodo, Double newDistanza) {
		distanza0.set(idNodi.indexOf(idNodo), 0.0);
	}

	public void setPrecedente(Nodo nodo, Nodo precedente) {
		this.precedente.set(idNodi.indexOf(nodo.getId()), precedente.getId());
	}

	public void setPrecedente(Integer idNodo, Nodo precedente) {
		this.precedente.set(idNodi.indexOf(idNodo), precedente.getId());
	}

	public void setPrecedente(Integer idNodo, Integer idPrecedente) {
		this.precedente.set(idNodi.indexOf(idNodo), idPrecedente);
	}

	public void setPrecedente(Nodo nodo, Integer idPrecedente) {
		this.precedente.set(idNodi.indexOf(nodo.getId()), idPrecedente);
	}

	public int getNodoMinValore(Integer nodoPartenza) {
		for (Integer nodo : idNodi) {
			if (distanza0.get(nodi.indexOf(idNodi.get(nodoPartenza))) > distanza0.get(nodi.indexOf(nodo))) {
				return nodi.indexOf(nodo);
			}
		}
		return (Integer) null;
	}
}
