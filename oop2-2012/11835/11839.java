import java.util.*;
import java.io.*;        

public class MediaRegister {

	private ArrayList<MusicAlbum> allAlbums = new ArrayList<MusicAlbum>();
	private Scanner keyboard = new Scanner(System.in);

	public MediaRegister(){
		try{
			FileInputStream file = new FileInputStream("Media.obj");
			ObjectInputStream in = new ObjectInputStream(file);
			allAlbums = (ArrayList <MusicAlbum>)in.readObject();
		}
		catch(FileNotFoundException e){} catch(IOException e){System.exit(2);}
		catch(ClassNotFoundException e){System.exit(3);}
		menu();
	}
	
	
	public static void main(String[] args) {
		new MediaRegister();

	}//main

	private void menu(){

		while(true){

			System.out.println("Välkommen till Mediaregistret, vad vill du göra?");

			System.out.println("1. Lägg till album i samlingen \n2. Lista albumen i samlingen"
					+ "\n3. Ändra betyg på album i samlingen \n4. Radera album ur samlingen \n5. Avsluta och spara");

			int command = addInt(" ");

			switch(command){
			case 1: 
				choseFormat();
				break;

			case 2:
				list();
				break;

			case 3:
				changeRating();
				break;

			case 4:
				deleteAlbum();
				break;

			case 5: 
				quit();
				break;

			default: 
				System.out.println("Kommandot du skrev in finns ej, försök igen!");

			}//switch
		}//while
	}//Menu

	private void choseFormat(){

		String formatInput = addString("Ange format (mp3, flac, cd eller vinyl): ");

		switch (formatInput){
		case "mp3" :
			addMp3();
			break;

		case "flac":
			addFlac();
			break;

		case "cd":
			addCompactDisc();
			break;

		case "vinyl":
			addVinyl();
			break;

		default: 
			System.out.println("Det angivna formatet finns inte i systemet, var god försök igen!");
			choseFormat();
			break;
		}//switch
	}//choseFormat



	private String addString(String prompt){

		System.out.print(prompt);
		String addStr = keyboard.nextLine();
		return addStr;

	}//AddArtistName

	private int addInt(String prompt){
		for(;;){

			try{
				System.out.print(prompt);
				int addNumb = Integer.parseInt(keyboard.nextLine());

				return addNumb;
			}
			catch (NumberFormatException e){
				System.out.println("Input måste vara en siffra, var god försök igen din dummer.");
			}//catch
		}//for
	}//addInt
	private double addDouble(String prompt){
		for(;;){
			try{
				System.out.print(prompt);
				double addDouble = Double.parseDouble(keyboard.nextLine());
				return addDouble;
			}
			catch(NumberFormatException e){
				System.out.println("Betyget måste vara ett heltal eller ett decimaltal, var god försök igen.");
			}//catch
		}//for
	}//addDouble


	private int addRare(){
		boolean rareCheck = true; 	

		int rare = addInt("Skriv in hur ovanligt albumet är (1-5): ");
		if(rare >0 && rare <=5){
			rareCheck = true;

		}else if(!rareCheck){
			System.out.println("Det måste vara ett värde mellan 1-5, var god försök igen.");
			addRare();	
		}//else if
		return rare;
	}//addRare

	private void addMp3(){
		String format = "mp3";
		boolean rateCheck = true;
		System.out.println("Här lägger du till album i ditt Mediabibliotek!");

		String artistName = addString("Skriv in artistnamn: ");
		String albumName = addString("Skriv in albumnamn: ");
		int year = addInt("Ange releaseår: ");
		String genre = addString("Skriv in genre: ");
		String bitRate = addString("Ange bitrate: ");
		String source = addString("Ange källa: ");
		int rare = addRare();
		double rating = addDouble("Ange betyg: ");


		if(rating >0 && rating <= 5){

			Mp3 neo = new Mp3(artistName, albumName, year, genre, format, source, bitRate, rare, rating);
			allAlbums.add(neo);

			rateCheck = true;
			menu();

		}else if(!rateCheck){
			System.out.println("Ett album måste ha ett betyg mellan 1-5, var god börja om från början!");

		}//if
	}//addMp3

	private void addFlac(){
		String format = "FLAC";
		boolean rateCheck = true;

		String artistName = addString("Skriv in artistnamn: ");
		String albumName = addString("Skriv in albumnamn: ");
		int year = addInt("Ange releaseår: ");
		String genre = addString("Skriv in genre: ");
		String source = addString("Skriv in källa: ");
		int size = addInt("Skriv in storlek (mb): ");
		int rare = addRare();
		double rating = addDouble("Ange betyg: ");


		if(rating >0 && rating <= 5){

			Flac neo = new Flac(artistName, albumName, year, genre, format, source, size, rare, rating);
			allAlbums.add(neo);
			rateCheck = true;

		}else if(!rateCheck){
			System.out.println("Ett album måste ha ett betyg mellan 1-5, var god börja om från början!");
			addFlac();
		}//if
	}//addFlac

	private void addCompactDisc(){
		String format = "CD";
		boolean rateCheck = true;

		String artistName = addString("Skriv in artistnamn: ");
		String albumName = addString("Skriv in albumnamn: ");
		int year = addInt("Ange releaseår: ");
		String genre = addString("Skriv in genre: ");
		String release = addString("Skriv in realesenr: ");
		int condition = addInt("Ange skick (1-5): ");
		int rare = addRare();
		double rating = addDouble("Ange betyg: ");

		if(rating >0 && rating <= 5){

			CompactDisc neo = new CompactDisc (artistName, albumName, year, genre, format, release, condition, rare, rating);
			allAlbums.add(neo);
			rateCheck = true;

		}else if(!rateCheck) {
			System.out.println("Ett album måste ha ett betyg mellan 1-5, var god börja om från början!");
			addCompactDisc();
		}//if 	
	}//addCompactDisc

