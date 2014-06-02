package inluppZoo;

import java.util.*;

public class Hippo extends Animal{
	
	Random rand = new Random();
	private int numTeeth = 0;
	
	//Konstruktor f�r flodh�stobjekt
	public Hippo(String name, int age, String gender){
		super(name, age, gender, "Flodh�st");
		int numTeeth = rand.nextInt(3); //Slumpar fram ett tal mellan 0-2
		if (numTeeth == 2){ // 1/3 av flodh�starna f�r 3 t�nder
			numTeeth = 3;
		} else { //Resten f�r 4 t�nder
			numTeeth = 4;
		}
	}
	
	//Flodh�stobjektens toString-metod som anv�nds vid utskrift av flodh�star
	public String toString(){
		String text = "Art: " + species + "\nNamn: " + name + "\n�lder: " + age + "\nK�n: " + gender + 
				"\nAntal t�nder: " + numTeeth + "\nGl�dje: " + happiness + "\n";
		return text;
	}

}
