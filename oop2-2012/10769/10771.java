// subklass till Värdesak
class Apparat extends Värdesak{
	private int inköpspris;
	private int slitage;
// konstruktor
	public Apparat(String namn, int inköpspris, int slitage){
		super(namn);// super clasens konstuktor 
			this.inköpspris = inköpspris;
			this.slitage = slitage;
		}
// metod
		public int getVärde(){
		return (int)(slitage/10.0 * inköpspris);
	}
}



