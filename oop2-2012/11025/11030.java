class Smycke extends Pryl {
	private String namnSmycke;
	private int antalÄldelsten;
	private String metalSlag;
	
	Smycke(String namn, String namnSmycke, int antalÄldelsten, String metalSlag){	
		super(namn);
		this.namnSmycke = namnSmycke;
		this.antalÄldelsten = antalÄldelsten;
		this.metalSlag = metalSlag;
	
	}
	
	public String visaNamn(){
		return namnSmycke;
	}
	
	public int visaAntalÄldelsten(){
		return antalÄldelsten;
	}
	
	public String visaMetalSlag(){
		return metalSlag;
	}
	
	public int visaVärde(){
		
		int värde1 = antalÄldelsten * 500;
		if (metalSlag.equalsIgnoreCase("guld")){
			final int VÄRDE2 = 2000;
			int värde = värde1 + VÄRDE2;
			return värde;
		}
				
		if (metalSlag.equalsIgnoreCase("silver")){
			final int VÄRDE3 = 700;
			int värde = värde1 + VÄRDE3;
			return värde;
		}
		
		return värde1;
	}
	
	public String toString() {
		return namnSmycke + " " + visaVärde();
	
	}

}