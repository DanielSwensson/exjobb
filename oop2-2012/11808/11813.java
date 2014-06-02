import java.util.*;

public class Register
{
	Scanner MyScan = new Scanner(System.in);
	ArrayList<Person> personer = new ArrayList<Person>();
	
	int readInt(String fr�gan)
	{		
		int val = 0;
		boolean felaktigt =false;
		do 
		{
		System.out.print(fr�gan + " ");
		try
			{
			val = Integer.parseInt(MyScan.nextLine());	
			felaktigt = false;
			}
		
			catch (NumberFormatException exception)
			{
			System.out.println("Felaktigt v�rde. Ange ett heltal");
			felaktigt = true;
			}
		}
		while (felaktigt);
		
		return val;
	}
	
	String readString(String fr�gan)
	{		
		System.out.print(fr�gan +" ");
		String str = MyScan.nextLine();		
		return str;		
	}
	
	boolean compareStrings(String compare, String input)
	{
		if (compare.equalsIgnoreCase(input))
			return true;
		else
			return false;
	}
	
	Person getPerson(String namn)
	{
		for (Person p: personer)
		{
			if (compareStrings(p.getNamn1(), namn))
				return p;			
		}
		return null;
	}
	
	
	void skapaPerson()
	{		
		String namn = readString("Skriv ett namn f�r att l�gga till en person:");	
		Person p = getPerson(namn);
		
		if (p != null)
			System.out.println("Person med angivet namn existerar redan");
		else
		{
			Person p1 = new Person(namn);
			personer.add(p1);
			System.out.println(namn + " har lagts till i registret.");
		}
	}

	void skapaPryl()
	{
		String namn = readString("Ange namn p� �gare:");
		
		for (int x=0; x<personer.size(); x++)
		{
			if (personer.get(x).getNamn1().equals(namn))
			{
				int val = readInt("1: Smycke \n2: Aktie \n3: Apparat\n  V�lj (1-3)");
				if (val==1)
				{
					String str = readString("Typ av smycke?");
					boolean bol = compareStrings(readString("�r det gjort av guld? (ja/nej)"), "ja");
					int antalstenar = readInt("antal �delstenar?");
					Smycke s = new Smycke(str, bol, antalstenar);
					personer.get(x).addPryl(s);
				}
				
				if (val==2)
				{
					String str = readString("Namn p� aktie?");
					int antal = readInt("antal?");
					double ink�pspris = readInt("ink�pspris?");
					
					Aktie a = new Aktie(str, antal, ink�pspris);
					personer.get(x).addPryl(a);
				}
				
				if (val==3)
				{
					String str = readString("Namn p� apparat?");
					double ink�pspris = readInt("Ink�pspris?");
					int slitage = readInt("Slitage?");
					Apparat a = new Apparat(str, ink�pspris, slitage);
					personer.get(x).addPryl(a);
				}
			}
			
		}
	}
	
	void visaAlla()
	{
		if (personer.isEmpty())
			System.out.println("Registret �r tomt.");
		else
		{
			System.out.println("I registret finns:");
			for (int x = 0; x< personer.size(); x++)
				System.out.println(personer.get(x).getNamn1() + " \t" + personer.get(x).getTotalV�rde());
		}	
	}
	
	void visaRikaste()
	{
		
		if (personer.isEmpty())
			System.out.println("Registret �r tomt.");
		else
		{
			Person rikaste = personer.get(0);
			int rikasteSumma = personer.get(0).getTotalV�rde();
			for (int x = 0; x < personer.size(); x++)
			{
				if (personer.get(x).getTotalV�rde() > rikasteSumma)
				{
					rikasteSumma = personer.get(x).getTotalV�rde(); 
					rikaste = personer.get(x);
					
				}
			}
			
			System.out.println(rikaste.getNamn1() + " �r rikast och har en f�rm�genhet p� " + rikaste.getTotalV�rde() + "\n" + rikaste.listPryl());
		}
	}
	
	void visaViss()
	{
		if (personer.isEmpty())
			System.out.println("Registret �r tomt.");
		else
		{
			Person p = null;
			do
			{
				String namn = readString("Skriv ett namn:");
				p = getPerson(namn);
				if (p == null)
					System.out.println("personen existerar inte");
				else
					System.out.println(p.getNamn1()+  " �ger: \n" + p.listPryl());
			}
			while(p == null);
		}
	}
	
	void b�rskrasch()
	{
		for (Person p: personer)
		{
			p.setAktieValue(0);
		}
	}

    public static void main(String [] args)
    {
    	Register hp = new Register();
    	
    	System.out.println("Register �ver prylar");
    	System.out.println("\n1: L�gg till person\n2: L�gg till �godel\n3: Visa alla personer i registret\n4: Visa rikaste person\n5: Visa en viss person\n6: B�rskrasch\n7: Avsluta\n");
    	for(;;)
    	{
    		
    		int val=hp.readInt("Ange kommando 1-7:");
    		System.out.println("du valde " + val);
    		
    			switch(val)
    			{
    			case 1: hp.skapaPerson(); break;
    			case 2: hp.skapaPryl(); break;
    			case 3: hp.visaAlla(); break;
    			case 4: hp.visaRikaste(); break;
    			case 5: hp.visaViss(); break;
    			case 6: hp.b�rskrasch(); break;
    			case 7: System.exit(0);

    			default:System.out.println("felaktigt kommando");
    			}
    	}
	}

}

