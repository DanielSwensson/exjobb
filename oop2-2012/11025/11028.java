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
	
	public void l�ggaTillPryl(Pryl pryl){
		prylSamling.add(pryl);
	}
	
	public int visaTotalV�rde(){
		int totalV�rde = 0;
		for( int i=0; i < prylSamling.size(); i++){
			totalV�rde += prylSamling.get(i).visaV�rde();
		}	
		return totalV�rde;
		
	}
	
	public void kraschaB�rsen(){
		for(int j = 0; j < prylSamling.size(); j++) {
			if(prylSamling.get(j) instanceof Aktie){
				Aktie aktie = (Aktie)prylSamling.get(j);
				aktie.�ndraPris(0);
			}
		}
	}
	
	public String toString() {
		return namn + " " + visaTotalV�rde();
	}

}