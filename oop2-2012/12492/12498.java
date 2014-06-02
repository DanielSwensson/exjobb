package Inlupp2;

public abstract class Valuable {

	private String name;


	public Valuable (String name){
		this.name=name;
	}

	public abstract double getWorth();

	public String toString (){
		return name+" " + getWorth();
	}

}
