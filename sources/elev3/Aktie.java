class Aktie{
	private String namn;
	private int antal;
	private double varde;
	Aktie(String namn, int antal, double varde){
		this.namn=namn;
		this.antal=antal;
		this.varde=varde;
	}
	void j_varde(double nyttpris){
		this.varde=nyttpris;
	}
	public double retvarde(){
		double val=varde*antal;
		return val;
	}
}