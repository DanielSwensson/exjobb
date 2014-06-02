
public class TechnicalDevice extends Valuable {
    private String deviceType;
    private int startValue;
    private double condition;
    
    public TechnicalDevice(String deviceType, int startValue, int condition){
        this.deviceType = deviceType;
        this.startValue = startValue;
        this.condition = (condition / 10.0);
    }
    
    public double getValue(){
        value = (startValue * condition);
        return value;
    }
    
    //public void setCondition(int condition){
        //this.condition = condition;
    //}
    
    public String toString() {
        return deviceType + " " + getValue();
    }
}
