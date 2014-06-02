
class Aktier extends Pryl {
	private int pris;
	private int antal;
 
public Aktier(String namn, int antal, int pris) {
	super(namn);
	this.antal = antal;
	this.pris = pris;
 }
 
public int getVärde() {
	return (antal * pris);
 }
 
public int börskrasch() {
	pris = 0;
	return pris;
 }
}