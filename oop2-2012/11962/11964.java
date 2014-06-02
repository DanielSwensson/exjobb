public class Device extends Item {

    private int wearAndTear; //slitage
    private int devicePrice;

    public Device(String name, int wearAndTear, int devicePrice) {
        super(name);
        this.wearAndTear = wearAndTear;
        this.devicePrice = devicePrice;
    }

    public int getWearAndTear() {
        return wearAndTear;
    }

    public void setWearAndTear(int wearAndTear) {
        this.wearAndTear = wearAndTear;
    }

    public int getValue() {
        float percentage = wearAndTear / 10.0f; //säger att det är en float inte double. 
        return (int) (getDevicePrice() * percentage); //omcastning. från float till int, färre decimaler.

    }

    public int getDevicePrice() {
        return devicePrice;
    }

    public void setDevicePrice(int devicePrice) {
        this.devicePrice = devicePrice;
    }
}
