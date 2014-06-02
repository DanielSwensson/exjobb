
import java.util.*;
public class Person {

	private String namn;
	private ArrayList<Pryl> prylar = new ArrayList<Pryl>();
	
	
	Person(String namn)			
	{
		this.namn = namn;
	}

	public String getNamn1()
	{
		return namn;
	}
	
	public void addPryl(Pryl p)
	{
		prylar.add(p);
	}
	
	public String listPryl()
	{
		String list="";
		
		for (Pryl p : prylar)
		{
			list+=  " " +p;
		}
		return list;
	}

	public int getTotalV�rde()
	{

		int value=0;
		for (Pryl p : prylar)
		{
			value+= p.getV�rde();
		}

		return value ;
	}
	
	public void setAktieValue(double x)
	{
		for (Pryl p: prylar)
		{
			if (p instanceof Aktie)
				((Aktie)p).setV�rde(x);
		}
	}
	
	public String toString()
	{
	
		return namn +" "+ prylar;
	}

	
	}
	

	