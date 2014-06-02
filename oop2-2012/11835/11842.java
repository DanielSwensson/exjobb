
public class PhysicalMedia extends MusicAlbum {
	
	protected int condition;
	private String release;
	
	public PhysicalMedia (String artistName, String albumName, int year, String genreName, String formatName, int condition, String release, int rare, double rating){
		super(artistName, albumName, year, genreName, formatName, rare, rating);
		
		this.condition = condition;
		this.release = release;
	}
	public int getCondition(){
		return condition;
		
	}
	public String getRelease(){
		return release;
	}
	@Override
	public double value(){
		return rating*rare*condition;
	}
	
	public String toString(){
		return super.toString() +"\nSkick: " +condition +"\n" +"Releasenr: " +release +"\n\n";
		
	}
}
