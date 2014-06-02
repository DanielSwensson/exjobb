import java.util.*;
class Program {
	ArrayList<Personer>allaPersoner=new ArrayList<Personer>();
	Scanner keyboard=new Scanner(System.in);


	int readInt(String fråga){ 
		for(;;){
			try{ 
				System.out.print(fråga); 
				int x=Integer.parseInt(keyboard.nextLine()); 
				return x;
			} 
			catch (NumberFormatException e){
				System.out.println("Fel - Ska vara numeriskt");}
		}
		}

	String readString(String fråga){
		System.out.print(fråga); 
		String str=keyboard.nextLine(); 
		return str;}

	Personer getPersoner(String namn){
		for (Personer p:allaPersoner)
			if (p.getNamn().equalsIgnoreCase(namn))
				return p;
		return null;}

	void skapaPersoner(){
		String namn=readString("Personens namn: ");
		Personer p=getPersoner(namn);
		if (p!=null)
			System.out.println("Personen finns redan");
		else{
			Personer ny=new Personer(namn);
			allaPersoner.add(ny);}}

	void visaAlla() {

		System.out.println("I registret: ");


		for (Personer p: allaPersoner) {
			System.out.println(p.getNamn() + "\t"+p.getSumma());}

	}

	void skapaPrylar(){
		String agare =readString("Vilken person äger prylen: ");
		boolean pp=false;
		for (Personer p:allaPersoner){
			if (p.getNamn().equalsIgnoreCase(agare)){ 
				pp=true;
				String prylTyp=readString("Vilken sorts pryl: ");

				if (prylTyp.equalsIgnoreCase("Smycke")){
					String sort=readString("Vilken sorts smycke? ");
					int material=readInt ("Är smycket av guld? 1-Ja, 2-Nej ");
					int adelstenar=readInt("Antal ädelstenar: ");
					p.allaPrylar.add(new Smycken(sort, material, adelstenar));	}


				else if (prylTyp.equalsIgnoreCase("Aktie")){
					String sort1=readString("Vad heter aktieposten? ");
					int antal1=readInt("Antal aktieposter: ");
					int pris1=readInt("Pris för aktieposten: ");
					p.allaPrylar.add(new Aktier (sort1, antal1, pris1));}


				else if (prylTyp.equalsIgnoreCase("Apparat")){
					String sort2=readString("Vilken sorts apparat? ");
					int pris2=readInt("Inköpspris: ");
					int slitage=readInt("Apparatens slitage på en skala mellan 1-10: ");
					p.allaPrylar.add(new Apparater (sort2, pris2, slitage));}

				else
					System.out.println("Prylen finns inte");
			}
		}
		if(pp==false)
			System.out.println("Personen finns inte i registret");
	}

	void visaRikaste(){
		int big=0;
		int pos=0;
		int x=0;
		for(Personer p:allaPersoner){
			if (p.getSumma() > big) {
				big=p.getSumma();
				pos=x;}
			x++;}
		System.out.println ("Rikast av alla personer är "+allaPersoner.get(pos).getNamn()+" som sammanlagt äger "+big);
		System.out.println (allaPersoner.get(pos).getAllaPrylar());
	}
	void visaVissaPersoner(){
		String agare2 =readString("Vilken person? ");
		boolean pp=false;
		for (Personer p:allaPersoner){
			if (p.getNamn().equalsIgnoreCase(agare2)){
				pp=true;
				System.out.println (p.getNamn()+" som sammanlagt äger "+ p.getSumma()+"\n"+p.getAllaPrylar());
			}
		}
		if	(pp==false)
			System.out.println ("Personen finns inte i systemet.");
	}

	void borskrasch(){
		boolean pp=false;
		for (Personer p: allaPersoner) {
			for (Prylar pr: p.allaPrylar){
				if (pr instanceof Aktier){
					Aktier ak = (Aktier)pr;
					ak.bytaPris(0);

				} 
			}
		}

	}
	
	public static void main(String[]args){ 
		Program prog = new Program(); 

		for(;;){
			int val=prog.readInt(" 1. Skapa person \n 2. Skapa pryl \n 3. Visa alla \n 4. Visa rikaste \n 5. Visa viss person \n 6. Börskrasch \n 7. Avsluta"); 
			switch (val){
			case 1: prog.skapaPersoner();
			break;
			case 2: prog.skapaPrylar();
			break;
			case 3: prog.visaAlla();
			break;
			case 4: prog.visaRikaste();
			break;
			case 5: prog.visaVissaPersoner();
			break;
			case 6: prog.borskrasch();
			break;
			case 7: System.out.println("Hej då!");
			System.exit(0);
			break;
			default: System.out.println("Fel kommando");
			} 
		}
	}
}
