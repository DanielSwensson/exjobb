import java.util.ArrayList;

class Person{
	private String namn;
	private ArrayList<Pryl> prylSamling = new ArrayList<Pryl>();
	
			
	public Person(String namn){	
		this.namn = namn;
	}
	
	public String visaNamn() {
		return namn;
	}
	
	public ArrayList visaPrylSamling() {
		return prylSamling;
	}
	
	public void läggaTillPryl(Pryl pryl){
		prylSamling.add(pryl);
	}
	
	public int visaTotalVärde(){
		int totalVärde = 0;
		for( int i=0; i < prylSamling.size(); i++){
			totalVärde += prylSamling.get(i).visaVärde();
		}	
		return totalVärde;
		
	}
	
	public void kraschaBörsen(){
		for(int j = 0; j < prylSamling.size(); j++) {
			if(prylSamling.get(j) instanceof Aktie){
				Aktie aktie = (Aktie)prylSamling.get(j);
				aktie.ändraPris(0);
			}
		}
	}
	
	public String toString() {
		return namn + " " + visaTotalVärde();
	}

}