
public class Flac extends BitMedia {

	private int size;
	
	public Flac (String artistName, String albumName, int year, String genreName, String formatName, String source, int size, int rare,  double rating){
		super(artistName, albumName, year, genreName, formatName, source, rare, rating);
		
		this.size = size;
		
	}
	public int getSize(){
		return size;
	}

	
	public String toString(){
		return super.toString() +"Storlek: "+size +" mb\n\n";
	}
}

