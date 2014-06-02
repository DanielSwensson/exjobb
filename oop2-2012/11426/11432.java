
public abstract class Valuable {

	//attributes:
	private String typeOfValuable, name;
	
	//constructor:
	public Valuable(String typeOfValuable, String name){
	this.typeOfValuable = typeOfValuable;
	this.name = name;
	}

	//methods:
	abstract public double calculateValue();
	
	public String getTypeOfValuable() {
		return typeOfValuable;
	}
	
	public String getName(){
		return name;
	} 
	
	public String toString(){
		return name + "\t" + calculateValue();
	}
	
}
