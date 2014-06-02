package inlämning2;

import java.util.ArrayList;

public class Person 
{
	private ArrayList<Pryl> allaPrylar = new ArrayList<Pryl>();
	private String namn;
	private String pryl = "";
	private int count = 0;
	private final int PER_RAD = 1;

	
	public Person(String namn)
	{
		this.namn = namn;
	}
	
	
	//-----
	// Namn
	//-----
	
	public String getNamn()
	{
		return namn;
	}
	
	
	//----------
	//Pryl
	//----------
	
	
	public String getPryl()
	{	
		for(Pryl p : allaPrylar)
		{
			count++;
			
			if (count % PER_RAD == 0)
			{
				System.out.println(p);
			}
		}
		
		return pryl;
	}
	
	
	
	//----------
	//Pryl Summa
	//----------
	
	public int getSum()
	{
		int sum = 0;
		
		for (Pryl p : allaPrylar)
		{
			sum += p.getVarde();
		}
		
		return sum;
	}
	
	
	//---------------------------
	//Lägg till pryl hos personen
	//---------------------------
	
	public void addPryl(Pryl ny)
	{
		allaPrylar.add(ny);
	}
	
	
	//----------
	//Börskrasch
	//----------
	
	public void borsKrasch()
	{
		for (Pryl p : allaPrylar)
		{
			if (p instanceof Aktie)
			{
				((Aktie) p).getBorsKrasch();
			}
		}
	}
	
	
	//-----------
	// Utskriften
	//-----------
	
	public String toString()
	{
		return "" + namn;
	}
}
