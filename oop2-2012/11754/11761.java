import java.util.*;

//Ny scanner och array lista för att spara
public class Program {
	Scanner sc = new Scanner (System.in);
	private ArrayList<Person> person = new ArrayList<Person>();

	//Nummer inmatning
	public int readInt(String question){
		for(;;){
			try{
				System.out.println(question);
				int number = Integer.parseInt(sc.nextLine());
				return number;
			}
			catch (NumberFormatException e){
				System.out.println("Fel-Finns ej");
			}
		}
	}
	
	public String readString(String question){
		for(;;){
			System.out.println(question);
			String str = sc.nextLine();
			return str;
		}
	}
	public int getListSize(){
		return person.size();
	}
	//Skapa en ny person i programmet
	void skapaPers(){
		String name = readString("Skriv in namnet pa den person som ska läggas in: ");


		for(int i=0; i<person.size() && i!=(person.size()-1); i++){
			if(person.get(i).getName().equals(name)){
				System.out.println("Denna person finns redan i registret");

				return;
			}
		}
			person.add(new Person(name));	
		
	}

	//Ny pryl som kan vara aktie, smycke eller apparat
	void skapaSak(){
		String owner = readString("Vilken person äger prylen: ");
		boolean found = false;
		Person p = null;
		for(int i=0; i<person.size(); i++){
			if(person.get(i).getName().equalsIgnoreCase(owner)){
				found=true;
				p=person.get(i);
			}
		}

		if(found==false){
			System.out.println("Personen finns ej");
			return;
		}
		String typ = readString("Vilken sorts pryl (Smycke, Aktie eller Apparat): ");

		if(typ.equalsIgnoreCase("Smycke")){

			String type2 = readString("Vilken sorts smycke: ");
			String gold = readString("Är smycket av guld, Ja/Nej: ");

			boolean goldy = false;
			if(gold.equalsIgnoreCase("Ja"))
				goldy=true;

			int jewel = readInt("Antal ädelstenar: ");
			Smycke nytt = new Smycke(type2, goldy, jewel);

			p.addPryl(nytt);
		}

		else if(typ.equalsIgnoreCase("Aktie")){
			String company = readString("Aktiens Namn: ");

			int amount = readInt("Aktieandelar: ");
			int worth = readInt("Pris per styck: ");

			Aktie nytt = new Aktie(company, amount, worth);
			p.addPryl(nytt);
		}

		else if(typ.equalsIgnoreCase("Apparat")){
			String type3 = readString("Sort av apparat: ");

			int price = readInt("Pris som ny: ");
			int wear = readInt("Slitage (1-10 där 10 är ny): ");

			Apparat nytt = new Apparat(type3, price, wear);
			p.addPryl(nytt);
		}
		else{
			System.out.println("Fel-kan ej behandla denna pryl");
		}
	}



	void visaAllt(){

		for (int i=0; i<person.size(); i++){
			System.out.println(person.get(i).getName() +"/t"+ person.get(i).value());
		}
	}


	void visaRikast(){
		Person rikast = null;
		if(!person.isEmpty())
			rikast= person.get(0);

		for (int i=0; i<person.size(); i++){
			person.get(i).value();
			if (person.get(i).value()>rikast.value())
				rikast = person.get(i);
		}
		System.out.print("Rikast ar "+ rikast.getName()+" som sammanlagt ager "+rikast.value() +"\n"+rikast.allStuff());
	}

	void visaNagra(){
		String name = readString("Vilken person vill du visa? ");

		boolean found = false;
		for(int i=0; i<person.size(); i++){
			if(person.get(i).getName().equalsIgnoreCase(name)){
				found=true;
				if(found)
					System.out.println(person.get(i).getName()+" har prylar till ett sammanlagt varde av "+ person.get(i).allStuff());
				else
					System.out.println("Denna person finns ej!");
			}
		}

	}
	//Kracha borsen
	void borskrach(){
		System.out.println("Börskrasch genomförd");

		for(int i=0; i< person.size(); i++){
			person.get(i).getKrasch();
			
			System.out.println(person.get(i).getName()+" "+ person.get(i).allStuff());
		}
	}

	public static void main (String[]args){
		Program hp = new Program();
		System.out.println("Välkommen till prylprogrammet! ");
		for(;;){
			int choise=hp.readInt("1. Skapa person\n2. Skapa pryl\n3. Visa alla\n4. Visa rikast\n5. Visa viss person\n6. Borskrasch\n7. Avsluta program");
			switch (choise){
			case 1: hp.skapaPers();
			break;
			case 2: hp.skapaSak();
			break;
			case 3: hp.visaAllt();
			break;
			case 4: hp.visaRikast();
			break;
			case 5: hp.visaNagra();
			break;
			case 6: hp.borskrach();
			break;
			case 7:
				System.out.println("Program avslutat");
				System.exit(1);
			default:
				System.out.println("Fel-Fel inmatad siffra");

			}
		}
	}
}