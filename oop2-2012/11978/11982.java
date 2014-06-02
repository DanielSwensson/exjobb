class Pryl{

	private String pNamn;
	protected double värde;

	public Pryl (String pNamn){
		this.pNamn = pNamn;
	}

	public String getPNamn(){
		return pNamn;
	}

	public double getVärde(){
		return värde;
	}

	public String toString(){
		return (pNamn+" "+värde);
	}
}