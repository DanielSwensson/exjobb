import java.util.Scanner;
import java.util.ArrayList;


public class RegProg {

	static ArrayList <Person> allapersoner= new ArrayList<Person>();


	Scanner scan= new Scanner(System.in);
	public static Person getPerson(String personNamn){


		for (int x=0; x<allapersoner.size(); x++){
			if (personNamn.equalsIgnoreCase(allapersoner.get(x).personNamn())){
				return allapersoner.get(x);
			}
		}
		return null;
	}

	int readInt (String frŒga){
		for (;;){
			try {
				System.out.print(frŒga);
				int x=Integer.parseInt(scan.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println ("Fel inmatning, det ska vara ett nummer");
			}
		}
	}
	String readString (String frŒga){
		String str="";
		while(str.equals("")){
			System.out.print (frŒga);
			str=scan.nextLine();
		}
		return str;
	}


	public static void main(String[] args) {

		RegProg mainProgram= new RegProg();




		for(;;){

			int val=mainProgram.readInt("Vad vill du gšra?"+ "\n"+ "1.Skapa person"+"\n"+ "2.Skapa pryl"+ "\n"+ "3.Visa alla"+ "\n"+  "4.Visa rikaste"+ "\n"+ "5.Visa viss person"+ "\n"+ "6.bšrskrasch"+ "\n"+ "7.Avsluta"+ "\n" );

			switch (val){
			case 1:



				String personNamn=mainProgram.readString("Skriv in namn: "); 


				getPerson(personNamn);
				if (getPerson(personNamn)==null){
					Person person = new Person(personNamn);
					allapersoner.add(person);
					System.out.println("Antal personer i registret:"+allapersoner.size()); 

				}
				else {
					System.out.println ("Namnet existerar redan");

				} 
				break;
			case 2:


				String Šgare=mainProgram.readString("Vilken person Šger prylen?");

				personNamn = Šgare;
				getPerson(personNamn);
				if (getPerson(personNamn)==null){
					Person person = new Person(personNamn);
					allapersoner.add(person);


				}
				else {
					System.out.println (getPerson(personNamn) +" Šr registrerad sedan tidigare");


				} 

				String prylTyp=mainProgram.readString("Vilken sorts pryl vill du registrera fšr " +Šgare  +"? Smycke, apparat eller aktie?");

				if (prylTyp.equalsIgnoreCase ("Smycke")){

					String prylNamn=mainProgram.readString("vilken sorts smycke?");


					String material=mainProgram.readString("Vad Šr smycket gjort av? Guld eller Silver");

					int Šdelsten=mainProgram.readInt("Antal Šdelstenar:");



					getPerson(personNamn).addPryl(new Smycke (prylTyp, prylNamn, material, Šdelsten));
					System.out.println(prylNamn +" till " +Šgare +" Šr registrerad");

				}
				else if (prylTyp.equalsIgnoreCase("apparat")){
					String prylNamn=mainProgram.readString("namn pŒ apparat:");

					int inkšpspris=mainProgram.readInt("inkšpspris:");

					int slitage=mainProgram.readInt("ange slitage i nr frŒn 1-10. 10 betyder helt ny:");

					getPerson(personNamn).addPryl(new Apparat (prylNamn, prylTyp, inkšpspris, slitage));
					System.out.println(prylNamn +" till " +Šgare +" Šr registrerad");
				}
				else if (prylTyp.equalsIgnoreCase("aktie")){
					String prylNamn=mainProgram.readString("aktienamn:");

					int antal=mainProgram.readInt("Antal aktier:");

					int pris=mainProgram.readInt("pris pŒ aktie:");

					getPerson(personNamn).addPryl(new Aktie (prylNamn, prylTyp, antal, pris));
					System.out.println(prylNamn +" till " +Šgare +" Šr registrerad");
				}
				else {
					System.out.println("Finns ingen sŒdan kategori");
				}
				break;

			case 3:
				int num=1;
				for ( Person p: allapersoner){
					System.out.println(num+" " +p+ " "+p.getTotaltVŠrde()+ ".");
					num++;
				}
				break;

			case 4:
				Person rikast=allapersoner.get(0);
				for (Person p:allapersoner){
					if (rikast.getTotaltVŠrde()<p.getTotaltVŠrde()){
						rikast=p;
					}

				}
				System.out.println(rikast.personNamn()+ " " + " Šr rikast "+rikast.getTotaltVŠrde() +" :-");
				break;

			case 5:
				String visaViss=mainProgram.readString( " Skriv in namnet pŒ personen du vill se");


				for (Person p:allapersoner)
					if (p.personNamn().equalsIgnoreCase(visaViss)){
						System.out.println (p.personNamn() + "\n" + p.listaPrylar());
					}
				break;

			case 6:
				for (Person p : allapersoner){
					p.bšrskrasch();
				}
				break;

			case 7:
				System.out.println("programmet avslutas");
				System.exit(0);
				break;


			}}}}










