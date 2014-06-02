import java.util.ArrayList;
import java.util.Scanner;


public class WardrobeRegister {

	static ArrayList<Clothes> allClothes = new ArrayList<Clothes>();
	static Scanner keyboard = new Scanner(System.in);



	/* Här är själv programmet som skapar en ny instans av WardrobeRegister */
	
	public static void main(String[] args){
		
		
		WardrobeRegister w = new WardrobeRegister();
		w.showMenuDir();
		
		
	}








	/* Här är huvudmenyn som är det första som skrivs ut i programmet.
	 * Den skickar en int till mainDir (Main Direction)*/

	private int showMenu() {

		System.out.println();
		System.out.println("Välkommen till din Garderob!");
		System.out.println();
		System.out.println("   Meny");
		System.out.println();
		System.out.println("1. Lägg till kläder");
		System.out.println("2. Ändra/radera kläder");
		System.out.println("3. Sök kläder");
		System.out.println("4. Tvätta alla kläder");
		System.out.println("5. Visa statistik");
		System.out.println();
		System.out.println("6. Avsluta");
		System.out.println();
		System.out.print(">");

		for (;;){try {
			int usersChoice = Integer.parseInt(keyboard.nextLine());
			System.out.println();
			return usersChoice;
		}
		catch (NumberFormatException e){
			System.out.println("Ditt val måste bestå av ett nummer mellan 1-6");

		}
		}
	}

	
	

	/* mainDir får ett värde av menu() och kör vald metod.*/

	private void showMenuDir(){
		for (;;){

			int x= showMenu();
			switch(x){
			
			case 1: addItemMenuDir();
			break;
			case 2: deleteItem();
			break;
			case 3: searchItemMenuDir();
			break;
			case 4:	wash();
			break;
			case 5:	showStatsMenuDir();
			break;
			case 6: System.exit(0);
			break;
			default: 
				System.out.println("Felaktig valmöjlighet!");
				break;
			}
		}
	}
	
	
	

	/* submenyn för statistik, kan verka en aning tunn med bara ett alternativ men den är kvar
	 * för att den var tänkt att byggas ut med ev fler funktioner*/
				
	private int showStatsMenu() {


		System.out.println();
		System.out.println("Min garderob");
		System.out.println();
		System.out.println("   Välj vilken info du vill se om din garderob!");
		System.out.println();
		System.out.println("1. Visa totalt antal klädesplagg");
		System.out.println("2. Gå tillbaka till start menyn.");
		System.out.println();
		System.out.print(">");

		for (;;){try {
			int usersChoice = Integer.parseInt(keyboard.nextLine());
			System.out.println();
			return usersChoice;
		}
		catch (NumberFormatException e){
			System.out.println("Ditt val måste bestå av ett nummer mellan 1-6");

		}
		}
	}

	
	
	
	/* subStatsDir får ett värde av subStatsChoice() och kör vald metod.*/

	private void showStatsMenuDir(){
		for (;;){

			int x= showStatsMenu();
			switch(x){

			case 1: viewAllClothes();
			break;
			case 2: showMenuDir();
			break;
			default: System.out.println("Fel!");
			break;
			}
		}
	}



	/* subAddMenu är submenyn för att lägga till nya objekt av befintliga klasser.*/

	private int addItemMenu() {


		System.out.println();
		System.out.println("Lägga till klädesplagg");
		System.out.println();
		System.out.println("   Vad vill du lägga till?");
		System.out.println();
		System.out.println("1. Lägg till ny skjorta"); // klar
		System.out.println("2. Lägg till ny byxa "); // klar
		System.out.println("3. Lägg till ny tröja"); // klar
		System.out.println("4. Lägg till nytt skärp"); // klar
		System.out.println("5. Lägg till nya skor"); // klar
		System.out.println("6. Lägg till ny huvudbonad"); // klar
		System.out.println();
		System.out.println("7. Gå tillbaka till start menyn.");
		System.out.println();
		System.out.print(">");

		for (;;){try {
			int usersChoice = Integer.parseInt(keyboard.nextLine());
			System.out.println();
			return usersChoice;
		}
		catch (NumberFormatException e){
			System.out.println("Ditt val måste bestå av ett nummer mellan 1-6");

		}
		}
	}

	
	
	
	/* subAddDir får ett värde av subAddMenu() och kör vald metod.*/


