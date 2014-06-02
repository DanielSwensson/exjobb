import java.util.*;
import java.io.*;

class Person implements Serializable {
	
	private ArrayList<Pryl> prylar = new ArrayList<Pryl>();
    private String namn;
    
    public Person(String namn){
	this.namn = namn;
    }
    
    public void addPryl(Pryl ny){
	prylar.add(ny);
    }
    
    public String getNamn(){
	return namn;
    }
    
    public int summaVärde(){
	int summa = 0;
	for (Pryl p : prylar)
	    summa+=p.värde();
	    return summa;
	}
    
    public void visaPrylar(){
	for (Pryl p : prylar)
	    System.out.println(p.getpNamn()+"        "+p.värde());
    }
    
    public void börskrasch(){
	for (Pryl p : prylar)
	    if (p instanceof Aktie)
		((Aktie)p).börskrasch();
    }

}
