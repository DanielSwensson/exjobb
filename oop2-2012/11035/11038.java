import java.util.*;

class Huvudprogram {
	ArrayList<Person> personregister = new ArrayList<Person>();

	Scanner keyboard = new Scanner(System.in);

	private int readInt(String fr�ga){
		for(;;){
			try{
				System.out.print(fr�ga);
				int x=Integer.parseInt(keyboard.nextLine());
				return x;
			}
			catch(NumberFormatException e){
				System.out.println("Fel - ska vara numeriskt v�rde!");
			}
		}
	}

	private String readString(String fr�ga){
		System.out.print(fr�ga);
		String str = keyboard.nextLine();
		return str;
	}

	private boolean checkInmatning(int inmatning){
		if (inmatning <= 0){
			return true;
		}
		return false;
	}

	private Person getPerson (String namn){
		for(Person p: personregister)
			if (p.getNamn().equalsIgnoreCase(namn))
				return p;
		return null;
	}

	private boolean checkPersonregisterStorlek(){
		if (personregister.size() < 1){
			System.out.println("Det finns inga personer i registret.");
			return false;
		}
		return true;
	}

	private void skapaPerson(){
		String namn = readString("Nya personens namn: ");
		Person pers = getPerson(namn);
		if (pers!=null)
			System.out.println("Den personen finns redan.");
		else{
			Person ny = new Person(namn);
			personregister.add(ny);
			System.out.println("Personen har nu lagts till.");
		}
	}

	private void skapaPryl(){
		if(checkPersonregisterStorlek ()){
			Person pers;
			do{
				String personnamn = readString("Vilken person �ger prylen: ");
				pers = getPerson(personnamn);

				if (pers==null){
					System.out.println("Den personen finns inte. F�rs�k igen!");
				}
			}while(pers == null);

			String pryltyp;
			do{
				pryltyp = readString("Vilken sorts pryl (smycke/aktie/apparat): ");

				if(!pryltyp.equalsIgnoreCase("Aktie") && !pryltyp.equalsIgnoreCase("Smycke") && !pryltyp.equalsIgnoreCase("Apparat")){
					System.out.println("Var god ange smycke, aktie eller apparat.");
				}
			}while(!pryltyp.equalsIgnoreCase("Aktie") && !pryltyp.equalsIgnoreCase("Smycke") && !pryltyp.equalsIgnoreCase("Apparat"));


			if(pryltyp.equalsIgnoreCase("Smycke")){
				String namn = readString("Vilken sorts smycke: ");
				while (true){
					String metalltyp = readString ("Ange metalltyp (guld/silver): ");
					if (metalltyp.equalsIgnoreCase("guld") || metalltyp.equalsIgnoreCase("silver")){

						int antal�delstenar;
						do{
							antal�delstenar = readInt("Antal �delstenar: ");
							if (checkInmatning(antal�delstenar)){
								System.out.println("V�rdet m�ste vara positivt.");
							}
						}while(checkInmatning(antal�delstenar));

						Pryl p = new Smycke(antal�delstenar, metalltyp, pryltyp, namn);
						pers.addPryl(p);
						break;
					}
					else{
						System.out.println("Fel, det m�ste vara antingen guld eller silver!");
					}
				}
			}

			if(pryltyp.equalsIgnoreCase("Apparat")){
				int slit;
				String namn = readString("Vilken sorts apparat: ");

				int ink�p;
				do{
					ink�p = readInt("Vilket ink�pspris: ");
					if (checkInmatning(ink�p)){
						System.out.println("V�rdet m�ste vara positivt.");
					}
				}while(checkInmatning(ink�p));


				do{
					slit = readInt ("Vilket slitage: ");
					if (slit > 11 || slit < 0){
						System.out.println("Var v�nlig ange slitage mellan 1-10, d�r 10 betyder helt ny och 1 mycket sliten");
					}
				}while(slit > 11 || slit < 0);

				Pryl p = new Apparat(ink�p, slit, pryltyp, namn);
				pers.addPryl(p);
			}

			if(pryltyp.equalsIgnoreCase("Aktie")){
				String namn = readString("Vilket namn har aktien: ");

				int antalAktier;
				do{
					antalAktier = readInt("Hur m�nga? ");
					if (checkInmatning(antalAktier)){
						System.out.println("V�rdet m�ste vara positivt.");
					}
				}while(checkInmatning(antalAktier));

				int pris;
				do{
					pris = readInt("Vad kostade varje aktie?  ");
					if (checkInmatning(pris)){
						System.out.println("V�rdet m�ste vara positivt.");
					}
				}while(checkInmatning(pris));

				Pryl p = new Aktie (antalAktier, pris, pryltyp, namn);
				pers.addPryl(p);
			}
			System.out.println(pryltyp + " �r inlagd");

		}else{
			System.out.println("Registret �r tomt!");
		}

	}



 	private void visaAlla(){
		if (checkPersonregisterStorlek()){
			System.out.println("I registret finns: ");
			for (int x = 0; x < personregister.size(); x++){
				System.out.println(personregister.get(x));
			}
		}
		else {
			System.out.println("Registret �r tomt!");
		}
	}


	private void visaRikaste(){
		int x;
		if (checkPersonregisterStorlek()){
			Person rikaste = personregister.get(0);
			for(x = 1; x < personregister.size(); x++){
				personregister.get(x).getSummaV�rde();
				if (rikaste.getSummaV�rde() < personregister.get(x).getSummaV�rde()){
					rikaste = personregister.get(x);
				}	
			}
			System.out.println("Rikast �r " + rikaste.getNamn() + " som sammanlagt �ger " + rikaste.getSummaV�rde());

			System.out.print(rikaste.getPrylInfo());
		}
		else{
			System.out.println("Registret �r tomt!");
		}
	}

	private void visaViss(){
		Person pers;

		do{
			String personnamn = readString("Vilken person vill du lista: ");
			pers = getPerson(personnamn);

			if (pers==null){
				System.out.println("Den personen finns inte. F�rs�k igen!");

			}
		}while(pers == null);

		System.out.println(pers.getNamn() + " �ger prylar vars v�rde sammanlagt uppg�r till " +pers.getSummaV�rde() + " kr.");

		System.out.println(pers.getPrylInfo());
	}

	private void b�rskrasch(){
		int x;
		if (checkPersonregisterStorlek()){

			for(x = 0; x < personregister.size(); x++){

				Person person = personregister.get(x);
				person.SetAktieTillNoll();


			}System.out.println("B�rskrasch genomf�rd!");
		} 
		else{
			System.out.println("Registret �r tomt!");
		}
	}


	public static void main (String[] args){
		Huvudprogram hp = new Huvudprogram();
		System.out.println("Hej och v�lkommen till Prylprogrammet!");
		for(;;){
			System.out.println("1 - Skapa person, 2 - Skapa pryl, 3 - Visa alla, 4 - Visa rikaste, 5 - Visa viss person, 6 - B�rskrasch, 7 - Avsluta");
			int kommando = hp.readInt("> ");
			switch (kommando){
			case 1: 
				hp.skapaPerson();
				break;
			case 2:
				hp.skapaPryl();
				break;
			case 3:
				hp.visaAlla();
				break;
			case 4:
				hp.visaRikaste();
				break;
			case 5:
				hp.visaViss();
				break;
			case 6:
				hp.b�rskrasch();
				break;
			case 7:
				System.out.println("Tack och hejd�");
				System.exit(0);
			default:
				System.out.println("Felaktigt kommando");
			}
		}
	}


}

