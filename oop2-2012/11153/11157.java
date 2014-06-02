import java.util.ArrayList; // import av java arraylist

public class Person{
	
    private String namn;
   
    
    private ArrayList<Pryl> allaSaker = new ArrayList<Pryl>(); // Arraylist skapas
    
    public Person(String namn){ // konstruktor med namn som argument
    	this.namn=namn;
        }
    
    public String getNamn(){ // Metod f�r att h�mta namn
    	return namn;
        }
    
    public void addSak(Pryl pr){ // Metod f�r att l�gga till pryl
        allaSaker.add(pr);
        }
    
    public String getPryl(){ // Metod f�r att h�mta pryl
		String prylar="";
		for(Pryl p : allaSaker){
            prylar+=p.toString();
		}
        return prylar;
        }

    public int getKapital(){  // Metod f�r att h�mta f�rm�genhet
    	int summa=0;
        for(Pryl p : allaSaker){
        	summa+=p.getV�rde();
        }
        return summa;
        }
    
    public void b�rsKrasch(){ // Metod f�r att simulera b�rskrasch
    	for(Pryl p : allaSaker){
            if(p instanceof Aktier)
            	((Aktier)p).b�rsKrasch();
    	}
        }

    public String toString(){ // retunerar namnet som en str�ng
    	return namn;
    	}


        }