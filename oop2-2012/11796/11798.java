
public class Fiende {

	private int fiendeLiv;
	private int fiendeSkada;
	private String fiendeNamn;
	private int fiendeNiv� = 3;
	
	Fiende(String fNamn, int liv, int skada){
		fiendeNamn = fNamn;
		fiendeLiv = liv;
		fiendeSkada = skada;
	}

public int getfNiv�() {
	return fiendeNiv�;
}

public String getfNamn() {
	return fiendeNamn;
}

public int getfLiv() {
	return fiendeLiv;
}

public int getfSkada() {
	return fiendeSkada;

}public void setfLiv(int li) {
		fiendeLiv = li;
	}
}
//skapa fiendeobjekt i main. 
//
//r�kna ut det i main, skicka v�rde till fiendeclassen.
