
public class Personer {
	private String namn;
	private int f�rm�genhet;
	Personer(String s�ttNamn, int s�ttF�rm�genhet){
		
		namn = s�ttNamn;
		f�rm�genhet = s�ttF�rm�genhet;
	}
	
	public String toString(){
		return namn+" med "+f�rm�genhet+"kr";
	}
	
	public String getNamn(){
		return namn;
	}
	public int getF�rm�genhet(){
		return f�rm�genhet;
	}
	public void �ka(int fler){
		f�rm�genhet+=fler;
	}
	public int s�nka(int mindre){
		return f�rm�genhet-=mindre;
	}

}
