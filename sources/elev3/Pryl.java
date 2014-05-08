class Pryl{
	private String namn;
	private double pris;
	private double slit;
	private double varde;
	Pryl(String namn, double pris, double slit){
		this.namn=namn;
		this.pris=pris;
		this.slit=slit;
		this.varde=pris*slit/10;
	}
	public double Retvarde(){
		return varde;
	}
}