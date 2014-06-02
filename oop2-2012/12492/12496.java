package Inlupp2;
import java.util.ArrayList;

public class Person {
	String name;

	ArrayList <Valuable> owns = new ArrayList<Valuable>();

	Person (String name){
		this.name=name;
	}
	public void setName(String newName){
		name = newName;
	}

	public String getName(){
		return name;
	}


	public void addThing(Valuable newThing){
		owns.add(newThing);

	}
	public String toString (){
		return name;
	}

	// Ger totalvärdet på personens värdesaker.
	public double getTotalWorth(){
		double	totalWorth=0;
		for (int x=0; x<owns.size(); x++){

			totalWorth=totalWorth + owns.get(x).getWorth();
		}
		return totalWorth;
	}
	// Visar personens värdesaker.
	public void getAllValuables(){

		for (int x=0; x<owns.size(); x++){
			System.out.println(owns.get(x).toString());	
		}

	}

	// Startar börskrasch och sätter aktiepriset till 0 på alla nuvarande aktier.
	public void stockMarketCrash(){   
		for (int x=0; x<owns.size(); x++){
			if (owns.get(x) instanceof Stock){
				((Stock)owns.get(x)).setPrice(0);
			}
		}
	}
}

