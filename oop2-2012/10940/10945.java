abstract class Pryl {
	private String prylNamn;

	public Pryl(String prylNamn){
		this.prylNamn = prylNamn;
	}

	public String getPrylNamn(){
		return prylNamn;
	}
	

	abstract public double getV�rde();
	
		  public String toString(){
		    	return prylNamn+", v�rde: "+getV�rde()+ "\n";
		  }
	}
	

