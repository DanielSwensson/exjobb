class Smycke extends Pryl {
	private String namnSmycke;
	private int antal�ldelsten;
	private String metalSlag;
	
	Smycke(String namn, String namnSmycke, int antal�ldelsten, String metalSlag){	
		super(namn);
		this.namnSmycke = namnSmycke;
		this.antal�ldelsten = antal�ldelsten;
		this.metalSlag = metalSlag;
	
	}
	
	public String visaNamn(){
		return namnSmycke;
	}
	
	public int visaAntal�ldelsten(){
		return antal�ldelsten;
	}
	
	public String visaMetalSlag(){
		return metalSlag;
	}
	
	public int visaV�rde(){
		
		int v�rde1 = antal�ldelsten * 500;
		if (metalSlag.equalsIgnoreCase("guld")){
			final int V�RDE2 = 2000;
			int v�rde = v�rde1 + V�RDE2;
			return v�rde;
		}
				
		if (metalSlag.equalsIgnoreCase("silver")){
			final int V�RDE3 = 700;
			int v�rde = v�rde1 + V�RDE3;
			return v�rde;
		}
		
		return v�rde1;
	}
	
	public String toString() {
		return namnSmycke + " " + visaV�rde();
	
	}

}