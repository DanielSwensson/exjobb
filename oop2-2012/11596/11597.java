package inluppZoo;

import java.util.*;

public class Baboon extends Animal{

	Random rand = new Random();
	String colorBack = null;
	private int colorBackInt = 0;
	
	//Konstruktor för babianobjekt
	public Baboon(String name, int age, String gender){
		super(name, age, gender, "Babian");
		colorBackInt = rand.nextInt(4); //Slumpar ett tal mellan 0-3
		if (colorBackInt >= 2) { //Hälften av alla babianer får röd rumpa
			colorBack = "Röd";
		} else if (colorBackInt == 1){ // 1/4 av babianerna får lila rumpa
			colorBack = "Lila";
		} else { //Resterande 1/4 av babianerna får blå rumpa
			colorBack = "Blå";
		}
	}
	
	//Babianernas överskuggande happinessFood-metod
	public void happinessFood(){
		happiness += 2; //Babianer får +2 istället för +1 glädje vid matning
		if (happiness > MAXHAPPINESS){
			happiness = MAXHAPPINESS;
		}
	}
	
	//Babianernas överskuggande getBabies-metod
	public static int getBabies(){
		numBabies = 2; //Babianer får 2 ungar istället för 1
		return numBabies;
	}
	
	//Babianobjektens toString-metod som används vid utskrift av babianer
	public String toString(){
		String text = "Art: " + species + "\nNamn: " + name + "\nÅlder: " + age + "\nRumpfärg: " + colorBack + 
				"\nKön: " + gender + "\nGlädje: " + happiness + "\n";
		return text;
	}
	
}
