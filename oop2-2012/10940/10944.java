import java.util.ArrayList;

public class Person {
	private String namn;

	ArrayList<Pryl> allaSaker = new ArrayList <Pryl>();

	Person(String namn){
		this.namn = namn;
	}


	public String getNamn(){
		return namn;
	}

	public String toString(){
		return namn;
	}

	public void addPryl(Pryl sak){
		allaSaker.add(sak);
	}
	
	 public double getV�rde(){ 
	    	double summa=0;
	        for(Pryl p : allaSaker){
	        	summa+=p.getV�rde();
	        }
	        return summa;
	 }


	public String getPryl(){		
		String x = "";
		for(Pryl p : allaSaker ){
			x += p.getPrylNamn() +" ";
			x += p.getV�rde();
			x += "\n";
		}
		return x;
	}


	public void b�rsKrasch() {
		for (Pryl i : allaSaker){
			if (i instanceof Aktie)
				((Aktie)i).b�rsKrasch();
			//Aktier tmp = (Aktier)i;
		}
	}
}


