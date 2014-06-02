package Projekt;
import java.io.Serializable;
abstract public class Djur implements Serializable {
    private String namn;
    private int vikt;
    
    public Djur(String namn, int vikt){
        this.namn = namn;
        this.vikt = vikt;
    }
    
    public String returneraNamn(){
        return namn;
    }
    
    public int returneraVikt(){
        return vikt;
    }
    
    public String returneraNamnStora(){
        return namn.toUpperCase();
    }
    
    public void ändraVikt(int offer){
        vikt = vikt + offer;
    }
    
    abstract public double attackStyrka();
    
    abstract public String toString();
    
    abstract public void ändraAttribut(int offer);
}