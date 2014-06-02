package inluppZoo;

import java.util.*;

public class Hippo extends Animal{
	
	Random rand = new Random();
	private int numTeeth = 0;
	
	//Konstruktor för flodhästobjekt
	public Hippo(String name, int age, String gender){
		super(name, age, gender, "Flodhäst");
		int numTeeth = rand.nextInt(3); //Slumpar fram ett tal mellan 0-2
		if (numTeeth == 2){ // 1/3 av flodhästarna får 3 tänder
			numTeeth = 3;
		} else { //Resten får 4 tänder
			numTeeth = 4;
		}
	}
	
	//Flodhästobjektens toString-metod som används vid utskrift av flodhästar
	public String toString(){
		String text = "Art: " + species + "\nNamn: " + name + "\nÅlder: " + age + "\nKön: " + gender + 
				"\nAntal tänder: " + numTeeth + "\nGlädje: " + happiness + "\n";
		return text;
	}

}
