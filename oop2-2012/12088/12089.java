public class Stock extends Property{
  
  private int price;
  private int quantity;
  private int value;
  
  public Stock(String name, int price, int quantity){
    super(name);
    this.price = price;
    this.quantity = quantity;
    this.value = price*quantity; //Värdet är priset multiplicerat med antalet
  }
  
  //Returnerar värdet
  public int getValue(){
   return value;
  }
  
  //Nollställer aktiens värde
  public void crash(){
    value = 0;
  }
  
  public String toString(){
    return quantity + " aktier i " + name + " till ett värde av " + getValue() + " \n";
  }
  
}