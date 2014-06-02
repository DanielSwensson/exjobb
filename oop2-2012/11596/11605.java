package inluppZoo;

abstract public class Animal {
	
	//Gemensamma variabler f�r alla djur. Varje individuellt djur har egna v�rden p� variablerna, f�rutom konstanten
	protected String name;
	protected int age;
	protected String gender;
	protected int happiness;
	protected String species;
	protected static int numBabies;
	protected final int MAXHAPPINESS = 10;
	
	//Konstruktor f�r skapandet av ett djurobjekt
	public Animal(String name, int age, String gender, String species){
		this.name = name;
		this.age = age;
		this.gender = gender;
		happiness = 0;
		this.species = species;
	}
	
	//Metod f�r att f� tag p� ett djurs namn f�r kontroll vid f�rs�ljning
	public String getName(){
		return name;
	}
	
	//Metod f�r att f� tag p� djurs k�n f�r kontroll vid avel
	public String getGender(){
		return gender;
	}
	
	//Metod f�r att l�gga till r�tt gl�dje vi matning. Babianer har en �verskuggande happinessFood-metod
	public void happinessFood(){
		happiness += 1;
		if (happiness > MAXHAPPINESS){ //Kontrollerar om djur har maximal gl�dje eller �ver
			happiness = MAXHAPPINESS; //Om ett djur har �ver maximal gl�dje s�tts gl�djen till maxgl�djen
		}
	}
	
	//Metod f�r att returnera r�tt antal barn vid avel. Igelkottar och babianer har �verskuggande getBabies-metoder
	public static int getBabies(){
		numBabies = 1;
		return numBabies;
	}
	
	//Visar att varje djurart har en egen toString-metod som letas upp av programmet vid listning
	abstract public String toString();

}
