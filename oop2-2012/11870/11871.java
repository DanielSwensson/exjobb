package prylregister;

class Aktie extends Pryl{
    private int nrOfStocks;
    private double stockPrice;
    private double value;
    
    public Aktie (String name, int number, double price){
        super (name);
        nrOfStocks=number;
        stockPrice=price;
    }
    public void setValue(double price){
        this.stockPrice=price;
    }
    
    @Override
    public double getValue(){
        value =nrOfStocks*stockPrice;
            return value;
    }
    @Override
    public String toString(){
        return prylName+ "\t"+ value+"\n";
    }
}