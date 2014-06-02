import java.util.ArrayList;
import java.util.Scanner;

class Head {

	//Creates arraylist for all persons
	private static ArrayList<Person> per = new ArrayList<Person>();

	//Main method
	public static void main(String[]args){

		for(;;){
			Head hp = new Head();
			System.out.println();
			System.out.println("Hello, and Welcome to the Object Registry!");
			System.out.println();
			System.out.println("1. Add New Person");
			System.out.println("2. Create New Item");
			System.out.println("3. Show All");
			System.out.println("4. Show Richest");
			System.out.println("5. Show Person");
			System.out.println("6. Stockmarket Crash!");
			System.out.println("7. Quit!");

			int choice=hp.readInt("Insert Command 1-7 ");
			switch (choice){
			case 1: hp.createPerson(); break;
			case 2: hp.createItem(); break;
			case 3: hp.showAll(); break;
			case 4: hp.showRichest(); break;
			case 5: hp.showCertain(); break;
			case 6: hp.stockMarketCrasch(); break;
			case 7: System.out.println("Goodbye!");
			System.exit(0);
			default: System.out.println("Wrong Command!");
			}
		}
	}	

	//Creates scanner
	static Scanner scan = new Scanner(System.in);

	//errorcheck
	int readInt(String question){
		for(;;){
			try{
				System.out.print(question);
				int x=Integer.parseInt(scan.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Wrong! - Should be a numerical value!");
			}
		}
	}
	public String readString(String question){
		System.out.print(question);
		String str=scan.nextLine();
		return str;

	}
	//Creates stock
	void createStock(Person p){
		String name=readString("What stock? ");
		int price=readInt("How much is it worth? ");
		int amount=readInt("How many?: ");
		int svalue = amount*price;
		p.setTotal(p.getTotal()+svalue);
		p.addItem(new Stock(name, price, amount, svalue));
	}

	//Creates device
	void createDevice(Person p){
		String name=readString("What kind of device? ");
		int price=readInt("Purchase Price?: ");
		int wear=readInt("Quality (1-10): ");
		int dvalue = (price*wear)/10;
		p.setTotal(p.getTotal()+dvalue);
		p.addItem(new Device(name, price, wear, dvalue));
	}

	//Creates Jewellery
	void createJewellery(Person p){
		String name=readString("What kind of jewellery? ");
		int nog=readInt("How many gems? ");
		String material;
		for(;;){
			material=readString("Is it gold or silver? :");
			if(material.equalsIgnoreCase("gold")||material.equalsIgnoreCase("silver")){
				break;
			}
			else
				System.out.print("Answer yes or no.\n");
		}
		int jvalue = 0;
		if (material.equalsIgnoreCase("gold"))
			jvalue = (2000+500*nog);
		else
			jvalue = (700+500*nog);
		p.setTotal(p.getTotal()+jvalue);
		p.addItem(new Jewellery(name, nog, material, jvalue));
	}
	//Creates person
	void createPerson(){
		String name = readString("Name of new person: "); 
		Person p = getPerson(name); 
		if (p!=null)
			System.out.println("Person already exists!"); 
		else{
			int total = 0;
			Person n = new Person(name, total);
			per.add(n);
		}
	}

	//Creates items
	public void createItem(){
		System.out.print("\n");

		String name=readString("Name of the owner?: ");
		Person p=getPerson(name);
		if(p==null)
			System.out.println("That person does not exist!.\n");
		else{
			String type;
			for(;;){
				type=readString("What kind of item?(Jewellery/Device/Stock) ");
				if(type.equalsIgnoreCase("Jewellery")||type.equalsIgnoreCase("Device")||type.equalsIgnoreCase("Stock"))
					break;
				else
					System.out.print("Incorrect choice! \n");        
			}
			if(type.equalsIgnoreCase("Jewellery")){
				createJewellery(p);
			}
			else if(type.equalsIgnoreCase("Device")){
				createDevice(p);
			}
			else if(type.equalsIgnoreCase("Stock")){
				createStock(p);
			}        
		}
	}

	//Displays every person and their total value
	public void showAll() {
		int i=0;
		for (Person p : per){
			System.out.println("\n"+ ++i + ": " + p);
		}
	}

	//Displays the richest person, total value of that person and all items for that person
	public void showRichest() {
		Person richest=per.get(0);
		for(Person p : per){
			if(p.getTotal() > richest.getTotal()){
				richest=p;
			}
		}
		System.out.println("\n" + richest);
		System.out.print("------------------------------------------------------------\n");
		int i=0;
		for (Item it : richest.getItems()){
			if (it instanceof Stock){
				System.out.println("\n"+ ++i + ": " + "Stock: "+ it);
			}
			if (it instanceof Device){
				System.out.println("\n"+ ++i + ": " + "Device: " + it);
			}
			if (it instanceof Jewellery){
				System.out.println("\n"+ ++i + ": " + "Jewellery: "+ it);
			}
		}


	}
	//Shows a certain person and all items for that person
	public void showCertain() {
		String name=readString("Who do you want to see? ");
		Person p=getPerson(name);
		if(p!=null){
			System.out.print("\n"+ p);
			int i=0;
			for (Item it : p.getItems()){
				if (it instanceof Stock){
					System.out.println("\n"+ ++i + ": " + "Stock: "+ it);
				}
				if (it instanceof Device){
					System.out.println("\n"+ ++i + ": " + "Device: "+ it);
				}
				if (it instanceof Jewellery){
					System.out.println("\n"+ ++i + ": " + "Jewellery: "+ it);
				}
			}
		}
		else
			System.out.print("That person does not exist!");
	}
	//Sets the value of all stock to 0 and recalculates total value
	public void stockMarketCrasch() {
		for(Person p : per){
			for(Item i : p.getItems()){
				if(i instanceof Stock){
					p.setTotal(p.getTotal() - ((Stock)i).getValue());
					((Stock)i).setValue();
				}
			}
		}
		System.out.println("\n Stockmarket Crasch!");

	}
	Person getPerson(String name){
		for (Person p : per){
			if (p.getName().equalsIgnoreCase(name))
				return p;
		}
		return null;
	}
}
