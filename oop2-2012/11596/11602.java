package inluppZoo;

import java.util.*;

public class MethodsZoo {
	
	
	//Konstanter som används i metoder
	private static final int MAXELEPHANTS = 10;
	private static final int MAXHIPPOS = 10;
	private static final int MAXBABOONS = 13;
	private static final int MAXHEDGEHOGS = 20;
	private static final int MAXPENGUINS = 30;
	private static final int MAXUNICORNS = 12;
	private static final int MAXTOTALZOOANIMALS = MAXELEPHANTS + MAXHIPPOS + MAXBABOONS + MAXHEDGEHOGS + MAXPENGUINS + MAXUNICORNS;
	
	
	//________________________________________________________________________________
	//Information om zoo't som printas om spelaren vill läsa
	public static void printInfo(){
		System.out.print("\nVälkommen till ditt alldeles egna virtuella zoo!\n" +
				"Här kan du köpa, sälja, mata och avla dina djur\n" +
				"Du kan välja på sex olika djurarter:\n" +
				"Elefanter\n" +
				"Flodhästar\n" +
				"Babianer\n" +
				"Igelkottar\n" +
				"Pignviner\n" +
				"Enhörningar\n" +
				"Du kan även lista dina djur när som helst för att se hur många du har, \noch kanske upptäcka en överraskning eller två om dem!\n");
	}
	
	
	//________________________________________________________________________________
	//Metod för att räkna hur många man har av varje enskild art
	private static int countAnimals(ArrayList<Animal> animalList, String animal){
		int numAnimals = 0;
		for(Animal aktuell : animalList){ //Loopar igenom alla objekten i arraylistan
			switch(animal){
				case "elephant": //Räknar elefanter
					if (aktuell instanceof Elephant){
						++numAnimals;
					}
					break;
				case "hippo": //Räknar flodhästar
					if (aktuell instanceof Hippo){
						++numAnimals;
					}
					break;
				case "baboon": //Räknar babianer
					if (aktuell instanceof Baboon){
						++numAnimals;
					}
					break;
				case "hedgehog": //Räknar igelkottar
					if (aktuell instanceof Hedgehog){
						++numAnimals;
					}
					break;
				case "penguin": //Räknar pingviner
					if (aktuell instanceof Penguin){
						++numAnimals;
					}
					break;
				case "unicorn": //Räknar enhörningar
					if (aktuell instanceof Unicorn){
						++numAnimals;
					}
					break;
				}
				
			}
		return numAnimals; //Returnerar antalet av valt djur att räkna
		}
	

	//__________________________________________________________________________________
	//Metod för meny-valet att välja vilken djurart man vill göra något med
	public static String chooseAnimal(Scanner keyboard){
		String animal = null;
		int counter = 0;
		while(counter == 0){ //Om counter inte räknas upp (dvs ett giltigt val inte har skrivits in) kommer programmet fortsätta printa menyn och vänta på val
			System.out.println("1. Elefant \n2. Flodhäst \n3. Babian \n4. Igelkott \n5. Pingvin \n6. Enhörning"); //Menyn
			String choice = keyboard.nextLine();
				switch (choice){
					case "1":
						animal = "elephant";
						counter++;
						break;
					case "2":
						animal = "hippo";
						counter++;
						break;
					case "3":
						animal = "baboon";
						counter++;
						break;
					case "4":
						animal = "hedgehog";
						counter++;
						break;
					case "5":
						animal = "penguin";
						counter++;
						break;
					case "6":
						animal = "unicorn";
						counter++;
						break;
					default:
						System.out.println("Ogiltigt val\n");
				}
		}
		
		return animal; //Returnerar valet av djur
	}
	
	
	
	//_______________________________________________________________________
	//Metod som registrerar namnval på djur
	private static String registerName(Scanner keyboard){
		System.out.print("Namn: ");
		String name = keyboard.nextLine();
		return name;
	}
	
