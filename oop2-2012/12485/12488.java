import java.util.Scanner;
import java.util.ArrayList;

public class Register {
	static Scanner keyboard = new Scanner(System.in);	
	private static String l�sString(String text){
		System.out.print(text);
		String beg�rdInfo = keyboard.nextLine();
		return beg�rdInfo;}
		
	
	public static int l�sInt(String fr�ga){
		for(;;){
				try{
					System.out.print(fr�ga);
					int x = Integer.parseInt(keyboard.nextLine());
					return x;
				}catch(NumberFormatException e){
					System.out.println("Fel - ska vara numeriskt v�rde ");}
			}
		}
	
	public static void main(String [] args){
		
		boolean loop = true;
		ArrayList<Person> personLista = new ArrayList<Person>();
		
		do{
		
			System.out.print("Vad vill du g�ra? ");
			String kommando = keyboard.nextLine();
			kommando = kommando.toLowerCase();
			switch(kommando){
				
			
				case "skapa person":
					int kontrollSiffra = 0;
					System.out.print("Vad heter personen? ");
					String namn = keyboard.nextLine();
					for (int uppr�knarn = 0; uppr�knarn < personLista.size(); uppr�knarn++){
						if (namn.equals(personLista.get(uppr�knarn).h�mtaNamn())){
							kontrollSiffra++;}}
					if (kontrollSiffra == 0){
						Person nyPerson = new Person(namn);
						personLista.add(nyPerson);}
					else{
						System.out.println("Personen finns");}
					break;
		
				case "visa viss person":
					int personHittadNyckel = 0;
					namn = l�sString("Vad heter personen? ");
					for(int uppr�knarn = 0; uppr�knarn < personLista.size();uppr�knarn++){
						if(personLista.get(uppr�knarn).h�mtaNamn().equals(namn)){
							if(personLista.get(uppr�knarn).summaV�rde() < 1){
								System.out.println(personLista.get(uppr�knarn).toString(personLista.get(uppr�knarn).h�mtaNamn() +" �ger inget av v�rde \n"));}
							else{
							System.out.println(personLista.get(uppr�knarn).toString(personLista.get(uppr�knarn).h�mtaNamn() +" �ger sammanlagt "+personLista.get(uppr�knarn).summaV�rde()+" och har prylarna: \n"));}
							personHittadNyckel++;}}
					if(personHittadNyckel == 0){
						System.out.println("Fanns ingen person med det namnet i listan ");}
					break;
					
				case "visa rikaste":
					int rikastPerson = 0;
					int rikast = 0;
					if(personLista.size()<=0){
						System.out.println("Finns ingen registrerad ");}
					else{
						for(int uppr�kning = 0; uppr�kning <personLista.size();uppr�kning++){
							if (personLista.get(uppr�kning).summaV�rde() > rikast){
								rikastPerson = uppr�kning;
								rikast = personLista.get(uppr�kning).summaV�rde();}}
						System.out.println(personLista.get(rikastPerson).toString("Rikast �r "+ personLista.get(rikastPerson).h�mtaNamn()+ " som sammanlagt �ger "+personLista.get(rikastPerson).summaV�rde()+"\n"));}
					break;
				
				
				
				case "skapa pryl":
					String person = l�sString("Vem �ger prylen? ");
					personHittadNyckel = 0;
					int sparatTal = 0;
					for(int uppr�knarn = 0; uppr�knarn < personLista.size();uppr�knarn++){
						if(personLista.get(uppr�knarn).h�mtaNamn().equals(person)){
							sparatTal = uppr�knarn;
							personHittadNyckel++;
							break;}}
						if(personHittadNyckel == 0){
							System.out.println("Fanns ingen person med det namnet i listan ");
							break;}
					
					String sortPryl = l�sString("Vad f�r sorts pryl? ");
					
					if(sortPryl.equalsIgnoreCase("smycke")){
						String sortSmycke = l�sString("Vilken sorts smycke? ");
						String metalSort;
						int antal�delstenar;
						do{
							metalSort = l�sString("�r smycket av guld eller silver? ");
							}while(!metalSort.equalsIgnoreCase("silver") && (!metalSort.equalsIgnoreCase("guld")));
						do{
							antal�delstenar = l�sInt("Antal �delstenar: ");
						}while(antal�delstenar < 0);
						Pryl nyPryl = new Smycke(sortSmycke, antal�delstenar, metalSort);
						personLista.get(sparatTal).l�ggTillPryl(nyPryl);}
					
					else if(sortPryl.equalsIgnoreCase("aktie")){
						String f�retagAktie = l�sString("Vilket f�retag �r aktien fr�n? ");
						int prisPerAktie;
						int antalAktie;
						do{
							prisPerAktie = l�sInt("Hur mycket �r en aktie v�rd? ");
						}while(prisPerAktie < 0);
						do{
							antalAktie = l�sInt("Hur m�nga aktier av denna typ har du? ");
						}while(antalAktie < 0);
						Pryl nyPryl = new Aktie(f�retagAktie,antalAktie,prisPerAktie);
						personLista.get(sparatTal).l�ggTillPryl(nyPryl);}
					
					else if(sortPryl.equalsIgnoreCase("apparat")){
						int ink�psPris;
						int sliten;
						String sortsApparat = l�sString("Vilken sorts apparat �r det? ");
						do{
							ink�psPris = l�sInt("Hur mycket kostade den ny? ");
						}while(ink�psPris <= 0);
						do{
							sliten = l�sInt("Hur sliten �r den nu? ");
						}while(sliten > 10 || sliten < 0);
						Pryl nyPryl = new Apparat(sortsApparat, ink�psPris, sliten);
						personLista.get(sparatTal).l�ggTillPryl(nyPryl);}
					else{
						System.out.print("Det som kan skapas �r \"apparat\" \"aktie\" och \"smycke\"\n");}
					break;
				
						
						
				case "visa alla":
					if(personLista.size()==0){
						System.out.println("Finns ingen registrerad i registret ");}
					else{
						System.out.println("I registret finns: ");
						for(int uppr�knarn = 0; uppr�knarn < personLista.size(); uppr�knarn++){
							System.out.println(personLista.get(uppr�knarn).toString());}}
					break;
				
				case "b�rskrasch":
					for (int uppr�knarn = 0; uppr�knarn < personLista.size();uppr�knarn++){
						personLista.get(uppr�knarn).b�rsKrasch();}
					break;
					
				case "avsluta":
					System.exit(0);
					
				default:
					System.out.println("De godk�nda kommandona �r \"skapa person\", \"visa viss person\", \"visa rikaste\", \"skapa pryl\" och \"visa alla\"");
					break;
		
		}
		
		
		}while(loop = true);
	}
}
