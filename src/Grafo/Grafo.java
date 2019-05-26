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
		for (Entry<Integer, Integer> idArco : getNodo(nodo).getUscite().entrySet()) {
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

	public Dijkstra dijkstra(Integer idNodoP, Integer idNodoA) {
		Dijkstra dk = new Dijkstra();
		for (int i = 0; i < this.nodi.size(); i++) {
			dk.addNodo(this.nodi.get(i));
		}
		for (int i = 0; i < nodi.size(); i++) {
			dk.addDistanzaO(Double.POSITIVE_INFINITY);
			dk.addPrecedente(-1);
		}

		dk.setDistanzaO(idNodoP, 0.0);
		dk.setPrecedente(idNodoP, idNodoP);

		while (dk.getIdNodiSize() != 0) {
			int nodoT = dk.getNodoMinValore();

			for (Entry<Integer, Integer> key : vuoto.getNodoPerID(nodoT,this.nodi).getUscite().entrySet()) {
				for (Integer nodo : dk.getIdNodi()) {
					if (nodo == key.getKey()) {
						if (dk.getDistanza(nodoT) + archi.get(vuoto.getNodoPerID(nodoT,nodi).getUscite().get(key.getKey())) < dk
								.getDistanza(nodo)) {
							dk.setDistanzaO(dk.getIndiceNodo(nodo),
									(dk.getDistanza(nodoT) + archi.get(vuoto.getNodoPerID(nodoT,nodi).getUscite().get(key.getKey()))));
							dk.setPrecedente(dk.getIndiceNodo(nodo), nodoT);
							
						}
					}
				}

			}

			// ATTENZIONE
			// ATTENZIONE
			dk.removeNodo(nodoT);

		}
		
		dk.calcoloPercorso(idNodoP, idNodoA, this.nodi);
		return dk;

	}

	
}
