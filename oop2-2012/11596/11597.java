package inluppZoo;

import java.util.*;

public class Baboon extends Animal{

	Random rand = new Random();
	String colorBack = null;
	private int colorBackInt = 0;
	
	//Konstruktor f�r babianobjekt
	public Baboon(String name, int age, String gender){
		super(name, age, gender, "Babian");
		colorBackInt = rand.nextInt(4); //Slumpar ett tal mellan 0-3
		if (colorBackInt >= 2) { //H�lften av alla babianer f�r r�d rumpa
			colorBack = "R�d";
		} else if (colorBackInt == 1){ // 1/4 av babianerna f�r lila rumpa
			colorBack = "Lila";
		} else { //Resterande 1/4 av babianerna f�r bl� rumpa
			colorBack = "Bl�";
		}
	}
	
	//Babianernas �verskuggande happinessFood-metod
	public void happinessFood(){
		happiness += 2; //Babianer f�r +2 ist�llet f�r +1 gl�dje vid matning
		if (happiness > MAXHAPPINESS){
			happiness = MAXHAPPINESS;
		}
	}
	
	//Babianernas �verskuggande getBabies-metod
	public static int getBabies(){
		numBabies = 2; //Babianer f�r 2 ungar ist�llet f�r 1
		return numBabies;
	}
	
	//Babianobjektens toString-metod som anv�nds vid utskrift av babianer
	public String toString(){
		String text = "Art: " + species + "\nNamn: " + name + "\n�lder: " + age + "\nRumpf�rg: " + colorBack + 
				"\nK�n: " + gender + "\nGl�dje: " + happiness + "\n";
		return text;
	}
	
}
