import java.util.ArrayList;
import java.util.Scanner;

public class Registrering {

	private Scanner scan = new Scanner(System.in);
	
	public int readInt(){
		do{
			try{
				int result = Integer.parseInt(scan.nextLine());
				return result;
			}catch(NumberFormatException e){
				System.out.println("Felaktig inmatning");
			}
		}while(true);
	}
	
	public Registrering(){
		ArrayList<Person> register = new ArrayList<Person>();

		boolean running = true;
		while (running) {
			
			System.out.println("Hej! Vad vill du g�ra?");
			System.out.println("1. Skapa person");
			System.out.println("2. Skapa pryl");
			System.out.println("3. Visa alla");
			System.out.println("4. Visa rikaste");
			System.out.println("5. Visa viss person");
			System.out.println("6. B�rskrash");
			System.out.println("7. Avsluta");

			int choice;
			try {
				choice = Integer.parseInt(scan.nextLine());
				System.out.println("Du skrev in: " + choice);
			} catch(Exception e){
				choice = -1;
			}


			switch (choice) {
			// skapa person
			case 1:
				System.out.println("Du kan nu skapa en person!");
				System.out.println("Vad heter du?");
				String name = scan.nextLine();
				Person p = new Person(name);
				register.add(p);
				// add Array in register
				// l�gg till person i register
				break;

				// skapa pryl
			case 2:
				System.out.println("Du kan nu skapa en pryl!");
				System.out.println("Vad �r ditt namn?");
				String ownerName = scan.nextLine();
				Person owner = null;

				// se till s� att personen finns i arraylisten register
				for (Person pers : register) {
					if (pers.getName().equals(ownerName)) {
						owner = pers;
					}

				}
				if (owner == null) {
					System.out
					.println("B�rja om p� nytt, person du skrev in existerar inte!");
					break;

					// vad h�nder om en �gare inte finns?

				}

				// forloop som g�r igenom tregister och ser s� att person med
				// namnet owner finns

				// h�mta ut personen och skapa ett objekt av hopnom som ni sedan
				// kan addera prylen till
				System.out.println("Vilken sorts pryl �ger du?");
				System.out.println("1. Elektronik");
				System.out.println("2. Smycke");
				System.out.println("3. Aktier");
				//int choice1 = Integer.parseInt(scan.nextLine());
				String choice1 = (scan.nextLine());
				if (choice1.equalsIgnoreCase("1")) {

					System.out.println("Vad �ger du f�r elektronikprylar?");
					String name1 = scan.nextLine();
					System.out.println("Vad �r ink�pspriset?");
					try{
						int pris = readInt();
						System.out.println("�r den sliten?, v�lj ett tal mellan 1-10 d�r 10 �r nyast och 1 �r v�ldigt slitet");
						int slitage = readInt();
						Apparat a = new Apparat(name1, pris, slitage);
						owner.add(a);
					}catch(Exception e){
						System.out.println("Fel");
					}

				} else if (choice1.equalsIgnoreCase("2")) {
					System.out.println("Vilken sorts smycken �ger du?");
					String typ = scan.nextLine();
					System.out.println("�r det guld eller silver?");
					String metall = scan.nextLine();
					System.out.println("Hur m�nga �delstenar har smycket?");
					int stenar = readInt();
					Smycke smycke = new Smycke(typ, metall, stenar);
					owner.add(smycke);

				} else if (choice1.equalsIgnoreCase("3")) {
					System.out.println("Vad �r namnet p� dina aktier?");
					String aktie = scan.nextLine();
					System.out.println("Hur m�nga aktier �ger du?");
					int antal = readInt();
					System.out.println("Vad �r priset p� dina aktier?");
					int pris = readInt();
					Aktie akt = new Aktie(aktie, antal, pris);
					owner.add(akt);

				}
				else{
					System.out.println("Ej giltigt val!");
				}

				break;
			case 3:

				System.out.println("Dessa personer finns i registret");
				for (int x = 0; x < register.size(); x++)
					System.out.println(register.get(x));
				break;

			case 4:

				System.out.println("Den h�r personen �r rikast!");
				Person rikast = register.get(0);
				for (int x = 1; x < register.size(); x++) {
					if (rikast.getKapital() < register.get(x).getKapital()) {
						rikast = register.get(x);
					}
				}
				System.out.println(rikast.getName()
						+ " �r rikast, f�rm�genhet: " + rikast.getKapital()
						+ " kr.");

				//skriv ut personens saker
				break;

			case 5:
				System.out.println("Visa vem: ");
				String visa = scan.nextLine();
				boolean isFound = false;
				for (Person p2 : register) {
					if (p2.getName().equalsIgnoreCase(visa)) {
						System.out.println(p2.print());
						isFound = true;
					}
				}
				if (!isFound)
					System.out.println("Personen hittades inte :(");

				break;

			case 6:
				for (Person p3 : register) {
					p3.b�rsKrasch();
				}

				break;

			case 7:
				System.out.println("Du har nu valt att avsluta!, tack f�r du har varit med och k�rt v�rt program");
				running = false;
				break;
			case -1:
				break;
			}
		}

	}

	public static void main(String[] args) {
		new Registrering();

	}
}