	//Metod som registrerar åldersval på djur
	private static int registerAge(Scanner keyboard){
		int age = 0;
		for ( ; ; ) { //En evig for-loop om ett break ej anges
			try {
				System.out.print("Ålder: ");
				age = Integer.parseInt(keyboard.nextLine()); //int måste göras till en Integer för att catch skall fungera
				if (age < 0){
					System.out.print("Ett djur kan inte ha en negativ ålder!\n");
				} else {
					break;
				}
			} catch (NumberFormatException e) { //Om input ej är en integer fångas felet här
				System.out.print("Ogiltigt input - måste vara en siffra\n");
			}
		}
		return age;
	}
	
	//Metod som registrerar könsval på djur
	private static String registerGender(Scanner keyboard){
		String gender = null;
		boolean x = true;
		while(x){
			System.out.print("Kön (f/m): ");
			gender = keyboard.nextLine();
			if (gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("m")){ //Kontrollerar att giltigt kön skrivs in
				x = false;
			} else {
				System.out.print("Ej giltigt kön\n");
			}
		}
		return gender;
	}
	
	
	//_______________________________________________________________________________
	//Metoder som skapar djur
	//Metod som skapar elefantobjekt
	private static void createElephant(String name, int age, String gender, Scanner keyboard, ArrayList<Animal> animalList){
		name = registerName(keyboard); //Registrerar namn
		age = registerAge(keyboard); //Registrerar ålder
		gender = registerGender(keyboard); //Registrerar kön
		Animal a = new Elephant(name, age, gender); //Skapar djurobjekt
		animalList.add(a); //Lägger till djurobjektet i arraylisten med alla zoo'ts djur
	}
	
	//Metod som skapar flodhästobjekt
	private static void createHippo(String name, int age, String gender, Scanner keyboard, ArrayList<Animal> animalList){
		name = registerName(keyboard); //Registrerar namn
		age = registerAge(keyboard); //Registrerar ålder
		gender = registerGender(keyboard); //Registrerar kön
		Animal a = new Hippo(name, age, gender); //Skapar djurobjekt
		animalList.add(a); //Lägger till djurobjektet i arraylisten med alla zoo'ts djur
	}
	
	//Metod som skapar babianobjekt
	private static void createBaboon(String name, int age, String gender, Scanner keyboard, ArrayList<Animal> animalList){
		name = registerName(keyboard); //Registrerar namn
		age = registerAge(keyboard); //Registrerar ålder
		gender = registerGender(keyboard); //Registrerar kön
		Animal a = new Baboon(name, age, gender); //Skapar djurobjekt
		animalList.add(a); //Lägger till djurobjektet i arraylisten med alla zoo'ts djur
	}
	
	//Metod som skapar igelkottobjekt
	private static void createHedgehog(String name, int age, String gender, Scanner keyboard, ArrayList<Animal> animalList){
		name = registerName(keyboard); //Registrerar namn
		age = registerAge(keyboard); //Registrerar ålder
		gender = registerGender(keyboard); //Registrerar kön
		Animal a = new Hedgehog(name, age, gender); //Skapar djurobjekt
		animalList.add(a); //Lägger till djurobjektet i arraylisten med alla zoo'ts djur
	}
	
	//Metod som skapar pingvinobjekt
	private static void createPenguin(String name, int age, String gender, Scanner keyboard, ArrayList<Animal> animalList){
		name = registerName(keyboard); //Registrerar namn
		age = registerAge(keyboard); //Registrerar ålder
		gender = registerGender(keyboard); //Registrerar kön
		Animal a = new Penguin(name, age, gender); //Skapar djurobjekt
		animalList.add(a); //Lägger till djurobjektet i arraylisten med alla zoo'ts djur
	}
	
