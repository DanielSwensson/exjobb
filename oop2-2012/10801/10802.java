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
	 
	 
	 public int totalV�rde(){
		 int tempV�rde= 0; 
		 for (int i = 0;i < prylar.size(); i++)
			 tempV�rde+= prylar.get(i).kalkyleraV�rde();
			 
	     return tempV�rde;
			 
	 }
	 
	 public void b�rskrasch(){
		 for (int i = 0;i < prylar.size(); i++){
			 if (prylar.get(i).getTyp().equals("Aktie")){
				Aktie tempAktie = (Aktie)prylar.get(i);
				tempAktie.�ndraV�rde(0);									 
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
		 return getNamn() + ":\t" + String.valueOf(totalV�rde());
	 }
	 
	 public String getNamn(){
		 return namn;
	 }
	
}
	
