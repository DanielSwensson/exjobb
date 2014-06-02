
class Apparat extends Pryl {
	
	private String pNamn;
	private int inköpspris;
	private int slitage;
	
	public Apparat(String pNamn, int inköpspris, int slitage){
		this.pNamn = pNamn;
		this.inköpspris = inköpspris;
		this.slitage = slitage;
	}
	
	public String getpNamn(){
		return pNamn;
	}
	
	public void setSlitage(int slitage){
		this.slitage = slitage;
	}
	
	public int värde(){
		return inköpspris*slitage/10;
	}

}
