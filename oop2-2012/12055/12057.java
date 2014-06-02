
public class Tidning{
	
	private String namn;
	private int maxBetyg;
	
	public Tidning(String nyTidning, int nyttMaxBetyg){   
		namn = nyTidning;
		maxBetyg = nyttMaxBetyg;
	}
	
	public int getMaxBetyg(){
		return maxBetyg;
	}
	
	
	public String getTidningsNamn(){
		return namn;
	}	
}

