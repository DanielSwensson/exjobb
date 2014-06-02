
abstract class Pryl {
	abstract public int hämtaVärde();
	}



class Apparat extends Pryl{
	private String typAvApparat;
	private int inköpsPris;
	private int sliten;
	private int värde;
	
	Apparat(String typAvApparat,int inköpsPris, int sliten){
		this.typAvApparat = typAvApparat;
		this.inköpsPris = inköpsPris;
		this.sliten = sliten;
		värde = (int) (inköpsPris*(sliten/10.0));}
	
	
	public int hämtaVärde(){
		return värde;}
	
	public String toString(){
		return  typAvApparat + "\t\t\t"+ värde +"\n";}
	}


class Aktie extends Pryl{
	private String aktieFöretag;
	private int antal;
	private int pris;
	private int värde;
	

	
	Aktie(String aktieFöretag, int antal, int pris){
		this.aktieFöretag = aktieFöretag;
		this.antal = antal;
		this.pris = pris;
		värde = antal*pris;}
	
	public String toString(){
		return aktieFöretag + "\t\t\t"+ värde +"\n";}
	
	public int hämtaVärde(){
		return värde;}
	
	public void nollStällVärde(){
		pris = 0;
		värde = pris*antal;}
	}
	

class Smycke extends Pryl{
	private String typAvSmycke;
	private int antalÄdelstenar;
	private String vilkenMetalSmyckeGjordAv;
	private int värde;
	
	Smycke(String typAvSmycke, int antalÄdelstenar, String vilkenMetalSmyckeGjordAv){
		this.typAvSmycke = typAvSmycke;
		this.antalÄdelstenar = antalÄdelstenar;
		this.vilkenMetalSmyckeGjordAv = vilkenMetalSmyckeGjordAv;
		
		if(vilkenMetalSmyckeGjordAv.equalsIgnoreCase("guld")){
			värde = 2000+(antalÄdelstenar*500);}
		else if(vilkenMetalSmyckeGjordAv.equalsIgnoreCase("silver")){
			värde = 700+(500*antalÄdelstenar);}}
	
	public int hämtaVärde(){
		return värde;}
	
	public String toString(){
		return typAvSmycke + "\t\t\t"+ värde +"\n";}


}