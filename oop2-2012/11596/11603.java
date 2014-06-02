package inluppZoo;

public class Penguin extends Animal{
	
	//Konstruktor f�r pingvinobjekt
	public Penguin(String name, int age, String gender){
		super(name, age, gender, "Penguin");
	}
	
	//Pingvinobjektens toString-metod som anv�nds vid utskrift av pingviner
	public String toString(){
		String text = "Art: " + species + "\nNamn: " + name + "\n�lder: " + age + "\nK�n: " + gender + "\nGl�dje: " + happiness + "\n";
		return text;
	}

}
