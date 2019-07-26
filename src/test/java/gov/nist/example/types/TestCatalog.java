package gov.nist.example.types;


import static org.junit.Assert.assertNotNull;

import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.junit.Before;
import org.junit.Test;

import gov.nist.example.models.types.Catalog;

public class TestCatalog {
	public static String CATALOG_TEST_FILE = null;
	
	@Before
	public void init() {
		Path resourceDirectory = Paths.get("src","test","resources");
		CATALOG_TEST_FILE = resourceDirectory.toString() + "/testCatalog.xml";
		System.out.println("CATALOG_TEST_FILE is: " + CATALOG_TEST_FILE);
		
	}
	
	@Test
	public void testRepresentCatalog() throws Exception {
		JAXBContext context = JAXBContext.newInstance(Catalog.class);
		Unmarshaller um = context.createUnmarshaller();
		Catalog c = (Catalog) um.unmarshal(new FileReader(CATALOG_TEST_FILE));
		System.out.println(c);
		assertNotNull(c);
	}

}
