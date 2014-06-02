import java.util.*;

public class Index {

	private static Scanner sc;
	private static ArrayList<Person> persons;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		persons = new ArrayList<Person>();

		System.out.println("Välkommen till värdesaksregistret!");
		System.out.println();
		running();
		System.out.println("Hej då");

	}

	private static void running(){
		boolean going = true;
		while(going){

			printMessage();
			System.out.print("> ");
			int selection = 0;

			try{
				selection =sc.nextInt();
			}catch(InputMismatchException e){}
			sc.nextLine(); //Behövs för att ta bort newline tecknet eftersom nextInt() bara läser inten och inte \n tecknet

			if(selection == 1){

				System.out.println("Ange personens namn:");
				String name = sc.nextLine();
				boolean personName = false;
				for (int x = 0; x < persons.size(); x++) {
					if (persons.get(x).getPersonName().equalsIgnoreCase(name)) {
						personName = true;
						System.out.println("Den personen finns redan ");
					}
				}
				if (personName == false) {
					Person ny = new Person(name);
					persons.add(ny);

				}
			}
			else if(selection == 2){
				boolean found = false;{
					if (persons.size() == 0) {
						System.out.println("Det finns inga personer registrerade. Skapa person för att kunna skapa en ny pryl");
					} 
					else {
						while (found == false) {
							System.out.println("Vad heter ägaren?");
							Person person = null;
							String personName = sc.nextLine();
							for (int x = 0; x < persons.size(); x++) {
								if (persons.get(x).getPersonName().equalsIgnoreCase(personName)) {
									found = true;
									person = persons.get(x);
								}
							}
							if (found == false) {
								System.out.println("personen finns inte");
							} 
							else {
								int kom = -1;
								System.out.println("Vilken sorts pryl vill du registrera? "
										+ " 1-Smycke" + " 2-Aktiepost " + " 3-Apparat ");
								try {
									kom = Integer.parseInt(sc.nextLine());
								} catch (NumberFormatException exception) {
									System.out.println("Fel kommando");
									return;
								}
								if (kom != 1 && kom != 2 && kom != 3) {
									System.out.println("Fel kommando");
								} 
								else {
									String name = "";
									Pryl ny = null;
									switch (kom) {
									case 1:
										System.out.println("Namn på smycket?");
										name = sc.nextLine();
										System.out.println("Hur många ädelstenar finns på smycket?");
										int gemstoneAmount = readNumber();
										if (gemstoneAmount == -1) {
											return;
										}
										System.out.println("Är smycket i guld eller silver?");
										String type = sc.nextLine();
										if (type.equalsIgnoreCase("guld") == false
												&& type.equalsIgnoreCase("Silver") == false) {
											System.out.println("Fel metallsort");
											return;
										}
										ny = new Smycke(name, type, gemstoneAmount);
										person.laggTill(ny);
										break;
									case 2:
										System.out.println("Vad heter aktien?");
										name = sc.nextLine();
										System.out.println("Hur många aktier?");
										int amount = readNumber();
										if (amount == -1) {
											return;
										}
										System.out.println("Pris per aktie?");
										int price = readNumber();
										if (price == -1) {
											return;
										}
										ny = new Aktie(name, amount, price);
										person.laggTill(ny);
										break;
									case 3:
										System.out.println("Namn på apparaten?");
										name = sc.nextLine();
										System.out.println("Inköpspris?");
										int purchacePrice = readNumber();
										if (purchacePrice == -1) {
											return;
										}
										System.out.println("Hur sliten är apparaten på en skala från 10-1 dä 10 är 100% som nyskick?");
										int wear = readNumber();
										if (wear == -1) {
											return;
										}
										ny = new Apparat(name, purchacePrice, wear);
										person.laggTill(ny);
										break;
									}
								}
							}
						}
					}
				}
			}

			else if(selection == 3){
				for (int x = 0; x < persons.size(); x++)
					System.out.println(persons.get(x).toString());
				System.out.println("Dessa personer finns i registret");
			}
			else if(selection == 4){
				int richest = 0;
				for (int x = 1; x < persons.size(); x++)
					if (persons.get(x).getTotalWealth() > persons.get(richest).getTotalWealth()) {
						richest = x;
					}
				System.out.println(persons.get(richest).toString());
				System.out.println(persons.get(richest).getAllPrylar());
			}
			else if(selection == 5){
				System.out.println("Ange personens namn:");
				String name = sc.nextLine();
				boolean personName = false;
				for (int x = 0; x < persons.size(); x++) {
					if (persons.get(x).getPersonName().equalsIgnoreCase(name)) {
						personName = true;
						System.out.println(persons.get(x).toString());
						System.out.println(persons.get(x).getAllPrylar());
					}
				}
				if (personName == false) {
					System.out.println("personen finns inte");
				}
			}
			else if(selection == 6){
				for (int x = 0; x < persons.size(); x++) {
					Person pers = persons.get(x);
					pers.setRemoveAktieValue();
				}
				System.out.println("Alla aktieposter har nu värdet 0 kr");
			}

			else if(selection == 7){
				going = false;
			}

			else{
				System.out.print("Komandot kan inte genomföras, försök igen.");
			}
		}
	}
		Person getPerson(String name){
			for (Person pers : persons){
				if (pers.getPersonName().equalsIgnoreCase(name))
					return pers;
			}
			return null;
		}

		private static void printMessage(){
			System.out.println("Välj ett alternativ: ");
			System.out.println("1: Skapa person" );
			System.out.println("2: Skapa värdesak" );
			System.out.println("3: Visa alla");
			System.out.println("4: Visa rikaste");
			System.out.println("5: Visa en person");
			System.out.println("6: Börskrasch");
			System.out.println("7: Avsluta");
		}
		public static int readNumber() {
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException exception) {
				System.out.println("Fel kommando");
				return -1;
			}
		}
	}
