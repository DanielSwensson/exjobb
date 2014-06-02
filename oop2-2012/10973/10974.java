/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Tor Brambeck
 */
public class Smycke extends Prylar{
    private int stone;
    private String material;
    private int value;
    
    public Smycke(String name, int stone, String material){
        super(name);
        this.stone = stone;
        this.material = material;
    }
    
    public int stones(){
        return stone;
    }
    
    public String material(){
        return material;
    }
    
    public double getValue(){
        if(material.equals("Guld")){
            value = 2000;
        }
        else if(material.equals("Silver")){
            value = 700;
        }
        return value + (500*stone);
    }
    
    public String toString(){
        return super.getName() + " " + getValue();
    }        
}
