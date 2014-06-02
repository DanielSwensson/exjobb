package inluppZoo;

public class Hedgehog extends Animal{
	
	//Konstruktor f�r igelkottobjekt
	public Hedgehog(String name, int age, String gender){
		super(name, age, gender, "Igelkott");
	}
	
	//Igelkottarnas �verskuggande getBabies-metod
	public static int getBabies(){
		numBabies = 3; //Igelkottar f�r 3 barn ist�llet f�r 1
		return numBabies;
	}
	
	//Igelkottsobjektens toString-metod som anv�nds vid utskrift av igelkottar
	public String toString(){
		String text = "Art: " + species + "\nNamn: " + name + "\n�lder: " + age + "\nK�n: " + gender + "\nGl�dje: " + happiness + "\n";
		return text;
	}

}