	//Metod som skapar enhörningsobjekt
	private static void createUnicorn(String name, int age, String gender, Scanner keyboard, ArrayList<Animal> animalList){
		name = registerName(keyboard); //Registrerar namn
		age = registerAge(keyboard); //Registrerar ålder
		gender = registerGender(keyboard); //Registrerar kön
		Animal a = new Unicorn(name, age, gender); //Skapar djurobjekt
		animalList.add(a); //Lägger till djurobjektet i arraylisten med alla zoo'ts djur
	}
	
	
	//________________________________________________________________________________
	//Metod för att köpa ett djur
	public static void buyAnimal(String animal, ArrayList<Animal> animalList, Scanner keyboard){
		String name = null;
		int age = 0;
		String gender = null;
		int num = 0;
		switch(animal){
		case "elephant":
			num = countAnimals(animalList, animal);
			if (num < MAXELEPHANTS){ //Kontrollerar om maxantalet av djuret är uppnått. Om det är kan ej fler av det djuret köpas
				createElephant(name, age, gender, keyboard, animalList);
			} else {
				System.out.println("Det får inte plats fler elefanter i inhägnaden. Du kan inte köpa fler.");
			}
			break;
		case "hippo":
			num = countAnimals(animalList, animal);
			if (num < MAXHIPPOS){
				createHippo(name, age, gender, keyboard, animalList);
			} else {
				System.out.println("Det får inte plats fler flodhästar i inhägnaden. Du kan inte köpa fler.");
			}
			break;
		case "baboon":
			num = countAnimals(animalList, animal);
			if (num < MAXBABOONS){
				createBaboon(name, age, gender, keyboard, animalList);
			} else {
				System.out.println("Det får inte plats fler babianer i inhägnaden. Du kan inte köpa fler.");
			}
			break;
		case "hedgehog":
			num = countAnimals(animalList, animal);
			if (num < MAXHEDGEHOGS) {
				createHedgehog(name, age, gender, keyboard, animalList);
			} else {
				System.out.println("Det får inte plats fler igelkottar i inhägnaden. Du kan inte köpa fler.");
			}
			break;
		case "penguin":
			num = countAnimals(animalList, animal);
			if (num < MAXPENGUINS) {
				createPenguin(name, age, gender, keyboard, animalList);
			} else {
				System.out.println("Det får inte plats fler pignviner i inhägnaden. Du kan inte köpa fler.");
			}
			break;
		case "unicorn":
			num = countAnimals(animalList, animal);
			if (num < MAXUNICORNS) {
				createUnicorn(name, age, gender, keyboard, animalList);
			} else {
				System.out.println("Det får inte plats fler enhörningar i inhägnaden. Du kan inte köpa fler.");
			}
			break;
	}
	}
	
	
	
	//________________________________________________________________________________________
	//Metoder för att sälja/ta bort djur ur listan/zoo't
	private static void removeAnimalText(ArrayList<Animal> animalList, String checkName, int index){
		animalList.remove(index); //Tar bort valt djur ur listan
		System.out.println(checkName + " har sålts\n"); //Utskrift
	}
	
	//Metod för val av djur att ta bort/sälja
	public static void removeAnimal(ArrayList<Animal> animalList, String nameRemoveAnimal, String animal){
		int counter = 0;
		int index = 0;
		int arrayLength1 = animalList.size();
		if (arrayLength1 == 0){ //Kontrollerar om det finns djur i zoo't/listan
			System.out.println("Haha! Zoo't är tomt! Gick du på den luringen?\n");
		} else {
			for(Animal aktuell : animalList){ //Loopar igenom alla objekten i arraylistan
				String checkName = animalList.get(index).getName(); //Får tag på varje objekts namn en i taget
				if(checkName.equalsIgnoreCase(nameRemoveAnimal)){ //Kollar om objektets namn är samma som namnet på djuret vi vill ta bort
					switch(animal){ //Kontrollerar om det namn vi angett är rätt sorts djur
						case "elephant":
							if (aktuell instanceof Elephant){
								removeAnimalText(animalList, checkName, index);
							}
							counter++;
							break;
						case "hippo":
							if (aktuell instanceof Hippo){
								removeAnimalText(animalList, checkName, index);
							}
							counter++;
							break;
						case "baboon":
							if (aktuell instanceof Baboon){
								removeAnimalText(animalList, checkName, index);
							}
							counter++;
							break;
						case "hedgehog":
							if (aktuell instanceof Hedgehog){
								removeAnimalText(animalList, checkName, index);
							}
							counter++;
							break;
						case "penguin":
							if (aktuell instanceof Penguin){
								removeAnimalText(animalList, checkName, index);
							}
							counter++;
							break;
						case "unicorn":
							if (aktuell instanceof Unicorn){
								removeAnimalText(animalList, checkName, index);
							}
							counter++;
							break;
					} 
					int arrayLength2 = animalList.size();
					if (arrayLength2 != arrayLength1){ //For-loopen break:ar när listan är slut/alla objekt i listan gåtts igenom
						break;							//Utan denna if-sats får vi ett ConcurrentModificationException
					}
				}
				index++;
			}
			if (counter == 0){
				System.out.print("Djur med det namnet finns ej\n");
			}
		}
	}
	
	
	
