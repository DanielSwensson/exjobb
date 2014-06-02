import java.util.*;

public class Huvudprogram {

	Scanner sc = new Scanner(System.in);
	ArrayList<Personer> allaPersoner = new ArrayList<Personer>();
	ArrayList<Prylar> allaPrylar = new ArrayList<Prylar>();
	double tempV�rde;
	String tempNamn;

	boolean finns = false;
	boolean bort = false;
	boolean bort2 = false;
	String taBort;
	String typ;
	String �gare;


	//Printar och l�ser "int"
	int l�sInt(String fr�ga){
		for(;;){
			try{
				System.out.print(fr�ga);
				int x=Integer.parseInt(sc.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Felaktigt kommando!");
			}
		}
	}
	//Printar och l�ser str�ngar
	String l�sString(String fr�ga) {	
		System.out.print(fr�ga);
		String str=sc.nextLine();
		return str;

	}
	//Ber�knar hur mycket en person �r v�rd
		void r�knaV�rde() {
			for (Personer p: allaPersoner) {
				for (Prylar a: allaPrylar) {
					if (p.getNamn().equalsIgnoreCase(a.get�gare())) {
						tempV�rde += a.getPrylV�rde();
					}			
				}
				p.getTotalV�rde(tempV�rde);
				tempV�rde = 0.0;
			}
		}

	// 1			
	void skapaPerson(){
		boolean finns = false;

		String namn = l�sString("Ange personens namn:");
		for (int x=0; x<allaPersoner.size(); x++ ) {

			if (allaPersoner.get(x).getNamn().equals(namn)) {
				finns = true;
				break; }
		}
		if (finns == true)
			System.out.println("En person med det namnet finns redan registrerad! F�rs�k igen. \n");

		else {
			Personer p = new Personer (namn, 0.0);
			allaPersoner.add(p);

			System.out.println("Personen �r registrerad!\n");

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
			�gare = l�sString("Vilken person �ger prylen?: ");
			Personer p = getPerson(�gare);
			if (p==null) {
				System.out.println("Den personen finns inte!");
			}
			else {
				break;
			}
		}		
		for (;;) {
			String prylTyp = l�sString("Vilken sorts pryl �r det?: ");
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
				System.out.println("Prylen m�ste vara en Aktie, en Apparat, eller ett smycke");
			}
		}						 		
	}

	void skapaAktie(){
		double v�rde;
		String aNamn = l�sString("Vad �r det f�r Aktiebolag?");
		int aAntal = l�sInt("Hur m�nga aktier g�ller det? ");
		int aPris = l�sInt("Vad kostar aktien styck? ");

		v�rde = aAntal * aPris;
		Aktier skapaNy = new Aktier(�gare, v�rde, aNamn, aAntal, aPris);
		allaPrylar.add(skapaNy);

		System.out.println("Aktie fr�n [" + aNamn + "] �r registrerad!\n");


	}
	void skapaApparat(){
		int slitage;
		double v�rde;
		String appNamn = l�sString("Vad �r det f�r typ av apparat? ");
		int appPris = l�sInt("Vad kostar apparaten?");
		for (;;) {
			slitage = l�sInt("Hur sliten �r apparaten med ett v�rde 1-10? (10 �r helt ny) ");
			if (slitage < 1 || slitage > 10) {
				System.out.println("V�rdet ska vara mellan 1 och 10!");
			}
			else {
				break;
			}
		}
		v�rde = appPris * (slitage * 0.1);
		Apparater skapaNy = new Apparater(�gare, v�rde, appNamn, appPris, slitage);
		allaPrylar.add(skapaNy);

		System.out.println("Prylen ["+ appNamn + "] �r nu registrerad!\n");
	}

	//Skapar ett smycke
	void skapaSmycke(){
		boolean guld=false;
		double v�rde;
		String metall;
		String typSm = l�sString("Vilken typ av smycke?: ");
		for(;;) {
		metall = l�sString("�r smycket av guld? Ja / Nej ");
		
			if (metall.equalsIgnoreCase("ja")) {
				guld=true;
				break;
			}
			else if (metall.equalsIgnoreCase("nej")) {
				guld=false;
				break;
			}
			else 
				System.out.println("Du m�ste svara med antingen Ja/Nej!");
			
			
		}
		int aStenar = l�sInt("Hur m�nga �delstenar?: ");

		if (guld)
			v�rde = 2000 + aStenar * 500;
		else
			v�rde = 700 + aStenar * 500;

		Smycken skapaNy = new Smycken(�gare, v�rde, typSm, aStenar, metall);
		allaPrylar.add(skapaNy);

		System.out.println("Smycket [" + typSm + "] �r nu registrerad!\n");
	}

