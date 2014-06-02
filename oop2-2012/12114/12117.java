import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainProgram {
	
	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Person> allaPersoner = new ArrayList<Person>();
	
	private static void visaVälkomstMeddelande(){ //Används endast en gång. För att göra main metoden mer läsbar
		System.out.println("Prylregister 1.0" + '\n' + "-----------------");
	}

	private static void visaMeny(){ //Visar huvudmenyn
		for (;;){ //Evig loop för att programmet ska köras tills man kör avsluta-kommandot
			System.out.println("Vad vill du göra?" + '\n' + 
					"1. Skapa person" + '\n' + 
					"2. Skapa pryl" + '\n' +
					"3. Visa alla" + '\n' +
					"4. Visa rikaste" + '\n' +
					"5. Visa viss person" + '\n' +
					"6. Börskrash" + '\n' +
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
					börskrash();
					break;
				case "7":
					System.exit(0);
					break;
				default: //om användaren skriver något som inte är ett kommando
					System.out.println("Felaktig input, var god försök igen");
			}
		}
		
	}
	
	private static void skapaPerson(){ //Metod för att skapa en person
		String namn;
		boolean personFinns = false; //används för att se om vi har hittat en person i arrayen som heter samma sak
		
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
		väntaPåAnvändare();
	}
	
	private static void skapaPryl(){ //Metod för att skapa en pryl
		String namn;
		boolean giltigPryl = false;
		int personID = -1;
		
		System.out.println("Vilken person äger prylen?");
		namn = input.nextLine();
		
		for(int i=0;i<allaPersoner.size();i++){ //Loopar igenom arrayen för att hitta personen
			if(allaPersoner.get(i).getNamn().equalsIgnoreCase(namn)){
				personID = i;
			}
		}
		if(personID==-1){ //om personID fortfarande är -1 så har vi inte hittat någon person
			System.out.println("Personen finns ej, försök igen!");
			return; //bryter ur voiden så att ingen annan kod körs. Återvänder till menyn
		}
		do{ //Frågar användaren om prylens olika attribut
			System.out.println("Vilken sorts pryl?");
			String prylsort = input.nextLine();
			if(prylsort.equalsIgnoreCase("smycke")){
				String sort;
				giltigPryl = true; //används för att validera att användaren har skrivit en korrekt pryl så att den "stora" do-while loopen kan avslutas
				boolean rättInput = false; //defineras som false för att sedan ändras till true om användaren gör rätt
				boolean guldsmycke = false; //används för att bestämma om smycket är av guld eller inte
				int antalStenar = 0;
				
				System.out.println("Vilket sorts smycke?");
				sort = input.nextLine();
				System.out.println("Är smycket utav guld? (Ja/Nej)");
				do{
					String val = input.nextLine();
					if(val.equalsIgnoreCase("ja")){
						guldsmycke = true;
						rättInput = true;
					}else if(val.equalsIgnoreCase("nej")){
						guldsmycke = false;
						rättInput = true;
					}else{
						System.out.println("Felaktig input, (Skriv ja eller nej)");
					}
				}while(!rättInput);
				System.out.println("Hur många ädelstenar har smycket?");
				
				do{
					try{ //om man skriver något annat än siffror måste vi kunna hantera detta
					antalStenar = input.nextInt();
					
					if(antalStenar>=0){
						input.nextLine();
						break; //eftersom loopen är evig så används break för att avsluta den när användaren skriver ett korrekt värde på antal stenar
					}else{
						input.nextLine();
						System.out.print("Du kan inte ha ett negativt antal stenar, försök igen: ");
						continue; //gör så att loopen börjar om
					}
					}catch(InputMismatchException e){
						System.out.print("Felaktig input, skriv antal ädelstenar med siffror: ");
						input.nextLine();
						continue;
					}
					
				}while(true);
				
				Pryl newSmycke = new Smycke(sort, guldsmycke, antalStenar); //anropar konstruktorn som skapar en ny pryl
				allaPersoner.get(personID).addPryl(newSmycke); //lägger till denna i personens array över dess prylar
				
				System.out.println("Prylen lades till i registret");
				
			}else if (prylsort.equalsIgnoreCase("aktie")){
				giltigPryl = true;
				
				String aktieNamn;
				long antalAktier; //vi använder oss utav long eftersom man (i vissa fall) kan äga mer än 2 147 483 647 aktier
				double aktieVärde; //vi använder oss utav double eftersom en akties värde oftast är med ören
				
				System.out.println("Vad heter aktien?");
				aktieNamn = input.nextLine();
				System.out.println("Hur många äger personen utav aktien?");
				do{
					try{ //try för att hantera ifall att användaren skriver med bokstäver
						antalAktier = input.nextLong();
						input.nextLine();
						if(antalAktier<1){ //anger man att man har mindre än en aktie så finns det ingen anledning att registrera det i registret
							System.out.println("Du måste ha några aktier, försök igen");
							continue; //för att börja om loopen
						}else{
							break; //eftersom loopen är evig så går vi ur den med break
						}
					}catch(InputMismatchException e){ 
						System.out.println("Du måste ange antalet aktier med siffror, försök igen");
						continue;
					}
				}while(true);
				
				System.out.println("Vad är värdet på aktien?");
				do{
					try{ 
						aktieVärde = input.nextDouble();
						input.nextLine();
						if(aktieVärde<0){ //en akties värde måste vara större än 0
							System.out.println("Aktiens värde måste vara positivt, försök igen");
							continue; //börjar om loopen
						}else{
							break; //bryter ur loopen
						}
					}catch(InputMismatchException e){ //om användaren skriver sin input med bokstäver kastas detta exception av scannern
						System.out.println("Du måste ange värdet med siffror");
						continue;
					}
				}while(true);
				
				Pryl nyAktie = new Aktie(aktieNamn,antalAktier,aktieVärde); //Skapar en ny pryl
				
				allaPersoner.get(personID).addPryl(nyAktie); //Lägger till prylen i personens array över prylar
				
				System.out.println("Prylen lades till i registret");
				
			}else if (prylsort.equalsIgnoreCase("apparat")){
				giltigPryl = true;
				int slitage, värde;
				String apparatNamn;
				
				System.out.println("Vad heter apparaten?");
				apparatNamn = input.nextLine();
				System.out.println("Hur mycket är apparaten värd?");
				do{
					try{
						värde = input.nextInt();
						input.nextLine();
						if(värde<0){ //hindrar användaren från att registrera värdelösa prylar, alternativt prylar som är värda negativa summor
							System.out.println("Apparaten måste vara värd mer än 0 kronor");
							continue;
						}else{
							break;
						}
					}catch(InputMismatchException e){
						System.out.println("Du måste skriva värdet med siffror");
						continue;
					}
				}while(true);
				System.out.println("På en skala mellan 1-10, hur sliten är apparaten? Där 1 = brutalt sliten och 10 = nyskick");
				do{
					try{
						slitage = input.nextInt();
						input.nextLine();
						if(slitage<1 || slitage>10){
							System.out.println("Slitagevärdet måste vara mellan 1-10");
							continue;
						}else{
							break;
						}
					}catch(InputMismatchException e){
						System.out.println("Du måste skriva slitagevärdet med siffror");
						continue;
					}
				}while(true);
				
				Pryl nyApparat = new Apparat(apparatNamn, värde, slitage); //skapar en ny pryl
				
				allaPersoner.get(personID).addPryl(nyApparat); //lägger till den nya prylen i personens array
			}else{
				System.out.println("Ogiltig prylsort. Du kan antingen registrera ett smycke, en aktie eller en apparat" + '\n' + "Försök igen");
			}
		}while(!giltigPryl);
		väntaPåAnvändare();
	}
	
	private static void visaAlla(){ //metod för att visa alla personer
		System.out.println("I registret finns:");
		for(int i=0; i<allaPersoner.size();i++){ //loopar igenom hela arrayen med personer
			System.out.println(allaPersoner.get(i).getNamn() + " " + allaPersoner.get(i).getSammanlagtVärde());
		}
		väntaPåAnvändare();
	}
	
	private static void visaRikaste(){ //metod för att visa rikaste personen i registret
		int personID = -1;
		double rikasteSumma = 0;
		
		for(int i=0; i<allaPersoner.size();i++){ //loopar igenom hela arrayen
			if(allaPersoner.get(i).getSammanlagtVärde()>rikasteSumma){ //om den nuvarande personens sammanlagda värde är större än variabeln rikasteSumma.
				personID = i; //så sparar vi den personens ID i arrayen
				rikasteSumma = allaPersoner.get(i).getSammanlagtVärde(); //samt sätter rikasteSumma till denna personens sammanlagda värde
			}
		}
		System.out.println("Rikaste personen är " + allaPersoner.get(personID).getNamn() + " som sammanlagt äger " + allaPersoner.get(personID).getSammanlagtVärde());
		allaPersoner.get(personID).listaPrylar(); //anropar metoden lista prylar hos personen som är rikast
		väntaPåAnvändare();
	}
	
	private static void visaPerson(){ //metod för att visa en viss person
		String namn;
		boolean hittatPerson = false;
		System.out.println("Vem söker du?:");
		namn = input.nextLine();
		for(int i=0; i<allaPersoner.size();i++){
			if(namn.equalsIgnoreCase(allaPersoner.get(i).getNamn())){
				System.out.println(allaPersoner.get(i).getNamn() + 
						" äger totalt prylar för sammanlagt " + allaPersoner.get(i).getSammanlagtVärde());
				allaPersoner.get(i).listaPrylar();
				hittatPerson = true;
			}
		}
		if(!hittatPerson){
			System.out.println("Det finns ingen person med detta namn i registret");
		}
		väntaPåAnvändare();
	}
	
	private static void börskrash(){
		System.out.println("BÖRSKRASH!!!");
		System.out.println("Alla aktier är numera helt värdelösa");
		for(int i=0;i<allaPersoner.size();i++){ //loopar igenom alla personer i registret
			allaPersoner.get(i).krashaAktier(); //anropar metoden krashaAktier hos varje person
		}
		väntaPåAnvändare();
	}
	
	private static void väntaPåAnvändare(){ //metod för att stanna upp programmet. Så att användaren hinner läsa vad som står innan man återgår till menyn
		System.out.println('\n' + "Tryck enter för att återgå till menyn");
		input.nextLine();
	}
	
	public static void main(String[] args) {
		visaVälkomstMeddelande();
		visaMeny();
	}

}
