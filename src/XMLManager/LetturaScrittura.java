package XMLManager;

import java.util.*;
import java.util.Map.Entry;

import javax.xml.stream.*;

import java.io.*;

class LetturaScrittura {
	private XMLInputFactory xmlif = null;
	private XMLStreamReader xmlr = null;
	private XMLOutputFactory xmlof = null;
	private XMLStreamWriter xmlw = null;
	StrutturaDati file;

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
		if (scriviElemento(input)) {
			try {
				xmlw.writeEndDocument();
				return true;
			} catch (Exception e) {
			}
		}
		return false;
	}

	private boolean scriviElemento(StrutturaDati input) {
		// controlla se all'interno dell'elemento ci sono altri elementi oppure del
		// testo
		if (input.isText()) {
			// in caso ci sia del testo lo scrivo come tale
			try {
				xmlw.writeCharacters(input.getNome());
				xmlw.writeEndElement();
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			// altrimenti scrivo tutti gli elementi in modo ricorsivo
			try {
				xmlw.writeStartElement(input.getNome());
				for (Entry<String, String> tag : input.getTag().entrySet()) {
					xmlw.writeAttribute(tag.getKey(), input.getTag(tag.getKey()));
				}
			} catch (Exception e) {
				return false;
			}
			for (StrutturaDati att : input.getAttributi()) {
				if (!scriviElemento(att))
					return false;
			}
			try {
				xmlw.writeEndElement();
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
		return true;
	}
}
