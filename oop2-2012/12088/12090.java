public class Device extends Property{
  
  private int price;
  private double wear;
  
  public Device(String name, int price, int wear){
    super(name);
    this.price = price;
    this.wear = wear;
    if(wear > 10){
      this.wear = 10;
    }
  }
  
  //Returnerar värdet på prylen
  public int getValue(){
    return (int)Math.round((price*wear)/10);
  }

}