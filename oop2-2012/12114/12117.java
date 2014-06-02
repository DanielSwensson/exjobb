import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProgram {
	
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Person> allaPersoner = new ArrayList<Person>();
	
	private static void visaV�lkomstMeddelande(){ //Anv�nds endast en g�ng. F�r att g�ra main metoden mer l�sbar
		System.out.println("Prylregister 1.0" + '\n' + "-----------------");
	}

	private static void visaMeny(){ //Visar huvudmenyn
		for (;;){ //Evig loop f�r att programmet ska k�ras tills man k�r avsluta-kommandot
			System.out.println("Vad vill du g�ra?" + '\n' + 
					"1. Skapa person" + '\n' + 
					"2. Skapa pryl" + '\n' +
					"3. Visa alla" + '\n' +
					"4. Visa rikaste" + '\n' +
					"5. Visa viss person" + '\n' +
					"6. B�rskrash" + '\n' +
					"7. Avsluta" + '\n' +
					"Skriv in ditt val (1-7)");
			switch(input.nextLine()){
				case "1":
					skapaPerson();
					break;
				case "2":
					skapaPryl();
					break;
				case "3":
					visaAlla();
					break;
				case "4":
					visaRikaste();
					break;
				case "5":
					visaPerson();
					break;
				case "6":
					b�rskrash();
					break;
				case "7":
					System.exit(0);
					break;
				default: //om anv�ndaren skriver n�got som inte �r ett kommando
					System.out.println("Felaktig input, var god f�rs�k igen");
			}
		}
		
	}
	
	private static void skapaPerson(){ //Metod f�r att skapa en person
		String namn;
		boolean personFinns = false; //anv�nds f�r att se om vi har hittat en person i arrayen som heter samma sak
		
		System.out.println("Vad heter personen?");
		namn = input.nextLine();
		
		for(int i=0;i<allaPersoner.size();i++){
			if(allaPersoner.get(i).getNamn().equalsIgnoreCase(namn)){
				personFinns = true; //person har hittats
			}
		}
		
		if(personFinns){
			System.out.println("Person finns redan, personen lades inte till"); //I programmet kan vi endast ha en person med ett visst namn
		}else{
			allaPersoner.add(new Person(namn));
			System.out.println(namn + " lades till i registret");
		}
		v�ntaP�Anv�ndare();
	}
	
	private static void skapaPryl(){ //Metod f�r att skapa en pryl
		String namn;
		boolean giltigPryl = false;
		int personID = -1;
		
		System.out.println("Vilken person �ger prylen?");
		namn = input.nextLine();
		
		for(int i=0;i<allaPersoner.size();i++){ //Loopar igenom arrayen f�r att hitta personen
			if(allaPersoner.get(i).getNamn().equalsIgnoreCase(namn)){
				personID = i;
			}
		}
		if(personID==-1){ //om personID fortfarande �r -1 s� har vi inte hittat n�gon person
			System.out.println("Personen finns ej, f�rs�k igen!");
			return; //bryter ur voiden s� att ingen annan kod k�rs. �terv�nder till menyn
		}
		do{ //Fr�gar anv�ndaren om prylens olika attribut
			System.out.println("Vilken sorts pryl?");
			String prylsort = input.nextLine();
			if(prylsort.equalsIgnoreCase("smycke")){
				String sort;
				giltigPryl = true; //anv�nds f�r att validera att anv�ndaren har skrivit en korrekt pryl s� att den "stora" do-while loopen kan avslutas
				boolean r�ttInput = false; //defineras som false f�r att sedan �ndras till true om anv�ndaren g�r r�tt
				boolean guldsmycke = false; //anv�nds f�r att best�mma om smycket �r av guld eller inte
				int antalStenar = 0;
				
				System.out.println("Vilket sorts smycke?");
				sort = input.nextLine();
				System.out.println("�r smycket utav guld? (Ja/Nej)");
				do{
					String val = input.nextLine();
					if(val.equalsIgnoreCase("ja")){
						guldsmycke = true;
						r�ttInput = true;
					}else if(val.equalsIgnoreCase("nej")){
						guldsmycke = false;
						r�ttInput = true;
					}else{
						System.out.println("Felaktig input, (Skriv ja eller nej)");
					}
				}while(!r�ttInput);
				System.out.println("Hur m�nga �delstenar har smycket?");
				
				do{
					try{ //om man skriver n�got annat �n siffror m�ste vi kunna hantera detta
					antalStenar = input.nextInt();
					
					if(antalStenar>=0){
						input.nextLine();
						break; //eftersom loopen �r evig s� anv�nds break f�r att avsluta den n�r anv�ndaren skriver ett korrekt v�rde p� antal stenar
					}else{
						input.nextLine();
						System.out.print("Du kan inte ha ett negativt antal stenar, f�rs�k igen: ");
						continue; //g�r s� att loopen b�rjar om
					}
					}catch(InputMismatchException e){
						System.out.print("Felaktig input, skriv antal �delstenar med siffror: ");
						input.nextLine();
						continue;
					}
					
				}while(true);
				
				Pryl newSmycke = new Smycke(sort, guldsmycke, antalStenar); //anropar konstruktorn som skapar en ny pryl
				allaPersoner.get(personID).addPryl(newSmycke); //l�gger till denna i personens array �ver dess prylar
				
				System.out.println("Prylen lades till i registret");
				
			}else if (prylsort.equalsIgnoreCase("aktie")){
				giltigPryl = true;
				
				String aktieNamn;
				long antalAktier; //vi anv�nder oss utav long eftersom man (i vissa fall) kan �ga mer �n 2 147 483 647 aktier
				double aktieV�rde; //vi anv�nder oss utav double eftersom en akties v�rde oftast �r med �ren
				
				System.out.println("Vad heter aktien?");
				aktieNamn = input.nextLine();
				System.out.println("Hur m�nga �ger personen utav aktien?");
				do{
					try{ //try f�r att hantera ifall att anv�ndaren skriver med bokst�ver
						antalAktier = input.nextLong();
						input.nextLine();
						if(antalAktier<1){ //anger man att man har mindre �n en aktie s� finns det ingen anledning att registrera det i registret
							System.out.println("Du m�ste ha n�gra aktier, f�rs�k igen");
							continue; //f�r att b�rja om loopen
						}else{
							break; //eftersom loopen �r evig s� g�r vi ur den med break
						}
					}catch(InputMismatchException e){ 
						System.out.println("Du m�ste ange antalet aktier med siffror, f�rs�k igen");
						continue;
					}
				}while(true);
				
				System.out.println("Vad �r v�rdet p� aktien?");
				do{
					try{ 
						aktieV�rde = input.nextDouble();
						input.nextLine();
						if(aktieV�rde<0){ //en akties v�rde m�ste vara st�rre �n 0
							System.out.println("Aktiens v�rde m�ste vara positivt, f�rs�k igen");
							continue; //b�rjar om loopen
						}else{
							break; //bryter ur loopen
						}
					}catch(InputMismatchException e){ //om anv�ndaren skriver sin input med bokst�ver kastas detta exception av scannern
						System.out.println("Du m�ste ange v�rdet med siffror");
						continue;
					}
				}while(true);
				
				Pryl nyAktie = new Aktie(aktieNamn,antalAktier,aktieV�rde); //Skapar en ny pryl
				
				allaPersoner.get(personID).addPryl(nyAktie); //L�gger till prylen i personens array �ver prylar
				
				System.out.println("Prylen lades till i registret");
				
			}else if (prylsort.equalsIgnoreCase("apparat")){
				giltigPryl = true;
				int slitage, v�rde;
				String apparatNamn;
				
				System.out.println("Vad heter apparaten?");
				apparatNamn = input.nextLine();
				System.out.println("Hur mycket �r apparaten v�rd?");
				do{
					try{
						v�rde = input.nextInt();
						input.nextLine();
						if(v�rde<0){ //hindrar anv�ndaren fr�n att registrera v�rdel�sa prylar, alternativt prylar som �r v�rda negativa summor
							System.out.println("Apparaten m�ste vara v�rd mer �n 0 kronor");
							continue;
						}else{
							break;
						}
					}catch(InputMismatchException e){
						System.out.println("Du m�ste skriva v�rdet med siffror");
						continue;
					}
				}while(true);
				System.out.println("P� en skala mellan 1-10, hur sliten �r apparaten? D�r 1 = brutalt sliten och 10 = nyskick");
				do{
					try{
						slitage = input.nextInt();
						input.nextLine();
						if(slitage<1 || slitage>10){
							System.out.println("Slitagev�rdet m�ste vara mellan 1-10");
							continue;
						}else{
							break;
						}
					}catch(InputMismatchException e){
						System.out.println("Du m�ste skriva slitagev�rdet med siffror");
						continue;
					}
				}while(true);
				
				Pryl nyApparat = new Apparat(apparatNamn, v�rde, slitage); //skapar en ny pryl
				
				allaPersoner.get(personID).addPryl(nyApparat); //l�gger till den nya prylen i personens array
			}else{
				System.out.println("Ogiltig prylsort. Du kan antingen registrera ett smycke, en aktie eller en apparat" + '\n' + "F�rs�k igen");
			}
		}while(!giltigPryl);
		v�ntaP�Anv�ndare();
	}
	
	private static void visaAlla(){ //metod f�r att visa alla personer
		System.out.println("I registret finns:");
		for(int i=0; i<allaPersoner.size();i++){ //loopar igenom hela arrayen med personer
			System.out.println(allaPersoner.get(i).getNamn() + " " + allaPersoner.get(i).getSammanlagtV�rde());
		}
		v�ntaP�Anv�ndare();
	}
	
	private static void visaRikaste(){ //metod f�r att visa rikaste personen i registret
		int personID = -1;
		double rikasteSumma = 0;
		
		for(int i=0; i<allaPersoner.size();i++){ //loopar igenom hela arrayen
			if(allaPersoner.get(i).getSammanlagtV�rde()>rikasteSumma){ //om den nuvarande personens sammanlagda v�rde �r st�rre �n variabeln rikasteSumma.
				personID = i; //s� sparar vi den personens ID i arrayen
				rikasteSumma = allaPersoner.get(i).getSammanlagtV�rde(); //samt s�tter rikasteSumma till denna personens sammanlagda v�rde
			}
		}
		System.out.println("Rikaste personen �r " + allaPersoner.get(personID).getNamn() + " som sammanlagt �ger " + allaPersoner.get(personID).getSammanlagtV�rde());
		allaPersoner.get(personID).listaPrylar(); //anropar metoden lista prylar hos personen som �r rikast
		v�ntaP�Anv�ndare();
	}
	
	private static void visaPerson(){ //metod f�r att visa en viss person
		String namn;
		boolean hittatPerson = false;
		System.out.println("Vem s�ker du?:");
		namn = input.nextLine();
		for(int i=0; i<allaPersoner.size();i++){
			if(namn.equalsIgnoreCase(allaPersoner.get(i).getNamn())){
				System.out.println(allaPersoner.get(i).getNamn() + 
						" �ger totalt prylar f�r sammanlagt " + allaPersoner.get(i).getSammanlagtV�rde());
				allaPersoner.get(i).listaPrylar();
				hittatPerson = true;
			}
		}
		if(!hittatPerson){
			System.out.println("Det finns ingen person med detta namn i registret");
		}
		v�ntaP�Anv�ndare();
	}
	
	private static void b�rskrash(){
		System.out.println("B�RSKRASH!!!");
		System.out.println("Alla aktier �r numera helt v�rdel�sa");
		for(int i=0;i<allaPersoner.size();i++){ //loopar igenom alla personer i registret
			allaPersoner.get(i).krashaAktier(); //anropar metoden krashaAktier hos varje person
		}
		v�ntaP�Anv�ndare();
	}
	
	private static void v�ntaP�Anv�ndare(){ //metod f�r att stanna upp programmet. S� att anv�ndaren hinner l�sa vad som st�r innan man �terg�r till menyn
		System.out.println('\n' + "Tryck enter f�r att �terg� till menyn");
		input.nextLine();
	}
	
	public static void main(String[] args) {
		visaV�lkomstMeddelande();
		visaMeny();
	}

}
