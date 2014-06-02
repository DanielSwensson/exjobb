public class Stock extends Property{
  
  private int price;
  private int quantity;
  private int value;
  
  public Stock(String name, int price, int quantity){
    super(name);
    this.price = price;
    this.quantity = quantity;
    this.value = price*quantity; //V�rdet �r priset multiplicerat med antalet
  }
  
  //Returnerar v�rdet
  public int getValue(){
   return value;
  }
  
  //Nollst�ller aktiens v�rde
  public void crash(){
    value = 0;
  }
  
  public String toString(){
    return quantity + " aktier i " + name + " till ett v�rde av " + getValue() + " \n";
  }
  
}