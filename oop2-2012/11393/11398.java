package varderegister;

import java.util.ArrayList;

public class Person {
	
	private ArrayList<Pryl> pryllista = new ArrayList<Pryl>();
	
	private String namn;
	
	public Person(String namn){
		this.namn = namn;
	}
	
	public String getNamn(){
		return this.namn;
	}
	
	public void addPryl(Pryl pryl){
		pryllista.add(pryl);
	}
	
	public void visaPrylar(){
		for(int i=0;i<pryllista.size();i++){
			Pryl pr = pryllista.get(i);
			System.out.println("\t"+pr.namn+"\t"+pr.varde());
		}
	}
	
	public double prylarsVarde(){
		double summa=0;
		
		for(int i=0;i<pryllista.size();i++){
			Pryl pr = pryllista.get(i);
			summa += pr.varde();
		}
		return summa;
	}
	

	public void borskrasch() {
		for(Pryl pr : pryllista){
			if(pr instanceof Aktie){
				((Aktie)pr).setPris(0);
			}
		}
	}
}
