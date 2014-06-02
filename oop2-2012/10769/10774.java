//subklass till Värdesak
class Smycke extends Värdesak{
		private int ädelstenar = 0;
		private boolean guld;
// konstruktor
	public Smycke(String namn, int ädelstenar, boolean guld){
		super(namn);// super classens konstruktor
		this.ädelstenar = ädelstenar;
		this.guld=guld;
	}
	
	// om smycket är av guld då värde = 2000, annars =700,
    //och med varje ädelsten ökar värde med 500
	
	public int getVärde(){    
		int x=0;              
			if (guld == true)
			x = 2000;
	    else x = 700;
		x += ädelstenar*500;
		return x;
	}
}
