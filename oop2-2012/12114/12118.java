import java.util.ArrayList;

public class Person {
	
	private ArrayList<Pryl> prylar = new ArrayList<Pryl>(); //en lista šver alla prylar en viss person Šger
	private String namn; 
	
	public Person(String namn) { //konstruktor
		this.namn = namn;
	}
	
	public void listaPrylar(){ //metod fšr att lista alla prylar en person Šger
		for(int i=0;i<prylar.size();i++){ //loopar igenom hela arrayen med prylar
			System.out.println(prylar.get(i).getNamn() + '\t' + prylar.get(i).getVŠrde()); //skriver ut prylen och dess vŠrde
		}
	}

	public double getSammanlagtVŠrde(){ //metod fšr att skriva ut vŠrdet pŒ alla prylar en person Šger
		double summa = 0;
		
		for(int i=0;i<prylar.size();i++){ //loopar igenom hela prylarrayen
			summa = summa + prylar.get(i).getVŠrde(); //adderar vŠrdet av varje pryl till summa
		}
		return summa; //skriver ut summa
	}
	
	public String getNamn(){ //metod fšr att returnera personens namn
		return namn;
	}

	public void addPryl(Pryl newPryl) { //metod fšr att lŠgga till en pryl i arrayen
		prylar.add(newPryl);
	}
	
	public void krashaAktier(){ //metod fšr att krasha alla aktier en person Šger
		for(int i=0;i<prylar.size();i++){ //loopar igenom hela arrayen
			if(prylar.get(i).getPrylSort().equals("aktie")){ //om prylen Šr en aktie
				((Aktie)prylar.get(i)).setVŠrde(0); //sŠtt vŠrdet pŒ aktien till 0
			}
		}
	}
	
}
