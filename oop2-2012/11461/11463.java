public class Apparater extends Pryl{
    private int inköpsPris;
    private int slitageVärde;
    private double värde;
    
    Apparater(String name, int inköpsPris, int slitageVärde){
        super(name);
        this.inköpsPris = inköpsPris;
        this.slitageVärde = slitageVärde; 
    }
    public double hämtaVärde() {
        double internSlitage = (double) slitageVärde; 
        värde = (internSlitage/10)*inköpsPris;
        return värde;
    }
     public String toString(){
        return super.toString() +" Inköpspris: " + inköpsPris + " Slitagevärde: " + slitageVärde + " Värde: " + värde + " kr";
        
    }
}