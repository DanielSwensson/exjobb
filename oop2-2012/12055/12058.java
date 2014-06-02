
public class Album {

	private String album;
	private String artist;
	private int Âr;
	private static int antalAlbum = 0; 
	private int idNr = 0; 

	
	public Album (String nyttAlbum, String nyArtist, int nytt≈r){
		artist = nyArtist; 
		album = nyttAlbum;
		Âr = nytt≈r;
		idNr = ++antalAlbum;
	}
	
	public String getAlbumNamn(){
		return album;
	}
	
	public int getIdNr(){
		return idNr;
	}
	
	public String getArtistNamn(){
		return artist;
	}
	
	public int get≈r(){
		return Âr;
	}
}


