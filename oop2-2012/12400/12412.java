class Smycken extends Prylar{
	private int adelstenar;
	private int guld;

	public int getVarde(){
		if (guld ==1)
			return 2000+(500*adelstenar);

		else
			return 700+(500*adelstenar);}

	public Smycken (String namnet, int guld, int adelstenar){
		super(namnet);
		this.adelstenar=adelstenar;
		this.guld=guld;}

	public String toString(){
		return "Smycke"+super.toString()+"antal ädelstenar: "+adelstenar+ "typ av metall: "+guld;}

}