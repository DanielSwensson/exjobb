// subklass till V�rdesak
class Apparat extends V�rdesak{
	private int ink�pspris;
	private int slitage;
// konstruktor
	public Apparat(String namn, int ink�pspris, int slitage){
		super(namn);// super clasens konstuktor 
			this.ink�pspris = ink�pspris;
			this.slitage = slitage;
		}
// metod
		public int getV�rde(){
		return (int)(slitage/10.0 * ink�pspris);
	}
}



