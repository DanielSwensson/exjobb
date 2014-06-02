import java.util.ArrayList;




public class Person {
	String personNamn;
	
	
	public Person(String personNamn){
		this.personNamn=personNamn;
		
		
	}
	ArrayList<Prylar> allaPrylar = new ArrayList<Prylar>();

	
public void add(Prylar p) {

	allaPrylar.add(p);

}

   public int summaVärde(){
	   int summa=0;
	   for(Prylar aktuell: this.allaPrylar)
		summa+=aktuell.värde();
	   return summa;
   }
  public void crash() {
	  
	  for(Prylar p:allaPrylar){
		  if(p instanceof Aktie)
		  {
			  Aktie a = (Aktie)p;
			  a.setPris(0);
	 
		  }
		  
		 }
    

	}
	
	public String getNamn(){
		return personNamn;
	}
	
	public String toString(){
		return personNamn+ " "+summaVärde();
	}
	public String allaPrylartoString(){
		String str="";
		 for(Prylar p:allaPrylar){
		str+=p+ "\n";
		
		 }
		return str;
	}
}
  