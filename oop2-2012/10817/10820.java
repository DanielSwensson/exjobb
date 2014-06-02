import java.util.ArrayList;

public class Person {
	
	private ArrayList<Pryl> allaPrylar = new ArrayList<Pryl>();

	private String namn;
	
	public Person(String str1){
		namn=str1;
	}
	
	public String getNamn(){
		return namn;
	}
	public void addPryl(Pryl p){
		allaPrylar.add(p);
	}
	
    public String getPryl(){
		String prylar="";
		for(Pryl p:allaPrylar){
            prylar+=p+"\n";
		}
        return prylar;
    }
	
    public double getPrylv�rde(){
    	double prylM�ngd=0;
		for(Pryl p:allaPrylar){
            prylM�ngd+=p.getV�rde();
		}
        return prylM�ngd;
    }
    
    public void b�rskrasch(){
    	for(Pryl p:allaPrylar){
    		if(p instanceof Aktie)
    			((Aktie)p).prisNoll();
    	}
    		
    }
	
    public String toString(){
    	return "Namn: "+namn;
    }
}
