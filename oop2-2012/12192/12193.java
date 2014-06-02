import java.io.File;
import java.util.*;


//* Programmet gjort av: Goran Stepanovic *//

public class Gissa_Ord  {

	// intierar variabler
    private int intGissaord;
    private ArrayList<String> ordLista;
    private boolean Start;
    private boolean LOOP;
    private int MAX_GUESSES = 15;
    int [] guesses = new int[MAX_GUESSES];
    char [] gissningar = new char[MAX_GUESSES];
    int guessCount = 0;
    char guessedChar = 0;
    boolean gissatRätt = false;
    int antalRätt = 0;
    int antalPoäng = 0;
    int pointHolder;
    int visaChar = 0;
    Highscore laggTill = new Highscore();
    Scanner input = new Scanner(System.in);  // Gör tangentbordet tillgängligt. 
    private boolean easyMode = false;
    private int gameRound = 1;
    
public static void main(String[] args)  {
    new Gissa_Ord();
    }

    
        public Gissa_Ord()  {
            System.out.println('\n' + "** Information: Spelaren kan väja 2 svårighetsgrader. EASYMODE ger spelare" + '\n' +
            		"30 gissningar och NORMALMODE ger spelare 11 gissningar" + '\n' +
            		"på sig till och gissa fram alla bokstäver i ordet." + '\n' +
            		"En gissning betyder att man skriver in en bokstav, t.ex. A, E, D" + '\n' + 
            		"Fel gissningar kommer att lagras och visas upp i konsolen." + '\n' +
            		"Rätt gissning ger +2 poäng och fel gissning ger -1 poäng." + '\n' + 
            		"Lycka till! **" + '\n');
            
            textFil(); //kallar på textFil() OBS! Längre ner.
            String helaOrdet = ordLista.get(intGissaord); //får ett slumpmässigt genererat ord.
            char [] rätt = helaOrdet.toCharArray();   //rätt blir en char av arrayer. 
            char [] replacer = new char[helaOrdet.length()];
            
            for (int i = 0; i < helaOrdet.length(); i++)   //kollar ordets längd och använder replacer[i] för att byte ut bokstäver mot *
            {
            replacer[i] = '*';
            }
            
           
            while(!LOOP) {
           int system=0;
            	System.out.println("Tryck 1 för att spela spel[EASYMODE]" + '\n' +
            			           "Tryck 2 för att spela spel[NORMALMODE]" + '\n'+
                                   "Tryck 3 för att lista highscore" + '\n' +
                                   "Tryck 4 för att stänga av");
            
                 try{
                system = input.nextInt();
                 }
                 catch(InputMismatchException e){
                	 System.out.println("Var vänlig och ange mellan siffrorna 1-4" + '\n');
                	 input.next();
                 }
                
            	
            	switch(system){
            	case 1:
                MAX_GUESSES = 30;	//ändrar antal gissningar
                easyMode = true; //aktiverar easymode
                guesses = new int[MAX_GUESSES];
                gissningar = new char[MAX_GUESSES];
            	case 2:	
                input.nextLine();
            	while(!Start) {
            	if(antalRätt==helaOrdet.length()) { //Om hela ordet bli gissat sker det här
            		System.out.println('\n' + "Du gissade alla bokstäver rätt! Ordet var: " + helaOrdet + '\n' + "Du klara omgång: " 
            	                       + gameRound++ +"!" + '\n' + "Tryck på antingen 1 eller 2 för att spela igen!" + '\n');
            		MAX_GUESSES = 15; //sätter tillbaka till normal mode
                    guesses = new int[MAX_GUESSES];
                    gissningar = new char[MAX_GUESSES];
                    easyMode = false;
            		guessCount = 0;
                    guessedChar = 0;
                    antalRätt = 0;
                    antalPoäng = 0;
                    visaChar = 0;
                    textFil();
                    helaOrdet = ordLista.get(intGissaord); /* reseta det nödvändiga behåller allt från pointHolder */
                    rätt = helaOrdet.toCharArray(); 
                    replacer = new char[helaOrdet.length()];
                    for (int i = 0; i < helaOrdet.length(); i++)   //kollar ordets längd och använder replacer[i] för att byte ut bokstäver mot *
                    {
                    replacer[i] = '*';
                    }
            		break;
            	}
            	
            	System.out.print('\n' + "Ordet är: ");
            	 for (int i = 0; i < helaOrdet.length(); i++) // här skrivs replacer[i] ut d.v.s. hela ordets längd fast bokstäverna visas *
           	  {
               System.out.print(replacer[i]); 
           	  }	  
            	try {
                System.out.println('\n' + "Ordet är: " + helaOrdet + " ((FUSK))"); //fusk, det här är menat för fusk. Kan användas av lärare för lättare gissning
                
            	System.out.println( '\n' + "Gissa ordet: ");
                char strInput = input.nextLine().toUpperCase().charAt(0); //kollar bara första bokstaven man gissar på och gör om den till stor ifall liten
                guesses[guessCount++] = intGissaord; 
                
                searchFile(strInput, rätt, replacer); // sätter in alla chars in searchFile.
               
                gissningar[visaChar] = strInput; //visar denna gissade bokstaven
                visaChar++; //uppdaterar index för vart nästa bokstav ska hamna
                System.out.print('\n' + "-  Dina gissade bokstäver: ");  //hjälp programmet, håller koll på gissningarna
              
                for(int i = 0;i<MAX_GUESSES;i++){
                	System.out.print(gissningar[i] + " "); //printar ut senast gissade
                	}
               
                if (MAX_GUESSES <= guessCount) {  //gör så att man även kan förlorar, i detta fall när gissningarna tar slut.
                    System.out.println('\n' + "~~ Dina antal gissningar är slut ~~" + '\n' + " ~~ Spelet är slut ~~");
                    System.out.println('\n' + "Ange Namn: "); 
                }
                if(!easyMode && MAX_GUESSES <= guessCount) {  //om man inte kört easymode och förlorat
                    String spelarNamn = input.nextLine();
                    laggTill.laggTillSpelare(spelarNamn, pointHolder);
                    System.out.println(spelarNamn + " du fick "+ pointHolder +" poäng och har lagrats i highscore" + '\n');
                    guessCount = 0;
                    guessedChar = 0;
                    antalRätt = 0;
                    antalPoäng = 0;
                    pointHolder = 0; /* nollsätter allt för nästa spelomgång*/
                    visaChar = 0;
                    textFil();
                    helaOrdet = ordLista.get(intGissaord);
                    rätt = helaOrdet.toCharArray(); 
                    replacer = new char[helaOrdet.length()];
                    for (int i = 0; i < helaOrdet.length(); i++)   //kollar ordets längd och använder replacer[i] för att byte ut bokstäver mot *
                    {
                    replacer[i] = '*';
                    }
                    Start=false;
                    break;
                }
                   if(easyMode && MAX_GUESSES <= guessCount) { //om man kört easymode och förlorat
                	  String spelarNamn = input.nextLine();
                      laggTill.laggTillEasySpelare(spelarNamn, pointHolder, "EASYMODE");
                      System.out.println(spelarNamn + " du fick "+ pointHolder +" poäng och har lagrats i highscore!" + '\n');
                      MAX_GUESSES = 15; //sätter tillbaka till normal mode
                      guesses = new int[MAX_GUESSES];
                      gissningar = new char[MAX_GUESSES];
                      easyMode = false;
                      guessCount = 0;
                      guessedChar = 0;  /* nollsätter allt för nästa spelomgång*/
                      antalRätt = 0;
                      antalPoäng = 0;
                      pointHolder = 0;
                      visaChar = 0;
                      textFil();
                      helaOrdet = ordLista.get(intGissaord);
                      rätt = helaOrdet.toCharArray(); 
                      replacer = new char[helaOrdet.length()];
                      for (int i = 0; i < helaOrdet.length(); i++)   //kollar ordets längd och använder replacer[i] för att byte ut bokstäver mot *
                      {
                      replacer[i] = '*';
                      }
                      Start=false;
                      break;
                   }
            	}
                    catch(Exception e) {  //fångar expection som kan framkomma och stänga av programmet.
                     
                        System.out.println("Fel meddelande! " + '\n' + e.getMessage() + '\n' + 
                        		"Problemet som kan ha orsakat det här är att du tryckt in Enter knappen!" + '\n' + 
                        		"Undvik det för att slippa fel meddelandet igen, tack!");

                    }
            	}
            	break;
            	case 3:
            	      System.out.println(laggTill.getHighscorePoints());
            	      System.out.println('\n' + "Väntar.. Ange kommando: ");
            	      break;
            	
            	case 4:
            		System.out.println("Välkommen åter!");
            		System.exit(0);
            		break;
            	}
            }
            }
            
           
             
            
        
