package inluppZoo;

public class Hedgehog extends Animal{
	
	//Konstruktor för igelkottobjekt
	public Hedgehog(String name, int age, String gender){
		super(name, age, gender, "Igelkott");
	}
	
	//Igelkottarnas överskuggande getBabies-metod
	public static int getBabies(){
		numBabies = 3; //Igelkottar får 3 barn istället för 1
		return numBabies;
	}
	
	//Igelkottsobjektens toString-metod som används vid utskrift av igelkottar
	public String toString(){
		String text = "Art: " + species + "\nNamn: " + name + "\nÅlder: " + age + "\nKön: " + gender + "\nGlädje: " + happiness + "\n";
		return text;
	}

}
