package personer.src.Package;

import java.util.ArrayList;

public class Person {


	
	private String name;

	private ArrayList<Smycken> smyckeList;

	private ArrayList<Aktier> aktieList;

	private ArrayList<Apparater> apparatList;


	public Person(String name, ArrayList<Smycken> smyckeList, ArrayList<Aktier> aktieList, ArrayList<Apparater> apparatList){
		this.name=name;
		this.smyckeList = smyckeList;
		this.aktieList = aktieList;
		this.apparatList = apparatList;
	}

	public ArrayList<Smycken> getSmyckeList() {

		return smyckeList;
	}
	public ArrayList<Aktier> getAktieList() {
		return aktieList;
	}
	public ArrayList<Apparater> getAppList() {
		return apparatList;
	}

	public String getName(){
		return name;
	
	}

	public String toString(){
		return "Name: "+name+", "+getSmyckeList() + "  " + getAktieList() + "  " + getAppList();
	}


}

