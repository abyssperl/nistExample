package gov.nist.example.parse;

import java.io.*;
import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import gov.nist.example.models.types.Catalog;

public class XmlWordDocument {

	private Catalog catalog;
	
	public XmlWordDocument(Catalog c) {
		catalog = c;
	}
	
	public XmlWordDocument(String s) throws Exception {
		JAXBContext context = JAXBContext.newInstance(Catalog.class);
		Unmarshaller um = context.createUnmarshaller();
		catalog = (Catalog) um.unmarshal(new FileReader(s));
	}
	
	public String run() {
		String result = null;
		return result;
	}

}
