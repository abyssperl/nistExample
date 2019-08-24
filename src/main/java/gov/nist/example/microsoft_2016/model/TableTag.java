package gov.nist.example.microsoft_2016.model;

import java.util.List;

public class TableTag implements HandRollTag {
	
	private TableGridTag tableGrid;
	private TablePartTag tablePart;
	private List<TableRowTag> tableRows;
	@Override
	public String output() {
		String result = tableGrid.output() + tablePart.output();
		for (TableRowTag trt : tableRows) {
			result += trt.output();
		}
		return result;
	} 

}
