
public class Smycke extends Pryl {
	private int antalstenar;
	private String material; 
	    
	    
	    public Smycke(String na, int antalstenar, String material){
	        super(na);
	        this.antalstenar=antalstenar;
	        this.material=material;
	        setV�rde();
	    }
	  
	    public void setV�rde(){
				if(material.equalsIgnoreCase("ja"))
					v�rde=2000+antalstenar*500;
				else 
					if(material.equalsIgnoreCase("nej"))
						v�rde=500+antalstenar*500;
	    }
}
