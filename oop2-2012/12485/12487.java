
abstract class Pryl {
	abstract public int h�mtaV�rde();
	}



class Apparat extends Pryl{
	private String typAvApparat;
	private int ink�psPris;
	private int sliten;
	private int v�rde;
	
	Apparat(String typAvApparat,int ink�psPris, int sliten){
		this.typAvApparat = typAvApparat;
		this.ink�psPris = ink�psPris;
		this.sliten = sliten;
		v�rde = (int) (ink�psPris*(sliten/10.0));}
	
	
	public int h�mtaV�rde(){
		return v�rde;}
	
	public String toString(){
		return  typAvApparat + "\t\t\t"+ v�rde +"\n";}
	}


class Aktie extends Pryl{
	private String aktieF�retag;
	private int antal;
	private int pris;
	private int v�rde;
	

	
	Aktie(String aktieF�retag, int antal, int pris){
		this.aktieF�retag = aktieF�retag;
		this.antal = antal;
		this.pris = pris;
		v�rde = antal*pris;}
	
	public String toString(){
		return aktieF�retag + "\t\t\t"+ v�rde +"\n";}
	
	public int h�mtaV�rde(){
		return v�rde;}
	
	public void nollSt�llV�rde(){
		pris = 0;
		v�rde = pris*antal;}
	}
	

class Smycke extends Pryl{
	private String typAvSmycke;
	private int antal�delstenar;
	private String vilkenMetalSmyckeGjordAv;
	private int v�rde;
	
	Smycke(String typAvSmycke, int antal�delstenar, String vilkenMetalSmyckeGjordAv){
		this.typAvSmycke = typAvSmycke;
		this.antal�delstenar = antal�delstenar;
		this.vilkenMetalSmyckeGjordAv = vilkenMetalSmyckeGjordAv;
		
		if(vilkenMetalSmyckeGjordAv.equalsIgnoreCase("guld")){
			v�rde = 2000+(antal�delstenar*500);}
		else if(vilkenMetalSmyckeGjordAv.equalsIgnoreCase("silver")){
			v�rde = 700+(500*antal�delstenar);}}
	
	public int h�mtaV�rde(){
		return v�rde;}
	
	public String toString(){
		return typAvSmycke + "\t\t\t"+ v�rde +"\n";}


}