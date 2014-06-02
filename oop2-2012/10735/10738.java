public class Jewelry extends Item{

    private boolean material;
    private int gems;
    private int temp;

    public Jewelry (String name, boolean material, int gems){
        super(name);
        this.material = material;
        this.gems = gems;
        this.temp = temp;

        // if (material == true) = samma sak! :D
        if (material){
            temp = temp + 2000;
        } else {
            temp = temp + 700;
        }


    }

    public double getValue(){
        return temp + gems;
    }

    public String toString(){
        return "Jewelry: " + name + "      Value: " + getValue() + "\n";
    }

}
