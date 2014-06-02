public class Smycke extends Pryl{
    
	
	private String material;
	private int v;

	private int varde;
	private int antalStenar;
    		
	public Smycke(String sNamn, String styp, int antalStenar, String material){
    			super(sNamn, styp);
    		
    		
    			this.antalStenar=antalStenar;
    			this.material=material;
    		 
   
   	}
   	
   	public int getValue(){
   		

		if(material.equalsIgnoreCase("guld")){
	     v=2000;
				}
	
	else if(material.equalsIgnoreCase("silver")){
				v=700;
			}	
   		
   		return varde= v+antalStenar * 500;
   	
   	}

   	
}


