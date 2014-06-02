
public abstract class GURPS {
	
	private int techLevel;
	
	public void setTechLevel(int newTechLevel){
		this.techLevel = newTechLevel;
	}
	
	public int getTechLevel(){
		int techLevel = this.techLevel;
		return techLevel;
	}
	
	public GURPS(){
		
	}
	
	public GURPS(int techLevel){
		this.techLevel = techLevel;
	}
	

}
