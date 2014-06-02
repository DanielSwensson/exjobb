
import java.util.*;

class Person{
	
	private String namn;
	private int samVärde;
// array för alla prylar     
	private ArrayList<Värdesak> allavärdesaker=new ArrayList<Värdesak>();
//konstuktor
	Person (String namn){
	this.namn = namn;
	}
//metoder	
	public void setAktiepris(int pris){
	for (Värdesak v: allavärdesaker){
		if (v instanceof Aktie){
			((Aktie)v).setPris(pris);
			}
		}
	}
	public void addVärdesak(Värdesak v)
	{
	allavärdesaker.add(v);
	}

	public String getNamn(){
		return namn;
	}
	public int getTotalVärde(){
		int summaVärde = 0;
		for (Värdesak v:allavärdesaker){
		summaVärde+=v.getVärde();
		}

	return summaVärde;
	}

	public int getVärdesakSize(){
	return allavärdesaker.size();
	}

	public String listVärdesak(){
	String list="";
	int antal=0;
		for (Värdesak v : allavärdesaker){
		list+=+(++antal)+" "+v;
	}
	return list;
	}

	public String toString(){
		return namn+"\t"+getTotalVärde();
	}
}




