public abstract class Pryl{
	private String namn;
	
	
	Pryl(String namn){
		this.namn = namn;
	}
	
	public String  visaNamn(){
		return namn;
	}
	
	public abstract int visaVärde();
	
		
	
	public String toString(){
		return namn;
	}
}