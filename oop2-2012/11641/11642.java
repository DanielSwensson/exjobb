public class Aktie extends Pryl
{
	private int antal;
	public double pris;

        Aktie(String namn, int antal, double pris)
        {
            super(namn);
            this.antal = antal;
            this.pris = pris;
        }

	public double getVärde()
	{
            return antal*pris;
	}

        public void setPris()
        {
            pris = 0;
        }

        public String toString()
	{
            return getNamn() +"\t"+ getVärde();
	}
}

