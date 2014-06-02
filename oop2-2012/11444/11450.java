public class Smycken extends Pryl	{
    
private int antalstenar;
private String material; 
    
    
    public Smycken(String na, int antalstenar, String material) 

    {
        super(na);
        this.antalstenar=antalstenar;
        this.material=material;
        setVärde();
    }
  
    public void setVärde(){
			if(material.equalsIgnoreCase("ja"))
				värde=2000+antalstenar*500;
			else 
				if(material.equalsIgnoreCase("nej"))
					värde=500+antalstenar*500;
    }
}  
