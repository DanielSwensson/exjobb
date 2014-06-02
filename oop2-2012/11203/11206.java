import java.util.ArrayList;
import java.util.Scanner;

public class HuvudProgram {
	static Scanner keyboard=new Scanner(System.in);
	static	ArrayList<Person>personer=new ArrayList <Person>();

	public String readString(String fråga) {
		System.out.print(fråga);
		String str = keyboard.nextLine();
		return str;
	}

	public int readInt(String fråga){
		for (;;){
			try{
				System.out.println(fråga);
				int x=Integer.parseInt(keyboard.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println("Fel, ska vara numeriskt värde");
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
			System.out.println(namn+" är nu tillagd.");
		}	
	}
	public void skapaPrylar () {
		String namn=readString("Till vilken person vill du lägga till en pryl?");
		Person p = getPerson(namn);
		if (p==null){
			System.out.println("Personen finns inte i listan");

		}else{ 
			String prylar=readString("Vilken pryl vill du lägga till?");

			if (prylar.equalsIgnoreCase("smycke")) {
				Smycke s = skapaSmycke();
				p.läggaTillPryl(s);


			} else if (prylar.equalsIgnoreCase("Apparat")) {
				Apparat ap = skapaApparat();
				p.läggaTillPryl(ap);

			} else if  (prylar.equalsIgnoreCase("Aktie")){
				Aktie a = skapaAktie(); 
				p.läggaTillPryl(a);

			}else {
				System.out.println("Felaktigt kommando ");
			}

		}
	}

	public Smycke skapaSmycke() {
		String prylNamn=readString("Vilken typ av smycke är det?");
		int antalÄdelstenar=readInt("Hur många ädelstenar har smycket?");
		String material=readString("Vilket material är smycket gjort i?");
		Smycke s=new Smycke (prylNamn, antalÄdelstenar, material);
		return (s);

	}
	public Apparat skapaApparat() {
		String prylNamn=readString("Vilken typ av apparat?");
		int inköpspris=readInt("Vad var dess inköpspris i kr?");
		int slitage=readInt("Hur gammal är den på en skala mellan 1-10 (10=ny 1=gammal)?");
		Apparat ap=new Apparat (prylNamn,inköpspris,slitage);
		return (ap);
	}
	private Aktie skapaAktie() {
		String prylNamn=readString("Vad heter aktieposten?");
		int antal=readInt("Hur många aktieposter har du?");
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
				if (rikastePerson == null||p.sammanlagtVärde()>rikastePerson.sammanlagtVärde()){
					rikastePerson=p;
				}
			}
			System.out.println(rikastePerson + " är rikast");
		}
	}
	public void visaPerson(){
		String namn = readString  ("Vilken person vill du se?");
		for (Person p : personer )
			if (namn.equalsIgnoreCase(p.getNamn())){
				System.out.println(p +"\n"+ p.hämtaPryl());
			}else {
				System.out.println("Personen finns inte i listan");
			}
	}
	private void börskrasch(){
		for (Person p : personer)
			p.nollställAktie();
	}

	public static void main(String[] args) {
		HuvudProgram hp = new HuvudProgram();
		System.out.println("Hej och välkommen till prylprogrammet!");
		for (;;){
			int kom=hp.readInt ("1- Lägg till person\n2- Lägg till pryl\n3 Visa alla\n4 Visa rikaste \n5 Visa person \n6 Börskrasch \n7 Avsluta\nAnge kommando; ");
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
			case 6: hp.börskrasch();
			break;
			case 7:System.out.println("Tack och välkommen åter!"); 
			System.exit(0);
			default: System.out.println("Felaktigt kommando");
			}
		}
	}
}