public abstract class Pryl{ //superklass
	private String prylNamn;// deklarerar v�ra attribut/variabler
	private String typ;
	
	public Pryl(String prylNamn, String typ){ // konstruktor med argument som m�ste uppfyllas av varje nytt objekt
			this.prylNamn=prylNamn;// prylNamn parametern f�r samma v�rde som objektet med samma namn
			this.typ=typ;
			}
	
	
    public abstract int getV�rde(); // superklassens getV�rde metod
    
    
    public String toString(){ // returnerar prylens namn som en string
    	return typ+", v�rde: "+getV�rde()+", ";
            }
	
	        }