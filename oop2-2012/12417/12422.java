import java.util.Scanner;
import java.util.ArrayList;
public class Register{
	
	private	ArrayList<Person> personRegister = new ArrayList<Person>();
	private Scanner sc = new Scanner(System.in);
	
	public int readInt(){
		boolean ok = true;	
		int value = -1;
		do{
			ok = true;
			try{
				String str = sc.nextLine();
				value = Integer.parseInt(str);
			}
			catch(NumberFormatException e){
				System.out.println("You entered a non-integer, try again");
				ok=false;
			}
		}while(!ok);
		return value;
	}
	public double readDouble(){
		boolean ok = true;
		double value = -1;
		do{
			ok = true;
			try{
				String str = sc.nextLine();
				value = Double.parseDouble(str);
			}
			catch(NumberFormatException e){
				System.out.println("You entered a non-double, try again");
				ok=false;
			}
			
		}while(!ok);
		return value;

	}
	public String readString(){	
		String str = sc.nextLine();
		return str; 
	}
	
	public void clearScreen(){
		int n=500;
		while(n>0){
			System.out.println("");
			n-=1;
		}	
	}

	public void help(){
		System.out.println("1: Add a person to the list");
		System.out.println("2: Remove a person from the list");
		System.out.println("3: Add a valuable to a person from the list");
		System.out.println("4: Show this text");
		System.out.println("5: Show a list of all persons");
		System.out.println("6: List a persons valuables");
		System.out.println("7: STOCKCRASH!!!!!!!!");
		System.out.println("0: Exit");	
	}

	public Person addPerson(){
		System.out.print("What is the name of the person you want to add? ");
	
		String name = this.readString();
		Person a = new Person(name);
		return a;
	}

	public void removePerson(){
		System.out.print("What is the name of the person you want to remove from the list? ");
		String name = this.readString();
		int person = 0;
		int remove = 0;
		boolean test = false;
		for(Person p : personRegister){
			if(p.getName().equals(name)){
				remove = person;
				test=true;
			}

		person +=1;	
		}
		if(test==true){	
			personRegister.remove(remove);	
		}
		else{
			System.out.println("The person you are looking for is not in the list");
		}

		
	}

	public void addValuable(){
		
		System.out.print("What is the name of the person you want to load? ");
		
		String name = readString();
		System.out.println("");
		System.out.print("What kind of Valuable do you want to add?\n 1: Device \n 2: Stock \n 3: Jewelry\n");
		int valChoice = readInt();
		int nameIndex = 0;
		int person = 0;
		for (Person p : personRegister){
			
			if(p.getName().equals(name)){
				
			switch(valChoice){
			case 1:	
				System.out.println("What is the name of the device?");
					
				name = readString();
				System.out.println("What is the wear of the device?(1-10, where one is broken and 10 is new)");
				
				int wear = readInt();	
				System.out.println("What was/is the starting value of the device");
				
				double startingValue = readDouble();
				p.addDevice( name, wear,  startingValue);
				break;	
			case 2:
			       	System.out.print("What is the name of the Stock?");	
				
				name = readString();
				System.out.println("");
				System.out.print("What is the value per stock?");	
				
				double value= readDouble();
				System.out.println("");
				System.out.print("What is the amount of stocks?");
			
				int amount = readInt();	
				System.out.println("");
				p.addStock(name, value, amount);
				break;
			case 3: 
				System.out.print("What is the name of the Jewelry?");
				
				name = readString();
				System.out.println("");
				System.out.print("What material is the Jewelry casted in? (gold, silver or other)?");	
				
				String type = readString();
				System.out.println("");
				System.out.print("What is the weight of the Jewelry?");
				
				double weight = readDouble(); 
				System.out.print("What is the amount of stones in the Jewelry?");
				
				int stones = readInt();
				System.out.println("");
				p.addJewelry(name,  weight, type, stones);
				break;	
			default: 
				System.out.println("Stupidhead");
					break;

				}		
			}
			person +=1;
		}
	}

	public void printValList(){ 
		
		System.out.print("Which person's valuables do you want to list?");
		String name = readString();
		int nameIndex=0;
		int person = 0;
		for (Person p : personRegister){
			if(p.getName().equals(name)){
				nameIndex=person;		
			}
			person +=1;
		}
		clearScreen();
		personRegister.get(nameIndex).printValList();
		help();
	}

	public void updateWealth(){
		for(Person p:personRegister){
			p.estimateWealth();
		}
	}
	public void stockCrash(){
		for(Person p:personRegister){
			p.stockCrash();
		}
	}	

	public void run(){
		this.clearScreen();
		int command = -1;
		System.out.println("Welcome to the valuableregister!");
		System.out.println("What do you want to do?");
		this.help();

		while(command !=0){	
			command = readInt();	
			updateWealth();
			switch(command){
				case 0:
					break;
				case 1:
					this.clearScreen();
					personRegister.add(this.addPerson());
					this.clearScreen();
					this.help();
					break;
				case 2:
					this.clearScreen();
					this.removePerson();	
					this.help();
					break;
				case 3: 
					this.clearScreen();
					addValuable();	
					this.help();
					break;
				case 4:
					this.clearScreen();
					this.help();
					break;
				case 5: 
					this.clearScreen();
					double richestamount = -1;
					Person richest = new Person("");
					updateWealth();
					for(Person p:personRegister){		
						System.out.println(p.getName()+"  "+p.getWealth());
						if(p.getWealth()>richestamount){
							richest = p;
							richestamount = p.getWealth();
						}
						
					}
					System.out.println(richest.getName()+" is the richest person, it has " +richest.getWealth()+" monies");
			
					this.help();	
					break;
				case 6: 
					this.printValList();
					break;	
				case 7: 
					this.clearScreen();
					this.stockCrash();
					this.help();
					break;
				default:
					this.clearScreen();
					System.out.println("The command you entered is invalid");
					this.help();
					break;	
			}
		}


	}	

}