	private void addItemMenuDir(){

		for (;;){
			int x= addItemMenu();

			switch(x){

			case 1: addShirt();
			break;
			case 2: addPants();
			break;
			case 3: addSweater();
			break;
			case 4: addBelt();
			break;
			case 5:	addShoes();
			break;
			case 6: addHat();
			break;
			case 7: showMenuDir();
			break;

			default:System.out.println("Felaktigt meny val, testa igen!");
			break;
			}
		}
	}
	
	
	
	
/* subSearchMenu visar användarens alternativ i kategorin att söka efter kläder efter vissa kriterier.*/
	
	private int searchItemMenu() {


		System.out.println();
		System.out.println("Sök efter kläder");
		System.out.println();
		System.out.println("   Vad vill du söka efter?");
		System.out.println();
		System.out.println("1. Söka kläder efter klädtyp");
		System.out.println("2. Söka kläder efter färg");
		System.out.println("3. Söka kläder efter stolek");
		System.out.println();
		System.out.println("4. Gå tillbaka till start menyn.");
		System.out.println();
		System.out.print(">");
		int yourChoice = keyboard.nextInt();keyboard.nextLine();
		System.out.println();
		return yourChoice;
	}
	

	/* subSearchDir  får ett värde av subAddMenu() och kör vald metod.*/

	private void searchItemMenuDir(){
		for (;;){

			int x= searchItemMenu();
			switch(x){

			
			case 1: searchClothType();
			break;
			case 2: searchClothColor();
			break;
			case 3: searchClothSize();
			break;
			case 4: showMenuDir();
			break;
			default:System.out.println("Felaktigt alternativ försök igen!");
			break;
		}		
	}
}	

	
	/* Följande metoder är alla metoder för diverse klädesplagg som användaren kan
	 * lägga till i registret.*/

	private void addShirt(){
		System.out.println("Fyll i följande information:");

		int serialNr = checkSerial();
		String color = addColor();
		int year = addYear();
		int price = addPrice();
		String collar = addCollar();
		String size = addSize();
		int washed = addWashedTimes();
		int value=price;
		Shirt s = new Shirt(serialNr,color, year, price, collar, size, washed,value);
		allClothes.add(s);
		System.out.println();
		System.out.println(s.toString2());
	}
	private void addSweater(){

		System.out.println("Fyll i följande information:");
		int serialNr = checkSerial();
		String color = addColor();
		int year = addYear();
		int price = addPrice();
		String collar = addCollar();
		String size = addSize();
		int washed = addWashedTimes();
		int value = price;
		Sweater sw = new Sweater(serialNr,color, year, price, collar, size, washed, value);
		allClothes.add(sw);
		System.out.println();
		System.out.println(sw.toString2());
	}

	private void addPants(){

		System.out.println("Fyll i följande information:");
		int serialNr = checkSerial();
		String color = addColor();
		int year = addYear();
		int price = addPrice();
		String size = addSize();
		String length = addLength();
		int washed = addWashedTimes();
		int value = price;
		Pants p = new Pants(serialNr,color, year, price, size, length, washed, value);
		allClothes.add(p);
		System.out.println();
		System.out.println(p.toString2());
	}

