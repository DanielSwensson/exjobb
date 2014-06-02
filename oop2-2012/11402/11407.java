package inlupp2;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class PrylTest {
	
	public static void main(String[] args){
		ArrayList<Person> people = new ArrayList<Person>();
		System.out.println("1-Skapa person\n2-Skapa pryl\n3-Visa alla\n"+
				"4-Visa rikaste\n5-Visa viss person\n6-Börskrasch\n"+
				"7-Avsluta\n: ");
		
		
		for(;;){
			System.out.println();
			int kom = askQuestionInt("Kommando: ");
			switch (kom){
				case 1: 
					String name = askQuestionString("Personens namn:");
					Person ny = new Person(name);
					Person test = getPerson(name, people);
					if(test ==null || people.isEmpty()){
						people.add(ny);
					}
					else{
						System.out.println("Den personen finns redan!");
					}
					break;
					
				case 2:
					String name1 = askQuestionString("Vem ska äga prylen: ");
					Person p1 = getPerson(name1, people);
					addGadget(p1);		
				
				break;
			case 3: 
				for(Person p: people){
					System.out.println(p);
				}
				
				
				break;
			case 4:
				int maxValue =0;
				int possition = 0;
				for(int i = 0;i<people.size();i++){
					if(maxValue<people.get(i).totalValue()){
						maxValue = people.get(i).totalValue();
						possition =i;
					}
				}
				System.out.println(people.get(possition));
				
					break;
				case 5:
					String name2 = askQuestionString("Vilken Person: ");
					Person vem= getPerson(name2, people);
			
					if(vem== null){
						System.out.println("Den personen fanns ej.");
					}
					System.out.println(vem);
					break;
				case 6:
					for(Person p: people){
						ArrayList <Gadget> gadgets = new ArrayList<Gadget>();
						gadgets = p.getGadget(); 
						for (Gadget g :gadgets){
							if(g instanceof Shares){
								((Shares) g).setPrice(0);
							}
						}
						
						
					}
					
					
					break;
				case 7:
					System.exit(0);
			default:
				System.out.println("Felaktigt kommando");
			}//switch
		}//for
		
	}
	public static Person getPerson(String name, ArrayList<Person> people){
		for(int i = 0;i<people.size();i++){
			if(people.get(i).getName().equals(name)){
				return people.get(i);
			}
		}
		return null;
	}
	public static String askQuestionString(String question){

			Scanner sc = new Scanner(System.in);
		
		System.out.println(question);
		String answer = sc.next();
		
		return answer;
		
		
	}
	public static int askQuestionInt(String question){
		for(;;){
			try{
				Scanner sc = new Scanner(System.in);
				System.out.println(question);
				int anw = sc.nextInt();
				return anw;
			}catch(InputMismatchException e){
				System.out.println("M�ste mate in en siffra");
			 	
			}
		}
	}
	public static void addGadget(Person p1){
		Scanner sc = new Scanner(System.in);
		for(;;){
			String gadgetType = askQuestionString("vilken sorts pryl är det? (smycke/aktie/apparat) ");
		
			if(gadgetType.equals("smycke")){
				String nameJewelery = askQuestionString("Vilket sorts smycke är det: ");
				int amountOfGems = askQuestionInt("Antal ädelstenar: ");
				
				System.out.println("Är smycket av guld? (ja/nej): ");
				boolean gold;
				String material = sc.next();
				if(material.equals("ja")){
					gold = true;
				}
				else{
					gold = false;
				}
				
				Jewelery j = new Jewelery(nameJewelery, amountOfGems, gold);
				p1.addGadget(j);
				return;
	
			}
			else if(gadgetType.equals("aktie")){
				String nameShares = askQuestionString("Vad heter aktien: ");
				int amount= askQuestionInt("Hur många aktier av " +nameShares+ ": " );
				int price= askQuestionInt("Vad är priset per aktie:");
				Shares s = new Shares(nameShares, amount, price);
				p1.addGadget(s);
				return;
			}
			else if(gadgetType.equals("apparat")){
				String nameDevice = askQuestionString("Vilket sorts smycke är det: ");
				int price= askQuestionInt("Hur mycket kostaded "+ nameDevice + " när den var ny:");
				int wear= askQuestionInt("Hur sliten är den: ");
				Device d= new Device(nameDevice, price, wear);
				p1.addGadget(d);
			}
			else{
				System.out.println("fel inmatning!");
			}
		}

	}
	
}
