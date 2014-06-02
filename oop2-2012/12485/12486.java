import java.util.ArrayList;
public class Person {
	private int totaltVärde;
	private String namn;
	
	private ArrayList<Pryl> ägdaPrylar = new ArrayList<Pryl>();
	
	public void börsKrasch(){
		for(int aktuell = 0; aktuell < ägdaPrylar.size(); aktuell++){
			if (ägdaPrylar.get(aktuell) instanceof Aktie){
				((Aktie) ägdaPrylar.get(aktuell)).nollStällVärde();}
		}
	}
	
	public void läggTillPryl(Pryl inkommandePryl){
		Pryl nyPryl = inkommandePryl;
		ägdaPrylar.add(nyPryl);}
	
	Person(String namn){
		this.namn = namn;
		totaltVärde = 0;}
	
	public String hämtaNamn(){
		return namn;}
	
	public int summaVärde(){
		int summa = 0;
		for (Pryl aktuell: ägdaPrylar){
			summa += aktuell.hämtaVärde();}
		return summa;}
	
	
	public String toString(){
		String utskrivning = namn +"\t\t\t"+summaVärde();
		return  utskrivning;}
	
	public String toString(String startText){
		int prylRäknad = 0;
		String utskrivning = startText;
		for(int uppräknarn = 0; uppräknarn < ägdaPrylar.size(); uppräknarn++){
			utskrivning += ++prylRäknad + " "+  ägdaPrylar.get(uppräknarn);}
		return utskrivning;}
}
