import java.util.*;

public class Huvudprogram {

	Scanner sc = new Scanner(System.in);
	ArrayList<Personer> allaPersoner = new ArrayList<Personer>();
	ArrayList<Prylar> allaPrylar = new ArrayList<Prylar>();
	double tempVärde;
	String tempNamn;

	boolean finns = false;
	boolean bort = false;
	boolean bort2 = false;
	String taBort;
	String typ;
	String ägare;


	//Printar och läser "int"
	int läsInt(String fråga){
		for(;;){
			try{
				System.out.print(fråga);
				int x=Integer.parseInt(sc.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Felaktigt kommando!");
			}
		}
	}
	//Printar och läser strängar
	String läsString(String fråga) {	
		System.out.print(fråga);
		String str=sc.nextLine();
		return str;

	}
	//Beräknar hur mycket en person är värd
		void räknaVärde() {
			for (Personer p: allaPersoner) {
				for (Prylar a: allaPrylar) {
					if (p.getNamn().equalsIgnoreCase(a.getÄgare())) {
						tempVärde += a.getPrylVärde();
					}			
				}
				p.getTotalVärde(tempVärde);
				tempVärde = 0.0;
			}
		}

	// 1			
	void skapaPerson(){
		boolean finns = false;

		String namn = läsString("Ange personens namn:");
		for (int x=0; x<allaPersoner.size(); x++ ) {

			if (allaPersoner.get(x).getNamn().equals(namn)) {
				finns = true;
				break; }
		}
		if (finns == true)
			System.out.println("En person med det namnet finns redan registrerad! Försök igen. \n");

		else {
			Personer p = new Personer (namn, 0.0);
			allaPersoner.add(p);

			System.out.println("Personen är registrerad!\n");

		}
	}

	// 2

	Personer getPerson(String namn)
	{
		for (Personer p : allaPersoner)
			if (p.getNamn().equalsIgnoreCase(namn))
				return p;
		return null;
	}

	void skapaPryl(){

		for (;;) {
			ägare = läsString("Vilken person äger prylen?: ");
			Personer p = getPerson(ägare);
			if (p==null) {
				System.out.println("Den personen finns inte!");
			}
			else {
				break;
			}
		}		
		for (;;) {
			String prylTyp = läsString("Vilken sorts pryl är det?: ");
			if (prylTyp.equalsIgnoreCase("Aktie")) {
				skapaAktie();
				break;
			}
			if (prylTyp.equalsIgnoreCase("Apparat")) {
				skapaApparat();
				break;
			}
			if (prylTyp.equalsIgnoreCase("Smycke")) {
				skapaSmycke();
				break;
			}

			else {
				System.out.println("Prylen måste vara en Aktie, en Apparat, eller ett smycke");
			}
		}						 		
	}

	void skapaAktie(){
		double värde;
		String aNamn = läsString("Vad är det för Aktiebolag?");
		int aAntal = läsInt("Hur många aktier gäller det? ");
		int aPris = läsInt("Vad kostar aktien styck? ");

		värde = aAntal * aPris;
		Aktier skapaNy = new Aktier(ägare, värde, aNamn, aAntal, aPris);
		allaPrylar.add(skapaNy);

		System.out.println("Aktie från [" + aNamn + "] är registrerad!\n");


	}
	void skapaApparat(){
		int slitage;
		double värde;
		String appNamn = läsString("Vad är det för typ av apparat? ");
		int appPris = läsInt("Vad kostar apparaten?");
		for (;;) {
			slitage = läsInt("Hur sliten är apparaten med ett värde 1-10? (10 är helt ny) ");
			if (slitage < 1 || slitage > 10) {
				System.out.println("Värdet ska vara mellan 1 och 10!");
			}
			else {
				break;
			}
		}
		värde = appPris * (slitage * 0.1);
		Apparater skapaNy = new Apparater(ägare, värde, appNamn, appPris, slitage);
		allaPrylar.add(skapaNy);

		System.out.println("Prylen ["+ appNamn + "] är nu registrerad!\n");
	}

	//Skapar ett smycke
	void skapaSmycke(){
		boolean guld=false;
		double värde;
		String metall;
		String typSm = läsString("Vilken typ av smycke?: ");
		for(;;) {
		metall = läsString("Är smycket av guld? Ja / Nej ");
		
			if (metall.equalsIgnoreCase("ja")) {
				guld=true;
				break;
			}
			else if (metall.equalsIgnoreCase("nej")) {
				guld=false;
				break;
			}
			else 
				System.out.println("Du måste svara med antingen Ja/Nej!");
			
			
		}
		int aStenar = läsInt("Hur många ädelstenar?: ");

		if (guld)
			värde = 2000 + aStenar * 500;
		else
			värde = 700 + aStenar * 500;

		Smycken skapaNy = new Smycken(ägare, värde, typSm, aStenar, metall);
		allaPrylar.add(skapaNy);

		System.out.println("Smycket [" + typSm + "] är nu registrerad!\n");
	}

	//3	
	void visaAlla(){
		räknaVärde();
		for (Personer va : allaPersoner){
			System.out.println(va.getNamn()+"\t"+va.getPersonVärde());
		}

	}

	//4	
	void visaRikaste(){
		räknaVärde();
		for (Personer rikast : allaPersoner){
			if (rikast.getPersonVärde() > tempVärde){
				tempNamn = rikast.getNamn();
				tempVärde = rikast.getPersonVärde();

			}
		}

		System.out.print("Rikast är "+ tempNamn +" med ett totalvärde på: "+ tempVärde+" \n");
		for (Personer p : allaPersoner) {
			if (p.getNamn().equals(tempNamn)) {
				for (Prylar a : allaPrylar) {
					if (p.getNamn().equalsIgnoreCase(a.getÄgare())) {
						System.out.println(a.getTyp() + "\t" + a.getPrylVärde());
					}			
				}
			}
		}
		tempVärde=0.0;
	}


	//5	
	void visaPers(){
		boolean finns2 = true;
		räknaVärde();
		String person = läsString("Ange namn på person du vill visa:");
		for (Personer p : allaPersoner){
			if (p.getNamn().equalsIgnoreCase(person)){
				finns2 = true;
			}
		}
		if (finns2 == true){
			for (Personer p : allaPersoner){
				if (p.getNamn().equalsIgnoreCase(person)){
					System.out.print(p.getNamn() +  " äger sammanlagt "+ p.getPersonVärde()+"\n");
					for (Prylar a : allaPrylar){
						if (person.equalsIgnoreCase(a.getÄgare())){
							System.out.print(a.getTyp() + "\t" + a.getPrylVärde()+"\n");
						}
					}
				}
			}

		}
		if (finns2 == false){
			System.out.println("Personen med det angivna namnet finns ej!");
		}	

	}

	//6	
	void börsKrasch(){

		for (Prylar bKrasch : allaPrylar)
		{	
			if (bKrasch instanceof Aktier){
				bKrasch.setPrylVärde(0.0);
				((Aktier)bKrasch).setPris(0);

			}
		}	
		System.out.println("Åh nej! Börskrasch!");
	}

	//7
	void taBortPers(){
		String vem = läsString("Vilken person vill du ta bort?");
		for (int x=0; x<allaPersoner.size(); x++ ) {
			if (allaPersoner.get(x).getNamn().equalsIgnoreCase(vem)){
				allaPersoner.remove(x);
				bort = true;
				break;	
			}
		}

		if (bort == true)
			System.out.println("Personen med det angivna namnet är nu borttagen.");
		else 
			System.out.println("Personen med det angivna namnet fanns ej i registret.");

	}
	void erasePryl(String o){
		taBort = o;
		allaPrylar.remove(o);
		for (int x=0; x<allaPrylar.size(); x++ ) {
			if (allaPrylar.get(x).getTyp().equalsIgnoreCase(taBort)){
				allaPrylar.remove(x);

			}	
		}
	}

	//8
	void taBortPryl(){
		boolean pFinns = true;
		räknaVärde();
		String person = läsString("Välj en person");
		for (Personer p : allaPersoner){
			if (p.getNamn().equalsIgnoreCase(person)){
				pFinns = true;
			}
		}
		if (pFinns == true){
			for (Personer p : allaPersoner){
				if (p.getNamn().equalsIgnoreCase(person)){
					System.out.print(p.getNamn() +  " äger sammanlagt "+ p.getPersonVärde()+"\n");
					for (Prylar a : allaPrylar){
						if (person.equalsIgnoreCase(a.getÄgare())){
							System.out.print(a.getTyp() + "\t" + a.getPrylVärde()+"\n" );

							String o = läsString("Vilken pryl vill du ta bort?");
							erasePryl(o);

						}
					}
				}
			}
		}
		if (pFinns == false){
			System.out.println("Personen med det angivna namnet finns ej!");
		}
	}

	public static void main(String[]args){
		Huvudprogram hp = new Huvudprogram(); 
		for(;;){
			int val=hp.läsInt("Välkommen!\n Meny:\n 1. Skapa Person \n 2. Skapa pryl \n 3. Visa alla personer \n 4. Visa rikast person \n 5. Visa viss person \n 6. Börskrasch \n 7. Ta bort person \n 8. Ta bort pryl \n 9. Avsluta \n Vad vill du göra?");
			switch (val){
			case 1: hp.skapaPerson(); break;
			case 2: hp.skapaPryl(); break;
			case 3: hp.visaAlla(); break;
			case 4: hp.visaRikaste(); break;
			case 5: hp.visaPers(); break;
			case 6: hp.börsKrasch(); break;
			case 7: hp.taBortPers(); break;
			case 8: hp.taBortPryl(); break;
			case 9: System.out.println("Programmet har nu avslutats!");
			System.exit(0);
			default: System.out.println("Felaktigt kommando!");


			}	
		}
	}
}