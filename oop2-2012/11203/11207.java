import java.util.ArrayList;



public class Person {
	private String namn;
	private ArrayList<Pryl>prylar=new ArrayList <Pryl>();
	
	public Person (String namn){
		this.namn=namn;

	}
	public String getNamn(){
		return namn;
	}
	
	
	public String hämtaPryl(){
		String alla = "";
		for (Pryl p: prylar)
			alla+= p + "\n";
		return alla;
	}
	public int sammanlagtVärde(){
		int totaltVärde = 0;
		for (Pryl p: prylar)
			totaltVärde+=p.getVärde();

		return totaltVärde;
	}
	public void läggaTillPryl(Pryl p){
		prylar.add(p);
	}

	public String toString(){
		return  namn +"\t" + sammanlagtVärde(); 

	}
	public void nollställAktie(){
		for (Pryl p : prylar)
			if (p instanceof Aktie){
				Aktie a = (Aktie)p;
				a.setVärde(0);

			}
	}
}
