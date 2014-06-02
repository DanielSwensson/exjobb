import java.util.ArrayList;
public class Person {
	private int totaltV�rde;
	private String namn;
	
	private ArrayList<Pryl> �gdaPrylar = new ArrayList<Pryl>();
	
	public void b�rsKrasch(){
		for(int aktuell = 0; aktuell < �gdaPrylar.size(); aktuell++){
			if (�gdaPrylar.get(aktuell) instanceof Aktie){
				((Aktie) �gdaPrylar.get(aktuell)).nollSt�llV�rde();}
		}
	}
	
	public void l�ggTillPryl(Pryl inkommandePryl){
		Pryl nyPryl = inkommandePryl;
		�gdaPrylar.add(nyPryl);}
	
	Person(String namn){
		this.namn = namn;
		totaltV�rde = 0;}
	
	public String h�mtaNamn(){
		return namn;}
	
	public int summaV�rde(){
		int summa = 0;
		for (Pryl aktuell: �gdaPrylar){
			summa += aktuell.h�mtaV�rde();}
		return summa;}
	
	
	public String toString(){
		String utskrivning = namn +"\t\t\t"+summaV�rde();
		return  utskrivning;}
	
	public String toString(String startText){
		int prylR�knad = 0;
		String utskrivning = startText;
		for(int uppr�knarn = 0; uppr�knarn < �gdaPrylar.size(); uppr�knarn++){
			utskrivning += ++prylR�knad + " "+  �gdaPrylar.get(uppr�knarn);}
		return utskrivning;}
}
