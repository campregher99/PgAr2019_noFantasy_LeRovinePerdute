package Grafo;

import java.util.*;
import java.util.Map.Entry;

public class Grafo {
	private ArrayList<String> keyStringhe = new ArrayList<String>();
	private ArrayList<String> keyDoppio = new ArrayList<String>();
	private ArrayList<String> keyBooleani = new ArrayList<String>();
	private ArrayList<Nodo> nodi = new ArrayList<Nodo>();
	private ArrayList<Double> archi = new ArrayList<Double>();
	private Nodo vuoto = new Nodo();

	public Grafo(ArrayList<String> keyStringhe, ArrayList<String> keyDoppio, ArrayList<String> keyBooleani) {
		this.keyStringhe = keyStringhe;
		this.keyDoppio = keyDoppio;
		this.keyBooleani = keyBooleani;
	}

	public Nodo getVuoto() {
		return vuoto;
	}

	public ArrayList<Double> getArchi() {
		return archi;
	}

	public Double getArco(int i) {
		return archi.get(i);
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
		for(int i=0; i<nodi.size();i++) {
			if(nodo1.getId()==nodi.get(i).getId()) {
				isFind1 = true;
			}
			if(nodo2.getId()==nodi.get(i).getId() && isFind1) {
				isFind2 = true;
			}
		}
		if(!isFind2) {
			return false;
		}
		archi.add(valore);
		nodo1.addUscita(nodo2.getId(), archi.size()-1);
		nodo2.addEntrate(nodo1.getId(), archi.size()-1);
		return true;
	}

	public void aggiungiNodo(HashMap<String, String> stringhe, HashMap<String, Double> doppio, HashMap<String, Boolean> booleani) {
		Nodo newNodo = new Nodo(stringhe, doppio, booleani);
		nodi.add(newNodo);
	}

	public boolean removeArco(int i) {
		try {
			archi.get(i);
		} catch (Exception e) {
			return true;
		}
		for (int j = 0; j < nodi.size(); j++) {
			for (Entry<Integer, Double> key : nodi.get(j).getUscite().entrySet()) {
				if (nodi.get(j).getUscite().get(key.getKey()) == archi.get(i)) {
					nodi.get(j).getUscite().remove(key.getKey());
				}
			}
			for (Entry<Integer, Double> key : nodi.get(j).getEntrate().entrySet()) {
				if (nodi.get(j).getEntrate().get(key.getKey()) == archi.get(i)) {
					nodi.get(j).getEntrate().remove(key.getKey());
				}
			}
		}
		// se rimuovo un nodo i sui archi devono rimanere all'interno dell'arreyList
		// altrimenti si sputtanano tutti gli altri quindi sarebbe meglio avere una
		// mappa per gli archi invece di una lista
		return true;
	}

	public boolean removeNodo(int i) {
		if (i < 0 && i > nodi.size()) {
			return false;
		}
		for (Entry<Integer, Double> key : nodi.get(i).getUscite().entrySet()) {
			for (int j = 0; j < nodi.size(); j++) {
				if (nodi.get(j).getId() == key.getKey()) {
					for (Entry<Integer, Double> key2 : nodi.get(j).getEntrate().entrySet()) {
						if (nodi.get(j).getEntrate(key2.getKey()) == nodi.get(i).getId()) {
							nodi.get(j).getEntrate().remove(key2.getKey());
						}
					}
				}
			}
		}
		for (Entry<Integer, Double> key : nodi.get(i).getEntrate().entrySet()) {
			for (int j = 0; j < nodi.size(); j++) {
				if (nodi.get(j).getId() == key.getKey()) {
					for (Entry<Integer, Double> key2 : nodi.get(j).getUscite().entrySet()) {
						if (nodi.get(j).getUscite(key2.getKey()) == nodi.get(i).getId()) {
							nodi.get(j).getUscite().remove(key2.getKey());
						}
					}
				}
			}
		}
		// se rimuovo un nodo i sui archi devono rimanere all'interno dell'arreyList
		// altrimenti si sputtanano tutti gli altri quindi sarebbe meglio avere una
		// mappa per gli archi invece di una lista
		nodi.remove(i);
		return true;
	}

	public boolean removeNodo(Nodo nodo) {
		try {
			nodi.get(nodi.indexOf(nodo));
		} catch (Exception e) {
			return false;
		}
		for (Entry<Integer, Double> key : nodi.get(nodi.indexOf(nodo)).getUscite().entrySet()) {
			for (int j = 0; j < nodi.size(); j++) {
				if (nodi.get(j).getId() == key.getKey()) {
					for (Entry<Integer, Double> key2 : nodi.get(j).getEntrate().entrySet()) {
						if (nodi.get(j).getEntrate(key2.getKey()) == nodi.get(nodi.indexOf(nodo)).getId()) {
							nodi.get(j).getEntrate().remove(key2.getKey());
						}
					}
				}
			}
		}
		for (Entry<Integer, Double> key : nodi.get(nodi.indexOf(nodo)).getEntrate().entrySet()) {
			for (int j = 0; j < nodi.size(); j++) {
				if (nodi.get(j).getId() == key.getKey()) {
					for (Entry<Integer, Double> key2 : nodi.get(j).getUscite().entrySet()) {
						if (nodi.get(j).getUscite(key2.getKey()) == nodi.get(nodi.indexOf(nodo)).getId()) {
							nodi.get(j).getUscite().remove(key2.getKey());
						}
					}
				}
			}
		}
		// se rimuovo un nodo i sui archi devono rimanere all'interno dell'arreyList
		// altrimenti si sputtanano tutti gli altri quindi sarebbe meglio avere una
		// mappa per gli archi invece di una lista
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
}
