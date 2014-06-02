package inluppZoo;

import java.util.*;

public class Unicorn extends Animal{
	
	Random rand = new Random();
	int randColor = 0;
	private String color = null;
	
	private String numHornsString = null;
	
	//Konstruktor för enhörningsobjekt
	public Unicorn(String name, int age, String gender){
		super(name, age, gender, "Enhörning");
		//Slumpar fram en regnbågsfärg för varje enhörning
		int randColor = rand.nextInt(7);
		switch(randColor){
			case 0:
				color = "Röd";
				break;
			case 1:
				color = "Orange";
				break;
			case 2:
				color = "Gul";
				break;
			case 3:
				color = "Grön";
				break;
			case 4:
				color = "Blå";
				break;
			case 5:
				color = "Indigo";
				break;
			case 6:
				color = "Violett";
				break;
		}
		int numHorns = rand.nextInt(3);
		//Slumpar fram hur många horn varje enhörning får, ett eller två
		if (numHorns == 2) {
			numHorns = 2;
			numHornsString = "2 (Alltså är det en tvåhörning!!)";
		} else {
			numHorns = 1;
			numHornsString = "1";
		}
	}
	
	//Enhörningsobjektens toString-metod som används vid utskrift av enhörningar
	public String toString(){
		String text = "Art: " + species + "\nNamn: " + name + "\nÅlder: " + age + "\nFärg: " + color + 
				"\nKön: " + gender + "\nAntal horn: " + numHornsString + "\nGlädje: " + happiness + "\n";
		return text;
	}

}
