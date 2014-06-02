package inluppZoo;

import java.util.*;

public class MethodsZoo {
	
	
	//Konstanter som anv�nds i metoder
	private static final int MAXELEPHANTS = 10;
	private static final int MAXHIPPOS = 10;
	private static final int MAXBABOONS = 13;
	private static final int MAXHEDGEHOGS = 20;
	private static final int MAXPENGUINS = 30;
	private static final int MAXUNICORNS = 12;
	private static final int MAXTOTALZOOANIMALS = MAXELEPHANTS + MAXHIPPOS + MAXBABOONS + MAXHEDGEHOGS + MAXPENGUINS + MAXUNICORNS;
	
	
	//________________________________________________________________________________
	//Information om zoo't som printas om spelaren vill l�sa
	public static void printInfo(){
		System.out.print("\nV�lkommen till ditt alldeles egna virtuella zoo!\n" +
				"H�r kan du k�pa, s�lja, mata och avla dina djur\n" +
				"Du kan v�lja p� sex olika djurarter:\n" +
				"Elefanter\n" +
				"Flodh�star\n" +
				"Babianer\n" +
				"Igelkottar\n" +
				"Pignviner\n" +
				"Enh�rningar\n" +
				"Du kan �ven lista dina djur n�r som helst f�r att se hur m�nga du har, \noch kanske uppt�cka en �verraskning eller tv� om dem!\n");
	}
	
	
	//________________________________________________________________________________
	//Metod f�r att r�kna hur m�nga man har av varje enskild art
	private static int countAnimals(ArrayList<Animal> animalList, String animal){
		int numAnimals = 0;
		for(Animal aktuell : animalList){ //Loopar igenom alla objekten i arraylistan
			switch(animal){
				case "elephant": //R�knar elefanter
					if (aktuell instanceof Elephant){
						++numAnimals;
					}
					break;
				case "hippo": //R�knar flodh�star
					if (aktuell instanceof Hippo){
						++numAnimals;
					}
					break;
				case "baboon": //R�knar babianer
					if (aktuell instanceof Baboon){
						++numAnimals;
					}
					break;
				case "hedgehog": //R�knar igelkottar
					if (aktuell instanceof Hedgehog){
						++numAnimals;
					}
					break;
				case "penguin": //R�knar pingviner
					if (aktuell instanceof Penguin){
						++numAnimals;
					}
					break;
				case "unicorn": //R�knar enh�rningar
					if (aktuell instanceof Unicorn){
						++numAnimals;
					}
					break;
				}
				
			}
		return numAnimals; //Returnerar antalet av valt djur att r�kna
		}
	

