
import java.io.Serializable;
/**
 *
 * @author Erik Welander
 * @version 2012-02-04
 * Encoding: UTF-8
 * IDE: Netbeans 7.2.1
 */
public abstract class Thing implements Serializable{
    private String name;
    private int value;
    Thing(){}
    
    public void setValue(int value){
        this.value = value;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getValue(){
        return value;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return name+" "+value;
    }
}