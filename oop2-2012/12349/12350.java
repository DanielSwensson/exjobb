
import java.io.Serializable;

/**
 *
 * @author Erik Welander
 * @version 2012-02-04
 * Encoding: UTF-8
 * IDE: Netbeans 7.2.1
 */
public class Device extends Thing implements Serializable{
    private int condition;
    
    Device(String name, int value, int condition){
        setName(name);
        newValue(value, condition);
    }
    public void newValue(int value, int condition){
        this.condition = condition;
        float fValue = value*((float)condition/10);
        super.setValue((int)fValue);
    }
    @Override
    public void setName(String name){
        super.setName(name);
    }
    public int getCondition(){
        return condition;
    }
    public void setCondition(int condition){
        this.condition = condition;
    }
}
