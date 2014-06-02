
public abstract class Measurement {

	private String unit;
	abstract public double getEquivalent();
	
	public void setUnit(String u){
		unit = u.trim();
	}
	
	public String getUnit(){
		return unit;
	}
	
	public Measurement (String ut){
		setUnit(ut);
	}	
}

	
