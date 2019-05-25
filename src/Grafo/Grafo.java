package Grafo;

import java.util.*;
import java.util.Map.Entry;

public class Grafo {
	private ArrayList<String> keyStringhe = new ArrayList<String>();
	private ArrayList<String> keyDoppio = new ArrayList<String>();
	private ArrayList<String> keyBooleani = new ArrayList<String>();
	private ArrayList<Nodo> nodi = new ArrayList<Nodo>();
	private HashMap<Integer, Double> archi = new HashMap<Integer, Double>();
	private static int indiciArchi = 0;
	private Nodo vuoto = new Nodo();

	public Grafo(ArrayList<String> keyStringhe, ArrayList<String> keyDoppio, ArrayList<String> keyBooleani) {
		this.keyStringhe = keyStringhe;
		this.keyDoppio = keyDoppio;
		this.keyBooleani = keyBooleani;
	}

	public ArrayList<String> getKeyStringhe() {
		return keyStringhe;
	}

	public ArrayList<String> getKeyDoppio() {
		return keyDoppio;
	}

	public ArrayList<String> getKeyBooleani() {
		return keyBooleani;
	}

	public Nodo getVuoto() {
		return vuoto;
	}

	public HashMap<Integer, Double> getArchi() {
		return archi;
	}

	public Double getArco(int i) {
		return archi.get(i);
	}

	public ArrayList<Integer> getArchi(Nodo nodo) {
		ArrayList<Integer> indiciArchi = new ArrayList<Integer>();
		for(Entry<Integer, Integer> idArco:getNodo(nodo).getUscite().entrySet()) {
			indiciArchi.add(idArco.getKey());
		}
		return indiciArchi;
	}
	
	public ArrayList<Nodo> getNodi() {
		return nodi;
	}

	public Nodo getNodo(int i) {
		try {
			return nodi.get(i);
		} catch (Exception e) {
			return vuoto;
		}
	}

	public Nodo getNodo(Nodo nodo) {
		try {
			return nodi.get(nodi.indexOf(nodo));
		} catch (Exception e) {
			return vuoto;
		}
	}

	public Nodo getNodo(String attributo, String valore) {
		for (int i = 0; i < nodi.size(); i++) {
			for (Map.Entry<String, String> key : nodi.get(i).getStringhe().entrySet()) {
				if (key.getKey().equals(attributo)) {
					if (nodi.get(i).getStringhe(attributo).equals(valore)) {
						return nodi.get(i);
					}
				}
			}
		}
		return vuoto;
	}

	public Nodo getNodo(String attributo, Double valore) {
		for (int i = 0; i < nodi.size(); i++) {
			for (Entry<String, Double> key : nodi.get(i).getDoppio().entrySet()) {
				if (key.getKey().equals(attributo)) {
					if (nodi.get(i).getDoppio(attributo).equals(valore)) {
						return nodi.get(i);
					}
				}
			}
		}
		return vuoto;
	}

	public Nodo getNodo(String attributo, Boolean valore) {
		for (int i = 0; i < nodi.size(); i++) {
			for (Entry<String, Boolean> key : nodi.get(i).getBooleani().entrySet()) {
				if (key.getKey().equals(attributo)) {
					if (nodi.get(i).getBooleani(attributo).equals(valore)) {
						return nodi.get(i);
					}
				}
			}
		}
		return vuoto;
	}

	public boolean aggiungiArco(Nodo nodo1, Nodo nodo2, Double valore) {
		boolean isFind1 = false;
		boolean isFind2 = false;
		for (int i = 0; i < nodi.size(); i++) {
			if (nodo1.getId() == nodi.get(i).getId()) {
				isFind1 = true;
			}
			if (nodo2.getId() == nodi.get(i).getId() && isFind1) {
				isFind2 = true;
			}
		}
		if (!isFind2) {
			return false;
		}
		archi.put(indiciArchi, valore);
		nodo1.addUscita(nodo2.getId(), indiciArchi);
		nodo2.addEntrate(nodo1.getId(), indiciArchi);
		indiciArchi++;
		return true;
	}

	public void aggiungiNodo(HashMap<String, String> stringhe, HashMap<String, Double> doppio,
			HashMap<String, Boolean> booleani) {
		Nodo newNodo = new Nodo(stringhe, doppio, booleani);
		nodi.add(newNodo);
	}

	public boolean removeArco(int indice) {
		try {
			getArco(indice);
		} catch (Exception e) {
			return false;
		}
		for (int i = 0; i < nodi.size(); i++) {
			for (Entry<Integer, Integer> key : nodi.get(i).getUscite().entrySet()) {
				if (nodi.get(i).getUscite(key.getKey()) == indice) {
					nodi.get(i).getUscite().remove(key.getKey());
				}
			}
			for (Entry<Integer, Integer> key : nodi.get(i).getEntrate().entrySet()) {
				if (nodi.get(i).getEntrate(key.getKey()) == indice) {
					nodi.get(i).getEntrate().remove(key.getKey());
				}
			}
		}
		archi.remove(indice);
		return true;
	}

