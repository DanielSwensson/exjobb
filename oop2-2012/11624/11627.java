import java.util.Scanner;
import java.util.ArrayList;

public class MainProgram {

	private static ArrayList<Person> allaPersoner = new ArrayList<Person>();
	private static Scanner keyboard = new Scanner(System.in);

	public static int intInput(){
		for(;;){
			try{
				int i = Integer.parseInt(keyboard.nextLine());
				return i;
			}
			catch (NumberFormatException e){
				System.out.println("Fel! Numeriskt input tack! \n");
			}
		}
	}


	public static void main(String [] args){

		boolean done = false;


		while(!done){

			System.out.print("\nVälkommen till vårt register. \n" + "HUVUDMENY: \n 1. Skapa person " +
					"\n 2. Skapa pryl \n 3. Visa alla personer \n 4. Visa rikast " +
					"\n 5. Visa viss person \n 6. Börskrasch \n 7. Avsluta \n");

			String command = keyboard.nextLine();


			switch(command){
			case "1":
				boolean personFinns = false;
				System.out.print("\nVad heter personen? ");
				String Namn = keyboard.nextLine();

				for (Person p : allaPersoner){
					if(Namn.equalsIgnoreCase(p.getNamn())){
						System.out.println("Personen finns redan i registret! \n");
						personFinns = true;
						break;
					}
				} if(personFinns == false){
					Person person = new Person(Namn);
					allaPersoner.add(person);

					System.out.println(Namn + " har nu lagts till! \n");			

				}
				break;

			case "2":
				boolean prylar = false;

				while(!prylar){

					System.out.print("\nVälj pryl att skapa: \n 1. Smycke \n 2. Apparat \n 3. Aktie \n");

					String val = keyboard.nextLine();


					switch(val){
					case "1":
						System.out.println("\nVem äger smycket?");
						String n = keyboard.nextLine();
						for (Person p : allaPersoner){
							if(n.equalsIgnoreCase(p.getNamn())){
								System.out.println("Vad är det för typ av smycke?");
								String smyckesTyp = keyboard.nextLine();
								System.out.println("Är smycket av guld? Ja eller nej.");
								String smyckeGuld = keyboard.nextLine();
								System.out.println("Hur många ädelstenar?");
								int antalStenar = intInput();

								Smycken komplettSmycke = new Smycken(n, smyckesTyp, smyckeGuld, antalStenar);
								p.getAllaPrylar().add(komplettSmycke);

								prylar = true;
							}
						}
						break;
					case "2":
						System.out.println("\nVem äger apparaten?");
						String na = keyboard.nextLine();
						for (Person p : allaPersoner){
							if(na.equalsIgnoreCase(p.getNamn())){
								System.out.println("Vad är det för apparat?");
								String appNamn = keyboard.nextLine();
								System.out.println("Vad kostade apparaten?");
								int appPris = intInput();

								while(true){

									System.out.println("På skala 1-10 där 10 är splitterny " +"på vilken skala är apparaten?");
									int appSlitage = intInput();

									if(appSlitage >= 1 && appSlitage <= 10){

										Apparater komplettApparat = new Apparater(na, appNamn, appPris, appSlitage);
										p.getAllaPrylar().add(komplettApparat);

										break;

									}else{
										System.out.println("Slitaget kan endast ha ett värde mellan 1 och 10");
									}
								}//while

								prylar = true;
							}
						}
						break;
					case "3":
						System.out.println("\nVem äger aktien?");
						String nam = keyboard.nextLine();
						for (Person p : allaPersoner){
							if(nam.equalsIgnoreCase(p.getNamn())){
								System.out.println("Vad är det för aktie?");
								String aktNamn = keyboard.nextLine();
								System.out.println("Hur många aktier äger " +nam);
								int aktAntal = intInput();
								System.out.println("Vad kostade aktierna?");
								int aktPris = intInput();

								Aktier komplettAktie = new Aktier(nam, aktNamn, aktAntal, aktPris);
								p.getAllaPrylar().add(komplettAktie);

								prylar = true;
							}
						}
						break;

					default: 
						System.out.println("Felaktigt kommando!");
						break;
					}
				}
				break;

			case "3":
				System.out.print("\nVill du visa alla personer? ");
				String alla = keyboard.nextLine();
				for (Person p : allaPersoner){
					if(alla.equalsIgnoreCase("ja")){
						System.out.println(p.toString());
					}
				}
				break;

			case "4":
				String nm = "NULL";
				int rik = 0;
				System.out.println("\nListar rikast person. \n");

				for (Person p : allaPersoner){
					if(p.getSumma() >= rik){
						rik = p.getSumma();
						nm = p.getNamn();
					}
				}
				System.out.println(nm + "   " + rik);
				break;

			case "5":
				System.out.print("\nVem vill du se?\n");
				String n = keyboard.nextLine();
				for (Person p : allaPersoner){
					if(n.equalsIgnoreCase(p.getNamn())){
						for (Pryl x : p.getAllaPrylar()){
							System.out.println(x.toString());
						}
					}
				}
				break;

			case "6":
				System.out.println("Börskrasch har skett! Alla utdelade aktier har värde 0! \n");
				for (Person p : allaPersoner){
					for (Pryl akt : p.getAllaPrylar()){
						if(akt instanceof Aktier){
							((Aktier) akt).bKrasch();
						}
					}
				}
				break;

			case "7":
				System.out.print("Avslutar programmet.\n Ha en bra dag.");
				done = true;
				break;

			default:
				System.out.print("Felaktigt kommando!");
				break;
			}
		}
	}
}

