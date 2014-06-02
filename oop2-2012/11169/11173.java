import java.util.ArrayList;
import java.io.*;

public class Lag implements Serializable{
	private String lagNamn;
	private int marknadsvärde;
	
	public Lag(String nyttLagNamn) {
		lagNamn = nyttLagNamn.substring(0,1).toUpperCase()+nyttLagNamn.substring(1);

	}

	private ArrayList<Spelare> Rooster = new ArrayList<Spelare>();
	
	public ArrayList<Spelare> getRooster(){
		return Rooster;		
	}

	public String getNamn() {
		return lagNamn;
	}

	public void nySpelare(Spelare nySpelare) {
		Rooster.add(nySpelare);

	}
	
	public int räknaForwards(){
		int tot = 0;
		for(Spelare s : Rooster){
			if(s instanceof Forward)
				tot++;
		}
		return tot;
	}
	public int räknaMålvakter(){
		int tot = 0;
		for(Spelare s : Rooster){
			if(s instanceof Målvakt)
				tot++;
		}
		return tot;
	}
	public int räknaBackar(){
		int tot = 0;
		for(Spelare s : Rooster){
			if(s instanceof Back)
				tot++;
		}
		return tot;
	}

	public String toString() {
		String str = "";
		for (Spelare s : Rooster) 
			str += s.toString()+"\n";
		return str;
	}

	public int beräknaMarknadsvärde(){
		marknadsvärde = 0;
		for (int n = 0; n < Rooster.size(); n++) {
			marknadsvärde += Rooster.get(n).beräknaMarknadsvärde();
		}
		return marknadsvärde;
	}

	private static final long serialVersionUID = 1L;
}