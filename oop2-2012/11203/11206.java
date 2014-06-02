import java.util.ArrayList;
import java.util.Scanner;

public class HuvudProgram {
	static Scanner keyboard=new Scanner(System.in);
	static	ArrayList<Person>personer=new ArrayList <Person>();

	public String readString(String fr�ga) {
		System.out.print(fr�ga);
		String str = keyboard.nextLine();
		return str;
	}

	public int readInt(String fr�ga){
		for (;;){
			try{
				System.out.println(fr�ga);
				int x=Integer.parseInt(keyboard.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Fel, ska vara numeriskt v�rde");
			}
		}
	}

	public Person getPerson(String namn){
		for (Person p : personer)
			if (p.getNamn().equalsIgnoreCase(namn))
				return p;
		return null;
	}

	public void skapaPerson (){
		String namn=readString ("Registrera ny person: ");
		Person p = getPerson (namn);
		if (p!=null ){
			System.out.println("Personen finns redan i listan");
		}
		else {
			Person ny=new Person(namn);
			personer.add(ny);
			System.out.println(namn+" �r nu tillagd.");
		}	
	}
	public void skapaPrylar () {
		String namn=readString("Till vilken person vill du l�gga till en pryl?");
		Person p = getPerson(namn);
		if (p==null){
			System.out.println("Personen finns inte i listan");

		}else{ 
			String prylar=readString("Vilken pryl vill du l�gga till?");

			if (prylar.equalsIgnoreCase("smycke")) {
				Smycke s = skapaSmycke();
				p.l�ggaTillPryl(s);


			} else if (prylar.equalsIgnoreCase("Apparat")) {
				Apparat ap = skapaApparat();
				p.l�ggaTillPryl(ap);

			} else if  (prylar.equalsIgnoreCase("Aktie")){
				Aktie a = skapaAktie(); 
				p.l�ggaTillPryl(a);

			}else {
				System.out.println("Felaktigt kommando ");
			}

		}
	}

	public Smycke skapaSmycke() {
		String prylNamn=readString("Vilken typ av smycke �r det?");
		int antal�delstenar=readInt("Hur m�nga �delstenar har smycket?");
		String material=readString("Vilket material �r smycket gjort i?");
		Smycke s=new Smycke (prylNamn, antal�delstenar, material);
		return (s);

	}
	public Apparat skapaApparat() {
		String prylNamn=readString("Vilken typ av apparat?");
		int ink�pspris=readInt("Vad var dess ink�pspris i kr?");
		int slitage=readInt("Hur gammal �r den p� en skala mellan 1-10 (10=ny 1=gammal)?");
		Apparat ap=new Apparat (prylNamn,ink�pspris,slitage);
		return (ap);
	}
	private Aktie skapaAktie() {
		String prylNamn=readString("Vad heter aktieposten?");
		int antal=readInt("Hur m�nga aktieposter har du?");
		int pris=readInt("Vilket pris har de?");
		Aktie a=new Aktie (prylNamn,antal,pris);
		return (a);
	}
	public void visaAlla(){
		if (personer.isEmpty()){
			System.out.println("Det finns ingen i listan"); 
		}else{
			String alla= "";
			for (Person p : personer )
				alla+= p + "\n" ;
			System.out.println("I registret finns \n"  + alla + "\n");
		}
	}	

	public void visaRikaste(){
		if (personer.isEmpty()){
			System.out.println("Det finns ingen i listan"); 
		}else{
			Person rikastePerson = null;
			for (Person p : personer ){
				if (rikastePerson == null||p.sammanlagtV�rde()>rikastePerson.sammanlagtV�rde()){
					rikastePerson=p;
				}
			}
			System.out.println(rikastePerson + " �r rikast");
		}
	}
	public void visaPerson(){
		String namn = readString  ("Vilken person vill du se?");
		for (Person p : personer )
			if (namn.equalsIgnoreCase(p.getNamn())){
				System.out.println(p +"\n"+ p.h�mtaPryl());
			}else {
				System.out.println("Personen finns inte i listan");
			}
	}
	private void b�rskrasch(){
		for (Person p : personer)
			p.nollst�llAktie();
	}

	public static void main(String[] args) {
		HuvudProgram hp = new HuvudProgram();
		System.out.println("Hej och v�lkommen till prylprogrammet!");
		for (;;){
			int kom=hp.readInt ("1- L�gg till person\n2- L�gg till pryl\n3 Visa alla\n4 Visa rikaste \n5 Visa person \n6 B�rskrasch \n7 Avsluta\nAnge kommando; ");
			switch (kom){
			case 1: hp.skapaPerson();
			break;
			case 2: hp.skapaPrylar();		
			break;
			case 3: hp.visaAlla();
			break;
			case 4: hp.visaRikaste();
			break;
			case 5:hp.visaPerson();
			break;
			case 6: hp.b�rskrasch();
			break;
			case 7:System.out.println("Tack och v�lkommen �ter!"); 
			System.exit(0);
			default: System.out.println("Felaktigt kommando");
			}
		}
	}
}