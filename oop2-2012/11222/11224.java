package huvudprogram;

import java.util.Random;

public class Apparat extends Pryl {

    Random rand = new Random();
    private int inkopspris;
    private int slitage;

    public Apparat(String namn, int inkopspris, int slitage) {
        super(namn);

        this.inkopspris = inkopspris;
        this.slitage = slitage;

        if (slitage > 10) {
            this.slitage = 10;
        } else if (slitage < 1) {
            this.slitage = 1;
        }
    }

    public int getInkopspris() {
        return inkopspris;
    }

    public int getSlitage() {
        return slitage;
    }

    @Override
    public int getVarde() {
        return (int) (getSlitage() * 0.1 * getInkopspris());
    }

    @Override
    public String toString() {
        return super.toString() + ":" + "     " + getVarde();
    }
}
