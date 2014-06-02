import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	Scanner keyboard = new Scanner(System.in);
	ArrayList <Person> allPersons = new ArrayList<Person>();
	ArrayList <Item> allItems = new ArrayList<Item>();
	
	String readString(String text){
		System.out.print(text);
		String str = keyboard.nextLine();
		return str;
	}	
	int readInt(String text){
		for(;;){
			try{
				int nr = 0;			
				do{
					System.out.print(text);	
					nr = Integer.parseInt(keyboard.nextLine());
					if(nr < 0){
						System.out.println("Talet måste vara ett positivt heltal!");
					}
				}while(nr < 0);
					return nr;
			}
			catch(NumberFormatException e){
				System.out.println("Fel! Måste vara ett positivt heltal!");
			}
		}	
	}	
	private void createPerson(){
		String name = readString("Namn: ");
		int count = 0;
			for(Person p1 : allPersons){
				if(p1.getName().equalsIgnoreCase(name)){
					System.out.print("Namnet finns redan!");
					count++;
				}
			}
			if(count == 0){
				Person p = new Person(name);
				allPersons.add(p);
				count = 0;
			}
	}
	private void createItem(){
		String owner = readString("Vilken person äger värdesaken: ");
		int index = -1;	
			for(Person p : allPersons){
				if(p.getName().equalsIgnoreCase(owner)){
					index++;
				}
			}
			if(index == -1){
				System.out.println("Ingen person med det namnet!");
			}else{
				String type = readString("Vilken sorts värdesak: ");
				String name;
				switch(type.toLowerCase()){
					case "smycke":
						name = readString("Vilken sorts smycke: ");
						String goldOrSilver = readString("Är smycket av guld eller silver: "); 
						int gemstone = readInt("Antal ädelstenar: ");
						Jewelry j = new Jewelry(name, owner, gemstone, goldOrSilver);
						allItems.add(j); break;
					case "aktier":
						name = readString("Namn på aktierna: ");
						int amount = readInt("Antal: ");
						int price = 0;
						boolean newStock = true;
							for(Item i : allItems){
								if(i instanceof Stock && i.getName().equalsIgnoreCase(name) && i.getOwner().equalsIgnoreCase(owner)){
									((Stock) i).addAmount(amount);
									newStock = false;
										if(((Stock) i).getPrice() == 0){
											price = readInt("Pris per aktie: ");
											((Stock) i).setPrice(price);
										}
								}
							}
						if(newStock == true){
							price = readInt("Pris per aktie: ");
							Stock s = new Stock(name, owner, price, amount);
							allItems.add(s);
						}break;
					case "apparat":
						name = readString("Vilken sorts apparat: ");
						int purchasePrice = readInt("Inköpspris: ");
						int wear = 0;
						while(wear <1 || wear > 10){
						wear = readInt("Slitage(ett tal mellan 1 och 10 där 10 betyder helt ny och 1 mycket sliten): ");
						}
						Object o = new Object(name, owner, purchasePrice, wear); 
						allItems.add(o); break;
					default:
						System.out.println("Fel kommando! \nsmycke, aktier, apparat är valbara kommandon.");
						for(Item i : allItems){
							System.err.println(i.getName());
						}
				}		
			}	
	}
	private void showAll(){
		System.out.println("I registret finns:");
		for(Person p : allPersons){
			double totalValue = 0;
			for(Item i : allItems){
				if(i.getOwner().equalsIgnoreCase(p.getName())){
					totalValue = totalValue + i.value();
				}
			}
			System.out.println(p.getName() +"\t"+ totalValue);
		}
	}
	private void showRichest(){
		double totalValue = 0;
		double richestTotalValue = 0;
		String richest = null;
		double x = 0;
		for(Person p : allPersons){
			for(Item i : allItems){
				if(p.getName().equalsIgnoreCase(i.getOwner())){
					x = x + i.value();	
				}
			}
			totalValue = x;
			if(totalValue > richestTotalValue){
				richestTotalValue = totalValue;
				richest = p.getName();
			}
			x = 0;
		}
		if(allPersons.isEmpty()){
			System.out.println("Det finns inga personer i registret!");
		}else{
			if(richest == null){
				System.out.println("Rikaste äger värdesaker till ett värde av 0!");
				for(Person p : allPersons){
					System.out.println(p.getName() + "\t0");
				}
			}else{
				System.out.println("Rikast är "+richest+" som sammanlagt äger värdesaker till ett värde av "+richestTotalValue);
			}
		}	
			for(Item i : allItems){
				if(i.getOwner().equalsIgnoreCase(richest)){
					System.out.println(i.getName() + "\t" + i.value());
			}
		}
	}	
	private void showPerson(){
		boolean nobody = true;
		String name = readString("Namn på personen: ");
			for(Person p : allPersons){
				if(p.getName().equalsIgnoreCase(name)){
					nobody = false;
					System.out.println(name + " äger följande värdesaker:");
						for(Item i : allItems){
							if(i.getOwner().equalsIgnoreCase(name)){
								System.out.println(i.getName() + "\t" + i.value());
							}
						}
				}		
			}
			if(nobody == true){
				System.out.println("Ingen person med det namnet hittades!");
			}
	}	
	private void stockMarketCrash(){
		for(Item i : allItems){
			if(i instanceof Stock){
				((Stock)i).setPrice(0);
			}
		}
	}
	public static void main(String[] args){	
		Main cmd = new Main();
		for(;;){	
			int input = cmd.readInt("1=Skapa person \n2=Skapa värdesak \n3=Visa alla \n4=Visa rikaste \n5=Visa viss person \n6=Börskrasch \n7=Avsluta\n");			
			switch(input){
				case 1:
					cmd.createPerson(); break;
				case 2:
					cmd.createItem(); break;
				case 3:
					cmd.showAll(); break;
				case 4:
					cmd.showRichest(); break;
				case 5:
					cmd.showPerson(); break;
				case 6:
					cmd.stockMarketCrash(); break;
				case 7:
					System.exit(0);	
				default:
					System.out.println("Fel kommando!");		
			}			
		}
	}
}