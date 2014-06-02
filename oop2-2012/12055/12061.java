import java.lang.Math;

public class KritikerBetyg extends Betyg{
	private Tidning betygTidning;

	
	public KritikerBetyg (int nyttBetyg, Album nyttAlbum, Tidning nyTidning){
		super(nyttBetyg, nyttAlbum);
		betygTidning = nyTidning;		

	} 
	
	public int visaBetyg(){ 
		return Math.round(100/betygTidning.getMaxBetyg())*betyg;
	}	
	
	public Tidning getTidning(){
		return betygTidning;
	}	
}
