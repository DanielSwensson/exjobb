
public class Back extends Spelare{
	private int plusMinus;

	public Back(String na,String la, int al, int må, int as, int pM){
		super(na,la, al, må, as);
		plusMinus = pM;
		
		
		}
	public int getPlusMinus(){
    	return plusMinus;
        }

	
	public int beräknaMarknadsvärde(){		 
		return plusMinus*1000*ålder/5+250000;
	}
	public String toString(){
		return super.toString() + "\t-\t"+plusMinus+"\t-\t-";
	}
	public int ändraPlusMinus(int plusMinusFörändring){
		return plusMinus += plusMinusFörändring;
	}
	private static final long serialVersionUID = 1L;	
}
