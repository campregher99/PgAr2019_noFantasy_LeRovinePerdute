package Grafo;

import java.util.*;
import java.util.Map.Entry;

public class Nodo {
	private boolean isVuoto = true;
	private int id;
	private static int idAttuale = 0;
	private HashMap<String, String> stringhe = new HashMap<String, String>();
	private HashMap<String, Double> doppio = new HashMap<String, Double>();
	private HashMap<String, Boolean> booleani = new HashMap<String, Boolean>();
	/**
	 * HashMap<nodo, idArco>
	 */
	private HashMap<Integer, Integer> uscite = new HashMap<Integer, Integer>();
	private HashMap<Integer, Integer> entrate = new HashMap<Integer, Integer>();

	public Nodo(HashMap<String, String> stringhe, HashMap<String, Double> doppio, HashMap<String, Boolean> booleani) {
		isVuoto = false;
		this.booleani = booleani;
		this.doppio = doppio;
		this.stringhe = stringhe;
		id = idAttuale;
		idAttuale++;
	}

	public Nodo() {
		
	}
	
	public boolean getIsVuoto() {
		return isVuoto;
	}
	public HashMap<String, String> getStringhe() {
		return stringhe;
	}

	public String getStringhe(String nome) {
		return stringhe.get(nome);
	}

	public HashMap<String, Double> getDoppio() {
		return doppio;
	}

	public Double getDoppio(String nome) {
		return doppio.get(nome);
	}

	public HashMap<String, Boolean> getBooleani() {
		return booleani;
	}

	public Boolean getBooleani(String nome) {
		return booleani.get(nome);
	}

	public HashMap<Integer, Integer> getUscite() {
		return uscite;
	}

	public Integer getUscite(Integer nome) {
		return uscite.get(nome);
	}

	public HashMap<Integer, Integer> getEntrate() {
		return entrate;
	}

	public Integer getEntrate(Integer nome) {
		return entrate.get(nome);
	}

	public int getId() {
		return id;
	}

	public boolean setAttributo(String nome, String stringa) {
		for(Map.Entry<String,String> key : this.stringhe.entrySet()) {
			if(key.getKey().equals(nome)) {
				this.stringhe.replace(nome, stringa);
				return true;
			}
		}
		return false;
	}

	public boolean setAttributo(String nome, Double doppio) {
		for(Map.Entry<String,Double> key : this.doppio.entrySet()) {
			if(key.getKey().equals(nome)) {
				this.doppio.replace(nome, doppio);
				return true;
			}
		}
		return false;
	}

	public boolean setAttributo(String nome, Boolean booleano) {
		for(Map.Entry<String,Boolean> key : this.booleani.entrySet()) {
			if(key.getKey().equals(nome)) {
				this.booleani.replace(nome, booleano);
				return true;
			}
		}
		return false;
	}

	public void addUscita(Integer nome, Integer indiceArco) {
		this.uscite.put(nome, indiceArco);
	}

	public boolean removeUscita(Integer nome) {
		for(Entry<Integer, Integer> key : this.uscite.entrySet()) {
			if(key.getKey().equals(nome)) {
				this.uscite.remove(key.getKey());
				return true;
			}
		}
		return false;
	}

	public void addEntrate(Integer nome, Integer indiceArco) {
		this.entrate.put(nome, indiceArco);
	}

	public boolean removeEntrata(Integer nome) {
		for(Entry<Integer, Integer> key : this.entrate.entrySet()) {
			if(key.getKey().equals(nome)) {
				this.entrate.remove(key.getKey());
				return true;
			}
		}
		return false;
	}
	
	public Nodo getNodoPerID(int id, ArrayList<Nodo> nodi) {
		for (int i = 0; i < nodi.size(); i++) {
			if (nodi.get(i).getId() == id) {
				return nodi.get(i);
			}
		}
		return null;
	}
}
