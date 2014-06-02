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
 
    public void l�ggatillpryl(Pryl Ny){
        PrylRegister.add(Ny);  
    }
 
    public double totalV�rde(){
        double summa = 0;
		for(Pryl thisPryl: PrylRegister){
            summa += thisPryl.getV�rde();
        }
        return summa;
    }
public String getNamn(){
        return namn;
    }
  public String PrylRegister(){
        return namn + " " + totalV�rde() + "\n";
    }
    public String toString(){
        return namn + " " + totalV�rde() + "\n";
    }
 
    
}