import java.util.Scanner;
import java.util.ArrayList;

public class HuvudProgram {

	ArrayList <Person> allaPersoner = new ArrayList <Person>();
	Scanner keyboard = new Scanner(System.in);

	int readInt(String fråga){
		for(;;){
			try{
				System.out.println(fråga);
				int x=Integer.parseInt(keyboard.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Fel - värdet måste var numeriskt!");
			}
		}
	}
	String readString(String fråga){
		System.out.println(fråga);
		String str=keyboard.nextLine();
		return str;
	}

	Person getPerson(String namn){
		for (Person p : allaPersoner)
			if (p.getNamn().equalsIgnoreCase(namn))
				return p;
		return null;
	}

	//METOD FÖR ATT SKAPA PERSON
	void skapaPerson(){
		String namn = readString("Ange personens namn:");
		Person p = getPerson(namn);
		if (p!=null)
			System.out.println("Den personen finns redan!");
		else{
			Person ny = new Person(namn);
			allaPersoner.add(ny);
			System.out.println("Personen är nu sparad!");
		}

	}

	//METOD FÖR ATT SKAPA PRYL
	void skapaPryl(){

		boolean hittad = false;
		System.out.print("För vem ska prylen läggas till: ");
		String vem = keyboard.nextLine();
		for(Person p : allaPersoner){
		

			if(vem.equalsIgnoreCase(p.getNamn())){
				hittad = true;
				//System.out.println("Vilken sorts pryl (1=Aktier 2=Apparater 3=Smycken)");
				int readInt = readInt("Vilken sorts pryl (1=Aktier 2=Apparater 3=Smycken)");
				//int readInt = Integer.parseInt(keyboard.nextLine());
				System.out.println("Vad är det för pryl(om Aktie, ange aktiens namn):");
				String prylNamn = (keyboard.nextLine());

				if (readInt ==1){
					System.out.println("Ange antal aktier:");
					int antalAktier = Integer.parseInt(keyboard.nextLine());
					System.out.println("Ange aktiepris per stycke:");
					int aktiePris = Integer.parseInt(keyboard.nextLine());
					Aktie aktier = new Aktie (prylNamn, antalAktier, aktiePris);
					p.addPryl(aktier);
				}

				if (readInt ==2){
					System.out.println("Ange apparatens inköpspris:");
					int inköpspris = Integer.parseInt(keyboard.nextLine());
					System.out.println("Ange apparatens slitage(mellan 1-10):");
					int slitage = Integer.parseInt(keyboard.nextLine());

					Apparat apparater = new Apparat(prylNamn, inköpspris, slitage);
					p.addPryl(apparater);

				}

				if (readInt ==3){
					int ädelsten = readInt("Ange smyckets antal ädelstenar:");
					//int ädelsten = Integer.parseInt(keyboard.nextLine());
					System.out.println("Är smycket utav guld? (alla svar utom NEJ innebär guld)");
					String gold = (keyboard.nextLine());
					boolean smycke = true;
					if (gold.equalsIgnoreCase("ja")){
						smycke = true;					
					}
					if (gold.equalsIgnoreCase("nej")){
						smycke = false;
					}
					Smycke smycket = new Smycke (prylNamn, ädelsten, smycke);
					p.addPryl(smycket);
				}
			}

		}
		
		if (hittad == false){
			System.out.println("Finns ingen "+vem+"!");
		}
	}

	//METOD FÖR ATT VISA ALLA PERSONER OCH DESS PRYLAR
	void visaAlla(){
		System.out.println("Alla registrerade personer och deras samlade prylars värde:");
		
		for(Person p : allaPersoner){
			System.out.println(p.getNamn()+" " +p.getVärde());
		}		
	}

	//METOD FÖR ATT VISA VISS PERSON OCH DESS VÄRDESAKER
	void visaViss(){
		boolean hittad = false;
		String visaPerson = readString("Ange personen du vill visa:");
		for(Person p : allaPersoner){
			if(p.getNamn().equalsIgnoreCase(visaPerson)){
				hittad = true;
				System.out.println(p+", prylar: \n"+p.getPryl() +" ");
			}
		}
		if (hittad == false){
			System.out.println (visaPerson+" finns inte!");
		}
	}

	//METOD FÖR ATT VISA RIKAST PERSON
	void rikastPerson(){
		Person rikast = allaPersoner.get(0);
		for(Person p : allaPersoner){
			if(rikast.getVärde()<p.getVärde()){
				rikast=p;	
			}
		}	
		System.out.println(rikast.getNamn()+" är rikast med det totala värdet utav: "+rikast.getVärde()+" kr." +"\n" +rikast.getPryl());
	}

	//METOD FÖR ATT GÖRA BÖRSKRASCH
	void börsKrasch(){
		for (Person p : allaPersoner){
			p.börsKrasch();		
		}
		System.out.println("Börskrasch genomförd!");
	}


	public static void main(String[] args) {
		HuvudProgram hp = new HuvudProgram();
		System.out.println("1. Skapa person\n2. Skapa pryl\n3. Visa alla\n4. Visa rikaste\n5. Visa viss person\n6. Börskrasch\n7. Avsluta\n");

		while(true) {
			System.out.print(">");
			int val = hp.readInt("Ange kommande 1-7");
			switch (val) {

			case 1: hp.skapaPerson();	break;
			case 2: hp.skapaPryl(); 	break;
			case 3: hp.visaAlla();		break;
			case 4: hp.rikastPerson();	break;
			case 5: hp.visaViss();		break;
			case 6: hp.börsKrasch();	break;
			case 7:	System.out.println("Programmet avslutat!");	System.exit(0);
			default: System.out.println("Felaktigt kommando, försök igen.");
			}
		}
	}
}	

