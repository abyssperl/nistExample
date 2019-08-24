package gov.nist.example.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.math.BigInteger;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xwpf.usermodel.XWPFAbstractNum;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFNumbering;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTAbstractNum;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTLvl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STNumberFormat;

import gov.nist.example.models.types.Catalog;
import gov.nist.example.models.types.Control;
import gov.nist.example.models.types.Group;
import gov.nist.example.models.types.P;
import gov.nist.example.models.types.Part;
import gov.nist.example.models.types.Prop;

public class DisplayWord {

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
		run.setText("Test Run.");
		DisplayWord dw = new DisplayWord();
		dw.run(c);
		System.out.println("Done");
	}

	public void run(Catalog c) throws Exception {
		XWPFDocument docx = new XWPFDocument();		
		try (FileOutputStream out = new FileOutputStream(new File("createparagraph.docx"));) {
			List<Group> groups = c.getGroup();
			int count = 1;
			for (Group g : groups) {
			    docx = createSubSectionInformation(docx, g, count);
			    docx = createControlSummaryInformation(docx, g);
			    docx = createSolutionInformation(docx, g);
			    count++;
			}
			docx.write(out);
			docx.close();
		}
	}

	public XWPFDocument createSubSectionInformation(XWPFDocument docx, Group g, int count) {
		XWPFParagraph section = docx.createParagraph();
		XWPFRun run = section.createRun();
		run.setText("13." + count + "." + g.getTitle().getContent() + " (" + StringUtils.upperCase(g.getId()) + ")");
		

		List<Control> control = g.getControl();
		for (Control c : control) {
			XWPFParagraph subsection = docx.createParagraph();
			//subsection.setStyle();
			XWPFRun runsub = subsection.createRun();
			runsub.setText("" + c.getProp().get(0).getContent() + c.getTitle().getContent());
			

			XWPFParagraph subsection2 = docx.createParagraph();
			XWPFRun runsub2 = subsection.createRun();
			List<Part> parts = c.getPart();
			try {
			P p = (P) parts.get(0).getProse().get(0);
			String pTag = (String) p.getContent().get(0); //Returns <P> tag
			runsub2.setText(pTag);
		} catch (Exception e) {
			//Does not exist
		}
			
			List<String> documentList = new ArrayList<>(10);
//			for (Part part : parts) {
//				List<Prop> props = part.getProp();
//				List<Part> subParts = part.getPart();
//				//documentList.add(part.getProp());
//			}

			CTAbstractNum cTAbstractNum = CTAbstractNum.Factory.newInstance();
			cTAbstractNum.setAbstractNumId(BigInteger.valueOf(0));
			XWPFAbstractNum abstractNum = new XWPFAbstractNum(cTAbstractNum);

			CTLvl cTLvl = cTAbstractNum.addNewLvl();
			cTLvl.addNewNumFmt().setVal(STNumberFormat.DECIMAL);
			cTLvl.addNewLvlText().setVal("%1.");
			cTLvl.addNewStart().setVal(BigInteger.valueOf(1));

			XWPFNumbering numbering = docx.createNumbering();

			BigInteger abstractNumID = numbering.addAbstractNum(abstractNum);

			BigInteger numID = numbering.addNum(abstractNumID);

			for (String string : documentList) {
				section = docx.createParagraph();
				section.setNumID(numID);
				run = section.createRun();
				run.setText(string);
			}
			
			
			
		}
		return docx;
	}

	public XWPFDocument createControlSummaryInformation(XWPFDocument docx, Group g) {
		XWPFTable table = docx.createTable();

		// create first row
		XWPFTableRow tableRowOne = table.getRow(0);
		tableRowOne.getCell(0).setText("col one, row one");
		tableRowOne.addNewTableCell().setText("col two, row one");
		tableRowOne.addNewTableCell().setText("col three, row one");
		return docx;
	}

	public XWPFDocument createSolutionInformation(XWPFDocument docx, Group g) {
		XWPFTable table = docx.createTable();

		// create first row
		XWPFTableRow tableRowOne = table.getRow(0);
		tableRowOne.getCell(0).setText("col one, row one");
		tableRowOne.addNewTableCell().setText("col two, row one");
		tableRowOne.addNewTableCell().setText("col three, row one");
		return docx;
	}

}
