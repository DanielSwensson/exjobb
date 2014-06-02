package prylregister;

import java.util.ArrayList;



public class Aktier extends Pryl {

    private double price = 0;
    private int amount = 0;
    private String nameOfStock;
    
    
Aktier(String nameOfStock, double price, int amount){
this.price = price;
this.amount = amount;
this.nameOfStock = nameOfStock;


}
    
 public double value(){
     
    value =(price*amount);
    return value;
 }

  public String getText(){
  
    return ("COMPANY : " + nameOfStock + "\nAMOUNT: " + amount + "\nTOTAL VALUE: " + value() + "\n\n");
  }  
 public void setPrice(){
     
    price = 0;
 }  
    
}
