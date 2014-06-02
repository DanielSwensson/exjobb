package assetmanagement;

public class Jewelry extends Asset {//Subklass till klassen Asset

    private boolean isGold; //variabel sant/falskt
    private int numberStones;//variabel större än noll

    Jewelry(String name, boolean isGold, int numberStones) {//Konstruktor
        super.name = name;
        this.isGold = isGold;
        this.numberStones = numberStones;
    }

    public int getValue() {//metod värde
        if (isGold) {
            return (2000 + numberStones * 500);
        } else {
            return (700 + numberStones * 500);
        }
    }

    public String toString() {//metod formaterad sträng
        String text1 = "\t";
        String text2 = "";
        String text3 = "";
        if (name.length() < 8) {
            text1 = "\t\t";
        }
        if (this.isGold) {
            text2 = "\tGuldsmycke! ";
        }
        if (this.numberStones > 0) {
            text3 = "\tAntal ädelstenar: " + numberStones;
        }
        return name + text1 + this.getValue() + text2 + text3;
    }
    
  
}
