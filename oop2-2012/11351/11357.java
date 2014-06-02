package prylregister;
 
public class Smycke extends Pryl {
 
   private int ädelstenAntal;
   private boolean avGuld;
 
   public Smycke(String na, int ädA, boolean aG){
       super(na);
       ädelstenAntal = ädA; 
       avGuld = aG;
   }
 
   public int värde(){
   int smyckeVärde;
       if (avGuld == true){
           smyckeVärde = 2000;
       }else{
           smyckeVärde = 700; //av silver
       }
       return smyckeVärde+(ädelstenAntal*500);
   }
 
   public String toString(){
       String str = namn+" (smycke, "+värde()+" kr)"; 
       return str;
   }
 
}  