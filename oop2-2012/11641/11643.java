public class Apparat extends Pryl
{
	private double inköpspris;
	private int slitage;

        Apparat(String namn, double inköpspris, int slitage)
        {
            super(namn);
            this.inköpspris = inköpspris;
            this.slitage = slitage;
        }

	public double getVärde()
	{
            return inköpspris*(slitage/10.0);
	}

        public String toString()
	{
            return getNamn() +"\t"+ getVärde();
	}
}