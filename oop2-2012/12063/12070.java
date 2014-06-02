package inl�mning2;

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

	
	private String readString(String fr�ga)
	{
		System.out.print(fr�ga);
		String str = keyboard.next();
		return str;
	}
	
	
	private int readInt(String fr�ga)
	{
		for(;;)
		{
			try
			{
				System.out.print(fr�ga);
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
		System.out.println("Hej och v�lkommen till Prylprogrammet");
		
		for(;;)
		{
			int kom = readInt("1 - Skapa person\n" +	
						     "2 - Skapa pryl\n" +		
						     "3 - Visa alla\n" +		
						     "4 - Visa rikaste\n" + 	
						     "5 - Visa viss person\n" + 
						     "6 - B�rskrasch\n" +			
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
					System.out.println("Inget s�nt kommando!");
			
			} //switch
				System.out.println();
		
		} //for
	}
	

	private void skapaPerson() 
	{
		
		//L�gg till ny person / registrera
		
		String namn = readString("Namn: ");
		
		for (int m = 0; m < allaPersoner.size(); m++)
		{
				
			if (allaPersoner.get(m).getNamn().equalsIgnoreCase(namn))
			{
				System.out.println("Namnet �r upptaget");
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
		//L�gg till pryl hos person
		
		String namn = readString("Vilken person �ger prylen: ");
	
		for (Person p : allaPersoner)
		{		
			if (namn.equalsIgnoreCase(p.getNamn()))
			{
				System.out.println("Vi f�rvarar endast \"Smycken\", \"Aktier\" och \"Apparater\"");	
				String pryl = readString("Vilken sorts pryl: ");
				
				String prylNamn;
				
				if (pryl.equalsIgnoreCase("smycke") || (pryl.equalsIgnoreCase("smycken")))
				{
					prylNamn = readString("Vilken sorts smycke: ");
						
					String valor = readString("�r smycket av guld? ");
				
					int antalAdelstenar = readInt("Antal �delstenar: ");
				
					Smycke s = new Smycke(prylNamn, valor, antalAdelstenar);
					p.addPryl(s);
				} //if	
				
				
				else if (pryl.equalsIgnoreCase("aktie") || (pryl.equalsIgnoreCase("aktier")))
				{
					prylNamn = readString("Vilken aktie: ");
				
					int antalAktie = readInt("Hur m�nga aktier: ");
				
					double prisAktie = readInt("Aktiens styckepris: ");
				
					Aktie ak = new Aktie(prylNamn, antalAktie, prisAktie);
					p.addPryl(ak);
				} //if		
		
				
				else if (pryl.equalsIgnoreCase("apparat") || (pryl.equalsIgnoreCase("apparater")))
				{
					prylNamn = readString("Vilken apparat: ");
				
					int inkopspris = readInt("Ink�pspris: ");
				
					int slitage = readInt("Slitage, ange nummer (10 = ny apparat | 0 = trasig): ");
				
					Apparat ap = new Apparat(prylNamn, inkopspris, slitage);
					p.addPryl(ap);
				} //if		
				
			
				else 
				{
					System.out.println("Ingen s�dan pryl!");
				} //else
			
				System.out.println();
				
				commando();
			} //if
		}//for
		
		System.out.println("Personen finns ej i registret!");
	}
	
	

	private void visaAlla()
	{	
		//S�klista
		
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
				System.out.println("Rikast �r " + rikast + " som sammanlagt �ger " + rikastTotal);
				
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
				System.out.println(namn + " �ger prylarna:");
				
				System.out.println(p.getPryl());
		
				commando();
			} //if
		} //for
		
		System.out.println("Personen finns ej i registret!");
	}
	
	
	private void borskrasch()
	{
		//B�rskrasch
		
		for (Person p : allaPersoner)
		{
			p.borsKrasch();
		}
	}
	
		
	private void avsluta()
	{
		//L�gg till funktionen att st�nga ner programmet
		
		
		System.exit(0);
	}
	
} //main

