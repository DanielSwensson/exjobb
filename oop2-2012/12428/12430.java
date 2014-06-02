import java.io.*;

public class OppnaFil extends SkapaFil{ //OppnaFil �rver det mesta fr�n SkapaFil.
	
	public void filNamn(){ //Skillnaden ligger i annan utskriftstext.
		System.out.println("Vilken fil vill du �ppna?");
		setFilNamn(userInput.nextLine());
	}
	
	//�ppnar filen med namnet som finns i str�ngen filensnamn.
	//G�r igenom hela texten rad f�r rad och l�gger till varje rad i utskrift som sedan skrivs ut. 			
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
			System.out.println("N�got blev fel");
			System.exit(0);
	   
		}
		System.out.println(utskrift.toString());
	}
}
