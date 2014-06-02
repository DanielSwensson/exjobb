package Demo01;

import java.util.*;



public class Person {

	private String personName;
	
	ArrayList<Merchandise> allaM = new ArrayList<Merchandise>();
	
	public Person(String personName) {
		this.personName = personName;
	}

	public String getPersonName() {
		return personName;
	}

	public void addAllaM(Merchandise Mnew) {
		allaM.add(Mnew);
	}

	public String getMerchandise(){
		String merchandise="";
		for(Merchandise m: allaM){
			merchandise+=m.toString();
		}
		return merchandise;
	}
    public int getCapital(){ 
    	int summa=0;
        for(Merchandise m : allaM){
        	summa+=m.getValue();
        }
        return summa;
    }
	public void stockMarketCrash(){
		for(Merchandise m: allaM){
			if(m instanceof Share)
				((Share)m).stockMarketCrash();
		}
	}
	public String toString(){
		return personName;
	}

}
