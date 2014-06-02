package varderegister;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	private static Scanner keyboard = new Scanner(System.in);
	private static ArrayList<Person> personlista = new ArrayList<Person>();
	
	private static int readInt(String fraga){
		while (true){
			try{
				System.out.print(fraga);
				int xint = Integer.parseInt(keyboard.nextLine());
				return xint;
			}
			catch (NumberFormatException e){
				System.out.println("Fel, numeriskt v�rde m�ste anges.");
			}
		}
	}

	private static double readDouble(String fraga){
		while (true){
			try{
				System.out.print(fraga);
				double xdouble = Double.parseDouble(keyboard.nextLine());
				return xdouble;
			}
			catch (NumberFormatException e){
				System.out.println("Fel, numeriskt v�rde m�ste anges.");
			}
		}
	}
	
	private static String readString(String fraga){
		while (true){
			System.out.print(fraga);
			String xstring = keyboard.nextLine();
			
			if (xstring.trim().isEmpty()){
				System.out.println("Du m�ste ange n�gonting.");
			} else {
				return xstring;
			}	
		}
	}
	
	private static int visaMeny(){
		System.out.println("+---------------------------------------------+");
		System.out.println("V�lkommen till registerprogrammet. ");
		System.out.println("1. Skapa person.");
		System.out.println("2. Skapa pryl.");
		System.out.println("3. Visa alla registrerade personer.");
		System.out.println("4. Visa den rikaste personen.");
		System.out.println("5. Visa specifik person.");
		System.out.println("6. B�rskrasch.");
		System.out.println("7. Avsluta programmet.");
		return readInt("Ange Val >");
	}
	
	public static void main(String[] args) {
		int val = 0;
		
		while(true){
			val=visaMeny();
			System.out.println("+-------------------------------------------+");
			
			switch (val){
				case 1: 
					addPerson(); 
					break;
				case 2: 
					addPryl(); 
					break;
				case 3: 
					visaAlla(); 
					break;
				case 4: 
					visaRikaste(); 
					break;
				case 5: 
					visaSpecifik(); 
					break;
				case 6: 
					borskrasch(); 
					break;
				case 7: 
					System.out.println("Programmet avslutas!");
					System.exit(0);
					break;
				default: 
					System.out.println("Ogiltigt val, var god f�rs�k igen.");
					break;
			}
		}

	}
	
	private static void addPerson(){
		String namn = readString("Ange personens namn: ");
		if (hittaPerson(namn)!=null){
			System.out.println(namn+" finns redan i registret... ");
		} else {
			Person pe = new Person(namn);
			personlista.add (pe);	
			System.out.println(namn+" lades till i registret");
		}
	}
	
	private static void addPryl(){
		
		String namn = readString("Ange �gare: ");
		
		Person p=hittaPerson(namn);
		
		if(p==null){
			System.out.println(namn+" finns inte i registret");
			return;
		}
		
		String typ = readString("Ange typ (Smycke, aktie, apparat eller valfritt �vrigt f�rem�l): ");
		
		if (typ.equalsIgnoreCase("smycke")){
			String smyckestyp = readString("Ange typ av smycke: ");
			String metall = readString("Ange vilken metall smycket �r gjort av: ");
			int juvel = readInt("Ange hur m�nga �delstenar som finns i smycket: ");
			
			Smycke sm = new Smycke(smyckestyp, juvel, metall);
			p.addPryl(sm);
			return;
		}
		
		if (typ.equalsIgnoreCase("aktie")){
			String aktienamn = readString("Ange aktiens namn: ");
			double aktiepris = readDouble("Ange aktiens pris: ");
			int antalaktier = readInt("Ange antal aktier: ");
			
			Aktie ak = new Aktie (aktienamn, antalaktier, aktiepris);
			p.addPryl(ak);
			return;
		}
		
		if (typ.equalsIgnoreCase("apparat")){
			String apnamn = readString("Ange apparatens namn: ");
			double appris = readDouble("Ange apparatens ink�pspris: ");
			
			int apslitage=0;
			
			while (true){
				apslitage = readInt("Ange apparatens skick (1-10): ");
				if (apslitage<1||apslitage>10){
					System.out.println("Felaktigt skickv�rde, f�rs�k igen!");
				} else {
					break;
				}
			}
			
			Apparat ap = new Apparat (apnamn, appris, apslitage);
			p.addPryl(ap);
			return;
		}
		
		
		double varde = readDouble("Ange v�rde: ");
		
		Ovrigt ovrigt=new Ovrigt(typ,varde);
		p.addPryl(ovrigt);
		
	}
	
	private static void visaAlla(){
		System.out.println("I registret finns:");
		for(int i=0;i<personlista.size();i++){
			Person p=personlista.get(i);
			System.out.println(p.getNamn()+" �ger:");
			p.visaPrylar();
		}
	}
	
	private static void visaRikaste(){
		Person rikaste=null;
		
		for(int i=0;i<personlista.size();i++){
			Person p=personlista.get(i);
			if(rikaste==null || rikaste.prylarsVarde() < p.prylarsVarde()){
				rikaste=p;
			}
		}
		
		System.out.println(rikaste.getNamn()+ " �r rikast och har " + rikaste.prylarsVarde()+" kr.");
		rikaste.visaPrylar();
	}
	
	private static Person hittaPerson(String namn){
		for(Person p : personlista){
			if(p.getNamn().equalsIgnoreCase(namn)){
				return p;
			}
		}	
		return null;
	}
	
	private static void visaSpecifik(){
		String namn = readString("Vem vill du hitta: ");
		Person p = hittaPerson(namn);
		if (p==null){
			System.out.println("Personen finns inte i registret.");
			return;
		}
		System.out.println(namn+" har "+p.prylarsVarde()+" kr.");
		p.visaPrylar();
	}
	
	private static void borskrasch(){
		for(Person p : personlista){
			p.borskrasch();
		}
		System.out.println("B�rskrasch noterad, alla aktier �r nu v�rda 0.");
	}

}
