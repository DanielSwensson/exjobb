import java.util.ArrayList;


public class Person {
	private String namn;
	private ArrayList<Pryl> prylLista = new ArrayList<Pryl>();
	public Person(String namn){
		this.namn = namn;
	}
	
	public String getNamn(){
		return namn;
	}
	
	public void addPryl(Pryl a){
		prylLista.add(a);
	}
	
	public ArrayList<Pryl> getPrylar(){
		return prylLista;
	}
	
	public void printPrylar(){
		for(Pryl aktuell : prylLista)
			System.out.println(aktuell.getNamn() +"\t"+ aktuell.getVärde());
			
	}
	
	public double getVärde(){
		double värde = 0;
		//NullPointerException ?
		if(!prylLista.isEmpty()){
			for(Pryl aktuell : prylLista)
				värde+= aktuell.getVärde();
		}
		return värde;
	}
	
	public void börskrasch(){ //testa
		if(!prylLista.isEmpty()){
			for(Pryl aktuell : prylLista){
				if(aktuell instanceof Aktie)
					((Aktie) aktuell).setPris(0);	
			}
		}
	}
	/*
	public boolean equals(Object other)
	{
	   if (other == null)
		   return false;

	   else if (this.getClass() != other.getClass())
		   return false;
	  
	   
	   else if(this.namn.equals(((Person) other).getNamn()))
		   return true;
	   
	   else
		   return false;
	   
	}*/
}
