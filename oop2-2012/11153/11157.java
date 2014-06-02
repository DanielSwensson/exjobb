import java.util.ArrayList; // import av java arraylist

public class Person{
	
    private String namn;
   
    
    private ArrayList<Pryl> allaSaker = new ArrayList<Pryl>(); // Arraylist skapas
    
    public Person(String namn){ // konstruktor med namn som argument
    	this.namn=namn;
        }
    
    public String getNamn(){ // Metod för att hämta namn
    	return namn;
        }
    
    public void addSak(Pryl pr){ // Metod för att lägga till pryl
        allaSaker.add(pr);
        }
    
    public String getPryl(){ // Metod för att hämta pryl
		String prylar="";
		for(Pryl p : allaSaker){
            prylar+=p.toString();
		}
        return prylar;
        }

    public int getKapital(){  // Metod för att hämta förmögenhet
    	int summa=0;
        for(Pryl p : allaSaker){
        	summa+=p.getVärde();
        }
        return summa;
        }
    
    public void börsKrasch(){ // Metod för att simulera börskrasch
    	for(Pryl p : allaSaker){
            if(p instanceof Aktier)
            	((Aktier)p).börsKrasch();
    	}
        }

    public String toString(){ // retunerar namnet som en sträng
    	return namn;
    	}


        }