	//______________________________________________________________________________________
	//Metoder för att mata djur
	private static int feedAnimalText(Animal aktuell, int counter){
		aktuell.happinessFood(); //Lägger till rätt glädje vid matning för aktuell djurart
		counter++;
		return counter;
	}
	
	//Metod för val av djurar att mat
	public static void feedAnimal(ArrayList<Animal> animalList, String animal){
		int counter = 0;
		String animalPlural = "djur";
		String animalChoice = null;
		for(Animal aktuell : animalList){ //Loopar igenom alla objekten i arraylistan
			switch(animal){
				case "elephant":
					animalPlural = "elefanter";
					animalChoice = "elefanterna";
					if (aktuell instanceof Elephant){
						counter = feedAnimalText(aktuell, counter);
					}
					break;
				case "hippo":
					animalPlural = "flodhästar";
					animalChoice = "flodhästarna";
					if (aktuell instanceof Hippo){
						counter = feedAnimalText(aktuell, counter);
					}
					break;
				case "baboon":
					animalPlural = "babianer";
					animalChoice = "babianerna";
					if (aktuell instanceof Baboon){
						counter = feedAnimalText(aktuell, counter);
					}
					break;
				case "hedgehog":
					animalPlural = "igelkottar";
					animalChoice = "igelkottarna";
					if (aktuell instanceof Hedgehog){
						counter = feedAnimalText(aktuell, counter);
					}
					break;
				case "penguin":
					animalPlural= "pingviner";
					animalChoice = "pingvinerna";
					if (aktuell instanceof Penguin){
						counter = feedAnimalText(aktuell, counter);
					}
					break;
				case "unicorn":
					animalPlural = "enhörningar";
					animalChoice = "enhörningarna";
					if (aktuell instanceof Unicorn){
						counter = feedAnimalText(aktuell, counter);
					}
					break;
			}
				
		}
		if(counter == 0){ //Om counter är 0 finns det inga djur att mata
			System.out.println("Det finns inga " + animalPlural + " att mata");
		} else {
			System.out.println("Du har matat " + animalChoice + "!");
		}
	}

	
	
