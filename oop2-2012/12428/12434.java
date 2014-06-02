import java.util.Scanner;

public class Val { //klass som sk�ter menyvalen
	
	static Scanner userInput = new Scanner(System.in);
	private int trycktVal = 0;

	public Val(){
		System.out.println("Hej och v�lkommen!\n\n" +
							"Det h�r programmet har som huvudsyfte att\n" +
							"analysera en text du anger och genom dina\n" +
							"val genomf�ra olika operationer p� texten.\n");
	}

	public int hanteraVal(){
	
		System.out.println("Vad vill du g�ra?\n\n1 - Skapa och spara en ny fil med text\n2 - �ppna en befintlig text\n" +
				"3 - Se frekvensen av varje f�rekommande bokstav i texten\n4 - V�lja text och avg�ra dess spr�k\n"
				+ "5 - Avsluta");
	
		 try { //Detta har lagts till f�r att l�sa problemet med hantering av inmatning av ov�ntade tecken.
			    trycktVal = Integer.parseInt(userInput.next());
			    return trycktVal;
			}
			catch(NumberFormatException nFE) {
			    return 0;
			}

	}
}
