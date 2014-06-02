package inlämning2;

import java.util.Scanner;
import java.util.ArrayList;


public class PrylRegister 
{
	private Scanner keyboard = new Scanner(System.in);
	private ArrayList<Person> allaPersoner = new ArrayList<Person>();

	
	public PrylRegister() 
	{
		commando();
	}

	
	private String readString(String fråga)
	{
		System.out.print(fråga);
		String str = keyboard.next();
		return str;
	}
	
	
	private int readInt(String fråga)
	{
		for(;;)
		{
			try
			{
				System.out.print(fråga);
				int x = Integer.parseInt(keyboard.next());
				return x;
			} //try
			catch(NumberFormatException e)
			{
				System.out.println("Skriv med siffror!");
				System.out.println();
			} //catch
		} //for
	}
	
	
	private void commando()
	{
		System.out.println("Hej och välkommen till Prylprogrammet");
		
		for(;;)
		{
			int kom = readInt("1 - Skapa person\n" +	
						     "2 - Skapa pryl\n" +		
						     "3 - Visa alla\n" +		
						     "4 - Visa rikaste\n" + 	
						     "5 - Visa viss person\n" + 
						     "6 - Börskrasch\n" +			
						     "7 - Avsluta\n\n" + 			
						     "Kommando: ");
			
			System.out.println();
				
			switch (kom)
			{
				case 1:
					skapaPerson();
				
					break;
					
				case 2:
					skapaPryl();
		
					break;
					
				case 3:			
					visaAlla();
					
					break;
					
				case 4:
					visaRikast();
					
					break;
					
				case 5:
					visaVissPerson();
					
					break;
					
				case 6:
					borskrasch();
					
					break;
					
				case 7:
					avsluta();
					
				default:
					System.out.println("Inget sånt kommando!");
			
			} //switch
				System.out.println();
		
		} //for
	}
	

	private void skapaPerson() 
	{
		
		//Lägg till ny person / registrera
		
		String namn = readString("Namn: ");
		
		for (int m = 0; m < allaPersoner.size(); m++)
		{
				
			if (allaPersoner.get(m).getNamn().equalsIgnoreCase(namn))
			{
				System.out.println("Namnet är upptaget");
				System.out.println();
				commando();
			} //if
		} //for
		
		Person ny = new Person(namn);
		allaPersoner.add(ny);
							
		System.out.println();					
							
		System.out.println("En person har lagts till!");
		
	}	


	private void skapaPryl()
	{
		//Lägg till pryl hos person
		
		String namn = readString("Vilken person äger prylen: ");
	
		for (Person p : allaPersoner)
		{		
			if (namn.equalsIgnoreCase(p.getNamn()))
			{
				System.out.println("Vi förvarar endast \"Smycken\", \"Aktier\" och \"Apparater\"");	
				String pryl = readString("Vilken sorts pryl: ");
				
				String prylNamn;
				
				if (pryl.equalsIgnoreCase("smycke") || (pryl.equalsIgnoreCase("smycken")))
				{
					prylNamn = readString("Vilken sorts smycke: ");
						
					String valor = readString("Är smycket av guld? ");
				
					int antalAdelstenar = readInt("Antal ädelstenar: ");
				
					Smycke s = new Smycke(prylNamn, valor, antalAdelstenar);
					p.addPryl(s);
				} //if	
				
				
				else if (pryl.equalsIgnoreCase("aktie") || (pryl.equalsIgnoreCase("aktier")))
				{
					prylNamn = readString("Vilken aktie: ");
				
					int antalAktie = readInt("Hur många aktier: ");
				
					double prisAktie = readInt("Aktiens styckepris: ");
				
					Aktie ak = new Aktie(prylNamn, antalAktie, prisAktie);
					p.addPryl(ak);
				} //if		
		
				
				else if (pryl.equalsIgnoreCase("apparat") || (pryl.equalsIgnoreCase("apparater")))
				{
					prylNamn = readString("Vilken apparat: ");
				
					int inkopspris = readInt("Inköpspris: ");
				
					int slitage = readInt("Slitage, ange nummer (10 = ny apparat | 0 = trasig): ");
				
					Apparat ap = new Apparat(prylNamn, inkopspris, slitage);
					p.addPryl(ap);
				} //if		
				
			
				else 
				{
					System.out.println("Ingen sådan pryl!");
				} //else
			
				System.out.println();
				
				commando();
			} //if
		}//for
		
		System.out.println("Personen finns ej i registret!");
	}
	
	

	private void visaAlla()
	{	
		//Söklista
		
		System.out.print("I registret finns:\n");
		
		
		for (int m = 0; m < allaPersoner.size(); m++)
		{
			System.out.println(allaPersoner.get(m) + "\t" + allaPersoner.get(m).getSum());				
		}
	}

	private void visaRikast()
	{
		//Visa rikaste personen
		
		int rikastTotal = 0;

		String rikast = "\"Unknown\"";
		
		for(Person p : allaPersoner)
		{
			if(p.getSum() > rikastTotal)
			{
				rikastTotal = p.getSum();
				rikast = p.getNamn(); 
			} //if
		} //for
		
		
		for (Person p : allaPersoner)
		{		
			if (rikast.equalsIgnoreCase(p.getNamn()))
			{
				System.out.println("Rikast är " + rikast + " som sammanlagt äger " + rikastTotal);
				
				System.out.print(p.getPryl());
			} //if
		} //for
	}

	
	private void visaVissPerson()
	{
		//Visa specifik person
		
		String namn = readString("Namn: ");
		
		for (Person p : allaPersoner)
		{		
			if (namn.equalsIgnoreCase(p.getNamn()))
			{
				System.out.println(namn + " äger prylarna:");
				
				System.out.println(p.getPryl());
		
				commando();
			} //if
		} //for
		
		System.out.println("Personen finns ej i registret!");
	}
	
	
	private void borskrasch()
	{
		//Börskrasch
		
		for (Person p : allaPersoner)
		{
			p.borsKrasch();
		}
	}
	
		
	private void avsluta()
	{
		//Lägg till funktionen att stänga ner programmet
		
		
		System.exit(0);
	}
	
} //main

