import java.util.Scanner;
import java.util.ArrayList;

public class KomandoRadsInterface {
		private Scanner keyboard;
		private Register register;
		
		public static void main(String[] args) {
			KomandoRadsInterface komandoRadsInterface = new KomandoRadsInterface();
			komandoRadsInterface.kör();
		}
		
		public KomandoRadsInterface() {
			 keyboard = new Scanner(System.in);
			 register = new Register();
		}
		
		
		public void kör() {
			for(;;) {
				int val = readInt("Vad vill du göra?\n 1 Skapa person\n 2 Skapa pryl\n 3 Visa alla\n 4 Visa rikast\n 5 Visa viss person\n 6 Börskrasch\n 7 Avsluta");
			switch(val) {
				case 1:
					nyPerson();
					break;
				case 2:
					nyPryl();
					break;
				case 3:
					visaAlla();
					break;
				case 4:
					visaRikaste();
					break;
				case 5:
					visaVissPerson();
					break;
				case 6:
					görBörskrasch();
					break;
				case 7:
					System.out.print("Slipp då");
					return;
					
				}
			}
			
		}
		
		private void görBörskrasch() {
			register.görBörskrasch();
			System.out.println("Här var det krashat å klart motherfucker!!");
		}

		private int readInt(String fråga){
			
			for(;;){
				try{
					System.out.println(fråga);
					return Integer.parseInt(keyboard.nextLine());
				}
				catch (NumberFormatException e){
					System.out.println("Oj nu blev det fel, Du måste svara med ett heltal");
				}
			}
		}
	private double readDouble(String fråga){
			
			for(;;){
				try{
					System.out.print(fråga);
					return Integer.parseInt(keyboard.nextLine());
				}
				catch (NumberFormatException e){
					System.out.println("Oj nu blev det fel, Du måste svara med ett tal");
				}
			}
		}
		
		
		private boolean readBoolean(String fråga){
			System.out.print(fråga);
			return keyboard.nextLine().toLowerCase().charAt(0) == 'j';
		}
		
		public String readString(String fråga){
			System.out.println(fråga);
			String strSvar=keyboard.nextLine();
			return strSvar;
		}
		
		
		private void nyPerson() {
			System.out.println("Välj namn");
			String namn = keyboard.nextLine();
			boolean lykades = register.läggTillPerson(namn);
			if(lykades) {
				System.out.println("Person tilllagd");
			} else {
				System.out.println("Det finns redan en person med det namnet.");
			}
		}


		private void nyPryl() {
			int aktivitet = readInt("Vilken sorts pryl?\n 1 Smycke\n 2 aktiepost\n 3 Apparat\n 4 Avbryt");;			
				switch(aktivitet){
				case 1:
					nyttSmycke();
					return;
				case 2:
					nyAktiepost();
					return;
				case 3:
					nyApparat();
					return;
				case 4:
					return;
				default:
					nyPryl();
				}
		}
		private void nyApparat() {
			String person = readString("Vems apparat");
			String namn = readString("Namn på apparat");
			int slitage = readInt("Hur sliten är apparaten? (1-10)");
			double inkPris = readDouble("Vad kostar apparaten?");
			
			boolean lyckades = register.nyApparat(person, namn, slitage, inkPris);
			if(lyckades) {
				System.out.println("Apparat tillagd");
			} else {
				System.out.println("Kunde inte hitta personen!");
			}
		}
		
		private void nyttSmycke() {
			String person = readString("Vems smycke");
			String namn = readString("Namn på smycke");
			int ädelsten = readInt("Hur många ädelstenar har smycket? ");
			
			boolean guld = readBoolean("Är smycket gjort av guld? (J/N)");
			
			boolean lyckades = register.nyttSmycke(person, namn, ädelsten, guld);
			if(lyckades) {
				System.out.println("Smycke tillagt");
			} else {
				System.out.println("Kunde inte hitta personen!");
			}
		}
		
		private void nyAktiepost() {
			String person = readString("Vems Aktiepost? ");
			String namn = readString("Namn på Aktiepost? ");		
			int pris = readInt("Vad kostar Aktieposten? ");
			int antal = readInt("antal Aktieposter? ");
			
			boolean lyckades = register.nyAktiepost(person, namn, pris, antal);
			if(lyckades) {
				System.out.println("Aktiepost/er tillagd");
			} else {
				System.out.println("Kunde inte hitta personen!");
			}
		}
		private void visaAlla(){
			for (Person p : register.getPersoner()) {
				String namn = p.getNamn();
				double värde = p.räknaFörmögenhet();
				System.out.println(namn+" "+värde);
			}
		}
		private void visaRikaste(){
			String rikast=null;
			double högstaVärde=0;
			for(Person p : register.getPersoner()){
				String n = p.getNamn();
				double värde = p.räknaFörmögenhet();
				if (värde>högstaVärde){
					högstaVärde=värde;
					rikast=n;
				}			
			}System.out.println(rikast+" "+högstaVärde);
			visaPerson(rikast);
		}
		private void visaVissPerson(){
			String n = readString("Vem vill du titta på?");
			visaPerson(n);
		}
		private void visaPerson(String n){
			Person p = register.hittaPerson(n);
			if(p == null ){
				System.out.println("Finns ingen som heter så");
				return;
			}
			ArrayList<Pryl> attLista = new ArrayList<Pryl>();
			attLista = p.getallaPrylar();
			for(Pryl pr : attLista){
				System.out.println(pr);
			}
		}
		}