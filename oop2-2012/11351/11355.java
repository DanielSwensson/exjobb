package prylregister;
 
abstract class Pryl {
   protected String namn;
   protected int värde;
 
   abstract public int värde(); 
 
   public Pryl(String na){ 
       namn = na;
   }
 
   public String toString(){
        return namn;
    }
 
}
