import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Highscore {
        // En array av typen Spelare initieras f�r att jobba med Po�ngListan
        private ArrayList<Spelare> Po�ngLista;
        private ArrayList<String> highScoreLista;

        //Vart highscore sparas
        private static final String HIGHSCORE_FILE = "bin/Highscore1.txt";
        private String message = "Highscore Laddat!";
        
        public Highscore() {
                //Po�nglistan skapas
                Po�ngLista = new ArrayList<Spelare>();
        }
        public String getHighscorePoints() { //funktion som laddar in highscore textfilen samt sorterar
           loadScoreFile();
           String[] stockArr = new String[highScoreLista.size()];
           String[] arr = highScoreLista.toArray(stockArr);
     	   for(String z : arr){
     	   System.out.println(z);
     	   }
		return message;
    }
        public void laggTillSpelare(String n, int h) {
            loadScoreFile();
            Po�ngLista.add(new Spelare(n, h));
            updateScoreFile();
            Po�ngLista.clear();
}
        public void laggTillEasySpelare(String n, int h, String status) {
            loadScoreFile();
            Po�ngLista.add(new SpelareEasyMode(n, h, status));
            updateScoreFile();
            Po�ngLista.clear(); //valde att cleara arrayListen d� jag endast vill printa en person �t g�ngen
}

        public void loadScoreFile() { //funktionen laddar highscore arrayen och s�tter in allt som finns i .t
            try {
            	 highScoreLista = new ArrayList<String>();
            	 Scanner fileIn = new Scanner(new File(HIGHSCORE_FILE)); //h�r h�mtas ordlistan
            	 while(fileIn.hasNext()){
                  highScoreLista.add(fileIn.nextLine());
            		 }
            	 fileIn.close();
            } catch (IOException e){
                e.printStackTrace();
           }
}

                    public void updateScoreFile() { //precis som loadScoreFile fast ist�llet f�r l�sning skriver den
                        try {
                       PrintWriter out = new PrintWriter(new FileWriter(HIGHSCORE_FILE,true)); ;
                        	out.println(Po�ngLista);
                        	out.close();   
                        	
                        } catch (IOException e){
                            e.printStackTrace();
                       }
}
}
