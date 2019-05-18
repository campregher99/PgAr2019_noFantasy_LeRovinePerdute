package XMLManager;

import java.util.*;

class LetturaScrittura {
	private String pathInputFile;

	protected LetturaScrittura() {
		// TODO Auto-generated constructor stub
	}

	protected String letturaTagElemento() {
		String tag = null;
		return tag;
	}

	protected HashMap<String, String> letturaAttributi() {
		HashMap<String, String> attributi = new HashMap<String, String>();
		return attributi;
	}

	protected boolean scriviElemento(StrutturaDati input) {
		return false;
	}

	private boolean scriviAttributo(StrutturaDati input) {
		return false;
	}

	protected boolean isElementi() {
		return false;
	}

	protected boolean isEmpty() {
		return false;
	}

	protected boolean setPathInputFile(String pathInputFile) {
		this.pathInputFile = pathInputFile;
		return false;
	}
}
