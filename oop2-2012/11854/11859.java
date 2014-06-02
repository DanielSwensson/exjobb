public class BlockOfShares extends BlockofAssets {
private double dividend;
private double marketInterestRate = super.getMarketInterestRate();
private double value;

public BlockOfShares(String name, int numberOfShares, double dividendIn){
super(name,numberOfShares);
dividend = dividendIn;
value = this.calculateValue();
}
public double calculateValue(){
value = ((dividend/marketInterestRate)*this.getNumberOfType());
return value;
}

public String toString(){
String printOut = ("\n Aktiepost: " + this.getName()+ "\n Antal: "+ this.getNumberOfType()+" \n Aktiepostens värde: " +value);
return printOut;
}

 

}

 

