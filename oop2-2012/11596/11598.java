package inluppZoo;

import java.util.*;

public class Elephant extends Animal{
	
	Random rand = new Random(); //Skapar ett Random-objekt som används vid bestämning av antal snablar 
	private int numTrunks = 0;
	
	//Konstruktor för elefant-objekt
	public Elephant(String name, int age, String gender){
		super(name, age, gender, "Elefant"); //Anropar superklassen "Animal"s konstruktor
		int randTrunks = rand.nextInt(3); //Slumpar fram en siffra mellan 0-2
		if (randTrunks == 2) { //Om slumpad siffra är 2 får elefanten 2 snablar, dvs 1/3 eller 33,33% av alla elefanter har 2 snablar 
			numTrunks = 2;
		} else { //Resterande elefanter, 2/3, får 1 snabel
			numTrunks = 1;
		}	
	}
	
	//Elefantobjektens toString-metod för utskrift av elefanter
	public String toString(){
		String text = "Art: " + species + "\nNamn: " + name + "\nÅlder: " + age + "\nSnablar: " + numTrunks + 
				"\nKön: " + gender + "\nGlädje: " + happiness + "\n";
		return text;
	}

}
