
public  class LibraryContent {
	//Instansf�lt
	protected String Title;
	protected String Creator;
	protected String Genre;
	
	//Konstruktor
	LibraryContent(String Title, String Creator, String Genre){
		
		this.Title=Title;
		this.Creator=Creator;
		this.Genre=Genre;
		
	}
	//Instansmetod
	public String getTitle(){
		return Title;
	}
	public String getCreator(){
		return Creator;
	}
	public String getGenre(){
		return Genre;
	}
	public String printArrayList(){
		
		return "Titel: "+getTitle()+" - F�rfattare: "+getCreator()+" - Genre: "+getGenre();

	}

}
