public class Smycken extends Pryl {

    private int antalÄdelstenar;
    private String guld;
    private int värde;

    Smycken(String namn, String guld, int antalÄdelstenar) {
        super(namn);
        this.guld = guld;
        this.antalÄdelstenar = antalÄdelstenar;
        
        
    }

    public String toString() {
        return super.toString() + " Antal ädelstenar: " + antalÄdelstenar + " Guld?: " + guld + " Värde: "+ hämtaVärde() + " kr";

    }

    public double hämtaVärde() {
        if (guld.equalsIgnoreCase("ja")) {
                värde = 2000 + (antalÄdelstenar * 500);
            } else {
                värde = 700 + (antalÄdelstenar * 500);
            }
        return värde;
   
    }
}
