package gov.nist.example.microsoft_2016.model;

import java.util.*;

public class TableRowTag extends HandRollTagAbstract {
	private HeaderType isTableHeader;
	
	private static String IS_HEADER = "";
	private static String NOTHEADER = "";
	
	private List<TableRowColumnTag> columns = null;

  public TableRowTag(int start) {
    super(start);
  }

	@Override
	public String output() {
	  switch (isTableHeader) {
	    case YES:
	      
	  }
		// TODO Auto-generated method stub
		return null;
	}
	

  
  public enum HeaderType {
    YES, NO
  }
	
	
	
	

}
