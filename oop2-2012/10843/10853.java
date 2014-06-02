import java.util.*;
import java.io.*;

public class MainProgram {
	ArrayList<Character> allCharacters = new ArrayList<Character>();
	Scanner keyboard = new Scanner(System.in);
	AddItem addItem = new AddItem();
	ReadInput ri = new ReadInput();

	
	Character getCharacter (String name){
		for (Character c : allCharacters){
			if (c.getName().equalsIgnoreCase(name))
				return c;
		}
		return null;
	}
	
	void createCharacter (){
		boolean characterCreated = false;
		do {
			String name = ri.readString("Enter character name(exit to return to main menu): ");
			if(name.equalsIgnoreCase("exit")){
				characterCreated = true;
			}else{
				Character c = getCharacter(name);
				if (c!=null){
					System.out.println("That name is allready taken.\nPlease try again.");
				}else{
					Character newCharacter = new Character(name);
					allCharacters.add(newCharacter);
					characterCreated = true;
					System.out.println("Character created!");
				}
			}
		}
		while(!characterCreated);
	}
	
	
	void createItem(){
		//Code to create an item and give it to a character
		boolean ok = false;
		do 	{
			showAllCharacters();
			String characterName = ri.readString("Enter the name of the character which item it is(exit to return to main menu): ");
			Character c = getCharacter(characterName);
			if(characterName.equalsIgnoreCase("exit")){
				ok = true;
			}else {
				if (c!=null){
					boolean askAgain = true;
					while(askAgain){
						int choice = ri.readInt("Choices.\n1: Item.\n2: Armor.\n3: Weapon.\n4: Exit to main menu:\nChoose which kind of Item you want to create(enter the number 1-4): ");
						switch (choice){
						case 1:
							boolean askAgainItem = true;
							while(askAgainItem){
								int itemChoice = ri.readInt("1: Create an item.\n2: Return to itemtype menu.\n3: Exit to main menu.\nEnter a number 1-3.");
								switch (itemChoice){
								case 1:
									addItem.createItem(c);
									askAgain = false;
									askAgainItem = false;
									break;
								case 2:
									askAgainItem = false;
									break;
								case 3:
									askAgain = false;
									askAgainItem = false;
									break;
								default:
									System.out.println("Wrong command. Should be a numeric value (1-3).");
								}
							}
							break;

						case 2:
							boolean askAgainArmor = true;
							while(askAgainArmor){				
								int armorChoice = ri.readInt("Which kind of Armor?\n1: Head armor.\n2: Chest armor.\n3: Leg armor.\n4: Shield.\n5: Return to itemtype menu.\n6: Exit to main menu.\nEnter the number 1-6.");
								switch (armorChoice){
								case 1:
									addItem.createHeadArmor(c);
									askAgain = false;
									askAgainArmor = false;
									break;
								case 2:
									addItem.createChestArmor(c);
									askAgain = false;
									askAgainArmor = false;
									break;
								case 3:
									addItem.createLegArmor(c);
									askAgain = false;
									askAgainArmor = false;
									break;
								case 4:
									addItem.createShield(c);
									askAgain = false;
									askAgainArmor = false;
									break;
								case 5:
									askAgainArmor = false;
									break;
								case 6:
									askAgain = false;
									askAgainArmor = false;
									break;
								default:
									System.out.println("Please enter a numeric number (1-4). ");
								}
							}
							break;

						case 3:
							boolean askAgainWeapon = true;
							while(askAgainWeapon){
								int weaponChoice = ri.readInt("Which kind of weapon?\n1: Axe.\n2: Mace.\n3: Sword.\n4: Return to itemtype menu.\n5: Exit to main menu.\nEnter the number 1-5");
								switch (weaponChoice){
								case 1:
									addItem.createAxe(c);
									askAgain = false;
									askAgainWeapon = false;
									break;
								case 2:
									addItem.createMace(c);
									askAgain = false;
									askAgainWeapon = false;
									break;
								case 3:
									addItem.createSword(c);
									askAgain = false;
									askAgainWeapon = false;
									break;
								case 4:
									askAgainWeapon = false;
									break;
								case 5:
									askAgain = false;
									askAgainWeapon = false;
									break;
								default:
									System.out.println("Please enter a numeric number (1-4). ");
								}
							}
							break;
						case 4:
							askAgain = false;
							break;
						default:
							System.out.println("Please enter a numeric number (1-3). ");

						} //Switch
					} //Whileloop
				}else {
					System.out.println("No character with that name exists. Please enter a new name.");
				}
				ok = true; // Closes the Do-WhileLoop
			}
		}
		while(!ok);
	} //CreateItem

	void showAllCharacters(){
		System.out.println("All characters:");
		for (int x=0; x<allCharacters.size(); x++){
			System.out.println(allCharacters.get(x));
		}
	}
	
	void showAllItems(){
		//Code to show all items for a character
		boolean ok = false;
		do {
			String name = ri.readString("Enter the name of the character which items you want to see(exit to return to main menu): ");
			Character c = getCharacter(name);
			if (c!=null){
				c.showAllItems();
				ok = true;
			}else{
				System.out.println("No character with that name exists, please enter a new one.");
			}
			if(name.equalsIgnoreCase("exit")){
				ok = true;
			}
			
		}
		while(!ok);
	}
	
