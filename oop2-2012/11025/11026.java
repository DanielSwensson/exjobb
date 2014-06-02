class Apparat extends Pryl {
	private int slitageGrad;
	private int inköpspris;
	private String namnApparat;
	
	
	
	Apparat(String namn, String namnApparat, int slitageGrad, int inköpspris){
		super(namn);
		this.namnApparat = namnApparat;
		this.slitageGrad = slitageGrad;
		this.inköpspris = inköpspris;
	}
	
	public String visaNamn(){
		return namnApparat;
	}
	
	public int visaSlitageGrad(){
		return slitageGrad;
	}
	
	public int visaInköpspris(){
		return inköpspris;
	}
	
	public int visaPris(int nyPris){
		inköpspris = nyPris;
		return inköpspris;
	}
	
	public int visaVärde() {
		int värde = inköpspris * slitageGrad / 10;
		return värde;
	}
	
	public String toString() {
		return namnApparat + " " + visaVärde(); 
	
	}
	
	


}