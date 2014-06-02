import java.util.Scanner;
import java.util.ArrayList;

public class KomandoRadsInterface {
		private Scanner keyboard;
		private Register register;
		
		public static void main(String[] args) {
			KomandoRadsInterface komandoRadsInterface = new KomandoRadsInterface();
			komandoRadsInterface.k�r();
		}
		
		public KomandoRadsInterface() {
			 keyboard = new Scanner(System.in);
			 register = new Register();
		}
		
		
		public void k�r() {
			for(;;) {
				int val = readInt("Vad vill du g�ra?\n 1 Skapa person\n 2 Skapa pryl\n 3 Visa alla\n 4 Visa rikast\n 5 Visa viss person\n 6 B�rskrasch\n 7 Avsluta");
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
					g�rB�rskrasch();
					break;
				case 7:
					System.out.print("Slipp d�");
					return;
					
				}
			}
			
		}
		
		private void g�rB�rskrasch() {
			register.g�rB�rskrasch();
			System.out.println("H�r var det krashat � klart motherfucker!!");
		}

		private int readInt(String fr�ga){
			
			for(;;){
				try{
					System.out.println(fr�ga);
					return Integer.parseInt(keyboard.nextLine());
				}
				catch (NumberFormatException e){
					System.out.println("Oj nu blev det fel, Du m�ste svara med ett heltal");
				}
			}
		}
	private double readDouble(String fr�ga){
			
			for(;;){
				try{
					System.out.print(fr�ga);
					return Integer.parseInt(keyboard.nextLine());
				}
				catch (NumberFormatException e){
					System.out.println("Oj nu blev det fel, Du m�ste svara med ett tal");
				}
			}
		}
		
		
		private boolean readBoolean(String fr�ga){
			System.out.print(fr�ga);
			return keyboard.nextLine().toLowerCase().charAt(0) == 'j';
		}
		
		public String readString(String fr�ga){
			System.out.println(fr�ga);
			String strSvar=keyboard.nextLine();
			return strSvar;
		}
		
		
		private void nyPerson() {
			System.out.println("V�lj namn");
			String namn = keyboard.nextLine();
			boolean lykades = register.l�ggTillPerson(namn);
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
			String namn = readString("Namn p� apparat");
			int slitage = readInt("Hur sliten �r apparaten? (1-10)");
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
			String namn = readString("Namn p� smycke");
			int �delsten = readInt("Hur m�nga �delstenar har smycket? ");
			
			boolean guld = readBoolean("�r smycket gjort av guld? (J/N)");
			
			boolean lyckades = register.nyttSmycke(person, namn, �delsten, guld);
			if(lyckades) {
				System.out.println("Smycke tillagt");
			} else {
				System.out.println("Kunde inte hitta personen!");
			}
		}
		
		private void nyAktiepost() {
			String person = readString("Vems Aktiepost? ");
			String namn = readString("Namn p� Aktiepost? ");		
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
				double v�rde = p.r�knaF�rm�genhet();
				System.out.println(namn+" "+v�rde);
			}
		}
		private void visaRikaste(){
			String rikast=null;
			double h�gstaV�rde=0;
			for(Person p : register.getPersoner()){
				String n = p.getNamn();
				double v�rde = p.r�knaF�rm�genhet();
				if (v�rde>h�gstaV�rde){
					h�gstaV�rde=v�rde;
					rikast=n;
				}			
			}System.out.println(rikast+" "+h�gstaV�rde);
			visaPerson(rikast);
		}
		private void visaVissPerson(){
			String n = readString("Vem vill du titta p�?");
			visaPerson(n);
		}
		private void visaPerson(String n){
			Person p = register.hittaPerson(n);
			if(p == null ){
				System.out.println("Finns ingen som heter s�");
				return;
			}
			ArrayList<Pryl> attLista = new ArrayList<Pryl>();
			attLista = p.getallaPrylar();
			for(Pryl pr : attLista){
				System.out.println(pr);
			}
		}
		}