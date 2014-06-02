abstract public class Pryl
{
	private String namn;

        Pryl(String namn)
        {
            this.namn = namn;
        }

        public String getNamn()
        {
            return namn;
        }

        abstract public double getVärde();

        public String toString()
        {
		return getNamn() +"\t"+ getVärde();
        }

}

