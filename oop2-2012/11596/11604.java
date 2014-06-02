package inluppZoo;

import java.util.*;

public class Unicorn extends Animal{
	
	Random rand = new Random();
	int randColor = 0;
	private String color = null;
	
	private String numHornsString = null;
	
	//Konstruktor f�r enh�rningsobjekt
	public Unicorn(String name, int age, String gender){
		super(name, age, gender, "Enh�rning");
		//Slumpar fram en regnb�gsf�rg f�r varje enh�rning
		int randColor = rand.nextInt(7);
		switch(randColor){
			case 0:
				color = "R�d";
				break;
			case 1:
				color = "Orange";
				break;
			case 2:
				color = "Gul";
				break;
			case 3:
				color = "Gr�n";
				break;
			case 4:
				color = "Bl�";
				break;
			case 5:
				color = "Indigo";
				break;
			case 6:
				color = "Violett";
				break;
		}
		int numHorns = rand.nextInt(3);
		//Slumpar fram hur m�nga horn varje enh�rning f�r, ett eller tv�
		if (numHorns == 2) {
			numHorns = 2;
			numHornsString = "2 (Allts� �r det en tv�h�rning!!)";
		} else {
			numHorns = 1;
			numHornsString = "1";
		}
	}
	
	//Enh�rningsobjektens toString-metod som anv�nds vid utskrift av enh�rningar
	public String toString(){
		String text = "Art: " + species + "\nNamn: " + name + "\n�lder: " + age + "\nF�rg: " + color + 
				"\nK�n: " + gender + "\nAntal horn: " + numHornsString + "\nGl�dje: " + happiness + "\n";
		return text;
	}

}
