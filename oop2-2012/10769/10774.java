//subklass till V�rdesak
class Smycke extends V�rdesak{
		private int �delstenar = 0;
		private boolean guld;
// konstruktor
	public Smycke(String namn, int �delstenar, boolean guld){
		super(namn);// super classens konstruktor
		this.�delstenar = �delstenar;
		this.guld=guld;
	}
	
	// om smycket �r av guld d� v�rde = 2000, annars =700,
    //och med varje �delsten �kar v�rde med 500
	
	public int getV�rde(){    
		int x=0;              
			if (guld == true)
			x = 2000;
	    else x = 700;
		x += �delstenar*500;
		return x;
	}
}
