
class Aktier extends Pryl {
	private int pris;
	private int antal;
 
public Aktier(String namn, int antal, int pris) {
	super(namn);
	this.antal = antal;
	this.pris = pris;
 }
 
public int getV�rde() {
	return (antal * pris);
 }
 
public int b�rskrasch() {
	pris = 0;
	return pris;
 }
}