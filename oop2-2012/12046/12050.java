import java.util.ArrayList;

public class Person {
	private String namn;
	private  ArrayList<Pryl> allaPrylar=new ArrayList<Pryl>(); 
	
	public String getNamn(){
		return namn;
	}
	public double räknaFörmögenhet(){
		double summa = 0;
		for(Pryl p : allaPrylar) {
			summa += p.getVärde();
		}
		return summa;
	}
	public ArrayList<Pryl> getallaPrylar(){
		return new ArrayList<Pryl>(allaPrylar);
	}
	
	public void läggTill(Pryl p) {
		allaPrylar.add(p);
	}
	
	public Person(String namn){
		this.namn=namn;
	}
	public void göraBörsKrach(){
		for (Pryl tmpPryl: allaPrylar){
			tmpPryl.påverkaAvKrasch();
		}
	}
}
