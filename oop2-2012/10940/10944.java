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
	
	 public double getVŠrde(){ 
	    	double summa=0;
	        for(Pryl p : allaSaker){
	        	summa+=p.getVŠrde();
	        }
	        return summa;
	 }


	public String getPryl(){		
		String x = "";
		for(Pryl p : allaSaker ){
			x += p.getPrylNamn() +" ";
			x += p.getVŠrde();
			x += "\n";
		}
		return x;
	}


	public void bšrsKrasch() {
		for (Pryl i : allaSaker){
			if (i instanceof Aktie)
				((Aktie)i).bšrsKrasch();
			//Aktier tmp = (Aktier)i;
		}
	}
}


