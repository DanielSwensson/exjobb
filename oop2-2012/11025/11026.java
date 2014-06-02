class Apparat extends Pryl {
	private int slitageGrad;
	private int ink�pspris;
	private String namnApparat;
	
	
	
	Apparat(String namn, String namnApparat, int slitageGrad, int ink�pspris){
		super(namn);
		this.namnApparat = namnApparat;
		this.slitageGrad = slitageGrad;
		this.ink�pspris = ink�pspris;
	}
	
	public String visaNamn(){
		return namnApparat;
	}
	
	public int visaSlitageGrad(){
		return slitageGrad;
	}
	
	public int visaInk�pspris(){
		return ink�pspris;
	}
	
	public int visaPris(int nyPris){
		ink�pspris = nyPris;
		return ink�pspris;
	}
	
	public int visaV�rde() {
		int v�rde = ink�pspris * slitageGrad / 10;
		return v�rde;
	}
	
	public String toString() {
		return namnApparat + " " + visaV�rde(); 
	
	}
	
	


}