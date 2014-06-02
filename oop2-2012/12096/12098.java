
public class Apparat extends Pryl {

	private int ink�psPris;
	private int slitage;
	
	
	public Apparat(String prylNamn, int ink�psPris, int slitage) {
		/*
		 * Apparat konstruktor
		 */
		super(prylNamn);
		this.ink�psPris = ink�psPris;
		this.slitage = slitage;
	}


	private int setV�rde(){
		
	/*
	 * r�knar ut v�rdet p� apparaten. anv�nder r�knare(double) f�r att v�rdet ska kunna r�knas ut p� r�tt s�tt
	 */
		double r�knare = slitage /10.0;
		int lokalV�rde=(int) (ink�psPris*r�knare);
		return lokalV�rde;
		
	}
	
	protected int getV�rde(){
		return setV�rde();
	}

}
