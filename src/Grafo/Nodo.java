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
	private HashMap<Integer, Double> uscite = new HashMap<Integer, Double>();
	private HashMap<Integer, Double> entrate = new HashMap<Integer, Double>();

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

	public HashMap<Integer, Double> getUscite() {
		return uscite;
	}

	public Double getUscite(Integer nome) {
		return uscite.get(nome);
	}

	public HashMap<Integer, Double> getEntrate() {
		return entrate;
	}

	public Double getEntrate(Integer nome) {
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

	public void addUscita(Integer nome, Double indiceArco) {
		this.uscite.put(nome, indiceArco);
	}

	public boolean removeUscita(Integer nome) {
		for(Entry<Integer, Double> key : this.uscite.entrySet()) {
			if(key.getKey().equals(nome)) {
				this.uscite.remove(key.getKey());
				return true;
			}
		}
		return false;
	}

	public void addEntrate(Integer nome, Double indiceArco) {
		this.entrate.put(nome, indiceArco);
	}

	public boolean removeEntrata(Integer nome) {
		for(Entry<Integer, Double> key : this.entrate.entrySet()) {
			if(key.getKey().equals(nome)) {
				this.entrate.remove(key.getKey());
				return true;
			}
		}
		return false;
	}
}
