public class Smycke extends Pryl
{
	private double ädelstenar;
	private String material;

        Smycke(String namn, double ädelstenar, String material)
        {
            super(namn);
            this.ädelstenar = ädelstenar;
            this.material = material;
        }

	public double getVärde()
	{
            if ("ja".equalsIgnoreCase(material))//Vi frågar om smycket är av guld, så Ja = Guld, allt annat är silver
            {
                return 2000+(500*ädelstenar);
            } else return 700+(500*ädelstenar);
	}
	
        public String toString()
	{
            return getNamn() +"\t"+ getVärde();
	}

}