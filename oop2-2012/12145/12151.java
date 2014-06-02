
public class Smycke extends Pryl {
	private String metall;
	private int ädelsten;
	
	public double getValue() {
		if (metall.equals("guld")){
			return (ädelsten * 500) + 2000;
					
		}
		
		else 
			return(ädelsten * 500) + 700;
			
	}
	public Smycke(String typ, String metall, int ädelsten){
		super(typ);
		this.metall = metall;
		this.ädelsten = ädelsten;
	}
	public String toString(){
		return namn + " " + getValue()  ;
	}
	
	

} 


