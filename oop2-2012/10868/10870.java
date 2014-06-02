import java.util.ArrayList;
import java.util.Scanner;


public class ValuablesMain {
	public ArrayList<Person> personList = new ArrayList<Person>();
	Scanner keyboard = new Scanner(System.in);
	
	
//	Metod för try/catch
	int readInt(String question){
		for(;;){
			try{
				System.out.println(question);
				int x=Integer.parseInt(keyboard.nextLine());
				return x;
			}
			catch(NumberFormatException e){
				System.out.println("Wrong command, try again.");
			}
		}
	}
	
	public ValuablesMain(){
		
		mainLoop();
		
	}
	
public void mainLoop(){
	
	for(;;){
		int theChoice = 0;
		System.out.println("Choose command 1-7");
	
		
		System.out.println("Create person(1)");
		System.out.println("Create Item(2)");
		System.out.println("Show all(3)");
		System.out.println("Show the richest person(4)");
		System.out.println("Show certain person(5)");
		System.out.println("Stock market crash(6)");
		System.out.println("Quit(7)");
	
		
		try{
			String userChoice = keyboard.nextLine();
			theChoice = Integer.parseInt(userChoice);
		}
		catch(NumberFormatException e){
			System.out.println("");
			
		
		}
		
			switch (theChoice) {
			case 1:	
				System.out.println("Name?");
				String personName = keyboard.nextLine();
				
				Person newPerson = new Person(personName);
				personList.add(newPerson);	
				break;
			
			case 2:
				System.out.println("Who's the owner?");
				String correctName = keyboard.nextLine();
				boolean userFound = false;
					
				for(Person xPerson : personList){
					//System.out.println(xPerson.getName());
					if(correctName.equalsIgnoreCase(xPerson.getName()))
					{
			
						userFound = true;
						System.out.println("What kind of item? Jewelry(1), Stock(2), Electronics(3)");
						
						try{
							
							theChoice = Integer.parseInt(keyboard.nextLine());
							
						}
							
								catch(NumberFormatException e){
									System.out.println("Wrong command");
									break;
								
								}
						
						switch(theChoice) {
						
						case 1:
							System.out.println("What kind of jewellery?");
							String name = keyboard.nextLine();
							
							String jewelleryMaterial = "";
							
							for(;;){
							System.out.println("Is the jewellery made out of gold or silver?");
							jewelleryMaterial = keyboard.nextLine();
							
								if(jewelleryMaterial.equalsIgnoreCase("silver") || jewelleryMaterial.equalsIgnoreCase("gold")  ){
									break;	
									
								}
								
								System.out.println("Please choose gold or silver.");
								
							}
							int numberOfGems = readInt("How many gems are attached to the jewellery?");
							
						//	System.out.println("How many gems are attached to the jewellery?");
						//	int numberOfGems = Integer.parseInt(keyboard.nextLine());
							
							Jewellery newJ = new Jewellery(jewelleryMaterial, numberOfGems, name);
							xPerson.addItem(newJ);
							break;
						
							
						case 2:
							System.out.println("What's the name of stock?");
							String nameStock = keyboard.nextLine();
							
							int numberOfShares = readInt("How many shares?");
							
						//	System.out.println("How many shares?");
						//	int numberOfShares = Integer.parseInt(keyboard.nextLine());
								
							int priceOfStock = readInt("What's the price of the stock?");
							
						//	System.out.println("What's the price of the stock?");
						//	int priceOfStock = Integer.parseInt(keyboard.nextLine());
							
							Stock newS = new Stock(numberOfShares, priceOfStock, nameStock);
							xPerson.addItem(newS);
							break;
						
						
						case 3:
							System.out.println("What's the name of electronic item?");
							String nameElectronics = keyboard.nextLine();
							
							int price = readInt("What was the puchase price?");
							
						//	System.out.println("What was the puchase price?");
						//	int price = Integer.parseInt(keyboard.nextLine());
								
							int wear = readInt("What condition is it in? Choose 1-10.");
							
						//	System.out.println("What condition is it in? Choose 1-10.");
						//	int wear = Integer.parseInt(keyboard.nextLine());
							
							Electronics newE = new Electronics(wear, price, nameElectronics);
							xPerson.addItem(newE);
							break;
						
							
						default:
							System.out.println("Wrong command");	
						}
					}
				}
				if(!userFound)
					System.out.println("Person doesn't exist");
				break;
		
			
			case 3:
				
				System.out.println("Registered people:");
				for(Person p : personList){
					System.out.println(p.getName() + "\thas the value: " + p.getTotalValue());
				}
				break;
			
			
			case 4:	
				System.out.println("The richest person in the registry is:");
				Person richestPerson = null;
				int richest = 0;
				
				for(Person richPerson : personList){
					if(richPerson.getTotalValue() > richest)
					{
						richestPerson = richPerson;
						richest = richPerson.getTotalValue();
					}
				}
				System.out.println(richestPerson.getName() + "\t" + richestPerson.getTotalValue());
				richestPerson.getItemName();
				break;
			
				
			case 5:
				System.out.println("Whose value do you want to check?");
				String currentPerson = keyboard.nextLine();
				
				boolean userFoundTwo = false;
				
				for(Person xPerson : personList){
					if(currentPerson.equalsIgnoreCase(xPerson.getName())){
						
						userFoundTwo = true;
	
						System.out.println(xPerson.getName() + " has a total value of " + "\t" + xPerson.getTotalValue());
						xPerson.getItemName();
							
					}	
				}
				if(!userFoundTwo)
					System.out.println("Person doesn't exist");
				
				break;
			
				
			case 6://BÖRSKRASCH
				for (Person p : personList){
					for (Item xItem : p.itemList){
						if (xItem instanceof Stock)
						{
							Stock s = (Stock)xItem;
							s.borsKrasch();
						}
					}
				}
				System.out.println("XZXZX????!!!STOCK MARKET HAS CRASHED!!?+ZXZXZXZXZ");
				break;
			
			
			case 7:
				System.exit(0);
				break;
				
			default: 
				System.out.println("Wrong command");
	
				break;
			}
	
		}
}
	
	public static void main(String[] args) {
	
		ValuablesMain vm = new ValuablesMain();
		
	}
	
}
