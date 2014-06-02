public class Smycke extends Pryl{ // smycke är en subklass till pryl
    
	private int antÄdel; // deklarerar våra attribut/variabler
	private String metall;
	private int metallvärde;
	private int värde;
    
    public Smycke(String prylNamn, String typ, int antÄdel, String metall){ // konstruktor som innehåller argument som varje objekt måste uppfylla
		super(prylNamn, typ); // anropar superklassens konstruktor
		this.antÄdel=antÄdel; // antÄdel parametern får samma värde som objektet med samma namn
		this.metall=metall;
        if(metall.equalsIgnoreCase("guld")){
        	metallvärde=2000;
        }
        else if(metall.equalsIgnoreCase("Silver")){
        	metallvärde=700;
       
        }	
   	    }
   	
   	public int getVärde(){
   		return värde=antÄdel * 500 + metallvärde;
   		}//returnerar värdet på smycken

        }