
import java.io.Serializable;
/**
 *
 * @author Erik Welander
 * @version 2012-02-04
 * Encoding: UTF-8
 * IDE: Netbeans 7.2.1
 */
public class StockShare extends Thing implements Serializable{
    private int num;

    StockShare(String name, int worth, int num){
        setName(name);
        this.num = num;
        newValue(worth, num);
    }
    public void newValue(int worth, int num){
        this.num = num;
        super.setValue(worth*num);
    }
    public void setName(String name){
        super.setName(name);
    }
    public int getNum(){
        return num;
    }
    public String getName(){
        return super.getName();
    }

    
}
