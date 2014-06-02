package huvudprogram;

public class Smycke extends Pryl {

    private int adelsten;
    private String guld;

    public Smycke(String namn, String guld, int adelsten) {
        super(namn);

        this.namn = namn;
        this.adelsten = adelsten;
        this.guld = guld;

    }

    public int getAdelsten() {
        return adelsten;
    }

    @Override
    public int getVarde() {
        if (guld.equalsIgnoreCase("ja")) {
            return 2000 + 500 * getAdelsten();
        } else {
            return 700 + 500 * getAdelsten();
        }
    }

    @Override
    public String toString() {
        return super.toString() + ":" + "     " + getVarde();
    }
}
