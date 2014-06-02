import java.util.*;

public class Prylregister {
	/**
	 * @uml.property  name="keyboard"
	 */
	private Scanner keyboard = new Scanner(System.in);
	/**
	 * @uml.property  name="allaPersoner"
	 * @uml.associationEnd  multiplicity="(0 -1)" elementType="Person"
	 */
	private ArrayList<Person> allaPersoner = new ArrayList<Person>();
	//Arraylista med personer som kan anv�ndas var som helst i prylregister
	
	public Prylregister(){
		this.run();
	}
	public void run()
	{
		while(true){
			try{
				System.out.println(" ");
				System.out.println("G�r ett val: ");
				System.out.println("1. L�gg till person");
				System.out.println("2. L�gg till pryl till person");
				System.out.println("3. Visa alla");
				System.out.println("4. Visa f�r en person");
				System.out.println("5. Visa rikast");
				System.out.println("6. Aktiekrasch");;
				System.out.println("7. Avsluta program");
				int answer = Integer.parseInt(keyboard.nextLine());
				switch(answer){
				case 1:
					addPerson();
					break;
				case 2:
					addPryl();
					break;
				case 3:
					showAll();
					break;
				case 4:
					showCertainPerson();
					break;
				case 5:
					showRichest();
					break;
				case 6: 
					crash();
					break;
				case 7:
					System.exit(1);
					break;
				case 8:
					addTestPeople();
					break;
				default:
					System.out.println(answer + " �r inte ett giltigt kommando");
					break;	
				}
			}catch (NumberFormatException e){
				System.out.println("Fel - m�ste vara numeriskt v�rde");
			}
		}
	}
	
	
	public void addPerson(){
		System.out.print("Ange personens namn: ");
		String inputName = keyboard.nextLine();
		if (allaPersoner.size() != 0){
			checkIfExists(inputName);
		}else{
			allaPersoner.add(new Person(inputName));
		}
	}
	
	
	public void checkIfExists(String inputName){
		boolean notFound = true;
		for (Person p : allaPersoner){
			if (p.getName().equalsIgnoreCase(inputName)){
				System.out.println(inputName + " finns redan i registret");
				notFound = false;
			}
		}
		if (notFound == true){
			allaPersoner.add(new Person(inputName));
		}
	}
	
	public void doesNameExist(String inputName){
		boolean notFound = true;
		for (Person p : allaPersoner){
			if (p.getName().equalsIgnoreCase(inputName)){
				notFound = false;
				break;
			}
		}
		if (notFound == true){
			System.out.println(inputName + " finns inte med i registret");
		}
	}
	
	public void addPryl(){
		System.out.println(" ");
		System.out.print("Vem �ger prylen? ");
		String inputName = keyboard.nextLine();
		doesNameExist(inputName);
		for (Person p : allaPersoner){
			if (p.getName().equalsIgnoreCase(inputName)){
				while(true){
					try{
						System.out.println(" ");
						System.out.println("Vilken pryl �r det?");
						System.out.println("1. Smycke");
						System.out.println("2. Apparat");
						System.out.println("3. Aktie");
						System.out.println("4. Avsluta, jag vill inte l�gga till fler prylar till " + inputName);
						int answer = Integer.parseInt(keyboard.nextLine());
						switch(answer){
						case 1:
							prylSmycke(inputName);
							break;
						case 2:
							prylApparat(inputName);
							break;
						case 3:
							prylAktie(inputName);
							break;
						case 4:
							run();
							break;
						default:
							System.out.println("Inte ett gilitigt val");
							break;
						}
					}catch(Exception e){
						System.out.println("Fel - du m�ste ange ett numeriskt v�rde");
					}
				}
			}
		}
	}
		
	public void prylSmycke(String inputName){
		int x = 1;
		do{
			for (Person p : allaPersoner){
				try{
					if(p.getName().equals(inputName)){
					System.out.print("Vad �r det f�r typ av smycke: ");
					String smyckeNamn = keyboard.nextLine();
					System.out.print("Hur m�nga �delstenar har " + smyckeNamn + "? ");
					int amountOfGems = Integer.parseInt(keyboard.nextLine());
					System.out.print("�r det gjort av guld eller silver? ");
					String isGoldOrSilver = keyboard.nextLine();
					p.addPryl(new Smycke(smyckeNamn, amountOfGems, isGoldOrSilver));
					x=2;
					}
				}catch(Exception e){
					System.out.println("Fel - M�ste vara ett numeriskt v�rde");
				}
			}
		}while(x==1);
	}
	
	public void prylApparat(String inputName){
		int x = 1;
		do{
			for (Person p : allaPersoner){
				try{
					if(p.getName().equals(inputName)){
					System.out.print("Vad �r det f�r typ av apparat? ");
					String apparatNamn = keyboard.nextLine();
					System.out.print("Vad �r ink�pspriset f�r " +apparatNamn+ "? ");
					int purchasePrice = Integer.parseInt(keyboard.nextLine());
					System.out.print("Ange slitaget p� apparaten, skala 1-10 (10 anses som ny): ");
					int slitage = Integer.parseInt(keyboard.nextLine());
					p.addPryl(new Apparat(apparatNamn, purchasePrice, slitage));
					x = 2;
					}
				}catch(Exception e){
					System.out.println("Fel - v�rdet m�ste vara numeriskt");
				}
			}
		}while (x==1);
	}
	
	public void prylAktie(String inputName){
		int x = 1;
		do{
			for (Person p : allaPersoner){
				try{
					if(p.getName().equals(inputName)){
					System.out.print("Vart har du innehavet av din aktie? ");
					String aktieNamn = keyboard.nextLine();
					System.out.print("Hur mycket kostade varje " + aktieNamn +"aktie? ");
					int pricePerPost = Integer.parseInt(keyboard.nextLine());
					System.out.print("Hur m�nga " +aktieNamn+"aktier har " +inputName + "? ");
					int amountOfPosts = Integer.parseInt(keyboard.nextLine());
					p.addPryl(new Aktie(aktieNamn, pricePerPost, amountOfPosts));
					x=2;
					}
				}catch(Exception e){
					System.out.println("Fel - m�ste vara numeriskt v�rde");
				}
			}
		}while (x==1);
	}
	
	public void showAll()
	{
		System.out.println("I registret finns: ");
		for (int x = 0; x<allaPersoner.size(); x++){
			System.out.println(allaPersoner.get(x).toString());
		}
	}
	
	public void showCertainPerson()
	{
		Person certainPerson = new Person("ingen");
		System.out.println("Vem vill du titta n�rmre p�? ");
		String inputName = keyboard.nextLine();
		doesNameExist(inputName);
		for (Person p : allaPersoner){
			if(p.getName().equals(inputName)){
				certainPerson = p;
				System.out.println(certainPerson.toStringCertainPerson());
				certainPerson.printArrayAllaPrylar();
			}
		}
	}
	
	public void showRichest()
	{
		Person richest = new Person("ingen");
		for (Person p : allaPersoner){
			if(p.totalValue() > richest.totalValue()){
				richest = p;
			}
		}
		System.out.println(richest.toStringRichest());
		richest.printArrayAllaPrylar();
	}
	public void crash(){
		for (Person p : allaPersoner){
			p.aktieCrash();
		}
	}
	public void addTestPeople(){
		allaPersoner.add(new Person ("Niklas"));
		allaPersoner.add(new Person ("Henrik"));
		allaPersoner.add(new Person ("Tor"));
	}
}

