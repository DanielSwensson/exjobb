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
	
	
	public String h�mtaPryl(){
		String alla = "";
		for (Pryl p: prylar)
			alla+= p + "\n";
		return alla;
	}
	public int sammanlagtV�rde(){
		int totaltV�rde = 0;
		for (Pryl p: prylar)
			totaltV�rde+=p.getV�rde();

		return totaltV�rde;
	}
	public void l�ggaTillPryl(Pryl p){
		prylar.add(p);
	}

	public String toString(){
		return  namn +"\t" + sammanlagtV�rde(); 

	}
	public void nollst�llAktie(){
		for (Pryl p : prylar)
			if (p instanceof Aktie){
				Aktie a = (Aktie)p;
				a.setV�rde(0);

			}
	}
}
