
import java.util.Scanner;
import java.util.ArrayList;

public class Registerprogram{
	public static void main(String args[]){

		ArrayList<Person>allapersoner= new ArrayList<Person>();

		Scanner tgb = new Scanner(System.in);

		for(;;){

			try {

				System.out.print("1-Registrera\n2-L�gg till pryl\n3-Lista alla personer\n4-Visa rikast\n5-Visa viss person\n6-B�rskrasch\n7-Avsluta\nV�lj kommando 1-7: ");

				int val = Integer.parseInt(tgb.nextLine());

				switch(val){




				case 1: //L�gg till personer 
					boolean funnen = false;
					System.out.print(" Skriv in personens Namn: ");
					String name = tgb.nextLine();

					for(Person p1 : allapersoner){

						if(p1.getName().equalsIgnoreCase(name)){
							System.out.println("Person med det angivna namnet "+name+ " finns redan");
							funnen= true;

						}   
					}


					if(!funnen){

						Person person = new Person(name);
						allapersoner.add(person);
						System.out.println("\nPersonen vid namn "+name+ " �r tillagd");

					}

					break;

				case 2: //L�gg till pryl f�r person
					String material = "";
					System.out.print("F�r vem ska prylen l�ggas till? ");

					String vem = tgb.nextLine();
					Person person = null;
					for(Person p1 : allapersoner){
						if (vem.equalsIgnoreCase(p1.getName())){
							person = p1;
						}
					}
					
					if (person == null) {
					     System.out.println("Personen "+vem+" finns inte");
					     break;
					}
					
					System.out.print("Vilken sorts pryl?\n 1-Smycke\n 2-Aktie \n 3-Apparat");
					String prylNamn = tgb.nextLine();


					if(prylNamn.equalsIgnoreCase("1")){
               
						System.out.print("Vilken typ av smycke: ");

						String typ = tgb.nextLine();

						System.out.print("Antal �delstenar: ");


						int antalStenar = Integer.parseInt(tgb.nextLine());
						System.out.print("Ange material\n 1-Guld\n 2-Silver");

						String materialval = tgb.nextLine();

						if(materialval.equalsIgnoreCase("1")){
							material = "guld";
						}
						
						else if(materialval.equalsIgnoreCase("2")) {
							material = "silver";
							
				
						}
						else
							System.out.println(" Felaktigt val var god ange Material 1- guld eller 2-Sil");
						
						
						Smycke smy = new Smycke(prylNamn, typ, antalStenar, material);

						person.addPryl(smy);
					}


					else if(prylNamn.equalsIgnoreCase("2")){

			
						System.out.print("Aktiens namn: ");

						String ptyp = tgb.nextLine();

						System.out.print("Antal aktier: ");

						int antal = Integer.parseInt(tgb.nextLine());

						System.out.print("Pris per aktie: ");

						int pris = Integer.parseInt(tgb.nextLine());

						Aktie a = new Aktie(ptyp, ptyp, antal, pris);

						person.addPryl(a);
					}

					else if(prylNamn.equalsIgnoreCase("3")){
                      
					
						System.out.print("Ange typ av apparat ");

						String typ = tgb.nextLine();

						System.out.print("Apparatens pris: ");

						int Pris = Integer.parseInt(tgb.nextLine());

						System.out.print("Ange slitageniv� 1-10, 10=nyskick: ");

						int slitage = Integer.parseInt(tgb.nextLine());

						Apparat app = new Apparat(prylNamn, typ, Pris, slitage);
						person.addPryl(app);
					}


					else{
						System.out.println("Pryltypen "+prylNamn+" finns inte, v�lj mellan: pryltyperna 1-3, 1: Smycke 2: Aktie  eller 3: Apparat.");
					}



					break;
				case 3: //Skriv ut alla
					int count=1;
					System.out.println();
					System.out.println("I registret finns: " );
					for(Person p1 : allapersoner){
						System.out.println(count+". "+p1+" som har prylarna: "+p1.getPryl()+"");
						count++;
					}
					System.out.println("");


					break;

				case 4: //Visa rikast
					Person rik = allapersoner.get(0);
					for(Person p1 : allapersoner){

						if(rik.getCash()<p1.getCash()){

							rik=p1;
						}
					}

                    System.out.println();
					System.out.println(rik.getName()+" �r rikast, F�rm�genhet till ett v�rde av: "+rik.getCash()+" kr.");
					break;

					

				case 5: //Visa viss person

					System.out.print("Vem skall visas? ");
					Person person1 = null;
					String visas = tgb.nextLine();
					
					for(Person p1 : allapersoner){
						
						if (visas.equalsIgnoreCase(p1.getName())){
							person1=p1;
					
					        System.out.println();
							System.out.println(p1+",har prylarna: "+p1.getPryl());
						}
					}
					
					if (person1 == null) {
					     System.out.println("Personen " +visas+ "finns inte");
					   
					}
					     
					     break;
					




				case 6: //B�rskrasch
					System.out.println("\n--- B�RSKRASCH!----");
					for(Person p1 : allapersoner){
						p1.stockMcrash();


					}

					break;


				    case 7:
					   System.exit(0);

		                break;
				
				
				
				
				default:
					System.out.println("Felaktigt Kommando!!");



				}

			}		

			catch (NumberFormatException nfe) {
				System.out.println("Felaktigt kommando Var god ange siffra 1-7 f�r att b�rja om");


			}






		}


	}

}