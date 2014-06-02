package inluppZoo;

public class Penguin extends Animal{
	
	//Konstruktor för pingvinobjekt
	public Penguin(String name, int age, String gender){
		super(name, age, gender, "Penguin");
	}
	
	//Pingvinobjektens toString-metod som används vid utskrift av pingviner
	public String toString(){
		String text = "Art: " + species + "\nNamn: " + name + "\nÅlder: " + age + "\nKön: " + gender + "\nGlädje: " + happiness + "\n";
		return text;
	}

}
