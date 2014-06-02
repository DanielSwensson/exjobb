class Apparater extends Prylar{
	private int Pris;
	private int slitage;

	public int getVarde(){
		return ((Pris*slitage)/10);}

	public Apparater (String namnet, int inkop, int slitaget){
		super(namnet);
		Pris=inkop;
		slitage=slitaget;}


	public String toString(){
		return super.toString()+"inköpspris: "+Pris+ "slitage: "+slitage;}

}