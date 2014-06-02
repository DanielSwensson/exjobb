
class Mp3 extends BitMedia {

	private String bitRate;
	
	public Mp3 (String artistName, String albumName, int year, String genreName, String formatName,String source, String bitRate, int rare, double rating){
		super(artistName, albumName, year, genreName, formatName, source, rare, rating);
		
		this.bitRate = bitRate;
	}

	public String getBitRate(){
		return bitRate;
	}
	public String toString(){
		return super.toString() +"Bitrate: " +bitRate +" kbps\n\n";
	}
}