	//__________________________________________________________________________________
	//Metod f�r meny-valet att v�lja vilken djurart man vill g�ra n�got med
	public static String chooseAnimal(Scanner keyboard){
		String animal = null;
		int counter = 0;
		while(counter == 0){ //Om counter inte r�knas upp (dvs ett giltigt val inte har skrivits in) kommer programmet forts�tta printa menyn och v�nta p� val
			System.out.println("1. Elefant \n2. Flodh�st \n3. Babian \n4. Igelkott \n5. Pingvin \n6. Enh�rning"); //Menyn
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
	//Metod som registrerar namnval p� djur
	private static String registerName(Scanner keyboard){
		System.out.print("Namn: ");
		String name = keyboard.nextLine();
		return name;
	}
	
	//Metod som registrerar �ldersval p� djur
	private static int registerAge(Scanner keyboard){
		int age = 0;
		for ( ; ; ) { //En evig for-loop om ett break ej anges
			try {
				System.out.print("�lder: ");
				age = Integer.parseInt(keyboard.nextLine()); //int m�ste g�ras till en Integer f�r att catch skall fungera
				if (age < 0){
					System.out.print("Ett djur kan inte ha en negativ �lder!\n");
				} else {
					break;
				}
			} catch (NumberFormatException e) { //Om input ej �r en integer f�ngas felet h�r
				System.out.print("Ogiltigt input - m�ste vara en siffra\n");
			}
		}
		return age;
	}
	
	//Metod som registrerar k�nsval p� djur
	private static String registerGender(Scanner keyboard){
		String gender = null;
		boolean x = true;
		while(x){
			System.out.print("K�n (f/m): ");
			gender = keyboard.nextLine();
			if (gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("m")){ //Kontrollerar att giltigt k�n skrivs in
				x = false;
			} else {
				System.out.print("Ej giltigt k�n\n");
			}
		}
		return gender;
	}
	
	
	//_______________________________________________________________________________
	//Metoder som skapar djur
	//Metod som skapar elefantobjekt
	private static void createElephant(String name, int age, String gender, Scanner keyboard, ArrayList<Animal> animalList){
		name = registerName(keyboard); //Registrerar namn
		age = registerAge(keyboard); //Registrerar �lder
		gender = registerGender(keyboard); //Registrerar k�n
		Animal a = new Elephant(name, age, gender); //Skapar djurobjekt
		animalList.add(a); //L�gger till djurobjektet i arraylisten med alla zoo'ts djur
	}
	
	//Metod som skapar flodh�stobjekt
	private static void createHippo(String name, int age, String gender, Scanner keyboard, ArrayList<Animal> animalList){
		name = registerName(keyboard); //Registrerar namn
		age = registerAge(keyboard); //Registrerar �lder
		gender = registerGender(keyboard); //Registrerar k�n
		Animal a = new Hippo(name, age, gender); //Skapar djurobjekt
		animalList.add(a); //L�gger till djurobjektet i arraylisten med alla zoo'ts djur
	}
	
	//Metod som skapar babianobjekt
	private static void createBaboon(String name, int age, String gender, Scanner keyboard, ArrayList<Animal> animalList){
		name = registerName(keyboard); //Registrerar namn
		age = registerAge(keyboard); //Registrerar �lder
		gender = registerGender(keyboard); //Registrerar k�n
		Animal a = new Baboon(name, age, gender); //Skapar djurobjekt
		animalList.add(a); //L�gger till djurobjektet i arraylisten med alla zoo'ts djur
	}
	
	//Metod som skapar igelkottobjekt
	private static void createHedgehog(String name, int age, String gender, Scanner keyboard, ArrayList<Animal> animalList){
		name = registerName(keyboard); //Registrerar namn
		age = registerAge(keyboard); //Registrerar �lder
		gender = registerGender(keyboard); //Registrerar k�n
		Animal a = new Hedgehog(name, age, gender); //Skapar djurobjekt
		animalList.add(a); //L�gger till djurobjektet i arraylisten med alla zoo'ts djur
	}
	
	//Metod som skapar pingvinobjekt
	private static void createPenguin(String name, int age, String gender, Scanner keyboard, ArrayList<Animal> animalList){
		name = registerName(keyboard); //Registrerar namn
		age = registerAge(keyboard); //Registrerar �lder
		gender = registerGender(keyboard); //Registrerar k�n
		Animal a = new Penguin(name, age, gender); //Skapar djurobjekt
		animalList.add(a); //L�gger till djurobjektet i arraylisten med alla zoo'ts djur
	}
	
	//Metod som skapar enh�rningsobjekt
	private static void createUnicorn(String name, int age, String gender, Scanner keyboard, ArrayList<Animal> animalList){
		name = registerName(keyboard); //Registrerar namn
		age = registerAge(keyboard); //Registrerar �lder
		gender = registerGender(keyboard); //Registrerar k�n
		Animal a = new Unicorn(name, age, gender); //Skapar djurobjekt
		animalList.add(a); //L�gger till djurobjektet i arraylisten med alla zoo'ts djur
	}
	
	
	//________________________________________________________________________________
	//Metod f�r att k�pa ett djur
	public static void buyAnimal(String animal, ArrayList<Animal> animalList, Scanner keyboard){
		String name = null;
		int age = 0;
		String gender = null;
		int num = 0;
		switch(animal){
		case "elephant":
			num = countAnimals(animalList, animal);
			if (num < MAXELEPHANTS){ //Kontrollerar om maxantalet av djuret �r uppn�tt. Om det �r kan ej fler av det djuret k�pas
				createElephant(name, age, gender, keyboard, animalList);
			} else {
				System.out.println("Det f�r inte plats fler elefanter i inh�gnaden. Du kan inte k�pa fler.");
			}
			break;
		case "hippo":
			num = countAnimals(animalList, animal);
			if (num < MAXHIPPOS){
				createHippo(name, age, gender, keyboard, animalList);
			} else {
				System.out.println("Det f�r inte plats fler flodh�star i inh�gnaden. Du kan inte k�pa fler.");
			}
			break;
		case "baboon":
			num = countAnimals(animalList, animal);
			if (num < MAXBABOONS){
				createBaboon(name, age, gender, keyboard, animalList);
			} else {
				System.out.println("Det f�r inte plats fler babianer i inh�gnaden. Du kan inte k�pa fler.");
			}
			break;
		case "hedgehog":
			num = countAnimals(animalList, animal);
			if (num < MAXHEDGEHOGS) {
				createHedgehog(name, age, gender, keyboard, animalList);
			} else {
				System.out.println("Det f�r inte plats fler igelkottar i inh�gnaden. Du kan inte k�pa fler.");
			}
			break;
		case "penguin":
			num = countAnimals(animalList, animal);
			if (num < MAXPENGUINS) {
				createPenguin(name, age, gender, keyboard, animalList);
			} else {
				System.out.println("Det f�r inte plats fler pignviner i inh�gnaden. Du kan inte k�pa fler.");
			}
			break;
		case "unicorn":
			num = countAnimals(animalList, animal);
			if (num < MAXUNICORNS) {
				createUnicorn(name, age, gender, keyboard, animalList);
			} else {
				System.out.println("Det f�r inte plats fler enh�rningar i inh�gnaden. Du kan inte k�pa fler.");
			}
			break;
	}
	}
	
	
	
	//________________________________________________________________________________________
	//Metoder f�r att s�lja/ta bort djur ur listan/zoo't
	private static void removeAnimalText(ArrayList<Animal> animalList, String checkName, int index){
		animalList.remove(index); //Tar bort valt djur ur listan
		System.out.println(checkName + " har s�lts\n"); //Utskrift
	}
	
	//Metod f�r val av djur att ta bort/s�lja
	public static void removeAnimal(ArrayList<Animal> animalList, String nameRemoveAnimal, String animal){
		int counter = 0;
		int index = 0;
		int arrayLength1 = animalList.size();
		if (arrayLength1 == 0){ //Kontrollerar om det finns djur i zoo't/listan
			System.out.println("Haha! Zoo't �r tomt! Gick du p� den luringen?\n");
		} else {
			for(Animal aktuell : animalList){ //Loopar igenom alla objekten i arraylistan
				String checkName = animalList.get(index).getName(); //F�r tag p� varje objekts namn en i taget
				if(checkName.equalsIgnoreCase(nameRemoveAnimal)){ //Kollar om objektets namn �r samma som namnet p� djuret vi vill ta bort
					switch(animal){ //Kontrollerar om det namn vi angett �r r�tt sorts djur
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
					if (arrayLength2 != arrayLength1){ //For-loopen break:ar n�r listan �r slut/alla objekt i listan g�tts igenom
						break;							//Utan denna if-sats f�r vi ett ConcurrentModificationException
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
	//Metoder f�r att mata djur
	private static int feedAnimalText(Animal aktuell, int counter){
		aktuell.happinessFood(); //L�gger till r�tt gl�dje vid matning f�r aktuell djurart
		counter++;
		return counter;
	}
	
	//Metod f�r val av djurar att mat
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
					animalPlural = "flodh�star";
					animalChoice = "flodh�starna";
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
					animalPlural = "enh�rningar";
					animalChoice = "enh�rningarna";
					if (aktuell instanceof Unicorn){
						counter = feedAnimalText(aktuell, counter);
					}
					break;
			}
				
		}
		if(counter == 0){ //Om counter �r 0 finns det inga djur att mata
			System.out.println("Det finns inga " + animalPlural + " att mata");
		} else {
			System.out.println("Du har matat " + animalChoice + "!");
		}
	}

	
	
	//__________________________________________________________________________________________
	//Metoder f�r att avla djur
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
					if (aktuell instanceof Elephant){ //Kontrollerar r�tt djur
						animalCounter++;
						String gender = aktuell.getGender(); //H�mtar k�n
						if (gender.equals("f")){ //R�knar hur m�nga djur av varje k�n
							femaleCounter++;
						} else {
							maleCounter++;
						}
					}
					break;
				case "hippo":
					animalPlural = "flodh�star";
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
					animalPlural = "enh�rningar";
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
		//Kontrollerar om maxantalet djur �r uppn�tt. �r det det g�r det inte att avla
		maxAnimalsBreedingCheck(femaleCounter, maleCounter, animalPlural, arrayLength, animalList, keyboard, animalCounter);
	}
	
	
	//Kontrollerar om maxantalet djur uppn�tt innan avel
	private static void maxAnimalsBreedingCheck(int femaleCounter, int maleCounter, String animalPlural, int arrayLength, ArrayList<Animal> animalList, Scanner keyboard, int animalCounter){
		switch(animalPlural){
			case "elefanter":
				if(animalCounter < MAXELEPHANTS){
					//Om maxantal djur ej uppn�tt s� avlas djur
					breedAnimalsText(femaleCounter, maleCounter, animalPlural, arrayLength, animalList, keyboard);
				} else {
					System.out.print("Det finns redan" + MAXELEPHANTS + " elefanter. Du f�r inte avla, det �r f�r tr�ngt i inh�gnaden\n");
				}
				break;
			case "flodh�star":
				if(animalCounter < MAXHIPPOS){
					breedAnimalsText(femaleCounter, maleCounter, animalPlural, arrayLength, animalList, keyboard);
				} else {
					System.out.print("Det finns redan " + MAXHIPPOS + " flodh�star. Du f�r inte avla, det �r f�r tr�ngt i inh�gnaden\n");
				}
				break;
			case "babianer":
				if(animalCounter < MAXBABOONS){
					breedAnimalsText(femaleCounter, maleCounter, animalPlural, arrayLength, animalList, keyboard);
				} else {
					System.out.print("Det finns redan " + MAXBABOONS + " babianer. Du f�r inte avla, det �r f�r tr�ngt i inh�gnaden\n");
				}
				break;
			case "igelkottar":
				if(animalCounter < MAXHEDGEHOGS){
					breedAnimalsText(femaleCounter, maleCounter, animalPlural, arrayLength, animalList, keyboard);
				} else {
					System.out.print("Det finns redan " + MAXHEDGEHOGS + " igelkottar. Du f�r inte avla, det �r f�r tr�ngt i inh�gnaden\n");
				}
				break;
			case "pingviner":
				if(animalCounter < MAXPENGUINS){
					breedAnimalsText(femaleCounter, maleCounter, animalPlural, arrayLength, animalList, keyboard);
				} else {
					System.out.print("Det finns redan " + MAXPENGUINS + " pingviner. Du f�r inte avla, det �r f�r tr�ngt i inh�gnaden\n");
				}
				break;
			case "enh�rningar":
				if(animalCounter < MAXUNICORNS){
					breedAnimalsText(femaleCounter, maleCounter, animalPlural, arrayLength, animalList, keyboard);
				} else {
					System.out.print("Det finns redan " + MAXUNICORNS + " enh�rningar. Du f�r inte avla, det �r f�r tr�ngt i inh�gnaden\n");
				}
				break;
		}
	}
	
	//Metod som kontrollerar att det finns minst ett djur av varje k�n av det djur man vill avla. Finns inte b�da g�r det ej att avla
	private static void breedAnimalsText(int femaleCounter, int maleCounter, String animalPlural, int arrayLength, ArrayList<Animal> animalList, Scanner keyboard){
		if (femaleCounter > 0 && maleCounter > 0){ //Finns minst en av varje k�n g�r det att avla
			System.out.println("Du har avlat " + animalPlural + "!");
			createBabies(animalPlural, animalList, keyboard); //Metoden som avlar/skapar nya djur fr�n avel
		} else if (femaleCounter == 0 || maleCounter == 0){
			if (femaleCounter > 0){ //Om det bara finns honor av djuret
				System.out.println("G�r inte att avla. Det finns endast hon"  + animalPlural);
			} else if (maleCounter > 0){ //Om det bara finns hanar av djuret
				System.out.println("G�r inte att avla. Det finns endast han"  + animalPlural);
			}
		} 
		if (femaleCounter == 0 && maleCounter == 0) { //Om det inte finns n�gra djur alls av arten
			System.out.println("Det finns inga " + animalPlural + " i zoo't att avla med");
		}
	}
	
	//Metoden som skapar nya djur/barn fr�n aveln
	private static void createBabies(String animalPlural, ArrayList<Animal> animalList, Scanner keyboard){
		String name = null;
		int age = 0;
		String gender = null;
		int babies = 0;
			switch (animalPlural){
				case "elefanter":
					babies = Animal.getBabies(); //H�mtar det antal barn som aktuella djuret kan f�
					for (int i = 0 ; i < babies ; i++) {
						createElephant(name, age, gender, keyboard, animalList);
					}
					break;
				case "flodh�star":
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
				case "enh�rningar":
					babies = Animal.getBabies();
					for (int i = 0 ; i < babies ; i++) {
						createUnicorn(name, age, gender, keyboard, animalList);
					}
					break;
			}
	}
	
	
	
	//_________________________________________________________________________________
	//Metoder f�r att lista alla djur p� sk�rmen
	private static int listAnimalsText(Animal aktuell, int counter){
		System.out.println(aktuell + "\n"); //Skriver ut aktuella objektet
		counter++;
		return counter;
	}
	
	//Metod f�r val av r�tt djurart att lista
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
					animalPlural = "flodh�star";
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
					animalPlural = "enh�rningar";
					if (aktuell instanceof Unicorn){
						counter = listAnimalsText(aktuell, counter);
					}
					break;
				}
				
			}
		if(counter == 0){ //Om counter �r 0 finns det inga djur
			System.out.println("Det finns inga " + animalPlural + " i zoo't");
		}
	}

	
	
	//_____________________________________________________________________________________
	//Metod f�r att kontrollera om spelaren vunnit spelet
	public static boolean checkVictory(ArrayList<Animal> animalList, String animal){
		int animalCounter = animalList.size();
		boolean ret = false;
		
		if (animalCounter == MAXTOTALZOOANIMALS){ //Om zoo't �r fyllt till max har spelaren vunnit spelet
			System.out.print("\nDu har vunnit! Ditt zoo �r fullt!\n See you next time!");
			ret = true;
		}
		return ret;
	}
	
	
}
