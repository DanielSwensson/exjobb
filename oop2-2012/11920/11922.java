package prylregister;



public class Apparater extends Pryl {

    
    private String electricalOrNot = null;
    private double worn = 0 ;
    private double marketPrice= 0;
    private String typeOfDevice = null;
    
    
 Apparater(String electricalOrNot, double worn, double marketPrice, String typeOfDevice){
    
    this.electricalOrNot = electricalOrNot;
    this.worn = worn;
    this.marketPrice = marketPrice;
    this.typeOfDevice = typeOfDevice;
    

}      
    
 public double value(){
    
    value = ((worn/10)*(double)marketPrice);
    
    return value;
 }   
 
public String getText(){

return ("TYPE OF DEVICE: " + electricalOrNot +" "+ typeOfDevice + "\nVALUE: " + value() + "\n\n");

}  
    
  
    
}
