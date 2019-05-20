package XMLManager;

public class DecodificatoreXML {
	private LetturaScrittura inputFile;

	public boolean leggiFile(String pathInputFile) {
		if (!inputFile.setPathInputFile(pathInputFile))
			return false;
		if (!inputFile.leggiFile())
			return false;
		return true;
	}

	public StrutturaDati getFile() {
		try {
		return inputFile.getFile();
		}catch(Exception e) {
			StrutturaDati vuoto=new StrutturaDati();
			return vuoto;
		}
	}

	public boolean scriviFile(StrutturaDati input, String nomeFile, String formato, String versione) {
		if (inputFile.scriviFile(input, nomeFile, formato, versione))
			return true;
		return false;
	}
}
