class Aktier extends Prylar{
	private int Aktier;
	private int pris;

	public int getVarde(){
		return (Aktier*pris);}

	public void bytaPris(int x){
		pris= x;
	}

	public Aktier (String namnet, int Aktier, int pris){
		super(namnet);
		this.Aktier=Aktier;
		this.pris=pris;}



	public String toString(){
		return "Aktie"+super.toString()+"antal aktier: "+Aktier+ "pris: "+pris;}
}