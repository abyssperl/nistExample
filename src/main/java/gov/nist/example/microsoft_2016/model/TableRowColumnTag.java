package gov.nist.example.microsoft_2016.model;

public class TableRowColumnTag extends HandRollTagAbstract {

  private String columnValue = null;
  private ColumnType ct;

  private String implementationStatusIs_One = "";
  private String implementationStatusNotOne = "";
  private String controlOriginationIs_One = "";
  private String controlOriginationNotOne = "";
  
  public TableRowColumnTag(int start) {
    super(start);
  }

  @Override
  public String output() {
    switch (ct) {
      case IS__ISONE:
        columnValue = implementationStatusIs_One;
        break;
      case IS_NOTONE:
        columnValue = implementationStatusNotOne;
        break;
      case CO__ISONE:
        columnValue = controlOriginationIs_One;
        break;
      case CO_NOTONE:
        columnValue = controlOriginationNotOne;
        break;
      default:
        if (columnValue == null) {
          System.out.println("Did not set column value. Will corrupt the word doc.");
        }

    }
    return columnValue;
  }

  public void setColumnValue(String s) {
    columnValue = s;
  }

  public void setColumnType(ColumnType ct) {
    this.ct = ct;
  }

  public enum ColumnType {
    VARIABLE, IS__ISONE, IS_NOTONE, CO__ISONE, CO_NOTONE
  }

}
