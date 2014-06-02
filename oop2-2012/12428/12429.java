import java.io.*;


public class Frekvens extends SkapaFil{
	
	private int totaltBokstaver;
	public static final int ANTAL_BOKSTAVER = 26;
	public int[] frekvens = new int[ANTAL_BOKSTAVER]; //frekvens av varje bokstav i texten.
	

	public Frekvens(){
		totaltBokstaver = 0;
		frekvens = new int[ANTAL_BOKSTAVER];
	}
	
	public void setTotaltBokstaver(int antalBokstaver){
		totaltBokstaver = antalBokstaver;
	}
	public int getTotaltBokstaver(){
		return totaltBokstaver;
	}
	
	//Enda skillanden är utskriftstexten
	public void filNamn(){
		System.out.println("Vilken fil vill du öppna för att se frevensen av varje bokstav i texten?");
		setFilNamn(userInput.nextLine());
	}
	
	//Metod som returnerar en sträng till huvudprogrammet för vidare användning.
	public String skrivUt(){ 
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
		String valdText = utskrift.toString();
		
		return valdText;
	}
	
	//Räknar ut frekvensen av varje bokstav i texten och skriver ut antalet av varje samt totala antalet bokstäver.
	public void beraknaFrekvens(String enText){
		
		 String strang = enText;
		 if (enText!=""){
			 for (int i=0; i<ANTAL_BOKSTAVER; i++){
				 frekvens[i] = 0;
			 }
		 }
		        for (int i=0; i< strang.length(); i++){
		        	int index;
		            if (strang.charAt(i)>='a' && strang.charAt(i)<='z'){
		            	index = strang.charAt(i) - 'a';
		                frekvens[index]++;
		                totaltBokstaver++;
		            }

		            else if (strang.charAt(i)>='A' && strang.charAt(i)<='Z'){
		            	index = strang.charAt(i) - 'A';
		                frekvens[index]++;
		                totaltBokstaver++;
		            }
		 }
		 
		 System.out.println("Texten du valt har totalt " + totaltBokstaver + " bokstäver\n" +
				 				"och följande bokstavsfördelning: ");
		 System.out.println("\nBokstav\tAntal\n");
		 
		 int j = 0;
		 for (char i='A'; i<='Z'; i++){
		      System.out.println( i + "\t" + frekvens[j]);
		      j++;
		 }
	}
	
	

	
	
	
	
	
	
	
	
	
	
}
