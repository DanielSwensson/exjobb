import java.util.ArrayList;

public class Main {
	
	private Input input = new Input();
	private ArrayList<PC> playerCharacters = new ArrayList<PC>();
	private ArrayList<NPC> nonPlayerCharacters = new ArrayList<NPC>();
	
	public Main(){	
	}
	
	private void run(){
		System.out.println("Greetings");

		while (true){
			System.out.println("What funktion do you want to access?");
			System.out.println("1. Registrate a new character.");
			System.out.println("2. Change stats for a character.");
			System.out.println("3. Show a character form the lists.");
			System.out.println("4. Remove a character from the lists.");
			System.out.println("5. Registrate a new item.");		
			System.out.println("6. Change stats for an item.");
			System.out.println("7. Show an item from the lists");			
			System.out.println("8. Remove an item form the lists.");
			System.out.println("9. Exit the program.");
			System.out.println();
	
			switch(input.readInt("Now, make you decision: ")){
				case 1:
					addCharacter();
					break;
				case 2:
					switch(input.readInt("Chose if it is a PC or an NPC." + "\n" + "1. a PC" + "\n" + "2. an NPC")){
						case 1:
							updatePlayerCharacter();
							break;
						case 2:
							updateNonPlayerCharacter();
						}
						break;
				case 3:
					showCharacter();
					break;
				case 4:
					removeCharacter();
					break;
				case 5:
//					create an item
					System.out.println("To be added in a later version" + "\n");
					break;
				case 6:
//					update an item
					System.out.println("To be added in a later version" + "\n");
					break;
				case 7:
//					show an item
					System.out.println("To be added in a later version" + "\n");
					break;
				case 8:
//					remove an item
					System.out.println("To be added in a later version" + "\n");
					break;
				case 9:
					System.exit(0);
				default:
					System.out.println("Incorrect command, try again" + "\n");
			}
		}
		
	}
	
		
	private String choseOwner(){
		do{
			int no = input.readInt("Chose one of the following:" + "\n" + "1. PC" + "\n" + "2. NPC" + "\n" + "Now, what do you want? ");
			if(no == 1){
				return "PC";
			}else if(no == 2){
				return "NPC";
			}else{
				System.out.println("Error, wrong input. Try again");
			}
		}while(true);
	}
	
	private void addCharacter(){
		String Owner = choseOwner();
		if(Owner.equals("PC")){
			String name = input.readString("To create a PC enter the following." + "\n" + "Character name: ");
			String player = input.readString("Owner/Player: ");
			PC pc = new PC(name, player);
			playerCharacters.add(pc);
			System.out.println(name + " has been created, don't forget to give him/her stats." + "\n");
		}else{
			String name = input.readString("To create a NPC enter the following." + "\n" + "Character name: ");
			String gm = input.readString("Owner/Game Master: ");
			NPC npc = new NPC(name, gm);
			nonPlayerCharacters.add(npc);
			System.out.println(name + "  has been created, don't forget to give him/her stats." + "\n");
		}
	}
	
	private void removeCharacter(){
		switch(input.readInt("1. PC" + "\n" + "2. NPC" + "\n" + "Chose what to remove: ")){
		case 1:
			removePlayerCharacter(input.readString("Which character do you want to remove? "));
			break;
		case 2:
			removeNonPlayerCharacter(input.readString("Which character do you want to remove? "));
			break;
		default:
			System.out.println("Error, incorrect command. Try again.");
		}
	}
	
