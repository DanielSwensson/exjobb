
import java.util.*;

class Person{
	
	private String namn;
	private int samV�rde;
// array f�r alla prylar     
	private ArrayList<V�rdesak> allav�rdesaker=new ArrayList<V�rdesak>();
//konstuktor
	Person (String namn){
	this.namn = namn;
	}
//metoder	
	public void setAktiepris(int pris){
	for (V�rdesak v: allav�rdesaker){
		if (v instanceof Aktie){
			((Aktie)v).setPris(pris);
			}
		}
	}
	public void addV�rdesak(V�rdesak v)
	{
	allav�rdesaker.add(v);
	}

	public String getNamn(){
		return namn;
	}
	public int getTotalV�rde(){
		int summaV�rde = 0;
		for (V�rdesak v:allav�rdesaker){
		summaV�rde+=v.getV�rde();
		}

	return summaV�rde;
	}

	public int getV�rdesakSize(){
	return allav�rdesaker.size();
	}

	public String listV�rdesak(){
	String list="";
	int antal=0;
		for (V�rdesak v : allav�rdesaker){
		list+=+(++antal)+" "+v;
	}
	return list;
	}

	public String toString(){
		return namn+"\t"+getTotalV�rde();
	}
}




