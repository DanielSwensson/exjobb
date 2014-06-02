public class Device extends Item{

    private double devicePrice;
    private double quality;

    public Device (String name, int devicePrice, double quality){
        super(name);
        this.devicePrice = devicePrice;
        this.quality = quality;

    }

    public double getValue(){
        return quality * devicePrice;
    }

    public String toString(){

        return "Device: " + name + "      Value: " + getValue() + "\n";

    }

}
