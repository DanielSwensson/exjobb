class Aktie extends Pryl{

	private int antalAktie;
	private int prisPerAktie;
	private String namnAktie;
	
	
	Aktie(String namn, String namnAktie, int antalAktie, int prisPerAktie){
		super(namn);
		this.namnAktie = namnAktie;
		this.antalAktie = antalAktie;
		this.prisPerAktie = prisPerAktie;
	}
	
	public String visaNamn(){
		return namnAktie;
	}
	
	public int visaAntalAktie(){
		return antalAktie;
	}
	
	public int visaPrisPerAktie(){
		return prisPerAktie;
	}
	
	public void ändraPris(int nyPris){
		prisPerAktie = nyPris;
		
	}
	
	public int visaVärde(){
		int värde = antalAktie * prisPerAktie;
		return värde;
	}
	
	public String toString() {
		return namnAktie + " " + visaVärde();
	
	}
	
}