	private void addBelt(){

		System.out.println("Fyll i följande information:");
		int serialNr = checkSerial();
		String color = addColor();
		int year = addYear();
		int price = addPrice();
		String length = addLength();
		int washed = addWashedTimes();
		int value = price;
		Belt b = new Belt(serialNr, color, year, price, length, washed, value);
		allClothes.add(b);
		System.out.println();
		System.out.println(b.toString2());
	}
	private void addShoes(){

		int serialNr = checkSerial();
		String color = addColor();
		int year = addYear();
		int price = addPrice();
		String size = addSize();
		String type = addType();
		int washed = addWashedTimes();
		int value = price;
		Shoes sh = new Shoes(serialNr,color, year, price, size, type, washed, value);
		allClothes.add(sh);
		System.out.println();
		System.out.println(sh.toString2());
	}
	private void addHat(){

		System.out.println("Fyll i följande information:");
		int serialNr = checkSerial();
		String color = addColor();
		int year = addYear();
		int price = addPrice();
		String type = addType();
		int washed = addWashedTimes();
		int value = price;
		Hat h = new Hat(serialNr,color, year, price, type, washed, value);
		allClothes.add(h);
		System.out.println();
		System.out.println(h.toString2());
	}

	
	
	
	
	
	

	
	
	
	
	
	
	
	
	/* searchClothType är en metod för att hitta åt alla kläder vars attribut Name matchar användarens sök sträng,*/

	private void searchClothType(){
		boolean found = false;

		System.out.println("Vilket sorts plagg söker du? (skriv i plural)");
		String x = keyboard.nextLine();
		
		for (int i = 0; i<allClothes.size();i++){
			if (x.equalsIgnoreCase(allClothes.get(i).getName())){
				System.out.println("Du har följande kläder av typen "+x);
				System.out.println();
				System.out.println(allClothes.get(i).toString()); 
				System.out.println();
					found = true;
			}		
		}		 if (!found){
					System.out.println("Det finns inte inget sånt plagg("+x+") registret!");
	}
}



	
	/* searchClothColor är en metod för att hitta åt alla kläder vars attribut Name matchar användarens sök sträng,*/

	private void searchClothColor(){
		boolean found = false;

		System.out.println("Vilken färg söker du?");
		String x = keyboard.nextLine();
		for (int i = 0; i<allClothes.size();i++){
			if (x.equalsIgnoreCase(allClothes.get(i).getColor())){
				System.out.println("Du har följande kläder i färgen "+x);
				System.out.println();
				System.out.println(allClothes.get(i).toString()); 
				System.out.println();
				found = true;
			}		
		} 		if (!found){
			System.out.println(x +" finns inte några kläder i den färgen registret!");
	}
}




	/* searchClothsize är en metod för att hitta åt alla kläder vars attribut Name matchar användarens sök sträng,*/

	private void searchClothSize(){
		boolean found = false;

		System.out.println("Vilken storlek söker du?");
		String x = keyboard.nextLine();
		for (int i = 0; i<allClothes.size();i++){
			if (x.equalsIgnoreCase(allClothes.get(i).getSize())){
				System.out.println("Du har följande kläder av storlek "+x);
				System.out.println();
				System.out.println(allClothes.get(i).toString()); 
				System.out.println();
				found = true;
			}		
		} 		if (!found){
			System.out.println(" Det finns inget klädesplagg med den storleken("+x +") i registret!");
	}
}


	
	
	/* viewAllClothes är en metod för att lista alla kläder som finns i garderoben som användaren valt att lagt till.,*/

	private void viewAllClothes(){

		System.out.println("Garderoben innehåller "+allClothes.size()+" st plagg och det är följande kläder: ");
		System.out.println();
		int n = allClothes.size();
		for(int i = 0; i < n ; i++)
			System.out.println(allClothes.get(i)); 
		System.out.println();
	} 
	

	
	/* wash() anropar att alla objekt i arrayen allClothes ska köra metoden washCloth(); som finns i klassen Clothes.,*/


	private void wash(){
		for (Clothes c : allClothes){
			c.washCloth();
		}
		System.out.println();
		System.out.println("Alla kläder har blivit tvättade!");
		System.out.println();

	}




