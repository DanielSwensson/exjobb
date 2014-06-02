import java.util.ArrayList;

public class Person {
	 private String namn;
	 private ArrayList<Pryl> prylar;
	 
	 public Person(String namn){
		 prylar = new ArrayList<Pryl>();
		 this.namn = namn;
	}
	
	 
	 public void tilldelaPryl(Pryl pryl){
		 prylar.add(pryl);
	 }
	 
	 
	 public int totalVärde(){
		 int tempVärde= 0; 
		 for (int i = 0;i < prylar.size(); i++)
			 tempVärde+= prylar.get(i).kalkyleraVärde();
			 
	     return tempVärde;
			 
	 }
	 
	 public void börskrasch(){
		 for (int i = 0;i < prylar.size(); i++){
			 if (prylar.get(i).getTyp().equals("Aktie")){
				Aktie tempAktie = (Aktie)prylar.get(i);
				tempAktie.ändraVärde(0);									 
			 }
		 }
			 
		 
	 }

	 public String toString(){

		 String temp =getNamn() + ":\n";
		 for (int i = 0;i < prylar.size(); i++)
			 temp+= prylar.get(i);
		 return temp;
		}
	 
	 
	 public String skrivPerson(){
		 return getNamn() + ":\t" + String.valueOf(totalVärde());
	 }
	 
	 public String getNamn(){
		 return namn;
	 }
	
}
	
