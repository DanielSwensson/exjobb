import java.io.*;

public class OppnaFil extends SkapaFil{ //OppnaFil ärver det mesta från SkapaFil.
	
	public void filNamn(){ //Skillnaden ligger i annan utskriftstext.
		System.out.println("Vilken fil vill du öppna?");
		setFilNamn(userInput.nextLine());
	}
	
	//öppnar filen med namnet som finns i strängen filensnamn.
	//Går igenom hela texten rad för rad och lägger till varje rad i utskrift som sedan skrivs ut. 			
	public void skrivUt(){ 
		StringBuilder utskrift = new StringBuilder();
		String text = null;
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(getFilNamn()));
			while ((text = buffer.readLine()) != null) {
				utskrift.append(text);
			}
			buffer.close();
		}
		catch(IOException e){
			System.out.println("Något blev fel");
			System.exit(0);
	   
		}
		System.out.println(utskrift.toString());
	}
}
