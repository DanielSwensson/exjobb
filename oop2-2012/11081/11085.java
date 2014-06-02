import java.io.Serializable; 

public class Player extends Person implements Serializable, Comparable<Player>{

	private String stickHandling;
	private int skateSize;
	private int shirtNumber;
	private int goals;
	private int assist;
	private int totalPoints;
	
	public Player(String firstName, String lastName, int age, double Weight, String stickHandling, int skateSize, int shirtNumber, int goals, int assist, int totalPoints){ //konstruktor, använder this. för att motverka shadowing
	super (firstName, lastName, age, Weight);
	this.stickHandling = stickHandling;
	this.skateSize = skateSize;
	this.shirtNumber = shirtNumber;
	this.goals = goals;
	this.assist = assist;
	this.totalPoints = totalPoints;
	}
	
	public Player(String firstName, String lastName, int age, double Weight, String stickHandling, int skateSize, int shirtNumber){//konstruktor, använder this. för att motverka shadowing
	super (firstName, lastName, age, Weight);
	this.stickHandling = stickHandling;
	this.skateSize = skateSize;
	this.shirtNumber = shirtNumber;
	}
	
	public String getStickHandling(){
	return stickHandling;
	}
	
	public int getSkateSize(){
	return skateSize;
	}
	
	public int getShirtNumber(){
	return shirtNumber;
	}
	
	public int getGoals(){
	return goals;
	}
	
	public int getAssist(){
	return assist;
	}
	
	public int getTotalPoints(){
	return goals + assist;
	}
	
	public void traningCamp(double days){
	setWeight(getWeight() + (days/3));
	}
	
	@Override
	public int compareTo(Player comparePlayer) {
	
	//return fallande(descending) ordning	
	return comparePlayer.getTotalPoints() - this.getTotalPoints();
	
	//return stigande ordning
	//return this.getTotalPoints() - comparePlayer.getTotalPoints();
	}



	public void setAssist() {
	assist++;
	}
	
	public void setGoal(){
	goals++;
	}
	

}