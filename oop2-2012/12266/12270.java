
abstract public class Prylar {

	private String namn;
	
	public Prylar(String namn){
		this.namn = namn;
	}

	public String getNamn(){
		return namn;
	}	 
	 
	abstract public double v�rde();

	public void krasch() {
		
	}
		
	
}
