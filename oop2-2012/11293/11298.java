
public class VolumeMeasurement extends Measurement{
	
	private double mlEquivalent;
	
	public void setMlEquivalent(double db){
		mlEquivalent = db;
	}
	
	public double getEquivalent(){
		return mlEquivalent;
	}
	
	public VolumeMeasurement(String ut, double corr){
		super(ut);
		setMlEquivalent(corr);
	}
	
}
