import java.util.*;

public class MainProgram {
	
	ArrayList<Person> peopleIndex = new ArrayList<Person>();
	private static Scanner keyboard = new Scanner(System.in);
	
	private int readInt(String question){
		for(;;){
			try{
				System.out.print(question);
				int answear = Integer.parseInt(keyboard.nextLine());
				return answear;
			}
			catch (NumberFormatException e){
				System.out.println("Fel, ska vara ett nummer");
			}
		}
	}
	private String readString(String question){
		System.out.print(question);
		String answear = keyboard.nextLine();
		return answear;
	}
	private Person getPerson(String name){
		for (Person p : peopleIndex)
			if (p.getName () .equalsIgnoreCase (name))
				return p;
		return null;
	}
	private void createPerson(){
		String name = readString("Nya personens namn: ");
		Person p = getPerson(name);
		if (p != null)
			System.out.println("Den personen finns redan");
		else{
			Person fresh = new Person(name);
			peopleIndex.add(fresh);
		}
	}
	private void createGadget(){
		String name = readString("Vilken person äger prylen: ");
		if(getPerson(name) != null){
			boolean found = false;
			Person right = null;
			for (Person p : peopleIndex){
				if (p.getName() .equalsIgnoreCase(name)){
					right = p;
					found = true;
				}
			}
			
			if(found){
				String gadget = readString("Vilken sorts pryl? Smycke, aktie eller apparat: ");
				
				if (gadget .equalsIgnoreCase("Smycke")){
					String jewleryName = readString("Vilken typ av smycke? Halsband, armband eller ring: ");
					String jewleryMaterial = readString("Vilket sorts material? Guld eller silver: ");
					int jewleryGems = readInt("Hur många ädelstenar: ");
					
					Jewlery jew = new Jewlery (jewleryName, jewleryMaterial, jewleryGems);
					right.gadgetIndex.add(jew);
				
					}
				if (gadget .equalsIgnoreCase("Aktie")){
					String stockName = readString("Vad heter aktien: ");
					int stockNumber = readInt("Hur många aktier: ");
					int stockPrice = readInt("Vad är priset per aktie: ");
				
					Stock stock = new Stock (stockName, stockNumber, stockPrice);
					right.gadgetIndex.add(stock);
				
					}
				if (gadget .equalsIgnoreCase("Apparat")){
					String appName = readString("Vilken sorts apparat är det: ");
					int appPurchasePrice = readInt("Vad var inköpspriset: ");
					int appWear = readInt("Vad är slitaget? 1-10, där 10 är ny och 1 är ursliten: ");
				
					Appliance app = new Appliance (appName, appPurchasePrice, appWear);
					right.gadgetIndex.add(app);
				}
			}
		}
		else 
			System.out.println("Det finns ingen sådan person i registret!");
	}
	
	private void showAll(){
		for(Person p : peopleIndex){
			System.out.println(p);
		}
	}
	private void showRichest(){
		double max = 0;
		String nameOnRichest = null;
		for(Person p : peopleIndex){
			if(p.getSum() > max){
				max = p.getSum();
				nameOnRichest = p.getName();
			}
		}
		System.out.println("Rikast är " + nameOnRichest + " som sammanlagt äger " + max);
		for (Person p : peopleIndex){
			if (p.getName().equalsIgnoreCase(nameOnRichest))
			System.out.println(p.getGadget());
		}
	}
	private void showCertain(){
		String certain = readString("Vilken person vill du visa: ");
		for(Person p : peopleIndex){
			if(p.getName().equalsIgnoreCase(certain)){
				System.out.println(p + "\n");
				System.out.println(p.getGadget());
			}
		}
	}
	private void stockMarketCrash(){
			for(Person p : peopleIndex){
				p.startMarketCrash();
			}
		
		System.out.println("Börskrasch!");
	}
	
	public static void main(String[] args){
		MainProgram mp = new MainProgram();
		System.out.println("Välkommen till Prylprogrammet!");
		for(;;){
			int choice = mp.readInt("Tryck 1 för att skapa en person: \nTryck 2 för att skapa en " +
					"pryl: \nTryck 3 för att visa alla personer: \nTryck 4 för att visa den rikaste " +
					"personen: \nTryck 5 för att visa en viss person: \nTryck 6 för att få en " +
					"börskrasch: \nTryck 7 för att avsluta programmet: ");
			switch (choice){
				case 1: mp.createPerson(); break;
				case 2: mp.createGadget(); break;
				case 3: mp.showAll(); break;
				case 4: mp.showRichest(); break;
				case 5: mp.showCertain(); break;
				case 6: mp.stockMarketCrash(); break;
				case 7: System.out.println("Tack och hej då!");
						System.exit(0);
				default: System.out.println("Fel kommando");
				
			}
		}
	}
}
