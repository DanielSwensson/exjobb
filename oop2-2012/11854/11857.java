public class BlockOfBonds extends BlockofAssets {
private double nominalInterest;
private double faceValue;
private int yearsToMaturity;
private double marketInterestRate =super.getMarketInterestRate();
private double value;

public BlockOfBonds (String bondName, double fv,int ym, double ni, int numberOfBonds){
super(bondName,numberOfBonds);
faceValue = fv;
yearsToMaturity = ym;
nominalInterest = ni;
value = this.calculateValue();
}
public double calculateValue(){
value = (faceValue *((nominalInterest/marketInterestRate)*yearsToMaturity))*this.getNumberOfType();
return value;
}
public String toString(){
String printOut = ("\n Obligationspost: " + this.getName()+" Antal: " + this.getNumberOfType()+" Obligationspostens värde: "+value+"\n");
return printOut;
}


}

 

