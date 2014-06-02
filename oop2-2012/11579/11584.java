import java.util.Scanner; 
import java.util.ArrayList; 

public class Register {
	Scanner keyboard= new Scanner(System.in);	

	ArrayList<Person> allPersons=new ArrayList <Person>();

	Person getPerson(String humanName){
		for (Person p : allPersons)
			if (p.getHumanName().equalsIgnoreCase(humanName))
				return p;
		return null;
	}
	String readString(String Question){
		System.out.print(Question);
		String str=keyboard.nextLine();
		return str;
	}

	int readInt(String Question){
		for(;;){
			try{
				System.out.print(Question);
				int y=Integer.parseInt(keyboard.nextLine());
				return y;
			}
			catch (NumberFormatException notNumber){
				System.out.println("Fel - ange ett nummer");
			}
		}
	}

	int command(){
		for(;;){
			int choise=readInt("\n1 Skapa en person\n2 Skapa en ny pryl\n3 Lägg till skuld " +
					"\n4 Visa alla personer\n5 Visa rikaste personen\n6 Visa en viss person" +
					"\n7 Börskrasch\n8 Avsluta\n\nDitt val: ");
			if (choise>=1 && choise<=8)
				return choise;
			System.out.println("Felaktigt kommando, ska vara 1-8\n");
		}
	}

	void createPerson(){
		String humanName=readString("Namn på ny person: ");
		if (getPerson(humanName)!=null){
			System.out.println("Personen finns redan.");
			return;
		}
		Person p=new Person(humanName);
		allPersons.add(p);
	}
	void createThing(){
		String owner=readString("vilken person ska äga den nya prylen: ");
		if (getPerson(owner)==null){
			System.out.println("Personen finns inte.");
			return;
		}

		Person itemOwner = getPerson(owner);
		int numberCommand=readInt("Vad vill du skapa?\n1-Smycke\n2-Aktie\n3-Apparat\nAnge Kommando: ");

		switch (numberCommand){
		case 1:

			String name=readString("Vilken sorts smycke: ");
			String material=readString("Är smycket gjort av guld eller silver? ");
			if (material.equalsIgnoreCase("guld")||material.equalsIgnoreCase("silver")){
				int stones=readInt("Antal ädelstenar: ");
				Jewelry jewelryNew=new Jewelry(name, material, stones); 
				itemOwner.addThing(jewelryNew);
			}
			else System.out.println("Ogiltigt material. Giltigt val är guld eller silver.");
			break;

		case 2:
			String stockName=readString("Namn på aktien: ");
			int amount=readInt("Antal: ");
			int price=readInt("Pris: ");
			Stock New=new Stock(stockName, amount, price);
			itemOwner.addThing(New);
			break;


		case 3: 
			String deviceName=readString("Typ av apparat: ");
			int inPrice=readInt("Inköpspris: ");
			int wear=readInt("Slitage(1-10, där 10 är nytt):");
			Device deviceNew=new Device(deviceName, inPrice, wear);
			itemOwner.addThing(deviceNew);
			break;
		}
	}

	void createDebt(){
		String owner=readString("Vilken person gäller det?: ");
		if (getPerson(owner)==null){
			System.out.println("Personen finns inte.");
			return;
		}
		Person itemOwner = getPerson(owner);
		int debtSum=readInt("Hur stor är skulden? ");
		if (debtSum<=0)
			System.out.println("Ange ett positivt heltal för att ange en skuld");
		else { 
			Debt New=new Debt (debtSum);
			itemOwner.addThing(New);
		}
	}
	void showAllPeople(){           
		if (allPersons.size()==0){
			System.out.println("Det finns inga registrerade personer");
			return;
		}
		System.out.println("I registret finns:");
		for (Person p : allPersons){
			System.out.println(p.getHumanName()+"  " +p.totalSum());
		}
	}
	void showRichest(){     
		int highestValue = 0;
		Person richest = null;
		
		if (allPersons.size()==0){
			System.out.println("Det finns inga registrerade personer");
			return;
			
		}
		for (Person p : allPersons){
			if (p.totalSum()>=highestValue){
				highestValue=p.totalSum();
				richest=p;
			}
		}
				if (highestValue<=0)
					System.out.println("Det finns inga personer med positivt pryl-saldo");
					
				else {
				System.out.println("Rikast är "+richest.getHumanName() +" som sammanlagt äger prylar till ett värde av " +richest.totalSum()+" kronor.");
				System.out.println(richest.getHumanName()+"s tillgångar utgörs av: ");
				richest.showThing();
				}
		
	}



	void showPerson(){
		String name=readString("Namn: ");
		for (Person p : allPersons)
			if (p.getHumanName().equalsIgnoreCase(name)){
				System.out.println(name+" sammanlagda tillgångar uppgår till "+p.totalSum() + "kronor");
				System.out.println(name+"s tillgångar utgörs av:");
				p.showThing();
			}
	}

	void stockCrash(){
		for (Person p : allPersons)
			p.stockCrash();
		System.out.println("Börskrasch! aktierna har tappat sitt värde!");
	}





	public static void main (String[]args){
		Register main = new Register();
		System.out.println("Register över personer och deras tillgångar");
		int choise=0;
		do{
			choise=main.command();
			switch (choise) {


			case 1: main.createPerson(); break;
			case 2: main.createThing(); break;
			case 3: main.createDebt(); break;
			case 4: main.showAllPeople(); break;
			case 5: main.showRichest(); break;
			case 6: main.showPerson(); break;
			case 7: main.stockCrash(); break;
			case 8: System.out.println("Programmet avslutas"); break;
			default: System.out.println("Felaktig siffra. Giltigt val 1-8"); break;
			}	
		}
		while (choise!=8);
	}
}
