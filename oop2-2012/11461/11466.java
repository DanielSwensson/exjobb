public class Pryl{
    protected String namn;
    
    protected Pryl(String namn){
        this.namn = namn;
    }
       public String toString(){
        return "Typ: "+namn;
    }
       public double hämtaVärde(){
           return 0.0;
       }
       public String hämtaNamn(){
           return namn;
       }
     
    
}