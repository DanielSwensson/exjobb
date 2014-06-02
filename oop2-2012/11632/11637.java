
public abstract class Pryl {

	private String typAvPryl;	

	public Pryl(String tap){
		typAvPryl = tap;
	}	

	public abstract double getValue();

	public String getTypAvPryl(){
		return typAvPryl;
	}	
}
