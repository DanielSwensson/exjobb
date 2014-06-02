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
    boolean gissatR�tt = false;
    int antalR�tt = 0;
    int antalPo�ng = 0;
    int pointHolder;
    int visaChar = 0;
    Highscore laggTill = new Highscore();
    Scanner input = new Scanner(System.in);  // G�r tangentbordet tillg�ngligt. 
    private boolean easyMode = false;
    private int gameRound = 1;
    
public static void main(String[] args)  {
    new Gissa_Ord();
    }

    
        public Gissa_Ord()  {
            System.out.println('\n' + "** Information: Spelaren kan v�ja 2 sv�righetsgrader. EASYMODE ger spelare" + '\n' +
            		"30 gissningar och NORMALMODE ger spelare 11 gissningar" + '\n' +
            		"p� sig till och gissa fram alla bokst�ver i ordet." + '\n' +
            		"En gissning betyder att man skriver in en bokstav, t.ex. A, E, D" + '\n' + 
            		"Fel gissningar kommer att lagras och visas upp i konsolen." + '\n' +
            		"R�tt gissning ger +2 po�ng och fel gissning ger -1 po�ng." + '\n' + 
            		"Lycka till! **" + '\n');
            
            textFil(); //kallar p� textFil() OBS! L�ngre ner.
            String helaOrdet = ordLista.get(intGissaord); //f�r ett slumpm�ssigt genererat ord.
            char [] r�tt = helaOrdet.toCharArray();   //r�tt blir en char av arrayer. 
            char [] replacer = new char[helaOrdet.length()];
            
            for (int i = 0; i < helaOrdet.length(); i++)   //kollar ordets l�ngd och anv�nder replacer[i] f�r att byte ut bokst�ver mot *
            {
            replacer[i] = '*';
            }
            
           
            while(!LOOP) {
           int system=0;
            	System.out.println("Tryck 1 f�r att spela spel[EASYMODE]" + '\n' +
            			           "Tryck 2 f�r att spela spel[NORMALMODE]" + '\n'+
                                   "Tryck 3 f�r att lista highscore" + '\n' +
                                   "Tryck 4 f�r att st�nga av");
            
                 try{
                system = input.nextInt();
                 }
                 catch(InputMismatchException e){
                	 System.out.println("Var v�nlig och ange mellan siffrorna 1-4" + '\n');
                	 input.next();
                 }
                
            	
            	switch(system){
            	case 1:
                MAX_GUESSES = 30;	//�ndrar antal gissningar
                easyMode = true; //aktiverar easymode
                guesses = new int[MAX_GUESSES];
                gissningar = new char[MAX_GUESSES];
            	case 2:	
                input.nextLine();
            	while(!Start) {
            	if(antalR�tt==helaOrdet.length()) { //Om hela ordet bli gissat sker det h�r
            		System.out.println('\n' + "Du gissade alla bokst�ver r�tt! Ordet var: " + helaOrdet + '\n' + "Du klara omg�ng: " 
            	                       + gameRound++ +"!" + '\n' + "Tryck p� antingen 1 eller 2 f�r att spela igen!" + '\n');
            		MAX_GUESSES = 15; //s�tter tillbaka till normal mode
                    guesses = new int[MAX_GUESSES];
                    gissningar = new char[MAX_GUESSES];
                    easyMode = false;
            		guessCount = 0;
                    guessedChar = 0;
                    antalR�tt = 0;
                    antalPo�ng = 0;
                    visaChar = 0;
                    textFil();
                    helaOrdet = ordLista.get(intGissaord); /* reseta det n�dv�ndiga beh�ller allt fr�n pointHolder */
                    r�tt = helaOrdet.toCharArray(); 
                    replacer = new char[helaOrdet.length()];
                    for (int i = 0; i < helaOrdet.length(); i++)   //kollar ordets l�ngd och anv�nder replacer[i] f�r att byte ut bokst�ver mot *
                    {
                    replacer[i] = '*';
                    }
            		break;
            	}
            	
            	System.out.print('\n' + "Ordet �r: ");
            	 for (int i = 0; i < helaOrdet.length(); i++) // h�r skrivs replacer[i] ut d.v.s. hela ordets l�ngd fast bokst�verna visas *
           	  {
               System.out.print(replacer[i]); 
           	  }	  
            	try {
                System.out.println('\n' + "Ordet �r: " + helaOrdet + " ((FUSK))"); //fusk, det h�r �r menat f�r fusk. Kan anv�ndas av l�rare f�r l�ttare gissning
                
            	System.out.println( '\n' + "Gissa ordet: ");
                char strInput = input.nextLine().toUpperCase().charAt(0); //kollar bara f�rsta bokstaven man gissar p� och g�r om den till stor ifall liten
                guesses[guessCount++] = intGissaord; 
                
                searchFile(strInput, r�tt, replacer); // s�tter in alla chars in searchFile.
               
                gissningar[visaChar] = strInput; //visar denna gissade bokstaven
                visaChar++; //uppdaterar index f�r vart n�sta bokstav ska hamna
                System.out.print('\n' + "-  Dina gissade bokst�ver: ");  //hj�lp programmet, h�ller koll p� gissningarna
              
                for(int i = 0;i<MAX_GUESSES;i++){
                	System.out.print(gissningar[i] + " "); //printar ut senast gissade
                	}
               
                if (MAX_GUESSES <= guessCount) {  //g�r s� att man �ven kan f�rlorar, i detta fall n�r gissningarna tar slut.
                    System.out.println('\n' + "~~ Dina antal gissningar �r slut ~~" + '\n' + " ~~ Spelet �r slut ~~");
                    System.out.println('\n' + "Ange Namn: "); 
                }
                if(!easyMode && MAX_GUESSES <= guessCount) {  //om man inte k�rt easymode och f�rlorat
                    String spelarNamn = input.nextLine();
                    laggTill.laggTillSpelare(spelarNamn, pointHolder);
                    System.out.println(spelarNamn + " du fick "+ pointHolder +" po�ng och har lagrats i highscore" + '\n');
                    guessCount = 0;
                    guessedChar = 0;
                    antalR�tt = 0;
                    antalPo�ng = 0;
                    pointHolder = 0; /* nolls�tter allt f�r n�sta spelomg�ng*/
                    visaChar = 0;
                    textFil();
                    helaOrdet = ordLista.get(intGissaord);
                    r�tt = helaOrdet.toCharArray(); 
                    replacer = new char[helaOrdet.length()];
                    for (int i = 0; i < helaOrdet.length(); i++)   //kollar ordets l�ngd och anv�nder replacer[i] f�r att byte ut bokst�ver mot *
                    {
                    replacer[i] = '*';
                    }
                    Start=false;
                    break;
                }
                   if(easyMode && MAX_GUESSES <= guessCount) { //om man k�rt easymode och f�rlorat
                	  String spelarNamn = input.nextLine();
                      laggTill.laggTillEasySpelare(spelarNamn, pointHolder, "EASYMODE");
                      System.out.println(spelarNamn + " du fick "+ pointHolder +" po�ng och har lagrats i highscore!" + '\n');
                      MAX_GUESSES = 15; //s�tter tillbaka till normal mode
                      guesses = new int[MAX_GUESSES];
                      gissningar = new char[MAX_GUESSES];
                      easyMode = false;
                      guessCount = 0;
                      guessedChar = 0;  /* nolls�tter allt f�r n�sta spelomg�ng*/
                      antalR�tt = 0;
                      antalPo�ng = 0;
                      pointHolder = 0;
                      visaChar = 0;
                      textFil();
                      helaOrdet = ordLista.get(intGissaord);
                      r�tt = helaOrdet.toCharArray(); 
                      replacer = new char[helaOrdet.length()];
                      for (int i = 0; i < helaOrdet.length(); i++)   //kollar ordets l�ngd och anv�nder replacer[i] f�r att byte ut bokst�ver mot *
                      {
                      replacer[i] = '*';
                      }
                      Start=false;
                      break;
                   }
            	}
                    catch(Exception e) {  //f�ngar expection som kan framkomma och st�nga av programmet.
                     
                        System.out.println("Fel meddelande! " + '\n' + e.getMessage() + '\n' + 
                        		"Problemet som kan ha orsakat det h�r �r att du tryckt in Enter knappen!" + '\n' + 
                        		"Undvik det f�r att slippa fel meddelandet igen, tack!");

                    }
            	}
            	break;
            	case 3:
            	      System.out.println(laggTill.getHighscorePoints());
            	      System.out.println('\n' + "V�ntar.. Ange kommando: ");
            	      break;
            	
            	case 4:
            		System.out.println("V�lkommen �ter!");
            		System.exit(0);
            		break;
            	}
            }
            }
            
           
             
            
        
        private void searchFile(char strInput, char [] r�tt, char [] replacer) {
            try{ //anv�nds om man f�rmodar exception
            
            	gissatR�tt = false;
                for(int i=0;i<r�tt.length;i++){  //f�r hela ordets l�ngd
                if(strInput == r�tt[i]) {       // ifall anv�ndarens inmatning �r likamed n�gon bokstav..
                	gissatR�tt = true;
                	r�tt[i]=guessedChar; // g�r det inte m�jligt f�r anv�ndaren att spamma en och samma bokstav
                	replacer[i] = strInput;
                	antalR�tt++;
                	antalPo�ng=+2; //�ker +2 i po�ng
                	pointHolder= pointHolder+antalPo�ng;
                 break;//m�ste anv�nda break p.g.a. ifall vi har ett ord med indentiska bokst�ver vill vi bara avsl�ja ett och hoppa ut
                }
                }
                if(gissatR�tt){  //matar ut ifall r�tt gissad bokstav
                	System.out.println('\n' +"Du gissade r�tt!" + "\n" + "Gissad bokstav: " + strInput);
                	System.out.println("Po�ng just nu: " + pointHolder);
             
                }
                   else {  //annars matas detta ut
                	 pointHolder--;
                	 System.out.println("Du gissade fel!");
                	 System.out.println("Po�ng just nu: " + pointHolder);
                     System.out.println("Du gissade bokstaven: " + strInput);
                     System.out.println("Du har " + (MAX_GUESSES - guessCount) + " gissningar kvar.");
                }
                
               
                
            }
            
                //f�ngar exception som kan framkomma och st�nga av programmet
                	catch (StringIndexOutOfBoundsException e) {
                        e.printStackTrace();
               
                }
            
                }
        
                
                private void textFil()  {
                    try { //anv�nds om man f�rmodar expections
                    	
                        ordLista = new ArrayList<String>();  //deklarerar ordlistan till en array list str�ng f�r praktiska sk�ll.
                        Scanner fileIn = new Scanner(new File("bin/Ord_Lista.txt")); //�NDRA H�R!
                        while (fileIn.hasNext())
                        ordLista.add(fileIn.nextLine());
                        fileIn.close();
                        intGissaord = random(ordLista.size()); //anv�nder min egna deklarade random som g�r det m�jligt f�r mig att slumpa ut ord fr�n ordlistan.
                       
                           {
                            
                           }
            
                
                }
                        catch(Exception e) {  //f�ngar expection som kan framkomma och st�nga av programmet.
                        e.printStackTrace();
                        }
                        }
       
                        private int random(int D) {  // deklarerar en egen random som �r passande, rand.nextInt i detta fall.
                            Random rand = new Random();
                            int i = rand.nextInt(D);
                            return i;
                        }          
}