
//	OOP Inlämningsuppgift 2
//	Prylregister
//	Jonas Ask , 760818-0035

import java.io.*;

public abstract class Valueable implements Serializable{
	
	private String name;
	private String typeOfThing;
	
	public Valueable(String name, String type){
		this.name = name;
		this.typeOfThing = type;
	}
	
	abstract public int getValue();
	
	public String getTypeOfThing(){
		return typeOfThing;
	}
	
	public String getName(){
		return name;
	}
	
	public String toString(){
		return name;
	}
}
