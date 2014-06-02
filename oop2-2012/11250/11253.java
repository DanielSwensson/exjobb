import java.util.ArrayList;
 
public class Person {
 
    Person (String namn) {
        this.namn = namn;
    }
 
    ArrayList<Pryl> PrylRegister = new ArrayList<Pryl>();
    private String namn;
 
    public ArrayList<Pryl> getPryllista(){
        return PrylRegister;
    }
 
    public void läggatillpryl(Pryl Ny){
        PrylRegister.add(Ny);  
    }
 
    public double totalVärde(){
        double summa = 0;
		for(Pryl thisPryl: PrylRegister){
            summa += thisPryl.getVärde();
        }
        return summa;
    }
public String getNamn(){
        return namn;
    }
  public String PrylRegister(){
        return namn + " " + totalVärde() + "\n";
    }
    public String toString(){
        return namn + " " + totalVärde() + "\n";
    }
 
    
}