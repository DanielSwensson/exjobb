import java.util.Scanner;
import java.util.ArrayList;

public class HanteraPrylar {
	
	private static int läsInInt(String meddelande, Scanner in ){
		while (true){ // gillar while(true) mer än for(;;) (for (;;) ser lite ut som en gråtande gubbe )
			try{		
				System.out.println(meddelande);		
				return Integer.parseInt(in.nextLine());
			}
			catch(NumberFormatException e){
				System.out.println("Ett fel uppstod: försök igen. Inmatningen måste vara skriven med siffror");
			}
		}
	}
	
	private static String läsInString(String meddelande, Scanner in ){
	
		System.out.println(meddelande);		
		return in.nextLine();
	
	}
	
		
	private static void skapaPerson(ArrayList<Person> p, Scanner in){
		String namn = läsInString("Vad heter personen?",in);
		boolean personFinns = false;
		for (int i = 0; i < p.size(); i++ ){
			if (p.get(i).getNamn().equalsIgnoreCase(namn))
				personFinns = true;
				
		}
		if(!personFinns){
			p.add(new Person(namn));
			System.out.println("Lägger till person med namnet: " + namn);			
		}
			
		else System.out.println("Personen är redan registrerad");
	}
	
	private static void skapaPryl(ArrayList<Person> p, Scanner in){
		String vem = läsInString("Vem ska få prylen?",in);
		String vad = läsInString("Vilken sorts pryl? Aktie, Apparat eller Smycke?",in);
		boolean personhittad = false;
		
		for (int i = 0; i < p.size() && !p.isEmpty(); i++ ){
			if (p.get(i).getNamn().equalsIgnoreCase(vem)){
				personhittad = true;
				
				if (vad.equalsIgnoreCase("Smycke")){
					boolean guld = false;
					int iGuld = 2;
					
					while (iGuld != 1 && iGuld != 0){ // vänta tills frågan besvaras med 1 eller 0
						iGuld = läsInInt("Är smycket gjort av guld? 1 för ja och 0 för nej", in);
					}
					if (iGuld == 1){
						guld = true;
					}
					else if (iGuld == 0){
						guld = false;
					}
					
					p.get(i).tilldelaPryl(new Smycke(läsInString("Vad är det för smycke?",in),guld,läsInInt("Hur många ädelstenar har smycket?",in)));
				}
				else if (vad.equalsIgnoreCase("Apparat")){
					p.get(i).tilldelaPryl(new Apparat(läsInString("Vad är det för apparat?",in),läsInInt("Slitage?",in),läsInInt("Inköpsvärde?",in)));
				}
				else if (vad.equalsIgnoreCase("Aktie")){
					p.get(i).tilldelaPryl(new Aktie(läsInString("Vad heter aktien?",in),läsInInt("Värde?",in),läsInInt("hur många?",in)));
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
			if (p.get(i).totalVärde() > rikast){
				
				rikast = p.get(i).totalVärde();
				vem = i;
			}
			
		System.out.println("Rikast är : " + p.get(vem));
		
	}
//	
//		
	private static void visaPerson(ArrayList<Person> p, Scanner in){
		String vem = läsInString("Vem vill du visa?",in);
		for (int i = 0; i < p.size(); i++ )
			if (p.get(i).getNamn().equalsIgnoreCase(vem)){
				System.out.println(p.get(i));
			}
	}
	private static void börskrasch(ArrayList<Person> p){
		for (int i = 0; i < p.size(); i++)
			p.get(i).börskrasch();
	}
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Person> personer = new ArrayList<Person>();	
		boolean loop = true;
		
		do{
			switch(läsInInt("Vad vill du göra?\n" +
							"Tryck 1 för att lägga till en person\n" +
							"Tryck 2 för att lägga till en pryl\n" +
							"tryck 3 för att visa alla personer\n" +
							"tryck 4 för att visa personen som är rikast\n" +
							"tryck 5 för att visa en viss person\n" +
							"tryck 6 för att registrera en börskrasch\n" +
							"tryck 7 för att avsluta programmet\n", in)){
			
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
				börskrasch(personer);
				break;
			case 7:
				loop = false;
				break;
			default: 
				System.out.println("Alternativet finns inte");
			}	
		
	
		}while(loop);
	
		System.out.println("\n Hej då!");
		


	}
	

}
