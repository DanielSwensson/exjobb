import java.util.ArrayList;
import java.util.Scanner;


public class Register {
	private static Scanner keyboard = new Scanner(System.in);
	private static ArrayList<Person> allaPersoner = new ArrayList<Person>();
		
	public static void printString(String str){
		
		System.out.println(str);
	}
	
	public static String readString(String s){
		System.out.print(s);
		String out = keyboard.nextLine();
		return out;

	}
	
	public static int readInt(String fr){
		for(;;){
			try{
				System.out.print(fr);
				int i = Integer.parseInt(keyboard.nextLine());
				return i;
			}
			catch (NumberFormatException e){
				printString("Fel! Skall vara numeriskt input!");
			}
		}
	}
	
	
	public static void main(String[] args){
		
		
		boolean done = false;
		
		
		printString("Välkommen till mitt program! Var god välj en funktion! ");
		
		while(!done){
		printString("HUVUDMENY\n 1. Skapa person \n 2. Skapa pryl \n 3. Visa alla \n 4. Visa rikaste \n 5. Visa viss person \n 6. Börskrasch \n 7. Avsluta \n");
		
		String kommando = readString("> ");
		
		
		switch(kommando){
		
		case "add":
		case "1":
			
			
			boolean personer = false;
			String namnet = readString("Vad heter han som du vill lägga till? ");
			
			for (Person p: allaPersoner){
				
				if (namnet.equalsIgnoreCase(p.getNamn())){
					printString("Personen finns redan i registret!");
					personer = true;
					break;								
				}
			} if(personer == false){
				Person komplettperson = new Person(namnet);
				
				allaPersoner.add(komplettperson);
				
				printString(namnet + " har lagts till!");
			}
			break;
			
		case "2":
			
			boolean prylar = false;

					while(!prylar){
								printString("\n 1. Apparater \n 2. Smycken \n 3. Aktier \n 4. Avbryt \n");
								String PrylTyp = readString("Vad är det för typ av föremål du vill lägga till? ");
						
						switch(PrylTyp){
						
						case "1":
							String appA = "Apparater"; // Apparat Alternativ
							String n = readString("Namnet på person som äger föremål:");
							
							for (Person p: allaPersoner){
								if(n.equalsIgnoreCase(p.getNamn())){
									String appTyp = readString("Vad är det för typ av apparat? ");
									int appPris = readInt("Vad är apparatens ursprungspris? ");
									
										while(true){
								
											int appSlitage = readInt("Vad är apparatens nuvarande kvalitet? ");
								
											if(appSlitage >= 0 && appSlitage <= 10){
								
												Apparater nyApp = new Apparater(n, appA, appTyp, appPris, appSlitage);
								
												p.getAllaPrylar().add(nyApp);
								
												printString(p.getNamn() + " äger nu en " + appTyp + " och har nu ett totalt värde av " + p.getSummaVärde(p.getAllaPrylar()));
											
												break;
											} else {
												printString("Kvalitetsvärdet kan endast vara 0-10");
											}
											
										}//while
									}//if Namn
								}//for
							
							prylar = true;
							break;
							
						case "2":
							String juvA = "Juveler"; //Juvel Alternativ
							String q = readString("Namnet på person som äger föremål: ");
							for(Person p : allaPersoner){
								if(q.equalsIgnoreCase(p.getNamn())){
									String juvTyp = readString("Vad är det för typ av smycke: ");
									String juvGuld = readString("Är smycket gjort av guld? ");
									int juvSten = readInt("Hur många ädelstenar finns det i smycket? ");
									
									Juveler nyJuv = new Juveler(q, juvA, juvTyp, juvGuld, juvSten);
									
									p.getAllaPrylar().add(nyJuv);
									
									printString(p.getNamn() + " äger nu " + juvTyp + " med " + juvSten + "st ädelstenar. Smycket är av guld: " + juvGuld + " och har nu ett totalt värde av " + p.getSummaVärde(p.getAllaPrylar()));
								}
							}
							
							prylar = true;
							break;
							
						case "3":
							String aktA = "Aktier"; //Aktie Alternativ
							String w = readString("Namnet på person som äger föremål: ");
							for(Person p : allaPersoner){
								if(w.equalsIgnoreCase(p.getNamn())){
									String aktNamn = readString("Aktie namn: ");
									int aktAnt = readInt("Antal aktier: ");
									int aktPris = readInt("Pris per aktie: ");
									
									Aktier nyAkt = new Aktier(w, aktA, aktNamn, aktAnt, aktPris);
									
									p.getAllaPrylar().add(nyAkt);
									
									printString(p.getNamn() + " äger nu " + aktAnt + "st " + aktNamn + " och har nu ett totalt värde av " + p.getSummaVärde(p.getAllaPrylar()));
									
								}
							}
							prylar = true;
							break;
							
						case "4":
							
							prylar = true;
							break;
							
						default:
							printString("Felaktigt Kommando");
							break;
					
				}
				
			}
			break;
			
		case "3":
			for(Person p : allaPersoner){
				printString(p.toString());
			}			
			break;
			
		case "4":
			String nm = "TEMP";
			int vrd = 0;
			
			for(Person p : allaPersoner){
				if(p.getSummaVärde(p.getAllaPrylar()) >= vrd){
					vrd = p.getSummaVärde(p.getAllaPrylar());
					nm = p.getNamn();
					
				
				}
				
			}
			
			printString(nm + "    " + vrd);
			break;
			
		case "5":
			String vem = readString("Skriv namnet på personen vars ägodelar du vill se: ");
			for (Person p: allaPersoner){
				if(vem.equalsIgnoreCase(p.getNamn())){
					for(Pryl sak : p.getAllaPrylar()){
						printString(sak.toString());
						}
					printString("\nTotalt värde:" + p.getSummaVärde(p.getAllaPrylar()));
					}
				}
			break;
		case "6":
			for(Person p : allaPersoner){
				for(Pryl pAkt : p.getAllaPrylar()){
					if(pAkt instanceof Aktier){
						pAkt.nollVärd();
					}
				}
			}
			printString("Börskrash! Alla utdelade aktier är värda 0");
			break;
		case "7":
		case "exit":
				done = true;
				break;
				
		default:
				System.out.println("Felaktigt kommando!");
				break;
		
		
		
		}//switch 
		
		
		
		
		}//while done
		
		
	}//Pub stat void main
	

}//class Register
