import java.util.ArrayList;

public class Person{
	
    private String name;

    
    private ArrayList<Pryl> allaPrylar = new ArrayList<Pryl>();
    
    public Person(String name){
    	this.name=name;
    }
    
    public String getName(){
    	return name;
    }
    
    public void addPryl(Pryl pry){
        allaPrylar.add(pry);
    }
    
    public String getPryl(){
		String prylar="";
		for(Pryl p : allaPrylar){
            prylar+=p.toString();
		}
        return prylar;
    }

   
    
    public int getCash(){ 
    	int sum=0;
        for(Pryl pr : allaPrylar){
        	sum+=pr.getValue();
        }
        return sum;
    }
    
 

    public String toString(){
    	return name;
    		}
  
    
    public void stockMcrash(){
    	for(Pryl pry : allaPrylar){
            if(pry instanceof Aktie)
            	((Aktie)pry).stockMcrash();
    		}
        }

}