
public abstract class Pryl {
	private String namn;
	
	public Pryl(String namn){
		this.namn = namn;
	}
	
	public String getNamn(){
		return namn;
	}
	abstract public double getVärde();
}