	public boolean removeNodo(int i) {
		if (i < 0 && i > nodi.size()) {
			return false;
		}
		for (Entry<Integer, Integer> key : nodi.get(i).getUscite().entrySet()) {
			removeArco(key.getKey());
		}
		nodi.remove(i);
		return true;
	}

	public boolean removeNodo(Nodo nodo) {
		try {
			nodi.get(nodi.indexOf(nodo));
		} catch (Exception e) {
			return false;
		}
		for (Entry<Integer, Integer> key : nodi.get(nodi.indexOf(nodo)).getUscite().entrySet()) {
			for (int j = 0; j < nodi.size(); j++) {
				if (nodi.get(j).getId() == key.getKey()) {
					for (Entry<Integer, Integer> key2 : nodi.get(j).getEntrate().entrySet()) {
						if (nodi.get(j).getEntrate(key2.getKey()) == nodi.get(nodi.indexOf(nodo)).getId()) {
							removeArco(key2.getKey());
							nodi.get(j).getEntrate().remove(key2.getKey());
						}
					}
				}
			}
		}
		for (Entry<Integer, Integer> key : nodi.get(nodi.indexOf(nodo)).getEntrate().entrySet()) {
			for (int j = 0; j < nodi.size(); j++) {
				if (nodi.get(j).getId() == key.getKey()) {
					for (Entry<Integer, Integer> key2 : nodi.get(j).getUscite().entrySet()) {
						if (nodi.get(j).getUscite(key2.getKey()) == nodi.get(nodi.indexOf(nodo)).getId()) {
							nodi.get(j).getUscite().remove(key2.getKey());
						}
					}
				}
			}
		}

		nodi.remove(nodo);
		return true;
	}

	public boolean removeNodo(String attributo, String valore) {
		if (!getNodo(attributo, valore).getIsVuoto()) {
			if (removeNodo(getNodo(attributo, valore))) {
				return true;
			}
		}
		return false;
	}

	public boolean removeNodo(String attributo, Double valore) {
		if (!getNodo(attributo, valore).getIsVuoto()) {
			if (removeNodo(getNodo(attributo, valore))) {
				return true;
			}
		}
		return false;
	}

	public boolean removeNodo(String attributo, Boolean valore) {
		if (!getNodo(attributo, valore).getIsVuoto()) {
			if (removeNodo(getNodo(attributo, valore))) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Nodo> dijkstra(Integer idNodoP, Integer idNodoA) {
		ArrayList<Integer> idNodi = new ArrayList<Integer>();
		for (int i = 0; i < this.nodi.size(); i++) {
			idNodi.add(this.nodi.get(i).getId());
		}
		ArrayList<Integer> nodi = new ArrayList<Integer>();
		ArrayList<Double> distanza0 = new ArrayList<Double>();
		ArrayList<Integer> precedente = new ArrayList<Integer>();
		nodi = idNodi;
		for (int i = 0; i < nodi.size(); i++) {
			distanza0.add(Double.POSITIVE_INFINITY);
			precedente.add(-1);
		}

		distanza0.set(idNodi.indexOf(idNodoP), 0.0);
		precedente.set(idNodi.indexOf(idNodoP), nodi.get(idNodi.indexOf(idNodoP)));

		while (idNodi.size() != 0) {
			int nodoT = 0;
			for (int i = 0; i < idNodi.size(); i++) {
				if (distanza0.get(nodi.indexOf(idNodi.get(nodoT))) > distanza0.get(nodi.indexOf(idNodi.get(i)))) {
					nodoT = nodi.indexOf(idNodi.get(i));
				}
			}

			for (Entry<Integer, Integer> key : getNodoPerID(idNodi.get(nodoT)).getUscite().entrySet()) {
				for (Integer nodo : idNodi) {
					if (nodo == key.getValue()) {
						if (distanza0.get(nodi.get(nodoT))
								+ archi.get(getNodoPerID(idNodi.get(nodoT)).getUscite().get(nodo)) < distanza0
										.get(nodi.indexOf(nodo))) {
							distanza0.set(nodi.indexOf(nodo), (distanza0.get(nodi.get(nodoT))
									+ archi.get(getNodoPerID(idNodi.get(nodoT)).getUscite().get(nodo))));
							precedente.set(nodi.indexOf(nodo), nodoT);
						}
					}
				}

			}

			
			// ATTENZIONE
			// ATTENZIONE
			idNodi.remove(nodoT);
			

		}
		ArrayList<Nodo> percorso = new ArrayList<Nodo>();
		int nodoAtt = idNodoA;
		percorso.add(this.nodi.get(nodoAtt));
		while (percorso.get(percorso.size() - 1).getId() != idNodoP) {
			for (Integer nodo : nodi) {
				if (nodo == nodoAtt) {
					nodoAtt = precedente.get(nodi.indexOf(nodo));
					percorso.add(this.nodi.get(nodoAtt));
				}
			}
		}
		ArrayList<Nodo> app = new ArrayList<Nodo>();
		for (int i = percorso.size() - 1; i >= 0; i--) {
			app.add(percorso.get(i));
		}
		return app;

	}

	private Nodo getNodoPerID(int id) {
		for (int i = 0; i < nodi.size(); i++) {
			if (nodi.get(i).getId() == id) {
				return nodi.get(i);
			}
		}
		return null;
	}
}
