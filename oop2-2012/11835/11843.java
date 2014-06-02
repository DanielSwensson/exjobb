
public class VinylScratch extends PhysicalMedia {
	
	public VinylScratch (String artistName, String albumName, int year, String genreName, String formatName, String release, int condition, int rare, double rating){
		super(artistName, albumName, year, genreName, formatName, condition, release, rare, rating);
		
		
		 
	}
	@Override
	public double value(){
		return rating*rare*condition+5;
	}
}
