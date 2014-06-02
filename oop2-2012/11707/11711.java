
public class Book extends LibraryContent{
	//Instansfält------------------------
	protected String Status;
	protected String ReleaseYear;
	protected String PossibleToLend;
	
	public Book( String ReleaseYear, String PossibleToLend, String Title, String Creator, String Genre){
		super(Title, Creator, Genre);
		this.Status="Tillgänglig";;
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
		
		return "Titel: "+getTitle()+" - Författare: "+getCreator()+" - Genre: "+getGenre()+" - År: "+ReleaseYear+" - Status: "+Status+" - "+"Lånmöjlighet: "+PossibleToLend;

	}

}
