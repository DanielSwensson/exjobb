abstract class Pryl {
	private String prylNamn;

	public Pryl(String prylNamn){
		this.prylNamn = prylNamn;
	}

	public String getPrylNamn(){
		return prylNamn;
	}
	

	abstract public double getVärde();
	
		  public String toString(){
		    	return prylNamn+", värde: "+getVärde()+ "\n";
		  }
	}
	

