public abstract class Pryl {
	private String prylTyp;
	
	public Pryl(String p){
		prylTyp = p;
	}
	
	public String getPrylTyp(){
		return prylTyp;
	
	}
	public abstract int getVŠrde();
	
	
	
	public String toString(){
		return prylTyp + " " + getVŠrde();
	}

	
}
