 public class Apparat extends Pryl{
	
	 
	 	private int slitage;

		private int varde;
	 	private int pris;

	
	public Apparat(String apNamn, String aptyp, int pris, int slitage){
		super(apNamn, aptyp);
		
		this.pris=pris;
		this.slitage=slitage;
		}


    public int getValue(){
   		return varde=pris * slitage/10;
   	}

}