	/* deleteItem är en metod för att tabort något objekt som finns i garderoben som användaren valt att lagt till.
	 * deleteItem() frågar efter ett serienummer som klädesplagget som finns har. Den tar sedan bort just det plagget ur arrayen, */

	private void deleteItem() {

		boolean found = false;
		int index = -1;
		int deleteMe;
		System.out.println("Vilken klädesplagg vill du radera?");
		viewAllClothes();
		System.out.println();
		System.out.println();
		for (;;){
			try {
				System.out.print("Ange klädesplaggets serienummer:");
				deleteMe = Integer.parseInt(keyboard.nextLine());
				System.out.println();
				break;

			}
			catch (NumberFormatException e){
				System.out.println("Serienumret måste bestå av siffror!");

			}			

		}
		for (Clothes c : allClothes) {
			if	(c.getSerialNumber()==(deleteMe)){
				found = true;
				index = allClothes.indexOf(c);

			}
		}

			if (found){
				allClothes.remove(index);
				System.out.println(deleteMe + " är nu raderad raderad.");

			}
			if (!found){
				System.out.println(deleteMe+" finns inte i registret!");
			}
		

	}


	
	
		
		
	


	/*serialCheck är det första användaren få gå igenom när den vill lägga till ett nytt objekt.
	 * serialCheck() kör det valda serienummret mot alla serienummer alla som objekt har som attriut serialNr
	 * om det redan finns ett objekt med just det serienummret får användaren fortsättat tills serienummret är unikt*/


	private int checkSerial(){
		boolean unique = false;
		int serialNr = 0;
		for(;;){
		while(!unique){
			
			try {
				System.out.print("Tillge ett serienummer:");
				serialNr = Integer.parseInt(keyboard.nextLine());
				unique = true;
				for (Clothes c : allClothes) {
					if	(c.getSerialNumber()==(serialNr)){
						unique = false;				
					}

				}
				if (!unique){
					System.out.println("Serienummret finns redan i registret, försök igen.");
				}
				return serialNr;			
			}

			catch (NumberFormatException e){
				System.out.println("Serienumret måste bestå av siffror!");

			}


		}
		}


	}



	
	
	
	/* följande metoder är alla metoder som används för att lägga till ett objekt*/
	
	
	private String addColor(){
		System.out.print("Färg: ");
		String color = keyboard.nextLine();
		return color;
	}
	private int addYear(){
		int year;
		for (;;){
		try {
		System.out.print("Inköpt år: ");
			year = Integer.parseInt(keyboard.nextLine());
			return year;
			}
		catch (NumberFormatException e){
		System.out.println("Fel, år måste skrivas med siffror!");
		}
	}
}
		
	private int addPrice(){
		
		for (;;){
		try {
		System.out.print("Inköpt för pris: ");
		int	price = Integer.parseInt(keyboard.nextLine());
			return price;
			}
		catch (NumberFormatException e){
		System.out.println("Fel, pris måste skrivas med siffror!");
		}
	}
	}
	private String addSize(){
		System.out.print("Storlek (för byxor skriv midjemått): ");
		String size = keyboard.nextLine();
		return size;
	}
	private String addLength(){
		System.out.print("Längd: ");
		String length = keyboard.nextLine();
		return length;
	}
	private String addCollar(){
		System.out.print("Krage typ: ");
		String collar = keyboard.nextLine();
		return collar;
	}
	private int addWashedTimes(){
		for (;;){
		try {
		System.out.print("Antal tvättar sedan köp: ");
			int washed = Integer.parseInt(keyboard.nextLine());
			return washed;
			}
		catch (NumberFormatException e){
		System.out.println("Fel, antal tvättar måste skrivas med siffror!");
		}
	}
	}
	private String addType(){
		System.out.print("Typ: ");
		String type = keyboard.nextLine();
		return type;
	}
}









