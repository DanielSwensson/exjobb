
public class Personer {
	private String namn;
	private int fšrmšgenhet;
	Personer(String sŠttNamn, int sŠttFšrmšgenhet){
		
		namn = sŠttNamn;
		fšrmšgenhet = sŠttFšrmšgenhet;
	}
	
	public String toString(){
		return namn+" med "+fšrmšgenhet+"kr";
	}
	
	public String getNamn(){
		return namn;
	}
	public int getFšrmšgenhet(){
		return fšrmšgenhet;
	}
	public void ška(int fler){
		fšrmšgenhet+=fler;
	}
	public int sŠnka(int mindre){
		return fšrmšgenhet-=mindre;
	}

}
