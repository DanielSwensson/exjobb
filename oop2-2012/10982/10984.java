
class Apparat extends Pryl {
	
	private String pNamn;
	private int ink�pspris;
	private int slitage;
	
	public Apparat(String pNamn, int ink�pspris, int slitage){
		this.pNamn = pNamn;
		this.ink�pspris = ink�pspris;
		this.slitage = slitage;
	}
	
	public String getpNamn(){
		return pNamn;
	}
	
	public void setSlitage(int slitage){
		this.slitage = slitage;
	}
	
	public int v�rde(){
		return ink�pspris*slitage/10;
	}

}