	//__________________________________________________________________________________________
	//Metoder för att avla djur
	public static void breedAnimals(ArrayList<Animal> animalList, String animal, Scanner keyboard){
		int arrayLength = animalList.size();
		int femaleCounter = 0;
		int maleCounter = 0;
		int animalCounter = 0;
		String animalPlural = "djur";
		for(Animal aktuell : animalList){ //Loopar igenom alla objekten i arraylistan
			switch(animal){
				case "elephant":
					animalPlural = "elefanter";
					if (aktuell instanceof Elephant){ //Kontrollerar rätt djur
						animalCounter++;
						String gender = aktuell.getGender(); //Hämtar kön
						if (gender.equals("f")){ //Räknar hur många djur av varje kön
							femaleCounter++;
						} else {
							maleCounter++;
						}
					}
					break;
				case "hippo":
					animalPlural = "flodhästar";
					if (aktuell instanceof Hippo){
						animalCounter++;
						String gender = aktuell.getGender();
						if (gender.equals("f")){
							femaleCounter++;
						} else {
							maleCounter++;
						}
					}
					break;
				case "baboon":
					animalPlural = "babianer";
					if (aktuell instanceof Baboon){
						animalCounter++;
						String gender = aktuell.getGender();
						if (gender.equals("f")){
							femaleCounter++;
						} else {
							maleCounter++;
						}
					}
					break;
				case "hedgehog":
					animalPlural = "igelkottar";
					if (aktuell instanceof Hedgehog){
						animalCounter++;
						String gender = aktuell.getGender();
						if (gender.equals("f")){
							femaleCounter++;
						} else {
							maleCounter++;
						}
					}
					break;
				case "penguin":
					animalPlural = "pingviner";
					if (aktuell instanceof Penguin){
						animalCounter++;
						String gender = aktuell.getGender();
						if (gender.equals("f")){
							femaleCounter++;
						} else {
							maleCounter++;
						}
					}
					break;
				case "unicorn":
					animalPlural = "enhörningar";
					if (aktuell instanceof Unicorn){
						animalCounter++;
						String gender = aktuell.getGender();
						if (gender.equals("f")){
							femaleCounter++;
						} else {
							maleCounter++;
						}
					}
					break;
				}
				
			}
		//Kontrollerar om maxantalet djur är uppnått. Är det det går det inte att avla
		maxAnimalsBreedingCheck(femaleCounter, maleCounter, animalPlural, arrayLength, animalList, keyboard, animalCounter);
	}
	
	
	//Kontrollerar om maxantalet djur uppnått innan avel
	private static void maxAnimalsBreedingCheck(int femaleCounter, int maleCounter, String animalPlural, int arrayLength, ArrayList<Animal> animalList, Scanner keyboard, int animalCounter){
		switch(animalPlural){
			case "elefanter":
				if(animalCounter < MAXELEPHANTS){
					//Om maxantal djur ej uppnått så avlas djur
					breedAnimalsText(femaleCounter, maleCounter, animalPlural, arrayLength, animalList, keyboard);
				} else {
					System.out.print("Det finns redan" + MAXELEPHANTS + " elefanter. Du får inte avla, det är för trångt i inhägnaden\n");
				}
				break;
			case "flodhästar":
				if(animalCounter < MAXHIPPOS){
					breedAnimalsText(femaleCounter, maleCounter, animalPlural, arrayLength, animalList, keyboard);
				} else {
					System.out.print("Det finns redan " + MAXHIPPOS + " flodhästar. Du får inte avla, det är för trångt i inhägnaden\n");
				}
				break;
			case "babianer":
				if(animalCounter < MAXBABOONS){
					breedAnimalsText(femaleCounter, maleCounter, animalPlural, arrayLength, animalList, keyboard);
				} else {
					System.out.print("Det finns redan " + MAXBABOONS + " babianer. Du får inte avla, det är för trångt i inhägnaden\n");
				}
				break;
			case "igelkottar":
				if(animalCounter < MAXHEDGEHOGS){
					breedAnimalsText(femaleCounter, maleCounter, animalPlural, arrayLength, animalList, keyboard);
				} else {
					System.out.print("Det finns redan " + MAXHEDGEHOGS + " igelkottar. Du får inte avla, det är för trångt i inhägnaden\n");
				}
				break;
			case "pingviner":
				if(animalCounter < MAXPENGUINS){
					breedAnimalsText(femaleCounter, maleCounter, animalPlural, arrayLength, animalList, keyboard);
				} else {
					System.out.print("Det finns redan " + MAXPENGUINS + " pingviner. Du får inte avla, det är för trångt i inhägnaden\n");
				}
				break;
			case "enhörningar":
				if(animalCounter < MAXUNICORNS){
					breedAnimalsText(femaleCounter, maleCounter, animalPlural, arrayLength, animalList, keyboard);
				} else {
					System.out.print("Det finns redan " + MAXUNICORNS + " enhörningar. Du får inte avla, det är för trångt i inhägnaden\n");
				}
				break;
		}
	}
	
	//Metod som kontrollerar att det finns minst ett djur av varje kön av det djur man vill avla. Finns inte båda går det ej att avla
	private static void breedAnimalsText(int femaleCounter, int maleCounter, String animalPlural, int arrayLength, ArrayList<Animal> animalList, Scanner keyboard){
		if (femaleCounter > 0 && maleCounter > 0){ //Finns minst en av varje kön går det att avla
			System.out.println("Du har avlat " + animalPlural + "!");
			createBabies(animalPlural, animalList, keyboard); //Metoden som avlar/skapar nya djur från avel
		} else if (femaleCounter == 0 || maleCounter == 0){
			if (femaleCounter > 0){ //Om det bara finns honor av djuret
				System.out.println("Går inte att avla. Det finns endast hon"  + animalPlural);
			} else if (maleCounter > 0){ //Om det bara finns hanar av djuret
				System.out.println("Går inte att avla. Det finns endast han"  + animalPlural);
			}
		} 
		if (femaleCounter == 0 && maleCounter == 0) { //Om det inte finns några djur alls av arten
			System.out.println("Det finns inga " + animalPlural + " i zoo't att avla med");
		}
	}
	
