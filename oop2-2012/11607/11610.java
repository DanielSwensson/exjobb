import java.util.*;

public class Kommandotolk {


	
		ArrayList<Person> allaPersoner = new ArrayList<Person>();
		Scanner tangentbord = new Scanner (System.in);
		
		// en metod för att läsa in tal och undvika krasch
		int readInt(String fråga) {
			for (;;) {
				try {
					System.out.print(fråga);
					int x = Integer.parseInt(tangentbord.nextLine());
					return x;
				} catch (NumberFormatException e) {
					System.out.println("Fel skriv in ett heltal: ");
				}
			}
		}
		// en metod för att läsa in doubles
		double readDouble(String fråga) {
			for (;;) {
				try {
					System.out.print(fråga);
					double x = Double.parseDouble(tangentbord.nextLine());
					return x;
				} catch (NumberFormatException e) {
					System.out.println("Fel skriv in ett decimaltal: ");
				}
			}
		}
		
		// en metod för att läsa in strängar 
		String readString(String fråga) {
			System.out.print(fråga);
			String str = tangentbord.nextLine();
			return str;
		}
		// en metod som visar om personen finns i arrayen
		Person getPerson (String namn){
			for (Person p : allaPersoner){
				if (p.getNamn().equalsIgnoreCase(namn))
					return p;
			}
			return null;
		}
		
		//metod för att skapa person
		void skapaPerson (){
			String namn = readString("Skriv in personens namn: ");
			Person p = getPerson(namn);
			if (p!= null)
				System.out.println("Personen finns redan i registret");
			else{
				Person ny = new Person(namn);
				allaPersoner.add(ny);
			}
		}
		
		void skapaVardesaker(){
			String namn =readString("Vem äger värdesaken?");
			Person p =getPerson(namn);
			if (p == null)
				System.out.println("Den här personen finns inte i registret");
			else{
				System.out.print("Vilken värdesak ska skapas? (apparat, aktie eller smycke): ");
				String sort =tangentbord.nextLine();
				
				Vardesak nytt = null;
				if(sort.equalsIgnoreCase("smycke")){
					System.out.println("Vilken typ av smycke?: ");
					String vardesaksNamn = tangentbord.nextLine();
					System.out.println("Är smycket av guld?(Ja/Nej): ");
					String material=tangentbord.nextLine();
					
					int antalÄdelstenar = readInt("Hur många ädelstenar finns i smycket?: ");
					boolean guld = false;

					if (material.equalsIgnoreCase("Ja"))
						guld = true;
					if (material.equalsIgnoreCase("nej"))
						guld = false;
					nytt = new Smycke (vardesaksNamn, antalÄdelstenar, guld);

				}
				
				if (sort.equalsIgnoreCase("aktie")) {
					System.out.println("Vilket företag tillhör aktierna?: ");
					String vardesaksNamn = tangentbord.nextLine();

					int antal = readInt("Hur många aktieandelar finns?: ");

					double pris = readDouble("Vad är aktiens pris?: ");
					nytt = new Aktie(vardesaksNamn, antal, pris);
				}
				if (sort.equalsIgnoreCase("apparat")) {
					System.out.println("Vad är det för typ av apparat?: ");
					String vardesaksNamn = tangentbord.nextLine();

					double inköpspris = readDouble("Vad är inköpspriset?: ");
					
			        boolean sant = false;
			        int slitage = 0;
			        do {
			          slitage = readInt("Ange slitage mellan 1-10: ");
			          if(slitage>=11 || slitage <=0)
			            System.out.println("Du har anget ett tal utanför 1-10");
			          else
			            sant = true;
			        } while (sant==false);
			        sant = false;
			        nytt = new Apparat (vardesaksNamn, inköpspris, slitage);
			      }
			      getPerson(namn).addVardesaker(nytt);
						
		
			}

		}
		public void visaAlla() {
			System.out.println("Dessa personer finns i registret: ");
			for (int x = 0; x < allaPersoner.size(); x++) {
				System.out.print(allaPersoner.get(x).getNamn() + " ");
				System.out.println(allaPersoner.get(x).getTotalVarde());
			}
			System.out.print("\n");
		}
		void visaRikaste() {
			Person p = allaPersoner.get(0);
			for (Person p1 : allaPersoner) {
				if (p.getTotalVarde() < p1.getTotalVarde())
					p = p1;
			}
			System.out.println("Rikaste personen är " + p.getNamn() + " som sammanlagt äger "
					+ p.getTotalVarde());
		System.out.println(p.getAllaVardesaker());
		
		System.out.print("\n");
		}
		void visaViss() {
			String namn = readString("Vilken person vill du visa?: ");
			Person p = getPerson(namn);
			if (p == null)
				System.out.println("Personen finns inte i registret");
			else {
				System.out.println("\n" + p + "s" + " ägodelar:");

				System.out.println(p.getAllaVardesaker());
				System.out.println(p + "s" + " totala prylvŠrde Šr " + p.getTotalVarde()
						+ "\n");
			}
			System.out.print("\n");
		}
				
		void börskrasch() {
			System.out
			.println("Börskrasch! Alla aktier är nu värda 0 kr.");
			for (Person p : allaPersoner)
				p.börsKrasch();
		}

		public static void main(String[] args) {
			Kommandotolk kt = new Kommandotolk();
			
			
		for (;;) {
			int meny = kt
					.readInt("Meny\n1 Skapa ny person\n2 Skapa ny pryl\n3 Visa alla personer\n4 Visa rikaste personen\n5 Visa viss person\n6 Börskrasch\n7 Avsluta program\n");

			switch (meny) {
			case 1:
				kt.skapaPerson();
				break;
			case 2:
				kt.skapaVardesaker();
				break;
			case 3:
				kt.visaAlla();
				break;
			case 4:
				kt.visaRikaste();
				break;
			case 5:
				kt.visaViss();
				break;
			case 6:
				kt.börskrasch();
				break;
			case 7:
				System.out.println("Programmet är avslutat!");
				System.exit(0);
			default:
				System.out.println("Fel kommando!");
			}
		}

	}
}



	