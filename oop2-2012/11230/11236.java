package assetmanagement;

public class Stocks extends Asset { //Subklass till klassen Asset

    private int numberStocks; //variabel större än noll
    private int stockPrice; //variabel större än noll

    Stocks(String name, int numberStocks, int stockPrice) {//Konstruktor
        super.name = name;
        this.numberStocks = numberStocks;
        this.stockPrice = stockPrice;
    }

    public int getValue() { //metod värde som returnerar inköpspris * antal aktier
        return stockPrice * numberStocks;
    }

    public String toString() { //metod formaterad sträng
        String text1 = "\t";
        String text2 = this.getValue() + "\tAntal aktier:" + numberStocks + " och aktiepris:" + stockPrice;
        if (name.length() < 8) {
            text1 = "\t\t";
        }
        return name + text1 + text2;
    }

    public void Crash() {//metod börskrasch
        this.stockPrice = 0;
    }
}
