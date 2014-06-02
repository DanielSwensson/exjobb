public class Smycke extends Pryl{ // smycke �r en subklass till pryl
    
	private int ant�del; // deklarerar v�ra attribut/variabler
	private String metall;
	private int metallv�rde;
	private int v�rde;
    
    public Smycke(String prylNamn, String typ, int ant�del, String metall){ // konstruktor som inneh�ller argument som varje objekt m�ste uppfylla
		super(prylNamn, typ); // anropar superklassens konstruktor
		this.ant�del=ant�del; // ant�del parametern f�r samma v�rde som objektet med samma namn
		this.metall=metall;
        if(metall.equalsIgnoreCase("guld")){
        	metallv�rde=2000;
        }
        else if(metall.equalsIgnoreCase("Silver")){
        	metallv�rde=700;
       
        }	
   	    }
   	
   	public int getV�rde(){
   		return v�rde=ant�del * 500 + metallv�rde;
   		}//returnerar v�rdet p� smycken

        }