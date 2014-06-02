
package prylregister;


public class Smycken extends Pryl {

    private String jewelType = null;
    private String metal = null;
    private int jewel = 0;
    private String specType = null;
    
    Smycken (String jewelType, String metal, int jewel, String specType) {
        
        this.jewelType = jewelType;
        this.metal = metal ;
        this.jewel = jewel ;
        this.specType = specType;
    }
    
    public double value(){
        
        if(metal.equalsIgnoreCase("Gold")){
            value=(2000+(500*jewel));
        }
        else if (metal.equalsIgnoreCase("Silver")){
            value=(700+(500*jewel));
        }
       
        return value;
        
    } 
    
    public String getText(){

        return ("TYPE OF JEWELRY: " + jewelType + "\nMATERIAL: " + metal + "\nNUMBER OF GEMS: " + jewel + "\nSUBTYPE: " 
                + specType + "\nVALUE: " + value()+"\n\n");
    
    }
 
    
}