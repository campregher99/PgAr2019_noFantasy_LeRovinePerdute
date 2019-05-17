package XMLManager;

import java.util.*;

public class LetturaScrittura {
	private String pathInputFile;
	private String pathFormatInput;

	public LetturaScrittura() {
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

	protected boolean isElementi() {
		return false;
	}

	protected boolean isEmpty() {
		return false;
	}

	public boolean setPathFormatInput(String pathFormatInput) {
		this.pathFormatInput = pathFormatInput;
		return false;
	}

	public boolean setPathInputFile(String pathInputFile) {
		this.pathInputFile = pathInputFile;
		return false;
	}
}
