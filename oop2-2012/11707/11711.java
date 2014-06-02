
public class Book extends LibraryContent{
	//Instansf�lt------------------------
	protected String Status;
	protected String ReleaseYear;
	protected String PossibleToLend;
	
	public Book( String ReleaseYear, String PossibleToLend, String Title, String Creator, String Genre){
		super(Title, Creator, Genre);
		this.Status="Tillg�nglig";;
		this.ReleaseYear=ReleaseYear;
		this.PossibleToLend=PossibleToLend;
		
	}
	
	
	//Instansmetod----------------------
	public String getStatus(){
		return Status;
	}
	public String getReleaseYear(){
		return ReleaseYear;
	}
	public String getPossibleToLend(){
		return PossibleToLend;
	}
	public boolean getAvailability(){
		
		
		if(PossibleToLend.equalsIgnoreCase("ja")){
			return true;
		} else return false;
		
		
	}
	public String printArrayList(){
		
		return "Titel: "+getTitle()+" - F�rfattare: "+getCreator()+" - Genre: "+getGenre()+" - �r: "+ReleaseYear+" - Status: "+Status+" - "+"L�nm�jlighet: "+PossibleToLend;

	}

}
