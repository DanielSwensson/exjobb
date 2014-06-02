import java.util.*;

public class Register
{
	Scanner MyScan = new Scanner(System.in);
	ArrayList<Person> personer = new ArrayList<Person>();
	
	int readInt(String frågan)
	{		
		int val = 0;
		boolean felaktigt =false;
		do 
		{
		System.out.print(frågan + " ");
		try
			{
			val = Integer.parseInt(MyScan.nextLine());	
			felaktigt = false;
			}
		
			catch (NumberFormatException exception)
			{
			System.out.println("Felaktigt värde. Ange ett heltal");
			felaktigt = true;
			}
		}
		while (felaktigt);
		
		return val;
	}
	
	String readString(String frågan)
	{		
		System.out.print(frågan +" ");
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
		String namn = readString("Skriv ett namn för att lägga till en person:");	
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
		String namn = readString("Ange namn på ägare:");
		
		for (int x=0; x<personer.size(); x++)
		{
			if (personer.get(x).getNamn1().equals(namn))
			{
				int val = readInt("1: Smycke \n2: Aktie \n3: Apparat\n  Välj (1-3)");
				if (val==1)
				{
					String str = readString("Typ av smycke?");
					boolean bol = compareStrings(readString("Är det gjort av guld? (ja/nej)"), "ja");
					int antalstenar = readInt("antal ädelstenar?");
					Smycke s = new Smycke(str, bol, antalstenar);
					personer.get(x).addPryl(s);
				}
				
				if (val==2)
				{
					String str = readString("Namn på aktie?");
					int antal = readInt("antal?");
					double inköpspris = readInt("inköpspris?");
					
					Aktie a = new Aktie(str, antal, inköpspris);
					personer.get(x).addPryl(a);
				}
				
				if (val==3)
				{
					String str = readString("Namn på apparat?");
					double inköpspris = readInt("Inköpspris?");
					int slitage = readInt("Slitage?");
					Apparat a = new Apparat(str, inköpspris, slitage);
					personer.get(x).addPryl(a);
				}
			}
			
		}
	}
	
	void visaAlla()
	{
		if (personer.isEmpty())
			System.out.println("Registret är tomt.");
		else
		{
			System.out.println("I registret finns:");
			for (int x = 0; x< personer.size(); x++)
				System.out.println(personer.get(x).getNamn1() + " \t" + personer.get(x).getTotalVärde());
		}	
	}
	
	void visaRikaste()
	{
		
		if (personer.isEmpty())
			System.out.println("Registret är tomt.");
		else
		{
			Person rikaste = personer.get(0);
			int rikasteSumma = personer.get(0).getTotalVärde();
			for (int x = 0; x < personer.size(); x++)
			{
				if (personer.get(x).getTotalVärde() > rikasteSumma)
				{
					rikasteSumma = personer.get(x).getTotalVärde(); 
					rikaste = personer.get(x);
					
				}
			}
			
			System.out.println(rikaste.getNamn1() + " är rikast och har en förmögenhet på " + rikaste.getTotalVärde() + "\n" + rikaste.listPryl());
		}
	}
	
	void visaViss()
	{
		if (personer.isEmpty())
			System.out.println("Registret är tomt.");
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
					System.out.println(p.getNamn1()+  " äger: \n" + p.listPryl());
			}
			while(p == null);
		}
	}
	
	void börskrasch()
	{
		for (Person p: personer)
		{
			p.setAktieValue(0);
		}
	}

    public static void main(String [] args)
    {
    	Register hp = new Register();
    	
    	System.out.println("Register över prylar");
    	System.out.println("\n1: Lägg till person\n2: Lägg till ägodel\n3: Visa alla personer i registret\n4: Visa rikaste person\n5: Visa en viss person\n6: Börskrasch\n7: Avsluta\n");
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
    			case 6: hp.börskrasch(); break;
    			case 7: System.exit(0);

    			default:System.out.println("felaktigt kommando");
    			}
    	}
	}

}

