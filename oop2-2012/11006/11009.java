import java.util.ArrayList;
import java.util.Scanner;

public class HuvudProgram {
	Scanner keyboard = new Scanner(System.in);
	ArrayList<Person> allaPersoner = new ArrayList<Person>();
	Person aktuellPerson = null;

	int readInt(String fråga){
		boolean repeat;
		int svar;
		for(;;){
			try{
				do {
					System.out.print(fråga);
					svar = Integer.parseInt(keyboard.nextLine());
					if (svar < 0){
						System.out.println("Fel - Ange ett positivt värde");
						repeat = true;
					} else {
						repeat = false;
					}
				} while (repeat);
				return svar; 
			} catch(NumberFormatException e){
				System.out.println("Fel - Ange ett numeriskt värde");
			}
		}
	}

	String readString(String fråga){
		System.out.print(fråga);
		String str = keyboard.nextLine();
		return str;
	}

	char readChar(String fråga){
		System.out.print(fråga);
		String str = keyboard.nextLine();
		char svarChar = str.charAt(0);
		return svarChar;
	}

	void skapaPerson(){
		String namn = readString("Personens namn: ");
		Person ny = new Person(namn);
		allaPersoner.add(ny);
	}

	void skapaPryl(){

		String namn = readString("Ägarens namn: ");
		aktuellPerson = null;
		for (int x = 0; x < allaPersoner.size(); x++){
			if (allaPersoner.get(x).getNamn().equalsIgnoreCase(namn)){
				aktuellPerson = allaPersoner.get(x);
			}
		}

		if (aktuellPerson == null){
			System.out.println(namn+" finns inte");
			return;
		}

		int sortsPryl = readInt("Sorts Pryl\n 1)Smycke\n 2)Apparat\n 3)Aktie\n ");
		switch (sortsPryl){
		case 1:
			//Smycke
			String smyckesNamn = readString("Vilken sorts smycke?: ");
			char svarGuld = (char) readChar("Är " + smyckesNamn + " av guld?: ja/nej ");
			int metalVärde;
			if (svarGuld == 'j'){
				metalVärde = 2000;
			} else {
				metalVärde = 700;
			}
			int numÄdelsten = readInt("Hur många ädelstenar finns på smycket?: ");
			Smycke nySmycke = new Smycke(smyckesNamn, numÄdelsten, metalVärde);
			aktuellPerson.addPryl(nySmycke);

			break;
		case 2:
			//Apparat
			String apparatNamn = readString("Apparatnamn: ");
			int inköpspris = readInt("Inköpspris: ");
			int slitage;

			boolean repeat;
			do {
				slitage = readInt("Slitage: ");
				if (slitage < 1 || slitage > 10){
					System.out.println("Fel - Ange ett värde mellan 1 och 10");
					repeat = true;
				} else {
					repeat = false;
				}
			} while (repeat);

			Apparat nyApparat = new Apparat(apparatNamn, inköpspris, slitage);
			aktuellPerson.addPryl(nyApparat);

			break;
		case 3:
			//Aktie
			String aktieNamn = readString("Aktienamn: ");
			int pris = readInt("Pris: ");
			int antal = readInt("Antal: ");

			Aktie nyAktie = new Aktie(aktieNamn, pris, antal);
			aktuellPerson.addPryl(nyAktie);

			break;
		default: System.out.println("Fel - Ange en siffra mellan 1 och 3");
		}
	}

	void visaAlla(){
		System.out.println("I registret finns:");
		for (int x=0; x<allaPersoner.size(); x++){
			aktuellPerson = allaPersoner.get(x);
			System.out.println(aktuellPerson.getNamn()+" äger "+aktuellPerson.getFörmögenhet());
		}

	}
	void visaRikaste(){
		int störstVärde=0;
		int värde = 0;
		Person rikastePerson = null;

		for (int x = 0; x<allaPersoner.size(); x++){
			aktuellPerson = allaPersoner.get(x);

			värde = aktuellPerson.getFörmögenhet();
			if (värde > störstVärde){
				rikastePerson = aktuellPerson;
				störstVärde = värde;
			}
		}
		if (rikastePerson != null){
			System.out.println("Rikast är "+rikastePerson.toString());
		}else{
			System.out.println("Det finns inga personer som äger något");
		}
	}

	void visaViss(){
		String namn = readString("Personens namn: ");
		aktuellPerson = null;
		for (int x = 0; x < allaPersoner.size(); x++){
			aktuellPerson = allaPersoner.get(x);
			if (aktuellPerson.getNamn().equalsIgnoreCase(namn)){
				System.out.println(aktuellPerson.toString());
			} 
		}
		if (aktuellPerson == null)
		{
			System.out.println(namn+" finns inte");
			return;
		}
	}

	void börskrasch(){
		for (int x = 0; x < allaPersoner.size(); x++){
			allaPersoner.get(x).börskrasch();
		}
	}

	public static void main(String[] args) {
		HuvudProgram hp = new HuvudProgram();
		for(;;){
			int val = hp.readInt("Ange kommando:\n 1: skapa person \n 2: lägg till pryl \n 3: visa alla \n 4: visa rikaste \n 5: visa en viss person \n 6: simulera börskrasch \n 7: avsluta \n");
			switch(val){

			case 1:hp.skapaPerson();
			break;
			case 2:hp.skapaPryl();
			break;
			case 3:hp.visaAlla();
			break;
			case 4:hp.visaRikaste();
			break;
			case 5:hp.visaViss();
			break;
			case 6:hp.börskrasch();
			break;
			case 7:
				System.out.println("Programmet avslutas");
				System.exit(0);
			default: System.out.println("Fel - Ange en siffra mellan 1 och 7");

			}
		}
	}
}
