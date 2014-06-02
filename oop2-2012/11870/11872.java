package prylregister;

class Apparat extends Pryl{
    private double buyingPrice;
    private int currentWear;
   
    public Apparat (String name, double price, int wear){
       super(name);
       buyingPrice=price;
       currentWear=wear;
   }
    @Override
   public double getValue(){
       double value;
       value =buyingPrice*currentWear*0.1;
       return value;
   }
    @Override
   public String toString(){
       return prylName + "\t"+ getValue();
   }
}