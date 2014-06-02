
public class smycke extends Prylar{
	private String material;
	private int diamanter;
	
	smycke(String s�ttPNamn, String s�ttTyp, int s�ttV�rde, String namn, String s�ttMaterial, int s�ttDiamanter, int f�rm�genhet) {
		super(s�ttPNamn, s�ttTyp, s�ttV�rde, namn,f�rm�genhet);
		
		material = s�ttMaterial;
		diamanter = s�ttDiamanter;
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
		int v�rd=((tm+(diamanter*500)));
		return v�rd+"";
	}

}
