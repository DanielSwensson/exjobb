package huvudprogram;

public class Aktie extends Pryl {

    private int antal;
    private int pris;

    public Aktie(String namn, int pris, int antal) {
        super(namn);
        this.antal = antal;
        this.pris = pris;

    }

    public int getAntal() {
        return antal;
    }

    public int getPris() {
        return pris;
    }

    @Override
    public int getVarde() {
        return getAntal() * getPris();
    }

    @Override
    public String toString() {
        return super.toString() + ":" + "     " + getVarde();
    }

    public void getKrasch() {
        pris = 0;
    }
}
