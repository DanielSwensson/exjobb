public abstract class Pryl {
	private String prylTyp;
	
	public Pryl(String p){
		prylTyp = p;
	}
	
	public String getPrylTyp(){
		return prylTyp;
	
	}
	public abstract int getV�rde();
	
	
	
	public String toString(){
		return prylTyp + " " + getV�rde();
	}

	
}
