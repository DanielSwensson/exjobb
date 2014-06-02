package prylregister;
import java.util.ArrayList;
 
class Person {
   String namn;
   ArrayList<Pryl> prylsamling = new ArrayList<>();
 
   public Person(String n){
       namn = n;
   }   
 
   public String getNamn() {
        return namn;
   }
 
   public String getPryllista() {
        String sak = "";
        for (Pryl pr : prylsamling){
            sak += pr + "\n";
        }
        return sak;
   }
 
   public int getTotaltVärde(){
       int värdeTotal = 0;
       for (Pryl pr : prylsamling){
           värdeTotal += pr.värde();
       }
       return värdeTotal;
   }
 
   public void krasch(){
       for (Pryl pr : prylsamling){
           if (pr instanceof Aktie){
                ((Aktie)pr).setPris(0);
           }
       }
   }
 
   public String toString(){
        return namn;
    }
}