package XMLManager;

import java.util.ArrayList;
import java.util.HashMap;

public class StrutturaDati {
	private String nome;
	private String tag;
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

	public String getTag() {
		return tag;
	}

	public ArrayList<StrutturaDati> getAttributi() {
		return attributi;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected void setTag(String tag) {
		this.tag = tag;
	}

	protected void setAttributi(ArrayList<StrutturaDati> attributi) {
		this.attributi = attributi;
	}

	protected void setIsText(boolean isText) {
		this.isText = isText;
	}

}
