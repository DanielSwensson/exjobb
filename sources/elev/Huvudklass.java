import java.util.*;
class Huvudklass {
	ArrayList<Person> personlista = new ArrayList<Person>();
	Scanner sc = new Scanner(System.in);
		
	/// Fr�ga
	int readInt(String fr�ga){
		for(;;){
			try{
				System.out.print(fr�ga);
				int x=Integer.parseInt(sc.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Fel - skall vara numeriskt v�rde");
			}
		}
	}
	
	/// 
	String readString(String fr�ga){
		System.out.print(fr�ga);
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
		
	/// Metod f�r att skapa person.
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
	Huvudklass skapaSmycke(String �gare){
		String typ = readString("Typ av smycke: ");
		String material = readString("�r smycket av guld eller silver? ");
		if(material.equalsIgnoreCase("guld") || material.equalsIgnoreCase("Silver")){
			int �delstenar = readInt("Antal �delstenar: ");
			Smycke ny = new Smycke(typ, �delstenar, material);
			getPerson(�gare).pryllista.add(ny);
			
		}
		else{
			System.out.println("Fel material! Ska vara guld eller silver!");
			
		}
		return null;
		
	}
	//skapar aktier
	Huvudklass skapaAktie(String �gare){
		String namn = readString("Namn p� aktie: ");
		int antal = readInt("Antal aktier: ");
		int pris = readInt("V�rde p� varje aktie: ");
		Aktie ny = new Aktie(namn, pris, antal);
		getPerson(�gare).pryllista.add(ny);
		return null;
	}
	//skapar Apparat
	Huvudklass skapaApparat(String �gare){
		String namn = readString("Typ av apparat: ");
		int kostnad = readInt("Ink�pspris p� "+namn + ": ");
		int slitage = readInt("Slitage p� " + namn + " (1-10): ");
		if(slitage >=1 && slitage <=10){
		Apparat ny = new Apparat(namn, slitage, kostnad);
		getPerson(�gare).pryllista.add(ny);
		}
		else{
			System.out.println("Slitage m�ste vara mellan 1 och 10!");
		}
		return null;
	}
	
	void skapaPryl(){
	//Koden f�r att skapa en pryl och ge till en person
		
		String �gare = readString("�gare: ");
		Person p = getPerson(�gare);
		if (p!=null){
			String pryl = readString("Typ av pryl: ");
			if (pryl.equalsIgnoreCase("Smycke"))
				skapaSmycke(�gare);
				
			else if (pryl.equalsIgnoreCase("Aktie"))
				skapaAktie(�gare);
				
			else if (pryl.equalsIgnoreCase("Apparat"))
				skapaApparat(�gare);
				
			else
				System.out.println("M�ste vara Smycke, Aktie eller Apparat!");
				
		  }
	    if (p==null) 
	    	System.out.println("Personen finns inte");
			
	}
	void visaAlla(){
	//Koden f�r att visa alla personerna
		
		System.out.println("I registret finns: ");
		for(int i= 0; i<personlista.size(); i++){
			int tot = 0;

			for(int y= 0; y<personlista.get(i).pryllista.size(); y++){
			tot += personlista.get(i).pryllista.get(y).getV�rde();
			}
			System.out.println(personlista.get(i)+"  "+ tot);
		}	
	}
	void visaRikaste(){
	//Koden f�r att visa alla personerna
		
		int rikast=0;
		Person rikastp = null;
		for(int i= 0; i<personlista.size(); i++){
			int tot = 0;
			Person rik = null;

			for(int y= 0; y<personlista.get(i).pryllista.size(); y++){
				tot += personlista.get(i).pryllista.get(y).getV�rde();
				rik = personlista.get(i);
			}
			if(tot>=rikast){
				rikast=tot;
				rikastp = rik;
			}	
		}
		if(rikastp==null)
			System.out.println("Listan �r tom!");
		else{
			System.out.println("Rikaste personen �r " + rikastp + " som sammanlagt �ger " + rikast);
			
				for(int y= 0; y<rikastp.pryllista.size(); y++){
					System.out.println("  " + rikastp.pryllista.get(y));
				}
			}	
	}
	void visaViss(){
	//Koden f�r att visa alla personerna
		String s�ka = readString("Vilken person s�ker du efter? ");
		Person p = getPerson(s�ka);
		if(p!=null){
			System.out.println(getPerson(s�ka));
		
			for(int y= 0; y<getPerson(s�ka).pryllista.size(); y++){
				System.out.println("  " + getPerson(s�ka).pryllista.get(y));
			}
		}
		else{
			System.out.println("Personen finns inte!");
		}	
	}
	void b�rsKrasch(){
		
		for(int i = 0; i < personlista.size(); i++){
			for(int y = 0; y < personlista.get(i).pryllista.size(); y++){
				if (personlista.get(i).pryllista.get(y) instanceof Aktie){
					((Aktie)personlista.get(i).pryllista.get(y)).setV�rde(); 
				}	
			}
		}
	}

		
	public static void main(String[] args) {
		Huvudklass hp = new Huvudklass();
		System.out.println("Hej och v�lkommen till Prylprogrammet!");
		for(;;){
			int val=hp.readInt("Ange kommando 1-7 ");
			switch (val) {	
				case 1: hp.skapaPerson(); break;	
				case 2: hp.skapaPryl(); break;
				case 3: hp.visaAlla(); break;
				case 4: hp.visaRikaste(); break;
				case 5: hp.visaViss(); break;
				case 6: hp.b�rsKrasch(); break;
				case 7: System.out.println("Tack och hej!");
						System.exit(0);
				default: System.out.println("Felaktigt kommando!");
			}
	    }
	}
}
