package Grafo;

import java.util.ArrayList;

public class Dijkstra {
	private ArrayList<Integer> nodi = new ArrayList<Integer>();
	private ArrayList<Double> distanza0 = new ArrayList<Double>();
	private ArrayList<Integer> precedente = new ArrayList<Integer>();
	private ArrayList<Integer> idNodi = new ArrayList<Integer>();
	private ArrayList<Nodo> percorso = new ArrayList<Nodo>();
	private double distanzaMinima;
	private Nodo vuoto = new Nodo();

// GET
	public int getIdNodiSize() {
		return idNodi.size();
	}

	public int getNodoMinValore() {
		if (idNodi.size() != 0) {
			Integer nodoMin = idNodi.get(0);
			for (Integer nodo : idNodi) {
				if (getPrecedente(nodo) != -1) {
					if (distanza0.get(nodi.indexOf(nodoMin)) > distanza0.get(nodi.indexOf(nodo))) {
						nodoMin = nodo;
					}
				}
				
			}
			return nodoMin;
		}
		return (Integer) null;
	}

	public int getIndiceNodo(Integer idNodo) {
		return nodi.indexOf(idNodo);
	}

	public int getIndiceNodo(Nodo nodo) {
		return nodi.indexOf(nodo.getId());
	}

	public Double getDistanza(Nodo nodo) {
		return distanza0.get(nodi.indexOf(nodo.getId()));
	}

	public Double getDistanza(Integer idNodo) {
		return distanza0.get(nodi.indexOf(idNodo));
	}

	public int getNodoId(int i) {
		return idNodi.get(i);
	}

	public ArrayList<Integer> getIdNodi() {
		return idNodi;
	}

	public ArrayList<Integer> getNodi() {
		return nodi;
	}

	public int getPrecedente(Integer idNodo) {
		return precedente.get(nodi.indexOf(idNodo));
	}

	public int getPrecedente(Nodo nodo) {
		return precedente.get(nodi.indexOf(nodo.getId()));
	}

	public ArrayList<Nodo> getPercorso() {
		return percorso;
	}

	public double getDistanzaMinima() {
		return distanzaMinima;
	}

	// ADD
	public void addNodoPercorso(Nodo nodo) {
		percorso.add(nodo);
	}

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

	// SET
	public void setDistanzaO(Nodo nodo, Double newDistanza) {
		distanza0.set(idNodi.indexOf(nodo.getId()), newDistanza);
	}

	public void setDistanzaO(Integer idNodo, Double newDistanza) {
		distanza0.set(idNodo, newDistanza);
	}

	public void setPrecedente(Nodo nodo, Nodo precedente) {
		this.precedente.set(idNodi.indexOf(nodo.getId()), precedente.getId());
	}

	public void setPrecedente(Integer idNodo, Nodo precedente) {
		this.precedente.set(idNodi.indexOf(idNodo), precedente.getId());
	}

	public void setPrecedente(Integer idNodo, Integer idPrecedente) {
		this.precedente.set(idNodo, idPrecedente);
	}

	public void setPrecedente(Nodo nodo, Integer idPrecedente) {
		this.precedente.set(idNodi.indexOf(nodo.getId()), idPrecedente);
	}

	// REMOVE
	public void removeNodo(Nodo nodo) {
		idNodi.remove(nodo.getId());
	}

	public void removeNodo(Integer idNodo) {
		idNodi.remove(idNodo);
	}

	// ALTRO
	public void calcoloPercorso(Integer idNodoP, Integer idNodoA, ArrayList<Nodo> nodi) {
		int nodoAtt = idNodoA;
		percorso.add(vuoto.getNodoPerID(nodoAtt, nodi));
		while (percorso.get(percorso.size() - 1).getId() != idNodoP) {
			for (Integer nodo : getNodi()) {
				if (nodo == nodoAtt) {
					nodoAtt = getPrecedente(nodo);
					percorso.add(vuoto.getNodoPerID(nodoAtt, nodi));
					break;
				}
			}
		}

		ArrayList<Nodo> app = new ArrayList<Nodo>();
		for (int i = percorso.size() - 1; i >= 0; i--) {
			app.add(percorso.get(i));
		}
		percorso = app;
		distanzaMinima = distanza0.get(this.nodi.indexOf(idNodoA));
	}

}
