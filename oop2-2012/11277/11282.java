
import java.util.Scanner;
import java.util.ArrayList;

public class Registerprogram{
	public static void main(String args[]){

		ArrayList<Person>allapersoner= new ArrayList<Person>();

		Scanner tgb = new Scanner(System.in);

		for(;;){

			try {

				System.out.print("1-Registrera\n2-Lägg till pryl\n3-Lista alla personer\n4-Visa rikast\n5-Visa viss person\n6-Börskrasch\n7-Avsluta\nVälj kommando 1-7: ");

				int val = Integer.parseInt(tgb.nextLine());

				switch(val){




				case 1: //Lägg till personer 
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
						System.out.println("\nPersonen vid namn "+name+ " är tillagd");

					}

					break;

				case 2: //Lägg till pryl för person
					String material = "";
					System.out.print("För vem ska prylen läggas till? ");

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

						System.out.print("Antal ädelstenar: ");


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

						System.out.print("Ange slitagenivå 1-10, 10=nyskick: ");

						int slitage = Integer.parseInt(tgb.nextLine());

						Apparat app = new Apparat(prylNamn, typ, Pris, slitage);
						person.addPryl(app);
					}


					else{
						System.out.println("Pryltypen "+prylNamn+" finns inte, välj mellan: pryltyperna 1-3, 1: Smycke 2: Aktie  eller 3: Apparat.");
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
					System.out.println(rik.getName()+" är rikast, Förmögenhet till ett värde av: "+rik.getCash()+" kr.");
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
					




				case 6: //Börskrasch
					System.out.println("\n--- BÖRSKRASCH!----");
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
				System.out.println("Felaktigt kommando Var god ange siffra 1-7 för att börja om");


			}






		}


	}

}