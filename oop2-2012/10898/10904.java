
public class smycke extends Prylar{
	private String material;
	private int diamanter;
	
	smycke(String sättPNamn, String sättTyp, int sättVärde, String namn, String sättMaterial, int sättDiamanter, int förmögenhet) {
		super(sättPNamn, sättTyp, sättVärde, namn,förmögenhet);
		
		material = sättMaterial;
		diamanter = sättDiamanter;
	}
	
	public String getMaterial(){
		return material;
	}
	public int getDiamanter(){
		return diamanter;
	}
	
	public String toString(){
		int tm = 0;
		if (material.equals("guld")){
			tm=2000;
		}else if(material.equals("silver")){
			tm=700;
		}
		int värd=((tm+(diamanter*500)));
		return värd+"";
	}

}
