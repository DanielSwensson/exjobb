class Smycke{
	private String namn;
	private int stenar;
	private String metall;
	private double varde;
	Smycke(String namn, int stenar,String metall){
		this.namn=namn;
		this.stenar=stenar;
		varde+=stenar;
		this.metall=metall;
		if (metall.equalsIgnoreCase("guld")){
			varde+=2000;
		}
		else{
			varde+=700;
		}
	}
	public double retvarde(){
		return varde;
	}
}