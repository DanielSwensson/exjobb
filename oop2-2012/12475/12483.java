import java.io.*;
public abstract class Thing implements Serializable{
	protected String name = "";
	protected double value = 0.0;
	public Thing(String name, double value){
		this.name  = name;
		this.value = value;
	}
	public abstract double getValue();
	public String getName(){
		return this.name;
	}
}

