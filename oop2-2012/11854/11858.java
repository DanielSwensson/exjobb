


public class BlockOfOptions extends BlockofAssets {
private int daysToSettlement;
private double value;
private double marketInterest = super.getMarketInterestRate();

public BlockOfOptions(String name, int numberOfOptions, int daysLeft){
super(name,numberOfOptions);
daysToSettlement = daysLeft;
value = this.calculateValue();
}
public double calculateValue(){
value = daysToSettlement*daysToSettlement/marketInterest*this.getNumberOfType();
return value;
}
public String toString(){
String printOut = ("\n Optionspost " + this.getName()+ "\n Antal: " + this.getNumberOfType()+"\n Optionspostens värde: " +value+"\n");
return printOut;
}


}

 

