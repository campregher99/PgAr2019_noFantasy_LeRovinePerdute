package XMLManager;

import java.util.*;

public class StrutturaDati {
	private String nome;
	private HashMap<String, String> tag = new HashMap<String, String>();
	private ArrayList<String> indiciKey = new ArrayList<String>();
	private ArrayList<StrutturaDati> attributi;
	private boolean isText = false;

	protected StrutturaDati() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public boolean isText() {
		return isText;
	}

	public String getTag(String key) {
		return tag.get(key);
	}

	public String getTag(int i) {
		return tag.get(this.indiciKey.get(i));
	}

	public ArrayList<StrutturaDati> getAttributi() {
		return attributi;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTag(String tag, String valore) {
		this.tag.put(tag, valore);
	}

	public void removeTag(String tag) {
		this.tag.remove(tag);
	}

	public void removeTag(int i) {
		this.tag.remove(this.indiciKey.get(i));
	}

	public void setAttributi(ArrayList<StrutturaDati> attributi) {
		this.attributi = attributi;
	}

	public void setIsText(boolean isText) {
		this.isText = isText;
	}

}
