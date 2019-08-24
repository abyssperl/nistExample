package gov.nist.example.microsoft_2016.model;

public class TablePartTag implements HandRollTag {

	@Override
	public String output() {
		String output =
				"			<w:tblPr>" + 
				"				<w:tblW w:w=\"5000\" w:type=\"pct\" />" + 
				"				<w:tblBorders>" + 
				"					<w:top w:val=\"single\" w:sz=\"4\" w:space=\"0\" w:color=\"969996\"" + 
				"						w:themeColor=\"text1\" w:themeTint=\"80\" />" + 
				"					<w:left w:val=\"single\" w:sz=\"4\" w:space=\"0\" w:color=\"969996\"" + 
				"						w:themeColor=\"text1\" w:themeTint=\"80\" />" + 
				"					<w:bottom w:val=\"single\" w:sz=\"4\" w:space=\"0\"" + 
				"						w:color=\"969996\" w:themeColor=\"text1\" w:themeTint=\"80\" />" + 
				"					<w:right w:val=\"single\" w:sz=\"4\" w:space=\"0\"" + 
				"						w:color=\"969996\" w:themeColor=\"text1\" w:themeTint=\"80\" />" + 
				"					<w:insideH w:val=\"single\" w:sz=\"4\" w:space=\"0\"" + 
				"						w:color=\"969996\" w:themeColor=\"text1\" w:themeTint=\"80\" />" + 
				"					<w:insideV w:val=\"single\" w:sz=\"4\" w:space=\"0\"" + 
				"						w:color=\"969996\" w:themeColor=\"text1\" w:themeTint=\"80\" />" + 
				"				</w:tblBorders>" + 
				"				<w:tblCellMar>" + 
				"					<w:left w:w=\"115\" w:type=\"dxa\" />" + 
				"					<w:right w:w=\"115\" w:type=\"dxa\" />" + 
				"				</w:tblCellMar>" + 
				"				<w:tblLook w:val=\"04A0\" w:firstRow=\"1\" w:lastRow=\"0\"" + 
				"					w:firstColumn=\"1\" w:lastColumn=\"0\" w:noHBand=\"0\" w:noVBand=\"1\" />" + 
				"			</w:tblPr>";
		return output;
	}

}
