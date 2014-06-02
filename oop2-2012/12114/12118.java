import java.util.ArrayList;

public class Person {
	
	private ArrayList<Pryl> prylar = new ArrayList<Pryl>(); //en lista �ver alla prylar en viss person �ger
	private String namn; 
	
	public Person(String namn) { //konstruktor
		this.namn = namn;
	}
	
	public void listaPrylar(){ //metod f�r att lista alla prylar en person �ger
		for(int i=0;i<prylar.size();i++){ //loopar igenom hela arrayen med prylar
			System.out.println(prylar.get(i).getNamn() + '\t' + prylar.get(i).getV�rde()); //skriver ut prylen och dess v�rde
		}
	}

	public double getSammanlagtV�rde(){ //metod f�r att skriva ut v�rdet p� alla prylar en person �ger
		double summa = 0;
		
		for(int i=0;i<prylar.size();i++){ //loopar igenom hela prylarrayen
			summa = summa + prylar.get(i).getV�rde(); //adderar v�rdet av varje pryl till summa
		}
		return summa; //skriver ut summa
	}
	
	public String getNamn(){ //metod f�r att returnera personens namn
		return namn;
	}

	public void addPryl(Pryl newPryl) { //metod f�r att l�gga till en pryl i arrayen
		prylar.add(newPryl);
	}
	
	public void krashaAktier(){ //metod f�r att krasha alla aktier en person �ger
		for(int i=0;i<prylar.size();i++){ //loopar igenom hela arrayen
			if(prylar.get(i).getPrylSort().equals("aktie")){ //om prylen �r en aktie
				((Aktie)prylar.get(i)).setV�rde(0); //s�tt v�rdet p� aktien till 0
			}
		}
	}
	
}