	private void showCharacter(){
		switch(input.readInt("Chose a list to show a character from:" + "\n" + "1. PC" + "\n" + "2. NPC" +"\n" + "Now chose: ")){
		case 1:
			try{
				PC playerCharacter = getPC(input.readString("Which character do you want to show?: "));
				switch(input.readInt("Your options are:" + "\n" + "1. All base stats" + "\n" + "2. Submachine skill" + "\n" + "3. Hiking" + "\n" + 
						"4. Intimidate" + "\n" + "5. Broadsword" + "\n" + "6. Everything" + "\n" + "7. Player" + "\n" + "What do you want to see:")){
							case 1:
								System.out.println("Strengh: " + playerCharacter.getStrength() + "\n" + "Dexterity: " + playerCharacter.getDexterity() + "\n" + 
							"Intelligence: " + playerCharacter.getIntelligence() + "\n" + "Health: " + playerCharacter.getHealth());
								break;
							case 2:
								System.out.println("Submachine gun skill: " + playerCharacter.getSubmachineGunSkill());
								break;
							case 3:
								System.out.println("Hiking skill: " + playerCharacter.getHikingSkill());
								break;
							case 4:
								System.out.println("Intimidate skill: " + playerCharacter.getIntimidationSkill());
								break;
							case 5:
								System.out.println("Broadsword skill: " + playerCharacter.getBroadswordskill());
								break;
							case 6:
								System.out.println(playerCharacter.toString());
								break;
							case 7:
								System.out.println("Player: " + playerCharacter.getController());
							default:
								System.out.println("Error, incorrect command. Try again.");
						}
			}
			catch(NullPointerException e){
				System.out.println("Character does not exsist.");
			}
			break;
		case 2:
			try{
				NPC nonPlayerCharacter = getNPC(input.readString("Which character do you want to show?: "));
				switch(input.readInt("Your options are:" + "\n" + "1. All base stats" + "\n" + "2. Submachine skill" + "\n" + "3. Hiking" + "\n" + 
				"4. Intimidate" + "\n" + "5. Broadsword" + "\n" + "6. Everything" + "\n" + "7. Game master" + "\n" + "What do you want to see:")){
					case 1:
						System.out.println("Strengh: " + nonPlayerCharacter.getStrength() + "\n" + "Dexterity: " + nonPlayerCharacter.getDexterity() + "\n" + 
					"Intelligence: " + nonPlayerCharacter.getIntelligence() + "\n" + "Health: " + nonPlayerCharacter.getHealth());
						break;
					case 2:
						System.out.println("Submachine gun skill: " + nonPlayerCharacter.getSubmachineGunSkill());
						break;
					case 3:
						System.out.println("Hiking skill: " + nonPlayerCharacter.getHikingSkill());
						break;
					case 4:
						System.out.println("Intimidate skill: " + nonPlayerCharacter.getIntimidationSkill());
						break;
					case 5:
						System.out.println("Broadsword skill: " + nonPlayerCharacter.getBroadswordskill());
						break;
					case 6:
						System.out.println(nonPlayerCharacter.toString());
						break;
					case 7:
						System.out.println("Game master: " + nonPlayerCharacter.getController());
						break;
					default:
						System.out.println("Error, incorrect command. Try again.");
				}
			}
			
			catch(NullPointerException e){
				System.out.println("Character does not exsist.");
			}
		}
			
	}
	
	private void removePlayerCharacter(String name){
		for (int no = 0; no < playerCharacters.size(); no++){
			String tempName = playerCharacters.get(no).getName();
			if (tempName.equalsIgnoreCase(name)){
				playerCharacters.remove(no);
				System.out.println(tempName + " has been removed from the records");
			}
		}
	}

	private PC getPC(String name){
		for(PC c : playerCharacters){
			if(c.getName().equalsIgnoreCase(name)){
				return c;
			}
		}
			return null; 
	}
	
	private void removeNonPlayerCharacter(String name){
		for (int no = 0; no < nonPlayerCharacters.size(); no++){
			String tempName = nonPlayerCharacters.get(no).getName();
			if (tempName.equalsIgnoreCase(name)){
				nonPlayerCharacters.remove(no);
				System.out.println(tempName + " has been removed from the records");
			}
		}
	}


	private NPC getNPC(String name){
		for(NPC c : nonPlayerCharacters){
			if(c.getName().equalsIgnoreCase(name)){
				return c;
			}
		}	
		return null; 
	}
	
