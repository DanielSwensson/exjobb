import java.util.Scanner;

public class Val { //klass som sköter menyvalen
	
	static Scanner userInput = new Scanner(System.in);
	private int trycktVal = 0;

	public Val(){
		System.out.println("Hej och välkommen!\n\n" +
							"Det här programmet har som huvudsyfte att\n" +
							"analysera en text du anger och genom dina\n" +
							"val genomföra olika operationer på texten.\n");
	}

	public int hanteraVal(){
	
		System.out.println("Vad vill du göra?\n\n1 - Skapa och spara en ny fil med text\n2 - Öppna en befintlig text\n" +
				"3 - Se frekvensen av varje förekommande bokstav i texten\n4 - Välja text och avgöra dess språk\n"
				+ "5 - Avsluta");
	
		 try { //Detta har lagts till för att lösa problemet med hantering av inmatning av oväntade tecken.
			    trycktVal = Integer.parseInt(userInput.next());
			    return trycktVal;
			}
			catch(NumberFormatException nFE) {
			    return 0;
			}

	}
}
