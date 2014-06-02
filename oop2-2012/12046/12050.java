import java.util.ArrayList;

public class Person {
	private String namn;
	private  ArrayList<Pryl> allaPrylar=new ArrayList<Pryl>(); 
	
	public String getNamn(){
		return namn;
	}
	public double r�knaF�rm�genhet(){
		double summa = 0;
		for(Pryl p : allaPrylar) {
			summa += p.getV�rde();
		}
		return summa;
	}
	public ArrayList<Pryl> getallaPrylar(){
		return new ArrayList<Pryl>(allaPrylar);
	}
	
	public void l�ggTill(Pryl p) {
		allaPrylar.add(p);
	}
	
	public Person(String namn){
		this.namn=namn;
	}
	public void g�raB�rsKrach(){
		for (Pryl tmpPryl: allaPrylar){
			tmpPryl.p�verkaAvKrasch();
		}
	}
}