        private void searchFile(char strInput, char [] rätt, char [] replacer) {
            try{ //används om man förmodar exception
            
            	gissatRätt = false;
                for(int i=0;i<rätt.length;i++){  //för hela ordets längd
                if(strInput == rätt[i]) {       // ifall användarens inmatning är likamed någon bokstav..
                	gissatRätt = true;
                	rätt[i]=guessedChar; // gör det inte möjligt för användaren att spamma en och samma bokstav
                	replacer[i] = strInput;
                	antalRätt++;
                	antalPoäng=+2; //öker +2 i poäng
                	pointHolder= pointHolder+antalPoäng;
                 break;//måste använda break p.g.a. ifall vi har ett ord med indentiska bokstäver vill vi bara avslöja ett och hoppa ut
                }
                }
                if(gissatRätt){  //matar ut ifall rätt gissad bokstav
                	System.out.println('\n' +"Du gissade rätt!" + "\n" + "Gissad bokstav: " + strInput);
                	System.out.println("Poäng just nu: " + pointHolder);
             
                }
                   else {  //annars matas detta ut
                	 pointHolder--;
                	 System.out.println("Du gissade fel!");
                	 System.out.println("Poäng just nu: " + pointHolder);
                     System.out.println("Du gissade bokstaven: " + strInput);
                     System.out.println("Du har " + (MAX_GUESSES - guessCount) + " gissningar kvar.");
                }
                
               
                
            }
            
                //fångar exception som kan framkomma och stänga av programmet
                	catch (StringIndexOutOfBoundsException e) {
                        e.printStackTrace();
               
                }
            
                }
        
                
                private void textFil()  {
                    try { //används om man förmodar expections
                    	
                        ordLista = new ArrayList<String>();  //deklarerar ordlistan till en array list sträng för praktiska skäll.
                        Scanner fileIn = new Scanner(new File("bin/Ord_Lista.txt")); //ÄNDRA HÄR!
                        while (fileIn.hasNext())
                        ordLista.add(fileIn.nextLine());
                        fileIn.close();
                        intGissaord = random(ordLista.size()); //använder min egna deklarade random som gör det möjligt för mig att slumpa ut ord från ordlistan.
                       
                           {
                            
                           }
            
                
                }
                        catch(Exception e) {  //fångar expection som kan framkomma och stänga av programmet.
                        e.printStackTrace();
                        }
                        }
       
                        private int random(int D) {  // deklarerar en egen random som är passande, rand.nextInt i detta fall.
                            Random rand = new Random();
                            int i = rand.nextInt(D);
                            return i;
                        }          
}