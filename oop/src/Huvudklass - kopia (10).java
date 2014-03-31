import java.util.*;
class Huvudklass {
	ArrayList<Person> personlista = new ArrayList<Person>();
	Scanner sc = new Scanner(System.in);
		
	/// FrŒga
	int readInt(String frŒga){
		for(;;){
			try{
				System.out.print(frŒga);
				int x=Integer.parseInt(sc.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Fel - skall vara numeriskt vŠrde");
			}
		}
	}
	
	/// 
	String readString(String frŒga){
		System.out.print(frŒga);
		String str=sc.nextLine();
		return str;
	}
	
	/// Kollar om namnet finns i listan.
	Person getPerson(String namn){
		for (Person p : personlista)
			if (p.getNamn().equalsIgnoreCase(namn))
				return p;
		return null;
	}
		
	/// Metod fšr att skapa person.
	void skapaPerson(){
		String namn = readString("Nya personens namn: ");
		Person p = getPerson(namn);
		if (p!=null)
			System.out.println("Den personen finns redan");
		else{
			Person ny = new Person(namn);
			personlista.add(ny);
		}
	}
	//skapar smycke
	Huvudklass skapaSmycke(String Šgare){
		String typ = readString("Typ av smycke: ");
		String material = readString("€r smycket av guld eller silver? ");
		if(material.equalsIgnoreCase("guld") || material.equalsIgnoreCase("Silver")){
			int Šdelstenar = readInt("Antal Šdelstenar: ");
			Smycke ny = new Smycke(typ, Šdelstenar, material);
			getPerson(Šgare).pryllista.add(ny);
			
		}
		else{
			System.out.println("Fel material! Ska vara guld eller silver!");
			
		}
		return null;
		
	}
	//skapar aktier
	Huvudklass skapaAktie(String Šgare){
		String namn = readString("Namn pŒ aktie: ");
		int antal = readInt("Antal aktier: ");
		int pris = readInt("VŠrde pŒ varje aktie: ");
		Aktie ny = new Aktie(namn, pris, antal);
		getPerson(Šgare).pryllista.add(ny);
		return null;
	}
	//skapar Apparat
	Huvudklass skapaApparat(String Šgare){
		String namn = readString("Typ av apparat: ");
		int kostnad = readInt("Inkšpspris pŒ "+namn + ": ");
		int slitage = readInt("Slitage pŒ " + namn + " (1-10): ");
		if(slitage >=1 && slitage <=10){
		Apparat ny = new Apparat(namn, slitage, kostnad);
		getPerson(Šgare).pryllista.add(ny);
		}
		else{
			System.out.println("Slitage mŒste vara mellan 1 och 10!");
		}
		return null;
	}
	
	void skapaPryl(){
	//Koden fšr att skapa en pryl och ge till en person
		
		String Šgare = readString("€gare: ");
		Person p = getPerson(Šgare);
		if (p!=null){
			String pryl = readString("Typ av pryl: ");
			if (pryl.equalsIgnoreCase("Smycke"))
				skapaSmycke(Šgare);
				
			else if (pryl.equalsIgnoreCase("Aktie"))
				skapaAktie(Šgare);
				
			else if (pryl.equalsIgnoreCase("Apparat"))
				skapaApparat(Šgare);
				
			else
				System.out.println("MŒste vara Smycke, Aktie eller Apparat!");
				
		  }
	    if (p==null) 
	    	System.out.println("Personen finns inte");
			
	}
	void visaAlla(){
	//Koden fšr att visa alla personerna
		
		System.out.println("I registret finns: ");
		for(int i= 0; i<personlista.size(); i++){
			int tot = 0;

			for(int y= 0; y<personlista.get(i).pryllista.size(); y++){
			tot += personlista.get(i).pryllista.get(y).getVŠrde();
			}
			System.out.println(personlista.get(i)+"  "+ tot);
		}	
	}
	void visaRikaste(){
	//Koden fšr att visa alla personerna
		
		int rikast=0;
		Person rikastp = null;
		for(int i= 0; i<personlista.size(); i++){
			int tot = 0;
			Person rik = null;

			for(int y= 0; y<personlista.get(i).pryllista.size(); y++){
				tot += personlista.get(i).pryllista.get(y).getVŠrde();
				rik = personlista.get(i);
			}
			if(tot>=rikast){
				rikast=tot;
				rikastp = rik;
			}	
		}
		if(rikastp==null)
			System.out.println("Listan Šr tom!");
		else{
			System.out.println("Rikaste personen Šr " + rikastp + " som sammanlagt Šger " + rikast);
			
				for(int y= 0; y<rikastp.pryllista.size(); y++){
					System.out.println("  " + rikastp.pryllista.get(y));
				}
			}	
	}
	void visaViss(){
	//Koden fšr att visa alla personerna
		String sška = readString("Vilken person sšker du efter? ");
		Person p = getPerson(sška);
		if(p!=null){
			System.out.println(getPerson(sška));
		
			for(int y= 0; y<getPerson(sška).pryllista.size(); y++){
				System.out.println("  " + getPerson(sška).pryllista.get(y));
			}
		}
		else{
			System.out.println("Personen finns inte!");
		}	
	}
	void bšrsKrasch(){
		
		for(int i = 0; i < personlista.size(); i++){
			for(int y = 0; y < personlista.get(i).pryllista.size(); y++){
				if (personlista.get(i).pryllista.get(y) instanceof Aktie){
					((Aktie)personlista.get(i).pryllista.get(y)).setVŠrde(); 
				}	
			}
		}
	}

		
	public static void main(String[] args) {
		Huvudklass hp = new Huvudklass();
		System.out.println("Hej och vŠlkommen till Prylprogrammet!");
		for(;;){
			int val=hp.readInt("Ange kommando 1-7 ");
			switch (val) {	
				case 1: hp.skapaPerson(); break;	
				case 2: hp.skapaPryl(); break;
				case 3: hp.visaAlla(); break;
				case 4: hp.visaRikaste(); break;
				case 5: hp.visaViss(); break;
				case 6: hp.bšrsKrasch(); break;
				case 7: System.out.println("Tack och hej!");
						System.exit(0);
				default: System.out.println("Felaktigt kommando!");
			}
	    }
	}
}
