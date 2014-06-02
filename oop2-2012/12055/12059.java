
abstract public class Betyg {
	
	protected int betyg;	
	protected Album betygetsAlbum;
	
	protected Betyg (int nyttBetyg, Album nyttAlbum){
		betyg = nyttBetyg;
		betygetsAlbum = nyttAlbum;		
	}

	abstract protected int visaBetyg();
	
	protected Album getAlbum(){
		return betygetsAlbum;
	}	

	public int visaOriginalBetyg(){
		return betyg;
	}
	
	
}
