package XMLManager;

import java.util.*;
import java.util.Map.Entry;

import javax.xml.stream.*;

import java.io.*;

class LetturaScrittura {
	private static final String ERRORE_NELL_INIZIALIZZAZIONE_DEL_READER = "Errore nell'inizializzazione del reader:";
	private XMLInputFactory xmlif = null;
	private XMLStreamReader xmlr = null;
	private XMLOutputFactory xmlof = null;
	private XMLStreamWriter xmlw = null;
	private String pathInputFile;
	StrutturaDati file;

	protected LetturaScrittura() {
		// TODO Auto-generated constructor stub
	}

	protected boolean leggiFile() {
		Stack<StrutturaDati> elementoAttuale = new Stack<StrutturaDati>();
		try {
			while (xmlr.hasNext()) {
				switch (xmlr.getEventType()) {
				case XMLStreamConstants.START_DOCUMENT:
					file = new StrutturaDati(xmlr.getLocalName());
					elementoAttuale.push(file);
					break;
				case XMLStreamConstants.START_ELEMENT:
					StrutturaDati newElemento = new StrutturaDati(xmlr.getLocalName());
					elementoAttuale.push(newElemento);
					break;
				case XMLStreamConstants.END_ELEMENT:
					elementoAttuale.pop();
					break;
				case XMLStreamConstants.END_DOCUMENT:
					return true;
				case XMLStreamConstants.CHARACTERS:
					if (xmlr.getText().trim().length() > 0) {
						StrutturaDati newText = new StrutturaDati(xmlr.getText());
						newText.setIsText(true);
						elementoAttuale.peek().addAttributo(newText);
					}
					break;
				case XMLStreamConstants.ATTRIBUTE:
					for (int i = 0; i < xmlr.getAttributeCount(); i++) {
						elementoAttuale.peek().addTag(xmlr.getAttributeLocalName(i), xmlr.getAttributeValue(i));
					}
					break;
				}
				xmlr.next();
			}
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	protected StrutturaDati getFile() {
		return file;
	}

	protected boolean scriviFile(StrutturaDati input, String nomeFile, String formato, String versione) {
		try {
			xmlof = XMLOutputFactory.newInstance();
			xmlw = xmlof.createXMLStreamWriter(new FileOutputStream(nomeFile + ".xml"), formato);
			xmlw.writeStartDocument(formato, versione);
		} catch (Exception e) {
			return false;
		}
		if (scriviElemento(input))
			return true;
		return false;
	}

	private boolean scriviElemento(StrutturaDati input) {
		if (input.isText()) {
			try {
				xmlw.writeCharacters(input.getNome());
			} catch (Exception e) {
				return false;
			}
		} else {
			try {
				xmlw.writeStartElement(input.getNome());
				for(Entry<String, String> tag : input.getTag().entrySet()) {
					xmlw.writeAttribute(tag.getKey(), input.getTag(tag.getKey()));
				}
			} catch (Exception e) {
				return false;
			}
		}
		
		return false;
	}

	protected boolean setPathInputFile(String pathInputFile) {
		try {
			xmlif = XMLInputFactory.newInstance();
			xmlr = xmlif.createXMLStreamReader(pathInputFile, new FileInputStream(pathInputFile));
		} catch (Exception e) {
			return false;
		}
		this.pathInputFile = pathInputFile;
		return true;
	}
}
