import java.util.ArrayList;
import java.io.*;

public class Lag implements Serializable{
	private String lagNamn;
	private int marknadsv�rde;
	
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
	
	public int r�knaForwards(){
		int tot = 0;
		for(Spelare s : Rooster){
			if(s instanceof Forward)
				tot++;
		}
		return tot;
	}
	public int r�knaM�lvakter(){
		int tot = 0;
		for(Spelare s : Rooster){
			if(s instanceof M�lvakt)
				tot++;
		}
		return tot;
	}
	public int r�knaBackar(){
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

	public int ber�knaMarknadsv�rde(){
		marknadsv�rde = 0;
		for (int n = 0; n < Rooster.size(); n++) {
			marknadsv�rde += Rooster.get(n).ber�knaMarknadsv�rde();
		}
		return marknadsv�rde;
	}

	private static final long serialVersionUID = 1L;
}