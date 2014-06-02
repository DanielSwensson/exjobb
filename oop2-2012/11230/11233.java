package assetmanagement;

public class Gadget extends Asset {//Subklass till klassen Asset

    private int wearRate; //variabel slitage 1-10 där 10 är nyskick
    private int purchasePrice;//variabel pris större än noll

    Gadget(String name, int wearRate, int purchasePrice) {//Konstruktor
        super.name = name;
        this.wearRate = wearRate;
        this.purchasePrice = purchasePrice;
    }

    public int getValue() {//metod värde
        return purchasePrice * wearRate / 10;
    }

    public String toString() {//metod formaterad sträng
        String text1 = "\t";
        String text2 = this.getValue() + "\tSlitage:" + wearRate + " och inköpspris:" + purchasePrice;
        if (name.length() < 8) {
            text1 = "\t\t";
        }
        return name + text1 + text2;
    }
    
    
    
    
}
