package inluppZoo;

import java.util.*;

public class InluppZoo {
	
	
	public static void main (String[] args){
		ArrayList<Animal> animalList = new ArrayList<Animal>(); //Skapar en ny ArrayList "animalList" som skall fyllas med objekt "Animal"
		Scanner keyboard = new Scanner(System.in); //Skapar en ny Scanner "keyboard"
		
		System.out.print("Välkommen till zoo't! \nVill du ha information om vad du kan göra här? (j/n) ");
		String info = keyboard.nextLine();
		System.out.println("");
		if (info.equalsIgnoreCase("j")){ //equalsIgnoreCase ser till att det inte spelar någon roll om user skriver in stora eller små bokstäver
			MethodsZoo.printInfo(); //Går in i paketet "inluppZoo" och letar upp klassen "MethodsZoo" och kör metoden "printInfo()" om spelaren väljer "j"
		} else {
			System.out.println("Vi tolkar det som ett 'nej'\n"); //Alla andra input tolkas som "nej"
		}
		
		while(true){
			//Menyval vad man vill gör i spelet/sitt zoo
			int totalNumAnimals = animalList.size();
			System.out.println("\n1. Köpa djur \n2. Sälja djur \n3. Mata djur \n4. Avla djur \n5. Lista djur \n6. Avsluta");
			String choice = keyboard.nextLine();
			String animal = null;
			switch(choice){ //Switch med valen
				case "1":
					//Köpa djur
					animal = MethodsZoo.chooseAnimal(keyboard);
					MethodsZoo.buyAnimal(animal, animalList, keyboard);
					break;
				case "2":
					//Sälja djur
					animal = MethodsZoo.chooseAnimal(keyboard);
					System.out.print("Namn på djur att sälja: ");
					String nameRemoveAnimal = keyboard.nextLine();
					MethodsZoo.removeAnimal(animalList, nameRemoveAnimal, animal);
					break;
				case "3":
					//Mata djur, om det finns djur i zoo't
					if (totalNumAnimals > 0){
						animal = MethodsZoo.chooseAnimal(keyboard);
						MethodsZoo.feedAnimal(animalList, animal);
					} else {
						System.out.print("Det finns inga djur att mata\n");
					}
					break;
				case "4":
					//Avla djur, om det finns djur i zoo't
					if (totalNumAnimals > 0){
						animal = MethodsZoo.chooseAnimal(keyboard);
						MethodsZoo.breedAnimals(animalList, animal, keyboard);
					} else {
						System.out.print("Det finns inga djur i zoo't att avla med\n");
					}
					break;
				case "5":
					//Lista djur (alla djur i zoo't eller en enskild art)
					if (totalNumAnimals > 0){
						System.out.print("Vill du lista alla djur eller en enskild art? (alla/en) ");
						String listChoice = keyboard.nextLine();
						if (listChoice.equalsIgnoreCase("en")){ //Listar alla djur av enskild art
							animal = MethodsZoo.chooseAnimal(keyboard);
							MethodsZoo.listAnimals(animalList, animal);
						} else if (listChoice.equalsIgnoreCase("alla")) { //Listar alla djur i zoo't samt hur många djur man har
							System.out.println("\n" + animalList + "\n" + "Det finns " + totalNumAnimals + " djur totalt i ditt zoo");
						} else {
							System.out.println("Felaktigt kommando\n");
						}
					} else {
						System.out.println("\n" + "Det finns inga djur i ditt zoo\n");
					}
					break;
				case "6":
					//Avslutar spelet (utan att spara)
					System.exit(0);
					break;
				default:
					System.out.println("Ogiltigt val\n");
			}
			
			//Om spelaren vunnit avslutas spelet
			boolean victory = MethodsZoo.checkVictory(animalList, animal);
			if (victory == true){
				System.exit(0);
			}
			
		}
		
	}

}
