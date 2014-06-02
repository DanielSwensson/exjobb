import java.io.Serializable;


public class Coach extends Person implements Serializable{

	private String position;
	
	public Coach (String firstName, String lastName, int age, double weight, String position){
	super (firstName, lastName, age, weight);
	this.position = position;
	}
	
	public String getPosition(){
	return position;
	}
	
	public void traningCamp(double days){
	setWeight(getWeight() + days/2);
	}
}