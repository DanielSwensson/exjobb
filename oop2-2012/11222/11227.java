package huvudprogram;

abstract public class Pryl {

    protected String namn;

    public Pryl(String namn) {
        this.namn = namn;
    }

    public String getNamn() {
        return this.namn;

    }

    public abstract int getVarde();

    @Override
    public String toString() {
        return namn;
    }
}
