import java.util.ArrayList;
import java.util.Scanner;


public class WardrobeRegister {

	static ArrayList<Clothes> allClothes = new ArrayList<Clothes>();
	static Scanner keyboard = new Scanner(System.in);



	/* H�r �r sj�lv programmet som skapar en ny instans av WardrobeRegister */
	
	public static void main(String[] args){
		
		
		WardrobeRegister w = new WardrobeRegister();
		w.showMenuDir();
		
		
	}








	/* H�r �r huvudmenyn som �r det f�rsta som skrivs ut i programmet.
	 * Den skickar en int till mainDir (Main Direction)*/

	private int showMenu() {

		System.out.println();
		System.out.println("V�lkommen till din Garderob!");
		System.out.println();
		System.out.println("   Meny");
		System.out.println();
		System.out.println("1. L�gg till kl�der");
		System.out.println("2. �ndra/radera kl�der");
		System.out.println("3. S�k kl�der");
		System.out.println("4. Tv�tta alla kl�der");
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
			System.out.println("Ditt val m�ste best� av ett nummer mellan 1-6");

		}
		}
	}

	
	

	/* mainDir f�r ett v�rde av menu() och k�r vald metod.*/

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
				System.out.println("Felaktig valm�jlighet!");
				break;
			}
		}
	}
	
	
	

	/* submenyn f�r statistik, kan verka en aning tunn med bara ett alternativ men den �r kvar
	 * f�r att den var t�nkt att byggas ut med ev fler funktioner*/
				
	private int showStatsMenu() {


		System.out.println();
		System.out.println("Min garderob");
		System.out.println();
		System.out.println("   V�lj vilken info du vill se om din garderob!");
		System.out.println();
		System.out.println("1. Visa totalt antal kl�desplagg");
		System.out.println("2. G� tillbaka till start menyn.");
		System.out.println();
		System.out.print(">");

		for (;;){try {
			int usersChoice = Integer.parseInt(keyboard.nextLine());
			System.out.println();
			return usersChoice;
		}
		catch (NumberFormatException e){
			System.out.println("Ditt val m�ste best� av ett nummer mellan 1-6");

		}
		}
	}

	
	
	
	/* subStatsDir f�r ett v�rde av subStatsChoice() och k�r vald metod.*/

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



	/* subAddMenu �r submenyn f�r att l�gga till nya objekt av befintliga klasser.*/

	private int addItemMenu() {


		System.out.println();
		System.out.println("L�gga till kl�desplagg");
		System.out.println();
		System.out.println("   Vad vill du l�gga till?");
		System.out.println();
		System.out.println("1. L�gg till ny skjorta"); // klar
		System.out.println("2. L�gg till ny byxa "); // klar
		System.out.println("3. L�gg till ny tr�ja"); // klar
		System.out.println("4. L�gg till nytt sk�rp"); // klar
		System.out.println("5. L�gg till nya skor"); // klar
		System.out.println("6. L�gg till ny huvudbonad"); // klar
		System.out.println();
		System.out.println("7. G� tillbaka till start menyn.");
		System.out.println();
		System.out.print(">");

		for (;;){try {
			int usersChoice = Integer.parseInt(keyboard.nextLine());
			System.out.println();
			return usersChoice;
		}
		catch (NumberFormatException e){
			System.out.println("Ditt val m�ste best� av ett nummer mellan 1-6");

		}
		}
	}

	
	
	
	/* subAddDir f�r ett v�rde av subAddMenu() och k�r vald metod.*/


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
	
	
	
	
/* subSearchMenu visar anv�ndarens alternativ i kategorin att s�ka efter kl�der efter vissa kriterier.*/
	
	private int searchItemMenu() {


		System.out.println();
		System.out.println("S�k efter kl�der");
		System.out.println();
		System.out.println("   Vad vill du s�ka efter?");
		System.out.println();
		System.out.println("1. S�ka kl�der efter kl�dtyp");
		System.out.println("2. S�ka kl�der efter f�rg");
		System.out.println("3. S�ka kl�der efter stolek");
		System.out.println();
		System.out.println("4. G� tillbaka till start menyn.");
		System.out.println();
		System.out.print(">");
		int yourChoice = keyboard.nextInt();keyboard.nextLine();
		System.out.println();
		return yourChoice;
	}
	

	/* subSearchDir  f�r ett v�rde av subAddMenu() och k�r vald metod.*/

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
			default:System.out.println("Felaktigt alternativ f�rs�k igen!");
			break;
		}		
	}
}	

	
	/* F�ljande metoder �r alla metoder f�r diverse kl�desplagg som anv�ndaren kan
	 * l�gga till i registret.*/

	private void addShirt(){
		System.out.println("Fyll i f�ljande information:");

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

		System.out.println("Fyll i f�ljande information:");
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

		System.out.println("Fyll i f�ljande information:");
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

		System.out.println("Fyll i f�ljande information:");
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

		System.out.println("Fyll i f�ljande information:");
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

	
	
	
	
	
	

	
	
	
	
	
	
	
	
	/* searchClothType �r en metod f�r att hitta �t alla kl�der vars attribut Name matchar anv�ndarens s�k str�ng,*/

	private void searchClothType(){
		boolean found = false;

		System.out.println("Vilket sorts plagg s�ker du? (skriv i plural)");
		String x = keyboard.nextLine();
		
		for (int i = 0; i<allClothes.size();i++){
			if (x.equalsIgnoreCase(allClothes.get(i).getName())){
				System.out.println("Du har f�ljande kl�der av typen "+x);
				System.out.println();
				System.out.println(allClothes.get(i).toString()); 
				System.out.println();
					found = true;
			}		
		}		 if (!found){
					System.out.println("Det finns inte inget s�nt plagg("+x+") registret!");
	}
}



	
	/* searchClothColor �r en metod f�r att hitta �t alla kl�der vars attribut Name matchar anv�ndarens s�k str�ng,*/

	private void searchClothColor(){
		boolean found = false;

		System.out.println("Vilken f�rg s�ker du?");
		String x = keyboard.nextLine();
		for (int i = 0; i<allClothes.size();i++){
			if (x.equalsIgnoreCase(allClothes.get(i).getColor())){
				System.out.println("Du har f�ljande kl�der i f�rgen "+x);
				System.out.println();
				System.out.println(allClothes.get(i).toString()); 
				System.out.println();
				found = true;
			}		
		} 		if (!found){
			System.out.println(x +" finns inte n�gra kl�der i den f�rgen registret!");
	}
}




	/* searchClothsize �r en metod f�r att hitta �t alla kl�der vars attribut Name matchar anv�ndarens s�k str�ng,*/

	private void searchClothSize(){
		boolean found = false;

		System.out.println("Vilken storlek s�ker du?");
		String x = keyboard.nextLine();
		for (int i = 0; i<allClothes.size();i++){
			if (x.equalsIgnoreCase(allClothes.get(i).getSize())){
				System.out.println("Du har f�ljande kl�der av storlek "+x);
				System.out.println();
				System.out.println(allClothes.get(i).toString()); 
				System.out.println();
				found = true;
			}		
		} 		if (!found){
			System.out.println(" Det finns inget kl�desplagg med den storleken("+x +") i registret!");
	}
}


	
	
	/* viewAllClothes �r en metod f�r att lista alla kl�der som finns i garderoben som anv�ndaren valt att lagt till.,*/

	private void viewAllClothes(){

		System.out.println("Garderoben inneh�ller "+allClothes.size()+" st plagg och det �r f�ljande kl�der: ");
		System.out.println();
		int n = allClothes.size();
		for(int i = 0; i < n ; i++)
			System.out.println(allClothes.get(i)); 
		System.out.println();
	} 
	

	
	/* wash() anropar att alla objekt i arrayen allClothes ska k�ra metoden washCloth(); som finns i klassen Clothes.,*/


	private void wash(){
		for (Clothes c : allClothes){
			c.washCloth();
		}
		System.out.println();
		System.out.println("Alla kl�der har blivit tv�ttade!");
		System.out.println();

	}




	/* deleteItem �r en metod f�r att tabort n�got objekt som finns i garderoben som anv�ndaren valt att lagt till.
	 * deleteItem() fr�gar efter ett serienummer som kl�desplagget som finns har. Den tar sedan bort just det plagget ur arrayen, */

	private void deleteItem() {

		boolean found = false;
		int index = -1;
		int deleteMe;
		System.out.println("Vilken kl�desplagg vill du radera?");
		viewAllClothes();
		System.out.println();
		System.out.println();
		for (;;){
			try {
				System.out.print("Ange kl�desplaggets serienummer:");
				deleteMe = Integer.parseInt(keyboard.nextLine());
				System.out.println();
				break;

			}
			catch (NumberFormatException e){
				System.out.println("Serienumret m�ste best� av siffror!");

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
				System.out.println(deleteMe + " �r nu raderad raderad.");

			}
			if (!found){
				System.out.println(deleteMe+" finns inte i registret!");
			}
		

	}


	
	
		
		
	


	/*serialCheck �r det f�rsta anv�ndaren f� g� igenom n�r den vill l�gga till ett nytt objekt.
	 * serialCheck() k�r det valda serienummret mot alla serienummer alla som objekt har som attriut serialNr
	 * om det redan finns ett objekt med just det serienummret f�r anv�ndaren forts�ttat tills serienummret �r unikt*/


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
					System.out.println("Serienummret finns redan i registret, f�rs�k igen.");
				}
				return serialNr;			
			}

			catch (NumberFormatException e){
				System.out.println("Serienumret m�ste best� av siffror!");

			}


		}
		}


	}



	
	
	
	/* f�ljande metoder �r alla metoder som anv�nds f�r att l�gga till ett objekt*/
	
	
	private String addColor(){
		System.out.print("F�rg: ");
		String color = keyboard.nextLine();
		return color;
	}
	private int addYear(){
		int year;
		for (;;){
		try {
		System.out.print("Ink�pt �r: ");
			year = Integer.parseInt(keyboard.nextLine());
			return year;
			}
		catch (NumberFormatException e){
		System.out.println("Fel, �r m�ste skrivas med siffror!");
		}
	}
}
		
	private int addPrice(){
		
		for (;;){
		try {
		System.out.print("Ink�pt f�r pris: ");
		int	price = Integer.parseInt(keyboard.nextLine());
			return price;
			}
		catch (NumberFormatException e){
		System.out.println("Fel, pris m�ste skrivas med siffror!");
		}
	}
	}
	private String addSize(){
		System.out.print("Storlek (f�r byxor skriv midjem�tt): ");
		String size = keyboard.nextLine();
		return size;
	}
	private String addLength(){
		System.out.print("L�ngd: ");
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
		System.out.print("Antal tv�ttar sedan k�p: ");
			int washed = Integer.parseInt(keyboard.nextLine());
			return washed;
			}
		catch (NumberFormatException e){
		System.out.println("Fel, antal tv�ttar m�ste skrivas med siffror!");
		}
	}
	}
	private String addType(){
		System.out.print("Typ: ");
		String type = keyboard.nextLine();
		return type;
	}
}









