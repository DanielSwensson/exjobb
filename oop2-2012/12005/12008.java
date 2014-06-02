import java.util.Scanner;
import java.util.ArrayList;
public class Huvudprogram {
	static ArrayList <Person> allaPersoner = new ArrayList<Person>();
	static Scanner keyboard =new Scanner (System.in);
	static int readInt(String fråga){
		for(;;){
			try{
				System.out.print(fråga);
				int x = Integer.parseInt(keyboard.nextLine());
				return x;	
			}
			catch (NumberFormatException e){
				System.out.println("Fel, ska vara numeriskt värde");
			}
		}

	}
	static String readString (String fråga){
		System.out.print(fråga);
		String str=keyboard.nextLine();
		return str;
	}
	public static Person getPerson(String namn)
	{
		for(Person p:allaPersoner)
		{
			if(p.getNamn().equalsIgnoreCase(namn))
			{
				return p;
			}
		}
		return null;
	}
	public static void visaRikast()
	{
		Person rikast = allaPersoner.get(0);

		for(Person p:allaPersoner)
		{
			if(p.getRikedom() > rikast.getRikedom())
			{
				rikast = p;
			}
		}


		System.out.println("Rikaste är " + rikast.getNamn() + " som sammanlagt äger " + rikast.getRikedom());
		visaPrylar(rikast);
	}
	public static void visaPerson()
	{
		String namn = readString("Vad heter personen: ");
		Person p = getPerson(namn);
		if (p==null){
			System.out.println("Personen finns ej");
		}else{
			System.out.println(p.getNamn());
			visaPrylar(p);
		}
	}
	public static void visaPrylar(Person p)
	{
		for(Pryl prylar:p.getPersonPrylar())
		{
			System.out.println("   " + prylar.getNamn() + "\t" + prylar.getVärde());
		}
	}
	public static void visaAlla()
	{
		System.out.println("I registret finns:");

		for(Person person:allaPersoner)
		{
			System.out.println(person.getNamn() + "\t" + person.getRikedom());

		}
	}
	public static void börskrasch(){
		for(Person p:allaPersoner){
			p.börskrasch();
		}
	}
	public static void main(String[] args) { 
		for (;;){
			int val = readInt("Register för värdesaker:\nVälj vad du vill göra? (1-7):\n1. Registrera\n2. Lagg till pryl\n3. Lista alla personer\n4. Visa rikast\n5. Visa viss person\n6. Börskrasch\n7. Avsluta\nVälj kommando: ");



			switch (val){
			case 1:
				skapaPerson();
				break;
			case 2:
				skapaPryl();
				break;
			case 3:
				visaAlla();
				break;
			case 4:
				visaRikast();
				break;
			case 5:
				visaPerson();
				break;
			case 6:
				börskrasch();
				break;
			case 7:
				System.out.println("Hejdå och välkommen åter!");
				System.exit(0);
			default:
				System.out.println("Fel siffra! Gör om, gör rätt!");
			}

			System.out.println("---------------");
		}
	}	   
	static void skapaPerson(){ 
		String namn = readString("Vad heter personen: ");
		Person p = getPerson(namn); 
		if (p!=null){
			System.out.println("Den personen finns redan");
		}else{
			Person pers = new Person(namn);
			allaPersoner.add(pers);
		}
	}
	static void skapaPryl(){ 
		Person person;
		String namn = readString("Vilken person äger prylen: ");
		person = getPerson(namn);
		if (person==null){
			System.out.println("Personen finns ej");
		}else{

			String prylSort = readString("Vilken sorts pryl (Smycke, apparat eller aktie): ");

			if (prylSort.equalsIgnoreCase("smycke")) {
				String na = readString("Vilket sorts smycke: ");
				int ädel = readInt("Antal ädelstenar: ");
				String va = readString("Silver eller guld: ");
				if (va.equalsIgnoreCase("Guld")){
					person.addPryl(new Smycke(na, ädel, va));
				}else if (va.equalsIgnoreCase("Silver")){
					person.addPryl(new Smycke(na, ädel, va));
				}else{
					System.out.println("Valören ska vara av guld eller silver!");

				}

			} else if (prylSort.equalsIgnoreCase("apparat")) {
				String na = readString("Vilket sorts apparat: ");
				int in = readInt("Vilket inköpspris: ");
				int sl = readInt("Slitage 1-10 (1 är jättegammalt, 10 är helt nytt): ");
				person.addPryl(new Apparat(na, in, sl));

			} else if (prylSort.equalsIgnoreCase("aktie")) {
				String na = readString("Vilket sorts aktie: ");
				int an = readInt("Hur många aktier: ");
				int p = readInt("Pris per aktie: ");			
				person.addPryl(new Aktie(na, an, p));

			} else {
				System.out.println(prylSort+" finns inte att välja på, du får välja aktie, apparat eller smycke.");
			}

		}
	}
}

