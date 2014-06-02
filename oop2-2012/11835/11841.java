
import java.io.*;
import java.util.*;
abstract class MusicAlbum implements Serializable {
    
    private String artistName;
    private String albumName;
    private int year;
    private String formatName;
    private String genreName;
    protected double rating;
    protected int rare;
    
    
    public MusicAlbum(String artistName, String albumName, int year, String genreName, String formatName, int rare, double rating){
        
        this.artistName = artistName;
        this.albumName = albumName;
        this.year = year;
        this.formatName = formatName;
        this.genreName = genreName;
        this.rating = rating;
        this.rare = rare;
        
        
    }
    
    abstract public double value();

    
    public String getArtistName(){
        
        return artistName;
    }
    
    public String getAlbumName(){
        
        return albumName;
    }
    public int getYear(){
        
        return year;
    }
    
    public String getFormatName(){
        
        return formatName;
    }
    
    public String getGenreName(){
        
        return genreName;
    }
    public double getRating(){
    	
        return rating;
    }
    
    public void changeRating(double x){
        rating = 0;
        rating += x;
        
    }

    public double sumValue(ArrayList<MusicAlbum> allAlbums){
    	double sum = 0;
    	for(MusicAlbum now: allAlbums)
    		sum += now.value();
    	return sum;
    }

	public String toString(){
		return"Artist: " +artistName+"\nAlbumnamn: " +albumName +"\nÅr: " +year +"\nGenre: "+genreName+ "\nFormat: "+formatName +"\nBetyg: "+rating +"\nVärde: "+value() ;
	}
}

