
public class Back extends Spelare{
	private int plusMinus;

	public Back(String na,String la, int al, int m�, int as, int pM){
		super(na,la, al, m�, as);
		plusMinus = pM;
		
		
		}
	public int getPlusMinus(){
    	return plusMinus;
        }

	
	public int ber�knaMarknadsv�rde(){		 
		return plusMinus*1000*�lder/5+250000;
	}
	public String toString(){
		return super.toString() + "\t-\t"+plusMinus+"\t-\t-";
	}
	public int �ndraPlusMinus(int plusMinusF�r�ndring){
		return plusMinus += plusMinusF�r�ndring;
	}
	private static final long serialVersionUID = 1L;	
}
