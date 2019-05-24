package leRovinePerdute;

import java.util.*;
import java.util.Map.Entry;

import Grafo.*;
import XMLManager.*;
import interfaccia.*;

public class Navigatore {
	private ArrayList<String> attStr = new ArrayList<String>();
	private ArrayList<String> attDbl = new ArrayList<String>();
	private Grafo mappaM1;
	private Grafo mappaM2;
	private DecodificatoreXML XML = new DecodificatoreXML();
	private InterfacciaUtente interfaccai = new InterfacciaUtente();

	public Navigatore() {
		while (!XML.leggiFile(interfaccai.letturaString("inserisci il percorso del file XML della mappa: ")))
			;
	}

	public void grafo() {
		attStr.add("nome");
		attDbl.add("id");
		mappaM1 = new Grafo(attStr, attDbl, null);
		mappaM2 = new Grafo(attStr, attDbl, null);
		for (int i = 0; i < XML.getFile().getAttributi().size(); i++) {
			HashMap<String, String> nome = new HashMap<String, String>();
			HashMap<String, Double> id = new HashMap<String, Double>();
			nome.put(attStr.get(0), XML.getFile().getAttributi().get(i).getTag("name"));
			id.put(attDbl.get(0), (double) Integer.valueOf(XML.getFile().getAttributi().get(i).getTag("id")));
			mappaM1.aggiungiNodo(nome, id, null);
			mappaM2.aggiungiNodo(nome, id, null);
		}
		for (Nodo nodo : mappaM1.getNodi()) {
			boolean isEsiste = false;
			for (StrutturaDati attributo : XML.getFile().getAttributi()) {
				if ((double) Integer.valueOf(attributo.getTag(attDbl.get(0))) == nodo.getDoppio(attDbl.get(0))) {
					
				}
			}
			for (StrutturaDati attributo : XML.getFile().getAttributi().get(i).getAttributi()) {
				for (Entry<Integer, Integer> uscita : mappaM1
						.getNodo(attDbl.get(0), mappaM1.getNodo(mappaM1.getNodi().size() - 1).getDoppio(attDbl.get(0)))
						.getUscite().entrySet()) {
					if (uscita.getValue() == Integer.valueOf(attributo.getTag(attDbl.get(0)))) {
						isEsiste = true;
						break;
					}
				}
			}
			if (!isEsiste) {
				Nodo nodo1 = new Nodo();
				Nodo nodo2 = new Nodo();
				double valore = 0;
				nodo1 = mappaM1.getNodo(attDbl.get(0),
						(double) Integer.valueOf(XML.getFile().getAttributi().get(i).getTag("id")));

				mappaM1.aggiungiArco(nodo1, nodo2, valore);
			}
		}
		for (Nodo nodo : mappaM2.getNodi()) {

		}
	}
}
