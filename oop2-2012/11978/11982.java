class Pryl{

	private String pNamn;
	protected double v�rde;

	public Pryl (String pNamn){
		this.pNamn = pNamn;
	}

	public String getPNamn(){
		return pNamn;
	}

	public double getV�rde(){
		return v�rde;
	}

	public String toString(){
		return (pNamn+" "+v�rde);
	}
}