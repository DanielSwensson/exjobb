public abstract class Pryl{

	private String pNamn;
	
	private String ptyp;
	
	public Pryl(String pNamn, String ptyp){
			
			this.pNamn=pNamn;
			this.ptyp=ptyp;
			}
	
	
		public Pryl(String pNamn, String ptyp, int antalStenar, String material, int varde){
    		
			this.pNamn=pNamn;
			this.ptyp=ptyp;
			
			varde=varde;
			antalStenar=antalStenar;
			material=material;
	
    }
    
   
    
    public abstract  int getValue();
    
    
    
    public String toString(){
    	return ptyp+", värde: "+getValue()+" :- ";
    }
	
	}



