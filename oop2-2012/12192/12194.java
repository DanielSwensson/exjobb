import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Highscore {
        // En array av typen Spelare initieras för att jobba med PoängListan
        private ArrayList<Spelare> PoängLista;
        private ArrayList<String> highScoreLista;

        //Vart highscore sparas
        private static final String HIGHSCORE_FILE = "bin/Highscore1.txt";
        private String message = "Highscore Laddat!";
        
        public Highscore() {
                //Poänglistan skapas
                PoängLista = new ArrayList<Spelare>();
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
            PoängLista.add(new Spelare(n, h));
            updateScoreFile();
            PoängLista.clear();
}
        public void laggTillEasySpelare(String n, int h, String status) {
            loadScoreFile();
            PoängLista.add(new SpelareEasyMode(n, h, status));
            updateScoreFile();
            PoängLista.clear(); //valde att cleara arrayListen då jag endast vill printa en person åt gången
}

        public void loadScoreFile() { //funktionen laddar highscore arrayen och sätter in allt som finns i .t
            try {
            	 highScoreLista = new ArrayList<String>();
            	 Scanner fileIn = new Scanner(new File(HIGHSCORE_FILE)); //här hämtas ordlistan
            	 while(fileIn.hasNext()){
                  highScoreLista.add(fileIn.nextLine());
            		 }
            	 fileIn.close();
            } catch (IOException e){
                e.printStackTrace();
           }
}

                    public void updateScoreFile() { //precis som loadScoreFile fast istället för läsning skriver den
                        try {
                       PrintWriter out = new PrintWriter(new FileWriter(HIGHSCORE_FILE,true)); ;
                        	out.println(PoängLista);
                        	out.close();   
                        	
                        } catch (IOException e){
                            e.printStackTrace();
                       }
}
}
