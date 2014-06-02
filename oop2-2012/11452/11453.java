import java.util.*;

class Kommando{

	static Scanner scan = new Scanner(System.in);
	static Person[] personer = new Person[10];
	static Samling [] addedValue = new Samling[10];
	static Pryl[] prylar = new Pryl[10];
	static int prylarIndex = 0;
	static int apparatSlitage, pris, antal, metall;
	static String prylTyp, prylNamn, namn;
	static Person person;
	static double aPris;


	public static void main(String[] args){

		String namn = null;
        int choice = showMenu();

		while(choice!=7){
			switch(choice){
				case 1:
				int r = 0;

					System.out.print("Ange namn: ");
					namn = scan.nextLine();

						for(int x=0; x<personer.length; x++){
							if(personer[x] != null){
								r++;
								String i = personer[x].getNamn();

									if(i.equalsIgnoreCase(namn)){
										System.out.println(personer[x].getNamn() + " - " +"Namnet finns redan!");
										break;
									}//if
							} else {
								Person per = new Person(namn);
								personer[r] = per;
							}//ifelse
						}//for
				break;

				case 2:

					int prylSort = askPrylTyp();
					person = askOwner();
					//Ingen exception. Lägger in nedan metoder i en if-sats istället för att tvinga användaren att ange en giltig ägare för att komma vidare.
					if (person != null) {
						askResten(prylSort);
						addToPrylar(prylSort);
						}
					break;

				case 3:

					addAllValues();
					printAllAddedValues();

					break;

				case 4:

					namn = getRichestOwner();
					getOwnersPrylar(namn);

					break;

				case 5:

					namn = showPerson();
					namn = checkName(namn);
					getOwnersPrylar(namn);

					break;

				case 6:

					nollaAktier();
					addAllValues();

					break;

				case 7:
					break;

			}//switch
			choice = showMenu();
		}//while

	}//main

	public static int showMenu(){

		String menyVal;
		int val=0;

		try{
		System.out.println("Ange ett nummer för ditt menyval: ");
		System.out.println("1. Skapa person");
		System.out.println("2. Skapa pryl");
		System.out.println("3. Visa alla");
		System.out.println("4. Visa rikaste");
		System.out.println("5. Visa viss person");
		System.out.println("6. Börskrasch");
		System.out.println("7. Avsluta");

		menyVal = scan.nextLine();
		val = Integer.parseInt(menyVal);

		} catch (NumberFormatException e) {
			System.out.println("Du måste ange en siffra. Prova igen.");
			val = 0;
		}

		return val;
	}//method


	public static int askPrylTyp(){

        int pryl = 0;
        do {
			try{
		        System.out.println("Vilken sorts pryl vill du skapa?\n 1. Apparat\n 2. Aktie\n 3. Smycke\n Ange ett värde mellan 1 och 3.");
		        prylTyp = scan.nextLine();
		        pryl = Integer.parseInt(prylTyp);

			} catch (NumberFormatException e) {
				System.out.println("Du måste ange en siffra. Prova igen.");
				pryl = 0;
			}
				if(pryl > 3){
			        System.out.println("Värde " + pryl + " är inte ett giltigt val. Försök igen.");
		        }
		} while (pryl > 3||pryl == 0);

		return pryl;

	}

	public static Person askOwner(){

		Person p = null;

		System.out.println("Vem äger prylen: ");
		String owner = scan.nextLine();

			for(int x=0; x<personer.length; x++){

				if(personer[x] != null){

					if(personer[x].getNamn().equalsIgnoreCase(owner)){
						p = personer[x];

						return p;
					}
				} else {

					System.out.print("Det finns ingen ägare med sådant namn.");
					break;
				}//yttre if
			}//for

		return p;
	}

