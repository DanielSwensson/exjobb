import java.util.ArrayList;
//En klass som beskriver en person, n�r den skapas och vilka parametrar den personen har
public class Person {
	
	private String namn;
	
	ArrayList <Pryl> prylar;
	
	public Person (String namn){
		this.namn = namn;
		this.prylar = new ArrayList <Pryl> ();
	}
	
	public void setNamn (String namn){
		this.namn = namn;
	}
	
	public String getNamn (){
		return namn;
	}
		
	public void addPryl (Pryl p){
		prylar.add(p);
	}
	
	public int countV�rde (){
		int total = 0;
		for (int i = 0; i < prylar.size(); i++){
			total += prylar.get(i).getV�rde();	
		}
		
		return total;	
	}
	
	public String toString (){
		String prylText = "";
		for (Pryl p:prylar){
			prylText += p.getNamn() + " " + p.getV�rde() + "\n"; 
		}
		return this.namn + "\n" + prylText;
	}	
}