	//Metoden som skapar nya djur/barn från aveln
	private static void createBabies(String animalPlural, ArrayList<Animal> animalList, Scanner keyboard){
		String name = null;
		int age = 0;
		String gender = null;
		int babies = 0;
			switch (animalPlural){
				case "elefanter":
					babies = Animal.getBabies(); //Hämtar det antal barn som aktuella djuret kan få
					for (int i = 0 ; i < babies ; i++) {
						createElephant(name, age, gender, keyboard, animalList);
					}
					break;
				case "flodhästar":
					babies = Animal.getBabies();
					for (int i = 0 ; i < babies ; i++) {
						createHippo(name, age, gender, keyboard, animalList);
					}
					break;
				case "babianer":
					babies = Baboon.getBabies();
					for (int i = 0 ; i < babies ; i++) {
						createBaboon(name, age, gender, keyboard, animalList);
					}
					break;
				case "igelkottar":
					babies = Hedgehog.getBabies();
					for (int i = 0 ; i < babies ; i++) {
						createHedgehog(name, age, gender, keyboard, animalList);
					}
					break;
				case "pingviner":
					babies = Animal.getBabies();
					for (int i = 0 ; i < babies ; i++) {
						createPenguin(name, age, gender, keyboard, animalList);
					}
					break;
				case "enhörningar":
					babies = Animal.getBabies();
					for (int i = 0 ; i < babies ; i++) {
						createUnicorn(name, age, gender, keyboard, animalList);
					}
					break;
			}
	}
	
	
	
	//_________________________________________________________________________________
	//Metoder för att lista alla djur på skärmen
	private static int listAnimalsText(Animal aktuell, int counter){
		System.out.println(aktuell + "\n"); //Skriver ut aktuella objektet
		counter++;
		return counter;
	}
	
	//Metod för val av rätt djurart att lista
	public static void listAnimals(ArrayList<Animal> animalList, String animal){
		int counter = 0;
		String animalPlural = "djur";
		for(Animal aktuell : animalList){ //Loopar igenom alla objekten i arraylistan
			switch(animal){
				case "elephant":
					animalPlural = "elefanter";
					if (aktuell instanceof Elephant){
						counter = listAnimalsText(aktuell, counter);
					}
					break;
				case "hippo":
					animalPlural = "flodhästar";
					if (aktuell instanceof Hippo){
						counter = listAnimalsText(aktuell, counter);
					}
					break;
				case "baboon":
					animalPlural = "babianer";
					if (aktuell instanceof Baboon){
						counter = listAnimalsText(aktuell, counter);
					}
					break;
				case "hedgehog":
					animalPlural = "igelkottar";
					if (aktuell instanceof Hedgehog){
						counter = listAnimalsText(aktuell, counter);
					}
					break;
				case "penguin":
					animalPlural = "pingviner";
					if (aktuell instanceof Penguin){
						counter = listAnimalsText(aktuell, counter);
					}
					break;
				case "unicorn":
					animalPlural = "enhörningar";
					if (aktuell instanceof Unicorn){
						counter = listAnimalsText(aktuell, counter);
					}
					break;
				}
				
			}
		if(counter == 0){ //Om counter är 0 finns det inga djur
			System.out.println("Det finns inga " + animalPlural + " i zoo't");
		}
	}

	
	
	//_____________________________________________________________________________________
	//Metod för att kontrollera om spelaren vunnit spelet
	public static boolean checkVictory(ArrayList<Animal> animalList, String animal){
		int animalCounter = animalList.size();
		boolean ret = false;
		
		if (animalCounter == MAXTOTALZOOANIMALS){ //Om zoo't är fyllt till max har spelaren vunnit spelet
			System.out.print("\nDu har vunnit! Ditt zoo är fullt!\n See you next time!");
			ret = true;
		}
		return ret;
	}
	
	
}
