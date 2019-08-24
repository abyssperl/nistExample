package gov.nist.example.microsoft_2016.model;

public class TableGridTag implements HandRollTag {

	@Override
	public String output() {
		String output = "			<w:tblGrid>" + 
				"				<w:gridCol w:w=\"1517\" />" + 
				"				<w:gridCol w:w=\"7833\" />" + 
				"			</w:tblGrid>";
		return output;
	}
	

}