	void showCharacter (){
		boolean showCharacter = false;
		do {
			String name = ri.readString("Enter the name of the character you want to display(exit to return to main menu): ");
			Character c = getCharacter(name);
			if (c != null){
				System.out.println(c);
				System.out.println("Damage: "+c.getDamage()+"\nDefense: "+c.getDefense());
				System.out.println("Total Value of all items: "+c.getTotalValue());
				showCharacter = true;
			}
			else{
				System.out.println("No character with that name exists.");
			}
			if(name.equalsIgnoreCase("exit")){
				showCharacter = true;
			}
		}
		while(!showCharacter);
	}
	
	void equipItem(){
		boolean ok = false;
		do {
			showAllCharacters();
			String name = ri.readString("Choose which character(exit to return to main menu): ");
			Character c = getCharacter(name);
			if(name.equalsIgnoreCase("exit")){
				ok = true;
			}else{
				if (c != null){

					boolean itemExists = false;
					do {
						c.showAllItems();
						String itemName = ri.readString("Choose which item to equip (exit to return to main menu):");
						if(itemName.equalsIgnoreCase("exit")){
							itemExists = true;
							ok = true;
						}else{
							Item i = c.getItem(itemName);
							if(i!=null){
								c.equipItem(itemName);
								itemExists = true;
								ok = true;
							}
							if (itemExists){
								System.out.println("the item "+itemName+" has been equiped by "+c.getName());
							}else{
								System.out.println(c.getName()+" doesn't own a item with that name, please choose a new one.");
							}
						}
					}
					while(!itemExists);
				}
			}
		}
		while(!ok);
	}
	
	void showEquipment(){
		boolean ok = false;
		do {
			String name = ri.readString("Choose which characters equipment to list:");
			Character c = getCharacter(name);
			if(c!=null){	
				c.showEquipment();
				ok = true;
			}else{
				System.out.println("No character with that name exists, please enter a new name: ");
			}
			
			if (name.equalsIgnoreCase("exit")){
				ok = true;
			}
		}
		while(!ok);
	}
	
	void saveAndLoad(){
		int choice = ri.readInt("1: Save:\n2: Load:\n3: Return to main menu.\nWhat do you want to do?(answer with 1-3)");
		switch (choice){
		case 1:
//			boolean saveSuccess = false;
//			while(!saveSuccess){
				try{
					FileOutputStream file = new FileOutputStream("Characters.obj");
					ObjectOutputStream out = new ObjectOutputStream(file);
					out.writeObject(allCharacters);
//					saveSuccess = true;
					out.close();
				}
				catch (IOException e){
					System.out.println("The program couldn't write to the file.");
				}
			break;
//			}
		case 2:
//			boolean loadSuccess = false;
//			while(!loadSuccess){
				try{
					FileInputStream file = new FileInputStream("Charactersfile.obj");
					ObjectInputStream in = new ObjectInputStream(file);
					allCharacters = (ArrayList<Character>)in.readObject();
//					loadSuccess = true;
				}
				catch (FileNotFoundException e){
				}
				catch (IOException e){
					System.exit(2);
				}
				catch (ClassNotFoundException e){
					System.exit(3);
				}
//			}
			break;
		case 3:
			break;
		default:
			System.out.println("Wrong command.");
		}
	}
	
	void exitProgram (){ 
		//Closes the program and saves the data to file
		int exit = ri.readInt("Do you really want to exit the program?\n1: Yes\n2: No");
		if(exit == 1){
			//			boolean saveSuccess = false;
			//			while(!saveSuccess){
			try{
				FileOutputStream file = new FileOutputStream("Charactersfile.obj");
				ObjectOutputStream out = new ObjectOutputStream(file);
				out.writeObject(allCharacters);
//				saveSuccess = true;

			}
			catch (IOException e){
				System.out.println("The program couldn't write to the file.");
				System.exit(1);
			}
			//			}
			System.exit(0);
		}else {
			System.out.println("Okey please make a new choice. ");
		}
	}
	
	public static void main(String []args){
		ReadInput ri = new ReadInput();
		MainProgram mp = new MainProgram();
		System.out.println("Hi and welcome.");
		for(;;){
			int choice=ri.readInt("Please chose by entering the correct digit\n1: Create a character:\n2: Create an item and give it to a character:\n3: Show all characters:\n"+
									"4: Show all items for a character:\n5: Show a specific character:\n6: Equip item to a character:\n7: Show all equiped items of a character:\n8: Save and Load:\n9: Exit program:\nMake your choice: ");
			switch (choice){
			case 1: mp.createCharacter(); break;
			case 2: mp.createItem(); break;
			case 3: mp.showAllCharacters(); break;
			case 4: mp.showAllItems(); break;
			case 5: mp.showCharacter(); break;
			case 6: mp.equipItem(); break;
			case 7: mp.showEquipment(); break;
			case 8: mp.saveAndLoad(); break;
			case 9: mp.exitProgram(); break;
			
			default: System.out.println("Wrong command, please try again.");
			} //Switch
			System.out.println();
		} //For-loop
	} //Main
		
	
} //MainProgram

