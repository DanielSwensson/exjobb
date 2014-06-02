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
	
    public double getPrylvärde(){
    	double prylMängd=0;
		for(Pryl p:allaPrylar){
            prylMängd+=p.getVärde();
		}
        return prylMängd;
    }
    
    public void börskrasch(){
    	for(Pryl p:allaPrylar){
    		if(p instanceof Aktie)
    			((Aktie)p).prisNoll();
    	}
    		
    }
	
    public String toString(){
    	return "Namn: "+namn;
    }
}
