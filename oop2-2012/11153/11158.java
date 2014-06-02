public abstract class Pryl{ //superklass
	private String prylNamn;// deklarerar våra attribut/variabler
	private String typ;
	
	public Pryl(String prylNamn, String typ){ // konstruktor med argument som måste uppfyllas av varje nytt objekt
			this.prylNamn=prylNamn;// prylNamn parametern får samma värde som objektet med samma namn
			this.typ=typ;
			}
	
	
    public abstract int getVärde(); // superklassens getVärde metod
    
    
    public String toString(){ // returnerar prylens namn som en string
    	return typ+", värde: "+getVärde()+", ";
            }
	
	        }