	public static void askResten(int prylSort){
		boolean ok;

		//Apparat******************************
		if (prylSort==1)
		{
			System.out.println("Ange typ av apparat: ");
				prylNamn = scan.nextLine();
		do{
		ok = true;
			try{
			System.out.println("Vilket pris: ");
				String pris = scan.nextLine();
				aPris = Double.parseDouble(pris);
			} catch (NumberFormatException e) {
				System.out.println("Slitagen måste bestå av siffror. Prova igen.");
				ok = false;
			}
		} while (ok == false);


		do{
		ok = true;
			try{
			System.out.println("Ange slitage på en skala mellan 1 och 10 där 10 är ny: ");
				String aSlitage = scan.nextLine();
				apparatSlitage = Integer.parseInt(aSlitage);
			} catch (NumberFormatException e){
				System.out.println("Slitagen måste bestå av siffror. Prova igen.");
				ok = false;
			}
				if(apparatSlitage < 0 || apparatSlitage > 10) {
					System.out.println(apparatSlitage + "är inte ett giltigt val. Försök igen.");
				}
		} while((apparatSlitage < 0 || apparatSlitage > 10) || ok == false);

			prylNamn = prylNamn;
			aPris = aPris;
			apparatSlitage = apparatSlitage;
		}
		//Aktie********************************
		else if (prylSort==2)
		{
			System.out.println("Vilken aktie avser det: ");
				prylNamn = scan.nextLine();
		do{
		ok = true;
			try{
			System.out.println("Vilket antal: ");
				String aAntal = scan.nextLine();
				antal = Integer.parseInt(aAntal);
			} catch (NumberFormatException e) {
				System.out.println("Antal måste bestå av siffror. Prova igen.");
				ok = false;
			}

				if(antal < 0) {
					System.out.println(antal + " är inte ett godkänt antal. Försök med ett positivt tal.");
			}
		} while (antal < 0 || ok == false);

		do{
		ok = true;
			try{
			System.out.println("Vilket pris: ");
				String aPris = scan.nextLine();
				pris = Integer.parseInt(aPris);
			} catch (NumberFormatException e) {
				System.out.println("Pris måste bestå av siffror. Prova igen.");
				ok = false;
			}
			if(pris < 0){
				System.out.println(pris + " är inte ett giltigt pris. Försök igen.");
			}

		} while (pris < 0 || ok == false);

			prylNamn = prylNamn;
			antal = antal;
			pris = pris;
		}
		//Smycke*******************************
		else if (prylSort==3)
		{
			System.out.println("Vilket sorts smycke: ");
				prylNamn = scan.nextLine();

			do {
			ok = true;

				try{
				System.out.println("Är smycket i silver eller guld? Ange 1 för Silver och 2 för guld");
				String sMetall = scan.nextLine();
				metall = Integer.parseInt(sMetall);

				} catch (NumberFormatException e) {
					System.out.println("Valet måste vara numeriskt. Prova igen.");
					ok = false;
				}

				if(metall > 2 || metall < 0){
					System.out.println("Alternativet " + metall + " är inte ett giltigt val för metall. Gör ett nytt försök.");
				}

			} while((metall < 0 || metall > 2)|| ok == false);


			do {
			ok = true;
				try{
				System.out.println("Antal ädelstenar");
				String sStenar = scan.nextLine();
				antal = Integer.parseInt(sStenar);
				} catch (NumberFormatException e) {
					System.out.println("Valet måste vara numeriskt. Prova igen.");
					ok = false;
				}
				if(antal < 0){
					System.out.println(antal + "är inte ett giltigt alternativ. Försök igen.");
				}
			} while(antal < 0 || ok == false);

			prylNamn = prylNamn;
			metall = metall;
			antal = antal;
		}
	}//askResten

	public static void addToPrylar(int prylSort){


		if(prylSort==1){
			Pryl pryl = new Apparat(prylNamn, person, aPris, apparatSlitage);
			prylar[prylarIndex] = pryl;

			prylarIndex++;
		} else if (prylSort==2)
		{
			Pryl pryl = new Aktie(prylNamn, person, antal, pris);
			prylar[prylarIndex] = pryl;

			prylarIndex++;
		} else
		{
			Pryl pryl = new Smycke(prylNamn, person, metall, antal);
			prylar[prylarIndex] = pryl;

			prylarIndex++;

		}


	}//addToPrylar

	public static void addAllValues(){

		int result = 0;
		int x = 0;
		String namn;

		for(x = 0; x<personer.length; x++){

			if(personer[x] != null){

				namn = personer[x].getNamn();

					for(int y = 0; y<prylar.length; y++){

						if(prylar[y] != null){

							if(prylar[y].getOwner()==namn){

								int temp = prylar[y].getValue();
								result = result + temp;
							}
						}//if

					Samling s = new Samling(namn, result);
					addedValue[x] = s;

					}//for

				result = 0;
			}//if
		}//for
	}

	public static void printAllAddedValues(){

		System.out.println("I registret finns: ");

			for(Samling value : addedValue){

				if(value != null){
					System.out.println(value.getOwnerName() + " \t" +value.getAddedValue());
				}
			}
	}

	public static String getRichestOwner(){

		int rikValue = 0;
		String rikNamn = null;

			for(Samling rikast : addedValue){

				if(rikast != null){

					int sum = rikast.getAddedValue();

						if(sum>rikValue){
							rikValue = sum;
							rikNamn = rikast.getOwnerName();
						}
				} else
				{
					addAllValues();
				}

			}//for

		System.out.println("Rikast är "+rikNamn +" som sammanlagt äger " +rikValue);

		return rikNamn;

	}//getRichestOwner

	public static void getOwnersPrylar(String n){

		namn = n;

		for(Pryl pryl : prylar){

			if(pryl != null){

				String owner = pryl.getOwner();

					if(owner==namn){

						System.out.println("\t" +pryl.getPrylNamn() + "\t" +pryl.getValue());

					}
			}//if
		}//for
	}//getRichestPrylar

	public static String showPerson(){

		System.out.print("Ange ett namn: ");
		String n = scan.nextLine();

		return n;

	}//showPerson

	public static String checkName(String namn){

		String p = namn;

			for(Person pers : personer){

				if(pers != null){

					String n = pers.getNamn();

						if(p.equalsIgnoreCase(n)){
							p = n;
							System.out.println(p);
							return p;
						}
				} else {
					System.out.print("Det finns ingen person med ett sådant namn");
					break;
				}
			}//for

		return p;
	}//checkName

	public static void nollaAktier(){

		for(Pryl pryl : prylar){

			if(pryl != null){

				if(pryl instanceof Aktie) {

					Aktie a = (Aktie) pryl;
					a.setPris();
				}

			}//if
		}//for
	}//nollaAktier


}//class