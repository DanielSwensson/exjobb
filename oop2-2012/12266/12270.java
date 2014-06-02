
abstract public class Prylar {

	private String namn;
	
	public Prylar(String namn){
		this.namn = namn;
	}

	public String getNamn(){
		return namn;
	}	 
	 
	abstract public double värde();

	public void krasch() {
		
	}
		
	
}
