import java.util.*;
class MainProgram{
	ArrayList<Person> allPeople = new ArrayList<Person>();
	ArrayList<Item> allItems = new ArrayList<Item>();
	Scanner sc = new Scanner(System.in);
	
	int readInt(String q){
		for (;;){
			try{
				System.out.print(q);
				int x = Integer.parseInt(sc.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Fel - skall vara numeriskt värde.");
			}
		}
	}
	
	String readString(String q){
		System.out.print(q);
		String str = sc.nextLine();
		return str;
	}
	
	Person getPerson(String name){
		for (Person p : allPeople){
			if (p.getName().equalsIgnoreCase(name)){
				return p;
			}
		}
		return null;
	}
	
	void countTotalValues(){
		for (Item i : allItems){
			Person o = i.getOwner();
			o.addTotalValue(i.getValue());
		}
	}
	
	void zeroTotalValues(){
		for (Person p : allPeople){
			p.resetTotalValue();
			}
	}
	
	void createPerson(){
		String name = readString("Nya personens namn: ");
		Person p = getPerson(name);
		if (p != null){
			System.out.println("Den personen finns redan.");
		}else{
			Person newPerson = new Person(name);
			allPeople.add(newPerson);
		}
	}
	
	void createItem(){
		String nameOwner = readString("Ägaren: ");
		Person owner = getPerson(nameOwner);
		if (owner == null){
			System.out.println("Personen finns inte i registret.");
			return;
		}
		int type = readInt("Typ av pryl (1=Smycke, 2=Aktie, 3=Apparat): ");
		if (type == 1){
			String name = readString("Typ av smycke: ");
			String gold = readString("Är smycket av guld? (y/n): ");
			int gems = readInt("Antal ädelstenar i smycket: ");
			Jewel j = new Jewel(owner, name, gems, gold);
			allItems.add(j);
		}else if (type == 2){
			String name = readString("Företagsnamn: ");
			int amount = readInt("Antal aktier: ");
			int eachValue = readInt("Varje akties enskilda värde: ");
			Shares s = new Shares(owner, name, amount, eachValue);
			allItems.add(s);
		}else if (type == 3){
			String name = readString("Typ av apparat: ");
			int price = readInt("Inköpspris: ");
			int wear = readInt("Slitage 1-10 (10=helt ny): ");
			Device d = new Device(owner, name, price, wear);
			allItems.add(d);
		}else{
			System.out.println("Prylens typ bestäms genom 1, 2 eller 3.");
		}
	}
	
	void showAll(){
		countTotalValues();
		System.out.println("I registret finns: ");
		for (Person p : allPeople){
			System.out.println(" " + p.getName() + " " + p.getTotalValue());
			}
		zeroTotalValues();
	}
	
	void showRichest(){
		countTotalValues();
		Person rich = allPeople.get(0);
		int richValue = 0;
		for (Person p : allPeople){
			if (p.getTotalValue() >= rich.getTotalValue()){
				rich = p;
				richValue = p.getTotalValue();
			}
		}
		System.out.println(rich.getName() + " är rikast med totalvärdet " + richValue);
		for (Item x : allItems){
			if (x.getOwner().equals(rich)){
				System.out.println("   " + x.getName() + " " + x.getValue());
			}
		}
		zeroTotalValues();
	}
	
	void showOne(){
		String name = readString("Namn på personen: ");
		Person p = getPerson(name);
		if (p == null){
			System.out.println("Personen finns inte i registret.");
			return;
		}
		countTotalValues();
		System.out.println(p.getName() + " " + p.getTotalValue());
		for (Item x : allItems){
			if (x.getOwner().equals(p)){
				System.out.println("   " + x.getName() + " " + x.getValue());
			}
		}
		zeroTotalValues();
	}
	
	void stocksCrash(){
		for (Item i : allItems){
			if (i instanceof Shares){
				i.setEachValue(0);
			}
		}
	}
	
	public static void main(String []args){
		MainProgram mp = new MainProgram();
		System.out.println("Hej och välkommen till Prylprogrammet.");
		for (;;){
			System.out.println("1 = Skapa Person");
			System.out.println("2 = Skapa Pryl");
			System.out.println("3 = Visa Alla");
			System.out.println("4 = Visa Rikaste");
			System.out.println("5 = Visa Person");
			System.out.println("6 = Börskrash");
			System.out.println("7 = Avsluta");
			int command = mp.readInt("Ange kommando 1-7: ");
			switch (command){
				case 1: mp.createPerson(); break;
				case 2: mp.createItem(); break;
				case 3: mp.showAll(); break;
				case 4: mp.showRichest(); break;
				case 5: mp.showOne(); break;
				case 6: mp.stocksCrash(); break;
				case 7: System.out.println("Tack och hej då!");
						System.exit(0);
				default: System.out.println("Fel kommando!");
			}
		}
	}
	
}
