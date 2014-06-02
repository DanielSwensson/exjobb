import java.util.Scanner;
import java.util.ArrayList;

public class Register {
	static Scanner keyboard = new Scanner(System.in);	
	private static String läsString(String text){
		System.out.print(text);
		String begärdInfo = keyboard.nextLine();
		return begärdInfo;}
		
	
	public static int läsInt(String fråga){
		for(;;){
				try{
					System.out.print(fråga);
					int x = Integer.parseInt(keyboard.nextLine());
					return x;
				}catch(NumberFormatException e){
					System.out.println("Fel - ska vara numeriskt värde ");}
			}
		}
	
	public static void main(String [] args){
		
		boolean loop = true;
		ArrayList<Person> personLista = new ArrayList<Person>();
		
		do{
		
			System.out.print("Vad vill du göra? ");
			String kommando = keyboard.nextLine();
			kommando = kommando.toLowerCase();
			switch(kommando){
				
			
				case "skapa person":
					int kontrollSiffra = 0;
					System.out.print("Vad heter personen? ");
					String namn = keyboard.nextLine();
					for (int uppräknarn = 0; uppräknarn < personLista.size(); uppräknarn++){
						if (namn.equals(personLista.get(uppräknarn).hämtaNamn())){
							kontrollSiffra++;}}
					if (kontrollSiffra == 0){
						Person nyPerson = new Person(namn);
						personLista.add(nyPerson);}
					else{
						System.out.println("Personen finns");}
					break;
		
				case "visa viss person":
					int personHittadNyckel = 0;
					namn = läsString("Vad heter personen? ");
					for(int uppräknarn = 0; uppräknarn < personLista.size();uppräknarn++){
						if(personLista.get(uppräknarn).hämtaNamn().equals(namn)){
							if(personLista.get(uppräknarn).summaVärde() < 1){
								System.out.println(personLista.get(uppräknarn).toString(personLista.get(uppräknarn).hämtaNamn() +" äger inget av värde \n"));}
							else{
							System.out.println(personLista.get(uppräknarn).toString(personLista.get(uppräknarn).hämtaNamn() +" äger sammanlagt "+personLista.get(uppräknarn).summaVärde()+" och har prylarna: \n"));}
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
						for(int uppräkning = 0; uppräkning <personLista.size();uppräkning++){
							if (personLista.get(uppräkning).summaVärde() > rikast){
								rikastPerson = uppräkning;
								rikast = personLista.get(uppräkning).summaVärde();}}
						System.out.println(personLista.get(rikastPerson).toString("Rikast är "+ personLista.get(rikastPerson).hämtaNamn()+ " som sammanlagt äger "+personLista.get(rikastPerson).summaVärde()+"\n"));}
					break;
				
				
				
				case "skapa pryl":
					String person = läsString("Vem äger prylen? ");
					personHittadNyckel = 0;
					int sparatTal = 0;
					for(int uppräknarn = 0; uppräknarn < personLista.size();uppräknarn++){
						if(personLista.get(uppräknarn).hämtaNamn().equals(person)){
							sparatTal = uppräknarn;
							personHittadNyckel++;
							break;}}
						if(personHittadNyckel == 0){
							System.out.println("Fanns ingen person med det namnet i listan ");
							break;}
					
					String sortPryl = läsString("Vad för sorts pryl? ");
					
					if(sortPryl.equalsIgnoreCase("smycke")){
						String sortSmycke = läsString("Vilken sorts smycke? ");
						String metalSort;
						int antalÄdelstenar;
						do{
							metalSort = läsString("Är smycket av guld eller silver? ");
							}while(!metalSort.equalsIgnoreCase("silver") && (!metalSort.equalsIgnoreCase("guld")));
						do{
							antalÄdelstenar = läsInt("Antal ädelstenar: ");
						}while(antalÄdelstenar < 0);
						Pryl nyPryl = new Smycke(sortSmycke, antalÄdelstenar, metalSort);
						personLista.get(sparatTal).läggTillPryl(nyPryl);}
					
					else if(sortPryl.equalsIgnoreCase("aktie")){
						String företagAktie = läsString("Vilket företag är aktien från? ");
						int prisPerAktie;
						int antalAktie;
						do{
							prisPerAktie = läsInt("Hur mycket är en aktie värd? ");
						}while(prisPerAktie < 0);
						do{
							antalAktie = läsInt("Hur många aktier av denna typ har du? ");
						}while(antalAktie < 0);
						Pryl nyPryl = new Aktie(företagAktie,antalAktie,prisPerAktie);
						personLista.get(sparatTal).läggTillPryl(nyPryl);}
					
					else if(sortPryl.equalsIgnoreCase("apparat")){
						int inköpsPris;
						int sliten;
						String sortsApparat = läsString("Vilken sorts apparat är det? ");
						do{
							inköpsPris = läsInt("Hur mycket kostade den ny? ");
						}while(inköpsPris <= 0);
						do{
							sliten = läsInt("Hur sliten är den nu? ");
						}while(sliten > 10 || sliten < 0);
						Pryl nyPryl = new Apparat(sortsApparat, inköpsPris, sliten);
						personLista.get(sparatTal).läggTillPryl(nyPryl);}
					else{
						System.out.print("Det som kan skapas är \"apparat\" \"aktie\" och \"smycke\"\n");}
					break;
				
						
						
				case "visa alla":
					if(personLista.size()==0){
						System.out.println("Finns ingen registrerad i registret ");}
					else{
						System.out.println("I registret finns: ");
						for(int uppräknarn = 0; uppräknarn < personLista.size(); uppräknarn++){
							System.out.println(personLista.get(uppräknarn).toString());}}
					break;
				
				case "börskrasch":
					for (int uppräknarn = 0; uppräknarn < personLista.size();uppräknarn++){
						personLista.get(uppräknarn).börsKrasch();}
					break;
					
				case "avsluta":
					System.exit(0);
					
				default:
					System.out.println("De godkända kommandona är \"skapa person\", \"visa viss person\", \"visa rikaste\", \"skapa pryl\" och \"visa alla\"");
					break;
		
		}
		
		
		}while(loop = true);
	}
}
