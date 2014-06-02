
import java.util.ArrayList;
import java.util.Scanner;


public class Inlupp2{
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Person> allaPersoner = new ArrayList <Person>();

		int val;

		for (;;){
			System.out.println();
			write("Vad vill du göra? \n 1. Lägga till ny person \n 2. Lägga till ny pryl \n 3. Visa alla \n" +
			" 4. Visa rikast \n 5. Visa viss person \n 6. Börskrasch \n 7. Avsluta programmet");
			val = readInt(keyboard);

			switch (val) {
			case 1:
				write("Ange namn: ");
				while(true){
					String nyttNamn = keyboard.nextLine();

					Person hittad = null;
					for (int i=0; i<allaPersoner.size(); i++)
					{
						if (allaPersoner.get(i).getNamn().equalsIgnoreCase(nyttNamn)){
							write("Personen finns redan, försök igen: ");
							hittad = allaPersoner.get(i); 
						}

					}

					if(hittad == null){
						Person person = new Person(nyttNamn);
						allaPersoner.add(person);
						write(nyttNamn + " är nu sparad.");
						break;
					}
				}
				break;	

			case 2:
				write("Vilken person äger prylen?");
				String namn = keyboard.nextLine();
				Person hittadPerson = null;
				for (int x=0; x<allaPersoner.size(); x++)
				{
					if (allaPersoner.get(x).getNamn().equalsIgnoreCase(namn)){
						hittadPerson = allaPersoner.get(x);
					}
				}

				if(hittadPerson == null){
					write("Personen finns inte, lägg till en person först.");
					break;
				}

				write("Vad är det för pryl?");
				String nypryl = keyboard.nextLine();
				if (nypryl.toLowerCase().equals("smycke")){
					write("Vad är det för smycke?");
					String namnSmycke = keyboard.nextLine();
					write("Är smycket av guld? (Ja/Nej)");
					String guld = keyboard.nextLine();
					write("Antal ädelstenar:");
					int antalAdelstenar = readInt(keyboard);
					Smycke smycke = new Smycke(namnSmycke, guld, antalAdelstenar);
					hittadPerson.addPryl(smycke);
					write("Prylen är sparad.");
				}
				if (nypryl.toLowerCase().equals("aktie")){
					write("Vad är namnet på aktien?");
					String namnAktie = keyboard.nextLine();
					write("Vad är priset på aktien?");
					double pris = readDouble(keyboard);
					write("Hur många aktier är det?");
					int antal = readInt(keyboard);
					Pryl aktie = new Aktie(namnAktie, pris, antal);
					hittadPerson.addPryl(aktie);
					write("Prylen är sparad.");
				}
				if (nypryl.toLowerCase().equals("apparat")){
					write("Vad är namnet på apparaten?");
					String namnApparat = keyboard.nextLine();
					write("Vad var inköpspriset på apparaten?");
					int inkopspris = readInt(keyboard);
					write("Hur sliten är apparaten på en skala 1 - 10 där 10 är nyinköpt?");
					int slitage = readInt(keyboard);
					Pryl apparat = new Apparat(namnApparat, inkopspris, slitage);
					hittadPerson.addPryl(apparat);
					write("Prylen är sparad.");
				}
				break;
			case 3:
				System.out.println("Alla personer: ");
				for (int i=0; i < allaPersoner.size(); i++){
					System.out.println(allaPersoner.get(i).getNamn() + "   " + allaPersoner.get(i).getTotalvarde());
				}

				break;
			case 4:
				double maximum = 0;
				Person rikast = null;
				for (int i=0; i<allaPersoner.size(); i++){
					if (allaPersoner.get(i).getTotalvarde() >= maximum){
						rikast = allaPersoner.get(i);
						maximum = allaPersoner.get(i).getTotalvarde();
					}
				}
				System.out.println("Rikast är " + rikast.getNamn() + " vars sammanlagda förmögenhet är " + maximum);
				System.out.println(rikast.toPersonsPrylarLista());

				break;
			case 5:
				write("Skriv in personen som du vill veta mer om: ");
				while(true){
					String soktPerson = keyboard.nextLine();

					Person vissPerson = null;
					for (int i=0; i<allaPersoner.size(); i++)
					{
						if (allaPersoner.get(i).getNamn().equalsIgnoreCase(soktPerson)){
							vissPerson = allaPersoner.get(i);
							System.out.println(allaPersoner.get(i).getNamn() + "s totala förmögenhet:   "
									+ allaPersoner.get(i).getTotalvarde() + "\nHen äger följande prylar:\n");
							System.out.println(vissPerson.toPersonsPrylarLista());
						}						
					}

					if(vissPerson == null){
						write("Personen finns inte, lägg till personen.");
						break;
					}
					break;
				}
				break;
			case 6:
				Person kraschPerson = null;
				for (int i=0; i < allaPersoner.size(); i++){
					kraschPerson = allaPersoner.get(i);
					kraschPerson.loopKrasch();
				}

				break;
			case 7:
				write("Programmet är nu avslutat, hej då! :)");
				System.exit(0);
				break;

			default:
				write("Felaktigt alternativ. Försök igen!");
			}			
		}
	}


	private static void write(String str) {
		System.out.println(str);
	}

	private static int readInt(Scanner keyboard){
		while(true){
			try {
				return Integer.parseInt(keyboard.nextLine());
			}catch(NumberFormatException e){
				System.out.println("Skriv ett heltal: ");
			}
		}
	}

	private static double readDouble(Scanner keyboard){
		while(true){
			try {
				return Double.parseDouble(keyboard.nextLine());
			}catch(NumberFormatException e){
				System.out.println("Skriv en siffra: ");
			}
		}
	}
}