
public  class LibraryContent {
	//Instansfält
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
		
		return "Titel: "+getTitle()+" - Författare: "+getCreator()+" - Genre: "+getGenre();

	}

}
