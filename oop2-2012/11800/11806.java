
public class Smycke extends Prylar {
	int värde;
	
	public Smycke (String namn,int sten, String metal){
		super(namn);
		 
		this.sten=sten;
		this.metal=metal;
		
		if (metal.equalsIgnoreCase("ja"))
			
			this.värde = 2000 + sten * 500;
		else if (metal.equalsIgnoreCase("nej"))
			this.värde =700 + sten * 500;
		
		}

	private int sten;
	private String metal;

	 
 

	 public int värde(){
return värde;
		
	
		
}


	}

