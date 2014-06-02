import java.util.Scanner;
import java.util.ArrayList;

public class HanteraPrylar {
	
	private static int l�sInInt(String meddelande, Scanner in ){
		while (true){ // gillar while(true) mer �n for(;;) (for (;;) ser lite ut som en gr�tande gubbe )
			try{		
				System.out.println(meddelande);		
				return Integer.parseInt(in.nextLine());
			}
			catch(NumberFormatException e){
				System.out.println("Ett fel uppstod: f�rs�k igen. Inmatningen m�ste vara skriven med siffror");
			}
		}
	}
	
	private static String l�sInString(String meddelande, Scanner in ){
	
		System.out.println(meddelande);		
		return in.nextLine();
	
	}
	
		
	private static void skapaPerson(ArrayList<Person> p, Scanner in){
		String namn = l�sInString("Vad heter personen?",in);
		boolean personFinns = false;
		for (int i = 0; i < p.size(); i++ ){
			if (p.get(i).getNamn().equalsIgnoreCase(namn))
				personFinns = true;
				
		}
		if(!personFinns){
			p.add(new Person(namn));
			System.out.println("L�gger till person med namnet: " + namn);			
		}
			
		else System.out.println("Personen �r redan registrerad");
	}
	
	private static void skapaPryl(ArrayList<Person> p, Scanner in){
		String vem = l�sInString("Vem ska f� prylen?",in);
		String vad = l�sInString("Vilken sorts pryl? Aktie, Apparat eller Smycke?",in);
		boolean personhittad = false;
		
		for (int i = 0; i < p.size() && !p.isEmpty(); i++ ){
			if (p.get(i).getNamn().equalsIgnoreCase(vem)){
				personhittad = true;
				
				if (vad.equalsIgnoreCase("Smycke")){
					boolean guld = false;
					int iGuld = 2;
					
					while (iGuld != 1 && iGuld != 0){ // v�nta tills fr�gan besvaras med 1 eller 0
						iGuld = l�sInInt("�r smycket gjort av guld? 1 f�r ja och 0 f�r nej", in);
					}
					if (iGuld == 1){
						guld = true;
					}
					else if (iGuld == 0){
						guld = false;
					}
					
					p.get(i).tilldelaPryl(new Smycke(l�sInString("Vad �r det f�r smycke?",in),guld,l�sInInt("Hur m�nga �delstenar har smycket?",in)));
				}
				else if (vad.equalsIgnoreCase("Apparat")){
					p.get(i).tilldelaPryl(new Apparat(l�sInString("Vad �r det f�r apparat?",in),l�sInInt("Slitage?",in),l�sInInt("Ink�psv�rde?",in)));
				}
				else if (vad.equalsIgnoreCase("Aktie")){
					p.get(i).tilldelaPryl(new Aktie(l�sInString("Vad heter aktien?",in),l�sInInt("V�rde?",in),l�sInInt("hur m�nga?",in)));
				}
				else{
					System.out.println("Det finns inga prylar vid namn: " + vad );
				}
			}			
			
		}
		if (!personhittad){
			System.out.println("Personen finns inte i systemet");
		}
		
	}
		
	private static void visaAlla(ArrayList<Person> p){
		for (int i = 0; i < p.size(); i++)
			System.out.println( p.get(i).skrivPerson());
	}
//		
	private static void visaRikast(ArrayList<Person> p){
		int rikast = 0;
		int vem = 0; // indexet
		for (int i = 0; i < p.size(); i++)
			if (p.get(i).totalV�rde() > rikast){
				
				rikast = p.get(i).totalV�rde();
				vem = i;
			}
			
		System.out.println("Rikast �r : " + p.get(vem));
		
	}
//	
//		
	private static void visaPerson(ArrayList<Person> p, Scanner in){
		String vem = l�sInString("Vem vill du visa?",in);
		for (int i = 0; i < p.size(); i++ )
			if (p.get(i).getNamn().equalsIgnoreCase(vem)){
				System.out.println(p.get(i));
			}
	}
	private static void b�rskrasch(ArrayList<Person> p){
		for (int i = 0; i < p.size(); i++)
			p.get(i).b�rskrasch();
	}
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Person> personer = new ArrayList<Person>();	
		boolean loop = true;
		
		do{
			switch(l�sInInt("Vad vill du g�ra?\n" +
							"Tryck 1 f�r att l�gga till en person\n" +
							"Tryck 2 f�r att l�gga till en pryl\n" +
							"tryck 3 f�r att visa alla personer\n" +
							"tryck 4 f�r att visa personen som �r rikast\n" +
							"tryck 5 f�r att visa en viss person\n" +
							"tryck 6 f�r att registrera en b�rskrasch\n" +
							"tryck 7 f�r att avsluta programmet\n", in)){
			
			case 1:
				skapaPerson(personer,in);
				break;	
			case 2:
				skapaPryl(personer,in);
				break;
			case 3:
				visaAlla(personer);
				break;
			case 4:
				visaRikast(personer);
				break;
			case 5:
				visaPerson(personer,in);
				break;
			case 6:
				b�rskrasch(personer);
				break;
			case 7:
				loop = false;
				break;
			default: 
				System.out.println("Alternativet finns inte");
			}	
		
	
		}while(loop);
	
		System.out.println("\n Hej d�!");
		


	}
	

}
