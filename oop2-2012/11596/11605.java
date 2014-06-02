package inluppZoo;

abstract public class Animal {
	
	//Gemensamma variabler för alla djur. Varje individuellt djur har egna värden på variablerna, förutom konstanten
	protected String name;
	protected int age;
	protected String gender;
	protected int happiness;
	protected String species;
	protected static int numBabies;
	protected final int MAXHAPPINESS = 10;
	
	//Konstruktor för skapandet av ett djurobjekt
	public Animal(String name, int age, String gender, String species){
		this.name = name;
		this.age = age;
		this.gender = gender;
		happiness = 0;
		this.species = species;
	}
	
	//Metod för att få tag på ett djurs namn för kontroll vid försäljning
	public String getName(){
		return name;
	}
	
	//Metod för att få tag på djurs kön för kontroll vid avel
	public String getGender(){
		return gender;
	}
	
	//Metod för att lägga till rätt glädje vi matning. Babianer har en överskuggande happinessFood-metod
	public void happinessFood(){
		happiness += 1;
		if (happiness > MAXHAPPINESS){ //Kontrollerar om djur har maximal glädje eller över
			happiness = MAXHAPPINESS; //Om ett djur har över maximal glädje sätts glädjen till maxglädjen
		}
	}
	
	//Metod för att returnera rätt antal barn vid avel. Igelkottar och babianer har överskuggande getBabies-metoder
	public static int getBabies(){
		numBabies = 1;
		return numBabies;
	}
	
	//Visar att varje djurart har en egen toString-metod som letas upp av programmet vid listning
	abstract public String toString();

}