	private void updatePlayerCharacter(){
		try{
			PC character = getPC(input.readString("Which character do you want to update?: "));
			switch(input.readInt("Now chose which stat you want to update." + "\n" + "1. Strength" + "\n" + "2. Dexterity" + "\n" + 
				"3. Intelligence" + "\n" + "4. Health" + "\n" + "5. Hit Points" + "\n" + "6. Will" + "\n" + "7. Perception" + "\n" + 
				"8. Fatigue Points" + "\n" + "9. Submachine Gun Level" + "\n" + "10. Hiking Level" + "\n" + "11. Intimidate Level" + "\n" + 
				"12. Broadsword Level" + "\n" + "13. Player" + "\n" + "Now, decide: ")){
				case 1:
					character.setStrength(input.readInt("What is the new strength: "));
					break;
				case 2:
					character.setDexterity(input.readInt("What is the new dexterity: "));
					break;
				case 3:
					character.setIntelligence(input.readInt("What is the new intelligence: "));
					break;
				case 4:
					character.setHealth(input.readInt("What is the new health: "));
					break;
				case 5:
					character.setHitPoints(input.readInt("What is the new hit points: "));
					break;
				case 6:
					character.setWill(input.readInt("What is the new will: "));
					break;
				case 7:
					character.setPerception(input.readInt("What is the new perception: "));
					break;
				case 8:
					character.setFatiguePoints(input.readInt("What is the new fatigue points: "));
					break;
				case 9:
					character.setSubmachineGunLevel(input.readInt("What is the new submachine gun level: "));
					break;
				case 10:
					character.setHikingLevel(input.readInt("What is the new hiking level: "));
					break;
				case 11:
					character.setIntimidationLevel(input.readInt("What is the new intimidation level: "));
					break;
				case 12:
					character.setBroadswordLevel(input.readInt("What is the new broadsword level: "));
					break;
				case 13:
					character.setPlayer(input.readString("Who is the player: "));
					break;
				default:
					System.out.println("Error, incorrect command. Try again.");
			}
		}
		catch(NullPointerException e){
			System.out.println("Character does not exist.");
		}
	}
	
	private void updateNonPlayerCharacter(){
		try{
			NPC character = getNPC(input.readString("Which character do you want to update?: "));
			switch(input.readInt("Now chose which stat you want to update." + "\n" + "1. Strength" + "\n" + "2. Dexterity" + "\n" + 
				"3. Intelligence" + "\n" + "4. Health" + "\n" + "5. Hit Points" + "\n" + "6. Will" + "\n" + "7. Perception" + "\n" + 
				"8. Fatigue Points" + "\n" + "9. Submachine Gun Level" + "\n" + "10. Hiking Level" + "\n" + "11. Intimidate Level" + "\n" + 
				"12. Broadsword Level" + "\n" + "13. Game master" + "\n" + "Now, decide:")){
				case 1:
					character.setStrength(input.readInt("What is the new strength: "));
					break;
				case 2:
					character.setDexterity(input.readInt("What is the new dexterity: "));
					break;
				case 3:
					character.setIntelligence(input.readInt("What is the new intelligence: "));
					break;
				case 4:
					character.setHealth(input.readInt("What is the new health: "));
					break;
				case 5:
					character.setHitPoints(input.readInt("What is the new hit points: "));
					break;
				case 6:
					character.setWill(input.readInt("What is the new will: "));
					break;
				case 7:
					character.setPerception(input.readInt("What is the new perception: "));
					break;
				case 8:
					character.setFatiguePoints(input.readInt("What is the new fatigue points: "));
					break;
				case 9:
					character.setSubmachineGunLevel(input.readInt("What is the new submachine gun level: "));
					break;
				case 10:
					character.setHikingLevel(input.readInt("What is the new hiking level: "));
					break;
				case 11:
					character.setIntimidationLevel(input.readInt("What is the new intimidation level: "));
					break;
				case 12:
					character.setBroadswordLevel(input.readInt("What is the new broadsword level: "));
					break;
				case 13:
					character.setGameMaster(input.readString("Who is the new game master: "));
					break;
				default:
					System.out.println("Error, incorrect command. Try again.");
			}
		}
		catch(NullPointerException e){
			System.out.println("Character does not exist.");
		}
	}
	
	public static void main(String[] args){
		Main m  = new Main();
		m.run();


		
		
	}


}
