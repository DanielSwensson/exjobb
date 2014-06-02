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

	int readInt (String fr�ga){
		for (;;){
			try {
				System.out.print(fr�ga);
				int x=Integer.parseInt(scan.nextLine());
				return x;
			}
			catch (NumberFormatException e){
				System.out.println ("Fel inmatning, det ska vara ett nummer");
			}
		}
	}
	String readString (String fr�ga){
		String str="";
		while(str.equals("")){
			System.out.print (fr�ga);
			str=scan.nextLine();
		}
		return str;
	}


	public static void main(String[] args) {

		RegProg mainProgram= new RegProg();




		for(;;){

			int val=mainProgram.readInt("Vad vill du g�ra?"+ "\n"+ "1.Skapa person"+"\n"+ "2.Skapa pryl"+ "\n"+ "3.Visa alla"+ "\n"+  "4.Visa rikaste"+ "\n"+ "5.Visa viss person"+ "\n"+ "6.b�rskrasch"+ "\n"+ "7.Avsluta"+ "\n" );

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


				String �gare=mainProgram.readString("Vilken person �ger prylen?");

				personNamn = �gare;
				getPerson(personNamn);
				if (getPerson(personNamn)==null){
					Person person = new Person(personNamn);
					allapersoner.add(person);


				}
				else {
					System.out.println (getPerson(personNamn) +" �r registrerad sedan tidigare");


				} 

				String prylTyp=mainProgram.readString("Vilken sorts pryl vill du registrera f�r " +�gare  +"? Smycke, apparat eller aktie?");

				if (prylTyp.equalsIgnoreCase ("Smycke")){

					String prylNamn=mainProgram.readString("vilken sorts smycke?");


					String material=mainProgram.readString("Vad �r smycket gjort av? Guld eller Silver");

					int �delsten=mainProgram.readInt("Antal �delstenar:");



					getPerson(personNamn).addPryl(new Smycke (prylTyp, prylNamn, material, �delsten));
					System.out.println(prylNamn +" till " +�gare +" �r registrerad");

				}
				else if (prylTyp.equalsIgnoreCase("apparat")){
					String prylNamn=mainProgram.readString("namn p� apparat:");

					int ink�pspris=mainProgram.readInt("ink�pspris:");

					int slitage=mainProgram.readInt("ange slitage i nr fr�n 1-10. 10 betyder helt ny:");

					getPerson(personNamn).addPryl(new Apparat (prylNamn, prylTyp, ink�pspris, slitage));
					System.out.println(prylNamn +" till " +�gare +" �r registrerad");
				}
				else if (prylTyp.equalsIgnoreCase("aktie")){
					String prylNamn=mainProgram.readString("aktienamn:");

					int antal=mainProgram.readInt("Antal aktier:");

					int pris=mainProgram.readInt("pris p� aktie:");

					getPerson(personNamn).addPryl(new Aktie (prylNamn, prylTyp, antal, pris));
					System.out.println(prylNamn +" till " +�gare +" �r registrerad");
				}
				else {
					System.out.println("Finns ingen s�dan kategori");
				}
				break;

			case 3:
				int num=1;
				for ( Person p: allapersoner){
					System.out.println(num+" " +p+ " "+p.getTotaltV�rde()+ ".");
					num++;
				}
				break;

			case 4:
				Person rikast=allapersoner.get(0);
				for (Person p:allapersoner){
					if (rikast.getTotaltV�rde()<p.getTotaltV�rde()){
						rikast=p;
					}

				}
				System.out.println(rikast.personNamn()+ " " + " �r rikast "+rikast.getTotaltV�rde() +" :-");
				break;

			case 5:
				String visaViss=mainProgram.readString( " Skriv in namnet p� personen du vill se");


				for (Person p:allapersoner)
					if (p.personNamn().equalsIgnoreCase(visaViss)){
						System.out.println (p.personNamn() + "\n" + p.listaPrylar());
					}
				break;

			case 6:
				for (Person p : allapersoner){
					p.b�rskrasch();
				}
				break;

			case 7:
				System.out.println("programmet avslutas");
				System.exit(0);
				break;


			}}}}