	//3	
	void visaAlla(){
		r�knaV�rde();
		for (Personer va : allaPersoner){
			System.out.println(va.getNamn()+"\t"+va.getPersonV�rde());
		}

	}

	//4	
	void visaRikaste(){
		r�knaV�rde();
		for (Personer rikast : allaPersoner){
			if (rikast.getPersonV�rde() > tempV�rde){
				tempNamn = rikast.getNamn();
				tempV�rde = rikast.getPersonV�rde();

			}
		}

		System.out.print("Rikast �r "+ tempNamn +" med ett totalv�rde p�: "+ tempV�rde+" \n");
		for (Personer p : allaPersoner) {
			if (p.getNamn().equals(tempNamn)) {
				for (Prylar a : allaPrylar) {
					if (p.getNamn().equalsIgnoreCase(a.get�gare())) {
						System.out.println(a.getTyp() + "\t" + a.getPrylV�rde());
					}			
				}
			}
		}
		tempV�rde=0.0;
	}


	//5	
	void visaPers(){
		boolean finns2 = true;
		r�knaV�rde();
		String person = l�sString("Ange namn p� person du vill visa:");
		for (Personer p : allaPersoner){
			if (p.getNamn().equalsIgnoreCase(person)){
				finns2 = true;
			}
		}
		if (finns2 == true){
			for (Personer p : allaPersoner){
				if (p.getNamn().equalsIgnoreCase(person)){
					System.out.print(p.getNamn() +  " �ger sammanlagt "+ p.getPersonV�rde()+"\n");
					for (Prylar a : allaPrylar){
						if (person.equalsIgnoreCase(a.get�gare())){
							System.out.print(a.getTyp() + "\t" + a.getPrylV�rde()+"\n");
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
	void b�rsKrasch(){

		for (Prylar bKrasch : allaPrylar)
		{	
			if (bKrasch instanceof Aktier){
				bKrasch.setPrylV�rde(0.0);
				((Aktier)bKrasch).setPris(0);

			}
		}	
		System.out.println("�h nej! B�rskrasch!");
	}

	//7
	void taBortPers(){
		String vem = l�sString("Vilken person vill du ta bort?");
		for (int x=0; x<allaPersoner.size(); x++ ) {
			if (allaPersoner.get(x).getNamn().equalsIgnoreCase(vem)){
				allaPersoner.remove(x);
				bort = true;
				break;	
			}
		}

		if (bort == true)
			System.out.println("Personen med det angivna namnet �r nu borttagen.");
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
		r�knaV�rde();
		String person = l�sString("V�lj en person");
		for (Personer p : allaPersoner){
			if (p.getNamn().equalsIgnoreCase(person)){
				pFinns = true;
			}
		}
		if (pFinns == true){
			for (Personer p : allaPersoner){
				if (p.getNamn().equalsIgnoreCase(person)){
					System.out.print(p.getNamn() +  " �ger sammanlagt "+ p.getPersonV�rde()+"\n");
					for (Prylar a : allaPrylar){
						if (person.equalsIgnoreCase(a.get�gare())){
							System.out.print(a.getTyp() + "\t" + a.getPrylV�rde()+"\n" );

							String o = l�sString("Vilken pryl vill du ta bort?");
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
			int val=hp.l�sInt("V�lkommen!\n Meny:\n 1. Skapa Person \n 2. Skapa pryl \n 3. Visa alla personer \n 4. Visa rikast person \n 5. Visa viss person \n 6. B�rskrasch \n 7. Ta bort person \n 8. Ta bort pryl \n 9. Avsluta \n Vad vill du g�ra?");
			switch (val){
			case 1: hp.skapaPerson(); break;
			case 2: hp.skapaPryl(); break;
			case 3: hp.visaAlla(); break;
			case 4: hp.visaRikaste(); break;
			case 5: hp.visaPers(); break;
			case 6: hp.b�rsKrasch(); break;
			case 7: hp.taBortPers(); break;
			case 8: hp.taBortPryl(); break;
			case 9: System.out.println("Programmet har nu avslutats!");
			System.exit(0);
			default: System.out.println("Felaktigt kommando!");


			}	
		}
	}
}