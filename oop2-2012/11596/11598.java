package inluppZoo;

import java.util.*;

public class Elephant extends Animal{
	
	Random rand = new Random(); //Skapar ett Random-objekt som anv�nds vid best�mning av antal snablar 
	private int numTrunks = 0;
	
	//Konstruktor f�r elefant-objekt
	public Elephant(String name, int age, String gender){
		super(name, age, gender, "Elefant"); //Anropar superklassen "Animal"s konstruktor
		int randTrunks = rand.nextInt(3); //Slumpar fram en siffra mellan 0-2
		if (randTrunks == 2) { //Om slumpad siffra �r 2 f�r elefanten 2 snablar, dvs 1/3 eller 33,33% av alla elefanter har 2 snablar 
			numTrunks = 2;
		} else { //Resterande elefanter, 2/3, f�r 1 snabel
			numTrunks = 1;
		}	
	}
	
	//Elefantobjektens toString-metod f�r utskrift av elefanter
	public String toString(){
		String text = "Art: " + species + "\nNamn: " + name + "\n�lder: " + age + "\nSnablar: " + numTrunks + 
				"\nK�n: " + gender + "\nGl�dje: " + happiness + "\n";
		return text;
	}

}
