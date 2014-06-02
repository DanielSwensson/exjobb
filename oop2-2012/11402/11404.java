package inlupp2;

public abstract class Gadget {
	private String name;
	
	public Gadget(String na){
		name = na;
	}
	
	public String getName(){
		return name;
	}
	
	protected abstract int value();

	
	
}
