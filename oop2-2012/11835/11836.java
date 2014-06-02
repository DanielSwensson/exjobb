
public class BitMedia extends MusicAlbum {
	private String source;
	
	
	public BitMedia(String artistName, String albumName, int year, String genreName, String formatName, String source,  int rare, double rating){
		super(artistName, albumName, year, genreName, formatName, rare, rating);
		
		this.source = source;
	}

	public String getSource(){
		return source;
	}
	@Override
	public double value(){
		return rating*rare;
	}
	
	public String toString(){
		return super.toString() +"\nKälla: " +source +"\n";
	}
}
