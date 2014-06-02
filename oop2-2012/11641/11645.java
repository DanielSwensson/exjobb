import java.util.ArrayList;

public class Person
{
	ArrayList<Pryl> samling = new ArrayList<Pryl>();
	private String namn;
        private int sammanlagtVärde;

	public Person(String namn)
	{
            this.namn = namn;
	}

	public String getNamn()
	{
            return namn;
	}

        public int getSammanlagtVärde()
        {
            sammanlagtVärde = 0;
            for (Pryl x : samling)
            {
                sammanlagtVärde += x.getVärde();
            }
            return sammanlagtVärde;
        }

        public void addPryl(Pryl x)
	{
            samling.add(x);
	}

        public void börsKrasch()
        {
            for (Pryl x : samling)
            {
                if (x instanceof Aktie)
                    {
                        ((Aktie)x).setPris();
                    }
            }
        }

        public String toString()
	{
            return namn +" "+ getSammanlagtVärde();
	}



}


