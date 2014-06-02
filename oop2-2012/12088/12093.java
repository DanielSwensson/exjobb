abstract class Property{
  
  protected String name;
  private int value;
  
  public Property(String name){
   this.name = name;
  }
  
  public Property(String name, int value){
   this.name = name;
   this.value = value;
  }
  
  public String getName(){
    return name;
  }
  
  public int getValue(){
    return value;
  }
  
  public String toString(){
    return name + " " + getValue() + " \n";
  }
  
}