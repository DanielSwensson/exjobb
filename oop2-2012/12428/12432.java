import java.io.*;
import java.util.Scanner;

public class SkapaFil {

	public static Scanner userInput = new Scanner(System.in);
	private String filensNamn;
	private String texten;
	
	public SkapaFil(){
		filensNamn = "";
	}
	
	public void setFilNamn(String fil){
		filensNamn = fil;
	}
	
	public String getFilNamn(){
		return filensNamn;
	}
	
	public void setTexten(String text){
		texten = text;
	}
	
	public String getTexten(){
		return texten;
	}
	
	public void filNamn(){
		System.out.println("Vad vill du döpa din fil till?");
		
		setFilNamn(userInput.nextLine());	
	}
	
	public void skrivText(){
		System.out.println("Skriv din text, tryck enter när du är klar");
		setTexten(userInput.nextLine()); //texten sätts till strängen texten.
	}
	
	public void enFil(){ //strängen texten skrivs till en fil och sparas med namnet som finns i strängen filensnamn.
		
		try {
			Writer filen = new BufferedWriter(new FileWriter(filensNamn)); 
			filen.write(texten); 
			filen.close();
		}
	
		catch(IOException e){
			System.out.println("Något blev fel");
			System.exit(0);
		}
	
	}
	
}
