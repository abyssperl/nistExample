package gov.nist.example.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.sql.rowset.spi.XmlWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import gov.nist.example.models.types.Catalog;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class ConvertXMLtoDOCX {
	
	private String fileName = null;
	
	public ConvertXMLtoDOCX(String fileName) {
		this.fileName = fileName;
	}
	
	

	public String getFileName() {
		return fileName;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	public static void main(String[] args) throws Exception {
		Path resourceDirectory = Paths.get("src","test","resources");
		String CATALOG_TEST_FILE = resourceDirectory.toString() + "/full_nist_low_example.xml";
		JAXBContext context = JAXBContext.newInstance(Catalog.class);
		Unmarshaller um = context.createUnmarshaller();
		Catalog c = (Catalog) um.unmarshal(new FileReader(CATALOG_TEST_FILE));
		System.out.println(c);
		
		ConvertXMLtoDOCX docx = new ConvertXMLtoDOCX("test.docx");
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		run.setText(c.toString());
		try (FileOutputStream out = new FileOutputStream(new File(docx.getFileName()))) {
			document.write(out);
			System.out.println("Wrote something.");
		}
		
	}
	
	

}
