
public abstract class Gadget {
	
	private String name;
	
	public Gadget(String gadgetName){
		name = gadgetName;
	}
	public String getName(){
		return name;
	}
	public abstract double getValue();
	
	public String toString(){
		return name + "\t" + getValue() + "\n" ;
	}
	
}