	private void addVinyl(){
		String format = "Vinyl";
		boolean rateCheck = true;

		String artistName = addString("Skriv in artistnamn: ");
		String albumName = addString("Skriv in albumnamn: ");
		int year = addInt("Ange releaseår: ");
		String genre = addString("Skriv in genre: ");
		String release = addString("Skriv in realesenr: ");
		int condition = addInt("Ange skick (1-5): ");
		int rare = addRare();
		double rating = addDouble("Ange betyg: ");



		if(rating >0 && rating <= 5){

			VinylScratch neo = new VinylScratch (artistName, albumName, year, genre, format, release, condition, rare, rating);
			allAlbums.add(neo);
			rateCheck = true;

		}else if (!rateCheck) {
			System.out.println("Ett album måste ha ett betyg mellan 1-5, var god börja om från början!");
			addVinyl();
		}//else
	}//addVinyl



	private void list(){

		System.out.println("Hur vill söka?");

		int command = addInt("1. efter artist\n2. efter genre \n3. efter betyg \n4. Efter album \n5. Lista alla \n6. Gå tillbaka till huvudmenyn ");

		switch(command){
		case 1:
			listArtist();
			break;

		case 2:
			listGenre();
			break;

		case 3:
			listRating();
			break;

		case 4:
			listAlbum();
			break;

		case 5:
			listAll();
			break;

		case 6:
			menu();
			break;

		}//Switch

	}//ListAlbum


	private void listArtist(){
		boolean done = true;

		String artName = addString("Vilken artist vill du söka efter?");



		for(MusicAlbum musicAlbum: allAlbums){
			if (musicAlbum.getArtistName().equalsIgnoreCase(artName)){
				System.out.println(musicAlbum);


				done = true;

			}else{
				System.out.println("Artisten du sökte efter fanns inte i biblioteket, var god försök igen");
				list(); 

			}//else   
		}//for
	}//ListArtist

	private void listGenre(){
		boolean done = true;

		String genName = addString("Skriv in genren du vill söka efter: ");


		for(MusicAlbum musicAlbum: allAlbums){

			if(musicAlbum.getGenreName().equalsIgnoreCase(genName)){
				System.out.println(musicAlbum);

				done = true; 

			}else{
				System.out.println("Genren du sökte efter finns inte i biblioteket, var god att försök igen");
				list();

			}//else  
		}//for 
	}//ListGenre

	private void listRating(){
		boolean done = true;
		
		int rating = addInt("Skriv in vilket betyg du vill söka efter: ");
		

		for(MusicAlbum musicAlbum: allAlbums){
			if(Math.round(musicAlbum.getRating()) == rating){
				System.out.print(musicAlbum);

				done = true;

			}else{
				System.out.println("Det finns inga album i mediabiblioteket med det betyget");
				list();

			}//else
		}//for
	}//ListRating

	private void listAlbum(){
		boolean done = true;

		String album = addString("Skriv in vilket album du vill söka efter: ");

		for(MusicAlbum musicAlbum: allAlbums){

			if(musicAlbum.getAlbumName().equalsIgnoreCase(album)){
				System.out.print(musicAlbum);
				done = true;

			}else{
				System.out.println("Det finns inget album med det namnet i samlingen");
				list();	
			}//else
		}//for 
	}//ListAlbum


	
	private void listAll(){
		
		for (MusicAlbum musicAlbum: allAlbums){
			System.out.print(musicAlbum);
		}//for
	}//listAll

	private  void changeRating(){
		boolean done = true;

		String change = addString("Ange album: ");

		MusicAlbum album = null;

		for(MusicAlbum musicalbum: allAlbums){
			if(musicalbum.getAlbumName().equalsIgnoreCase(change)){
				album = musicalbum;

				if(album !=null){
					double x = addDouble("Ange nytt betyg: ");
					if(x > 0 && x <= 5){
						album.changeRating(x);

						System.out.println("Betyget har ändrats till: "+x);
						done = true;
					}

					else if(!done){
						System.out.println("Du kan bara ge ett betyg mellan 1-5, var god försök igen.");
						changeRating();
					}
				}
				else if(album == null){
					System.out.println("Det valda albumet fanns ej i listan, var god försök igen.");
				}//else
			}//if
		}//for
	}//changeRating

	private void deleteAlbum(){
		boolean done = true;

		String delAlbum = addString("Skriv in det album som du vill radera: ");


		for(int x = 0; x < allAlbums.size() ; x++){

			if(allAlbums.get(x).getAlbumName().equalsIgnoreCase(delAlbum)){
				allAlbums.remove(x);
				done = true;
				System.out.println("Albumet är nu borttaget");
				break;
			}else if(!done){

				System.out.print("Det finns inget album med det namnet");
				deleteAlbum();
			}//else

		}//for
	} //DeleteAlbum

	private void quit(){
		try{
			FileOutputStream file = new FileOutputStream("Media.obj");
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(allAlbums);
			System.exit(0);
		}
		catch (IOException e){ System.exit(1); }//catch
		
	}//Quit

}//class



