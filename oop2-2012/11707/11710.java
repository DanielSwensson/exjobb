
public class MusicRecords extends LibraryContent{
	//Instansfält
	protected String Playtime;
	protected String Condition;
	protected String Occupied;
	
	//Konstruktor
	MusicRecords(String Playtime, String Condition, String Title, String Creator, String Genre){
		super(Title, Creator, Genre);
		this.Playtime=Playtime;
		this.Condition=Condition;
		this.Occupied="Nej";
	}
	
	//Instansmetoder
	public String getPlaytime(){
		return Playtime;
	}
	public String getOccupied(){
		return Occupied;
	}
	public String getCondition(){
		return Condition;
	}
	public boolean getAvailability(){
		
		
		if(Occupied.equalsIgnoreCase("nej")){
			return true;
		} else return false;
		
		
	}
	public String printArrayList(){
		
		return "Titel: "+getTitle()+" - Artist: "+getCreator()+" - Genre: "+getGenre()+" - Speltid: "+Playtime+" - Skick: "+Condition+" - Upptagen: "+Occupied;

	}

}
