
public class Weight {
	private double weightInKG;
	
	public String toString(){
		String returnString =
			"Weight: " + weightInKG  
			;
		return returnString;
	}
	public Weight(double weightInKG){
		this.weightInKG = weightInKG;
	}
	
	public double getWeightInKG(){
		return this.weightInKG;
	}
	  
}
