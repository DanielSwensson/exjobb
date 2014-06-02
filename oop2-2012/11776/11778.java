

abstract public class Thing {

	protected String name;

	public Thing(String name){
		this.name = name;
	}
	
	public String toString(){
		return name + " " +getValue();
	}
	
	public abstract double getValue();
}
