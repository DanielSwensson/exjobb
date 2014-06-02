abstract class Valuable{
	private String name = "";  

	public void setName(String n){
		this.name = n; 
	}

	public String getName(){
		return this.name;
	}
	abstract double getValue();
	
	
}
