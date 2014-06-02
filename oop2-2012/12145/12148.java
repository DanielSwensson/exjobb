import java.util.ArrayList;


public class Person {

	private String name;
	private ArrayList<Pryl> register = new ArrayList<Pryl>();
	
	public Person(String name){
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void add(Pryl p) { 
	//
		register.add(p);
	

	}

	public String toString(){
		return name + "\t" + getKapital();
		//ska skriva ut personens totalvärde
	}
	
	public int getKapital(){
		int summa=0;
	    for(Pryl p : register){
	    		summa+=p.getValue(); 
	    }
	    
	return summa;
    }
	public String print(){
		String alla=this.name + "\n";
		for(Pryl p : register){
			alla+=p.toString() + "\n";
		}
		
		return alla;
	}
	
	
	public void börsKrasch(){
		
	    for(Pryl p : register){
	     if(p instanceof Aktie)
	     ((Aktie)p).setPris(0);
	    }
	}
}
	
