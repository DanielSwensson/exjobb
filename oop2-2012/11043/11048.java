import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Registry {
	private ArrayList<Person> personList = new ArrayList<Person>();
	int index = 0;
	
	public Registry(){
		
	}
	
	public void run(){
		Scanner sc = new Scanner(System.in);
		boolean finished = false;
		int input = 0;
		do{
			try{
				System.out.println("Kommandon: \n 1. Skapa person \n 2. Skapa pryl" +
						"\n 3. Visa alla \n 4. Visa rikaste \n 5. Visa viss person " +
						"\n 6. Börskrasch \n 7. Avsluta");
				System.out.print("> ");
				input = sc.nextInt();
				System.out.println();
			
				if(input > 7 || input<1) {
					System.out.println("Var vänlig och skriv en siffra mellan 1-7");
				}
			}
			catch(InputMismatchException e){
				getErrorMessage();
				sc.nextLine();
			}
			
			switch (input){
				case 1:
					createPerson();
					break;
				case 2:
					createItem();
					break;
				case 3:
					showAll();
					break;
				case 4:
					showRichest();
					break;
				case 5:
					showSpecificPerson();
					break;
				case 6:
					marketCrash();
					break;
				case 7:
					System.out.println("Programmet har avslutats.");
					finished = true;
					break;
				}
			}
		
		while(!finished);
		System.exit(0);
	}
	
	public void marketCrash(){
		System.out.println("Börskrasch! Alla existerande aktiers pris sätts till 0.");
		System.out.println();
		for(int i = 0; i<personList.size(); i++){
			personList.get(i).nullifyStock();
		}
	}
		
	public void showRichest(){
		int index = 0;
		int highestTotalValue = 0;
		
		if(personList.size() == 0){
			System.out.println("Det finns inga personer att visa. Var vänlig och skapa en person först.");
			}
		else {
			for(int i =0; i<personList.size(); i++){
				if(personList.get(i).getTotalValue() > highestTotalValue){
					highestTotalValue = personList.get(i).getTotalValue();
					index = i;
				}
			}
			
			System.out.println("Rikast är " + personList.get(index).getName() + " som sammanlagt äger " + highestTotalValue);
			personList.get(index).printAllItem();
		}
		
		System.out.println();
	}
	
	public void createPerson(){
			Scanner sc = new Scanner(System.in);
		
			
			boolean created = false;
			do{
				boolean exist = false;
				System.out.print("Namn: ");
				String name = sc.nextLine();
			
				for(int i =0; i<personList.size(); i++){
					if(personList.get(i).getName().equalsIgnoreCase(name)){
						System.out.println("Personen finns redan. Var vänlig och ange ett annat namn");
						System.out.println();
						exist = true;
						
					}
				}
				if(!exist){
					System.out.println();
					personList.add(new Person(name));
					created = true;
				}
			}
			while(!created);
	}
	
	public void showSpecificPerson(){
		Scanner sc = new Scanner(System.in);
	
		if(personList.size() == 0){
			System.out.println("Det finns inga personer att visa. Var vänlig och skapa en person först.");
			}
		
		else {	
			boolean exist = false;
			do{
				System.out.print("Vem: ");
				String name = sc.nextLine();
			
				for(int i =0; i<personList.size(); i++){
					if(personList.get(i).getName().equalsIgnoreCase(name)){
						System.out.println(name + " äger sammanlagt "+ personList.get(i).getTotalValue() + " och " +
								"äger följande prylar:");
						personList.get(i).printAllItem();
						exist=true;
					}
				}
				if(!exist){
					System.out.println("Personen finns inte. Var vänlig och ange ett annat namn.");
				}
			}
			while(!exist);
		}
		
		System.out.println();
	}
	
	public void createItem(){
		Scanner sc = new Scanner(System.in);

		if(personList.size() == 0){
			System.out.println("Det finns inga personer att skapa en pryl till. Var vänlig och skapa en person först.");
			}
		
		else {	
			
			boolean exist = false;
			do{
				System.out.print("Vilken person äger prylen: ");
				String name = sc.nextLine();
			
				for(int i =0; i<personList.size(); i++){
					if(personList.get(i).getName().equalsIgnoreCase(name)){
						exist = true;
						index = i;
					}
				}
				if(!exist){
					System.out.println("Personen finns inte. Var vänlig och ange ett annat namn.");
				}
			}
			while(!exist);
			
			boolean finished = false;
			while(!finished){
				System.out.print("Vilken sorts pryl: ");
				String item = sc.nextLine();
								
				switch(item.toLowerCase()){		
				case "smycke":
					
					createJewel();
					finished = true;
					break;
					
				case "apparat":
					createApparatus();
					finished = true;
					break;
					
				case "aktie":
					createStock();
					finished = true;
					break;
					
				default:
					System.out.println("Du angav fel sorts pryl");
					
				}
			}
		}
		System.out.println();
	}
	
	public void createJewel(){
		Scanner sc = new Scanner(System.in);
		String itemType;
		int materialValue = 0;
		int gemstoneAmount = 0;
		
		boolean done = false;
		
		//Vilken sorts smycke
		System.out.print("Vilken sorts smycke: ");	
		itemType = sc.nextLine();	
		
		//Om smycket är av guld eller silver
		
		do{
			System.out.print("Är smycket av guld: ");
			String answer = sc.nextLine();
			
			if(answer.equalsIgnoreCase("ja")){
				materialValue = 2000;
				done = true;
			}
			else if(answer.equalsIgnoreCase("nej")){
				materialValue = 700;
				done = true;
			}
			else{
				System.out.println("Fel inmatning. Var vänlig och skriv ja eller nej.");
			}
		}
		while(!done);
		
		//Hur många ädelstenar
		done = false;
		do{ 
			try{
				System.out.print("Hur många ädelstenar: ");
				gemstoneAmount = sc.nextInt();
				done = true;
			}
			
			catch(InputMismatchException e){
				getErrorMessage();
				sc.nextLine();
			}
		}
		while(!done);
		
		personList.get(index).addItem(new Jewelry(itemType, materialValue, gemstoneAmount));
	}
	
	public void createApparatus(){
		Scanner sc = new Scanner(System.in);
		String itemType;
		int price = 0;
		int deterioration = 0;
		boolean done = false;
		
		System.out.print("Vilken sorts apparat: ");
		itemType = sc.nextLine();
		
		do{
			try{
				System.out.print("Pris: ");
				price = sc.nextInt();
				done= true;
				
				if(price <0){
					System.out.println("Var vänlig och ange ett positiv pris.");
					done = false;
				}
				
			}
			catch(InputMismatchException e){
				getErrorMessage();
				sc.nextLine();
			}
		}
		while(!done);
		
		done = false;
		do{
			try{
				System.out.print("Hur sliten är apparaten, på skala 1-10 där 10 är ny: ");
				deterioration = sc.nextInt();
				done= true;
				
				if((deterioration>10) || (deterioration<0)){
					System.out.println("Var vänlig och skriv en siffra mellan 1-10.");
					done= false;
				}
				
				
			}
			catch(InputMismatchException e){
				getErrorMessage();
				sc.nextLine();
			}
		}
		while(!done);
		
		personList.get(index).addItem(new Apparatus(itemType, price, deterioration));
	}
	
	public void createStock(){
		Scanner sc = new Scanner(System.in);
		String itemType;
		int price = 0;
		int stockAmount = 0;
		boolean done = false;
		
		System.out.print("Vilken sorts aktie: ");
		itemType = sc.nextLine();
		
		do{
			try{
				System.out.print("Pris: ");
				price = sc.nextInt();
				done= true;
				
				if(price <0){
					System.out.println("Var vänlig och ange ett positiv pris.");
					done = false;
				}
				
			}
			catch(InputMismatchException e){
				getErrorMessage();
				sc.nextLine();
			}
		}
		while(!done);
		
		done = false;
		do{
			try{
				System.out.print("Antal: ");
				stockAmount = sc.nextInt();
				done= true;
				
				if(price <0){
					System.out.println("Var vänlig och ange ett positiv antal.");
					done = false;
				}
				
			}
			catch(InputMismatchException e){
				System.out.println("Var vänlig och skriv en siffra.");
				sc.nextLine();
			}
		}
		while(!done);
		
		personList.get(index).addItem(new Stock(itemType, stockAmount, price));
	}
	
	public void showAll(){
		if(personList.size() == 0){
			System.out.println("Det finns inga personer att visa. Var vänlig och skapa en person först.");
			}
		else{
			System.out.println("I Registret finns: ");
			for(int i = 0; i<personList.size(); i++){
				System.out.println("\t " +personList.get(i).getName() +" "+ personList.get(i).getTotalValue());
			}
		}
		
		System.out.println();
	}
			
	public void getErrorMessage(){
		System.out.println("Var vänlig och skriv en siffra.");
	} 

	public static void main(String[] args) {
		Registry r = new Registry();
		r.run();
	}

}
