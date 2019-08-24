package gov.nist.example.microsoft_2016.model;

public abstract class HandRollTagAbstract implements HandRollTag {
  
  private int counter;
  
  protected HandRollTagAbstract(int start) {
    setCount(start);
  }
  
  private HandRollTagAbstract() {
    setCount(6000000);
  }

  @Override
  public abstract String output();
  
  public void setCount(int count) {
    counter = count;
  }
  
  public String getCount() {
    counter++;
    return Integer.toHexString(counter);
  }

}
