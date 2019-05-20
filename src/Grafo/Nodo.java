package Grafo;

import java.util.*;

public class Nodo {
	private int id;
	private static int idAttuale = 0;
	private HashMap<String, String> stringhe = new HashMap<String, String>();
	private HashMap<String, Double> doppio = new HashMap<String, Double>();
	private HashMap<String, Boolean> booleani = new HashMap<String, Boolean>();
	private HashMap<Integer, Integer> uscite = new HashMap<Integer, Integer>();
	private HashMap<Integer, Integer> entrate = new HashMap<Integer, Integer>();

	public Nodo(HashMap<String, String> stringhe, HashMap<String, Double> doppio, HashMap<String, Boolean> booleani) {
		this.booleani = booleani;
		this.doppio = doppio;
		this.stringhe = stringhe;
		id = idAttuale;
		idAttuale++;
	}

	public Nodo() {

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

	public HashMap<String, Integer> getUscite() {
		return uscite;
	}

	public Integer getUscite(String nome) {
		return uscite.get(nome);
	}

	public HashMap<String, Integer> getEntrate() {
		return entrate;
	}

	public Integer getEntrate(String nome) {
		return entrate.get(nome);
	}

	public int getId() {
		return id;
	}

	public void setAttributo(String nome, String stringa) {

	}

	public void setAttributo(String nome, Double doppio) {

	}

	public void setAttributo(String nome, Boolean booleano) {

	}

	public void addUscita(String nome, Integer indiceArco) {
		this.uscite.put(nome, indiceArco);
	}

	public boolean removeUscita(String nome) {
		return false;
	}

	public void addEntrate(String nome, Integer indiceArco) {
		this.entrate.put(nome, indiceArco);
	}

	public boolean removeEntrata(String nome) {
		return false;
	}
}
