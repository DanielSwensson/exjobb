
public class WeightMeasurement extends Measurement{

	private double gramsEquivalent;
	
	public void setGramsEquivalent(double db){
		gramsEquivalent = db;
	}
	
	public double getEquivalent(){
		return gramsEquivalent;
	}
	
	public WeightMeasurement(String ut, double corr){
		super(ut);
		setGramsEquivalent(corr);
	}
	
}
